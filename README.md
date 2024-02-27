# Proyecto Bookstore - Implementando Clean Architecture

## Evaluación técnica

La Librería de Antioquia requiere ofrecer a sus clientes una aplicación back (servicio REST) para la búsqueda de libros de tecnología.

Esta debe tener las siguientes funcionalidades:
1. Exponer la consulta de libros, donde se reciba como parámetro el nombre del libro a consultar y entregue el listado de los libros que contengan el texto ingresado en su nombre.
2. Exponer la consulta del detalle de un libro, que debe recibir el ID del libro a consultar y entregar la información del libro indicado.
3. Exponer la actualización, creación y borrado de un libro.

Realizar un diseño de la arquitectura propuesta para la aplicación teniendo en cuenta la arquitectura en la nube, los componentes que consideras deben componer la arquitectura de la aplicación, la conexión entre los mismos, los componentes para exponer el servicio a los consumidores, etc.

Implementar la aplicación en Java con Spring Boot Reactivo utilizando arquitectura limpia, pruebas unitarias (por lo menos un 30 o 40% de cobertura). Se recomienda tener la información de los libros almacenada en una base de datos y tener conexión con ésta desde el microservicio.

# Solución

### Arquitectura

[Arquitectura AWS](https://github.com/joeldavg/bookstore/blob/main/readme/bookstore_architecture.drawio.pdf)

### Proyecto

Proyecto Bookstore desarrollado con Gradle 8, Java 17 y Spring Boot 3.2.2 stack reactivo.

Base de datos PostgreSQL (Servicio Render).

### Instrucciones

1. Clonar repositorio y ubicarse en la rama main.
2. Configurar `application.yaml` [applications/app-service/src/main/resources/application.yaml].
3. Ejecutar proyecto con `./gradlew BootRun` o `./gradlew.bat BootRun` en Windows.
5. Importar colección de Postman ubicada en el directorio [readme/postman].

**Nota:** El archivo `application.yaml` contiene configuración por defecto y apunta a la base de datos PostgreSQL alojada en Render.

### Servicios

1. #### Encontrar libros que contienen texto en el título
   **Método**: GET

   **URL**:  http://localhost:8080/api/bookstore/search/books/?title={texto}

   **Nota**: Ingresar texto como parámetro de consulta.

2. #### Encontrar detalle de un libro por ID
   **Método**: GET

   **URL**:  http://localhost:8080/api/bookstore/search/book/{id}

   **Nota**: El ID debe ser un número entero.

3. #### Eliminar libro por ID
   **Método**: DELETE

   **URL**:  http://localhost:8080/api/bookstore/delete/book/{id}

   **Nota**: El ID debe ser un número entero.

4. #### Crear un nuevo libro
   **Método**: POST

   **URL**:  http://localhost:8080/api/bookstore/save/book

   **Cuerpo de la solicitud (Ejemplo):**

   ```json
            {
              "title": "Code Complete",
              "subtitle": "A Practical Handbook of Software Construction",
              "authors": "Steve McConnell",
              "publisher": "Microsoft Press",
              "pages": 960,
              "year": 2004,
              "rating": 5,
              "desc": "Code Complete es un libro extenso que cubre todas las etapas del desarrollo de software, desde la planificación hasta el mantenimiento. Escrito por Steve McConnell, este libro es una referencia valiosa para desarrolladores de todos los niveles de experiencia.",
              "price": 35.00,
              "image": "code_complete.jpg",
              "url": "https://www.example.com/books/code-complete"
            }


5. #### Actualizar libro por ID
   **Método**: PUT

   **URL**:  http://localhost:8080/api/bookstore/update/book/{id}

   **Cuerpo de la solicitud (Ejemplo):**

   ```json
            {
              "title": "Code Complete",
              "subtitle": "A Practical Handbook of Software Construction",
              "authors": "Steve McConnell",
              "publisher": "Microsoft Press",
              "pages": 960,
              "year": 2004,
              "rating": 5,
              "desc": "Code Complete es un libro extenso que cubre todas las etapas del desarrollo de software, desde la planificación hasta el mantenimiento. Escrito por Steve McConnell, este libro es una referencia valiosa para desarrolladores de todos los niveles de experiencia.",
              "price": 35.00,
              "image": "code_complete.jpg",
              "url": "https://www.example.com/books/code-complete"
            }


**By: @joeldavg**