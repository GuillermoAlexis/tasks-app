-- Crear la base de datos 'task_project'
CREATE DATABASE task_project;

-- Conectarse a la base de datos 'task_project'
\c task_project;

-- Crear la tabla 'tarea' para almacenar las tareas
CREATE TABLE tarea (
    id SERIAL PRIMARY KEY,
    descripcion TEXT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    vigente BOOLEAN NOT NULL
);

-- Insertar datos de ejemplo en la tabla 'tarea'
INSERT INTO tarea (descripcion, fecha_creacion, vigente)
VALUES
    ('Tarea 1', '2023-07-20 10:00:00', true),
    ('Tarea 2', '2023-07-21 12:30:00', true),
    ('Tarea 3', '2023-07-22 14:15:00', false);