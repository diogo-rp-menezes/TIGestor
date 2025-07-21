package com.tigestor.controller;

import com.tigestor.model.Machine;
import com.tigestor.service.MachineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MachineController {

    private final MachineService machineService;

    @GetMapping("/health")
    @Operation(summary = "Check API status", description = "Endpoint simples para verificar se a API está online")
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok().body("{\"status\": \"OK\"}");
    }

    @GetMapping("/machines")
    @Operation(summary = "Listar todas as máquinas")
    public ResponseEntity<List<Machine>> listAllMachines() {
        return ResponseEntity.ok(machineService.findAll());
    }

    @PostMapping("/collect")
    @Operation(
            summary = "Coleta de informações da máquina",
            description = "Recebe o JSON gerado pelo PowerShell e armazena no banco de dados",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Coleta exemplo",
                                    value = "{\n  \"hostname\": \"PC-001\",\n  \"ip\": \"192.168.0.101\",\n  \"raw\": { /* json completo aqui */ }\n}"
                            )
                    )
            )
    )
    public ResponseEntity<Machine> collectJson(@RequestBody Map<String, Object> body) {
        String hostname = (String) body.get("hostname");
        String ip = (String) body.get("ip");
        String rawJson = body.get("raw").toString();
        Machine saved = machineService.saveFromJson(hostname, ip, rawJson);
        return ResponseEntity.ok(saved);
    }
}