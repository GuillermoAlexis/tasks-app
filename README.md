# TasksApp

TasksApp es una aplicación para gestionar tareas. Permite a los usuarios crear, listar, editar y eliminar tareas.

## Requisitos

- Java 8 o superior.
- Maven para la gestión de dependencias.
- Base de datos compatible con JPA (por ejemplo, MySQL, PostgreSQL, H2, etc.).
- Navegador web moderno para probar la interfaz de usuario.

## Instalación

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ, Eclipse, etc.).
3. Configura la conexión a la base de datos en el archivo `application.properties`.
4. Ejecuta la aplicación utilizando el método `main` en la clase `TasksAppApplication`.

Si deseas compilar y construir la aplicación usando Maven, puedes seguir estos pasos:

1. Abre una terminal en la ubicación raíz del proyecto (donde se encuentra el archivo `pom.xml`).
2. Ejecuta el siguiente comando para compilar y construir la aplicación:

   ```bash
   mvn clean install

Este comando descargará las dependencias necesarias, compilará el código fuente y generará un archivo JAR ejecutable en el directorio target.

Uso
Una vez que la aplicación se esté ejecutando, puedes acceder a la interfaz de usuario a través de tu navegador web en http://localhost:puerto/tasks-ms/swagger-ui/index.html#, donde puerto es el puerto configurado para la aplicación (por defecto, es 9093).

La interfaz de usuario te permitirá:

- Ver todas las tareas existentes.
- Crear una nueva tarea proporcionando la descripción, la fecha de creación y vigencia.
- Actualizar una tarea existente editando su descripción, la fecha de creación y vigencia.
- Eliminar una tarea por su ID.

Consideraciones para Docker
Si deseas ejecutar la aplicación en Docker con una base de datos PostgreSQL, sigue estos pasos:

1. Asegúrate de tener Docker instalado en tu máquina.
2. Dirígete a la carpeta ./Docker/Postgres dentro del directorio del proyecto.
3. Ejecuta el comando `docker-compose up -d` para crear los contenedores de la aplicación y la base de datos.
4. La base de datos PostgreSQL se creará utilizando el archivo Dockerfile ubicado en ./Docker/Postgres.
5. El archivo dump.sql ubicado en ./Docker/Postgres se utilizará para inicializar la base de datos con datos de ejemplo.
6. La aplicación ahora estará disponible en ttp://localhost:puerto/tasks-ms/swagger-ui/index, donde puerto es el puerto configurado para la aplicación en el archivo docker-compose.yaml.


Si deseas probar los tests de este proyecto y obtener una visión completa de la cobertura de código, te recomendamos utilizar Eclemma (también conocido como EclEmma) para Eclipse. Eclemma es una excelente herramienta de análisis de cobertura que te permitirá verificar qué partes de tu código están siendo ejecutadas por las pruebas y cuáles no.

    Para utilizar Eclemma, sigue estos sencillos pasos:

1. Abre Eclipse y asegúrate de tener el complemento Eclemma instalado. Si aún no lo tienes, puedes instalarlo fácilmente desde el Mercado de Eclipse.

2. Ejecuta las pruebas unitarias de tu proyecto haciendo clic derecho en el proyecto, luego selecciona "Coverage As" y "JUnit Test".

3. Después de ejecutar las pruebas, Eclemma generará un informe de cobertura de código en el que podrás ver qué líneas de código han sido cubiertas por las pruebas y cuáles no.

4. Para obtener una visión general de la cobertura de todo el proyecto, crea una nueva configuración de cobertura en Eclemma, selecciona todas las clases que deseas incluir y ejecuta la cobertura.

5. Eclemma te proporcionará estadísticas detalladas sobre la cobertura de código, incluyendo la cantidad de líneas cubiertas y no cubiertas, así como el porcentaje de cobertura total.

6. Utilizando Eclemma, podrás identificar rápidamente áreas de tu código que no están siendo probadas adecuadamente, lo que te ayudará a mejorar la calidad de tu proyecto y asegurar un funcionamiento más robusto.