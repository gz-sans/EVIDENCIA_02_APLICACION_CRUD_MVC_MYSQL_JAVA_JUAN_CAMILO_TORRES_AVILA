CREATE DATABASE java3;

USE java3;

DROP TABLE IF EXISTS transacciones;
DROP TABLE IF EXISTS cuentas;
DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100),
  usuario VARCHAR(50),
  contrasena VARCHAR(50),
  activo BOOLEAN NOT NULL DEFAULT TRUE
);
select *from usuarios;

CREATE TABLE cuentas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_usuario INT,
  nombre_cuenta VARCHAR(100),
  valor DECIMAL(10, 2),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);
select *from cuentas;
CREATE TABLE transacciones (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_cuenta INT,
  tipo VARCHAR(20),
  monto DECIMAL(10, 2),
  fecha DATETIME,
  FOREIGN KEY (id_cuenta) REFERENCES cuentas(id)
);
