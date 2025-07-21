CREATE TABLE machines (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  hostname VARCHAR(255) NOT NULL,
  ip VARCHAR(50) NOT NULL,
  status VARCHAR(50),
  data_coleta DATETIME,
  json_raw TEXT,
  created_at DATETIME,
  updated_at DATETIME
);