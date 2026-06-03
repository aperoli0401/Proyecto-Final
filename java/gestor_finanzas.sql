CREATE DATABASE gestor_finanzas;

USE gestor_finanzas;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    contraseña VARCHAR(50) NOT NULL
);

CREATE TABLE movimientos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cantidad DOUBLE NOT NULL,
    descripcion VARCHAR(100),
    fecha DATE,
    categoria VARCHAR(50),
    tipo VARCHAR(20),
    usuario_id INT,

    FOREIGN KEY (usuario_id)
    REFERENCES usuarios(id)
);