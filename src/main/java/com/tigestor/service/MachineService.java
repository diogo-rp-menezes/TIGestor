package com.tigestor.service;

import com.tigestor.model.Machine;
import com.tigestor.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineService {

    private final MachineRepository machineRepository;

    public List<Machine> findAll() {
        return machineRepository.findAll();
    }

    public Machine saveFromJson(String hostname, String ip, String jsonRaw) {
        Machine m = Machine.builder()
                .hostname(hostname)
                .ip(ip)
                .status("ACTIVE")
                .jsonRaw(jsonRaw)
                .dataColeta(LocalDateTime.now())
                .build();
        return machineRepository.save(m);
    }

    public Machine save(Machine machine) {
        return machineRepository.save(machine);
    }
}