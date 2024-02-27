# Proyecto Bookstore - Implementando Clean Architecture

## Evaluaci�n t�cnica

La Librer�a de Antioquia requiere ofrecer a sus clientes una aplicaci�n back (servicio REST) para la b�squeda de libros de tecnolog�a.

Esta debe tener las siguientes funcionalidades:
1. Exponer la consulta de libros, donde se reciba como par�metro el nombre del libro a consultar y entregue el listado de los libros que contengan el texto ingresado en su nombre.
2. Exponer la consulta del detalle de un libro, que debe recibir el ID del libro a consultar y entregar la informaci�n del libro indicado.
3. Exponer la actualizaci�n, creaci�n y borrado de un libro.

Realizar un dise�o de la arquitectura propuesta para la aplicaci�n teniendo en cuenta la arquitectura en la nube, los componentes que consideras deben componer la arquitectura de la aplicaci�n, la conexi�n entre los mismos, los componentes para exponer el servicio a los consumidores, etc.

Implementar la aplicaci�n en Java con Spring Boot Reactivo utilizando arquitectura limpia, pruebas unitarias (por lo menos un 30 o 40% de cobertura). Se recomienda tener la informaci�n de los libros almacenada en una base de datos y tener conexi�n con �sta desde el microservicio.

# Soluci�n

### Arquitectura

[Arquitectura AWS](https://github.com/joeldavg/bookstore/blob/main/readme/bookstore_architecture.drawio.pdf)

### Proyecto

Proyecto Bookstore desarrollado con Gradle 8, Java 17 y Spring Boot 3.2.2 stack reactivo.

Base de datos PostgreSQL (Servicio Render).

### Instrucciones

1. Clonar repositorio y ubicarse en la rama main.
2. Configurar `application.yaml` [applications/app-service/src/main/resources/application.yaml].
3. Ejecutar proyecto con `./gradlew BootRun` o `./gradlew.bat BootRun` en Windows.
5. Importar colecci�n de Postman ubicada en el directorio [readme/postman].

**Nota:** El archivo `application.yaml` contiene configuraci�n por defecto y apunta a la base de datos PostgreSQL alojada en Render.

### Servicios

1. #### Encontrar libros que contienen texto en el t�tulo
   **M�todo**: GET

   **URL**:  http://localhost:8080/api/bookstore/search/books/?title={texto}

   **Nota**: Ingresar texto como par�metro de consulta.

2. #### Encontrar detalle de un libro por ID
   **M�todo**: GET

   **URL**:  http://localhost:8080/api/bookstore/search/book/{id}

   **Nota**: El ID debe ser un n�mero entero.

3. #### Eliminar libro por ID
   **M�todo**: DELETE

   **URL**:  http://localhost:8080/api/bookstore/delete/book/{id}

   **Nota**: El ID debe ser un n�mero entero.

4. #### Crear un nuevo libro
   **M�todo**: POST

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
              "desc": "Code Complete es un libro extenso que cubre todas las etapas del desarrollo de software, desde la planificaci�n hasta el mantenimiento. Escrito por Steve McConnell, este libro es una referencia valiosa para desarrolladores de todos los niveles de experiencia.",
              "price": 35.00,
              "image": "code_complete.jpg",
              "url": "https://www.example.com/books/code-complete"
            }


5. #### Actualizar libro por ID
   **M�todo**: PUT

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
              "desc": "Code Complete es un libro extenso que cubre todas las etapas del desarrollo de software, desde la planificaci�n hasta el mantenimiento. Escrito por Steve McConnell, este libro es una referencia valiosa para desarrolladores de todos los niveles de experiencia.",
              "price": 35.00,
              "image": "code_complete.jpg",
              "url": "https://www.example.com/books/code-complete"
            }


**By: @joeldavg**