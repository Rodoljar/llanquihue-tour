# Llanquihue Tour App

## Descripción del Proyecto
Este proyecto es una aplicación de consola desarrollada en Java para la agencia de turismo **Llanquihue Tour**, ubicada en la Región de Los Lagos.

El sistema resuelve la necesidad de gestionar eficientemente la información de las rutas turísticas. En esta quinta semana, el proyecto ha sido refactorizado bajo principios de **organización modular**, implementando una arquitectura de capas, encapsulamiento robusto con validaciones de datos mediante control de excepciones (`try-catch` e `IllegalArgumentException`) y operaciones automatizadas de recorrido y filtrado utilizando colecciones dinámicas (`ArrayList`).

## Estructura de Paquetes y Clases
El código fuente se encuentra organizado dentro del directorio `src` bajo los siguientes paquetes funcionales:

* **`model`**
    * `Tour.java`: Clase molde que representa un tour turísticos. Cuenta con atributos privados (`nombre`, `tipo`, `precio`), constructores, métodos *getters/setters* con lógica de validación defensiva y la sobreescritura del método `toString()`.
* **`util`**
    * `GestorDatos.java`: Clase utilitaria encargada de la persistencia. Realiza la lectura del archivo plano `.txt`, procesa las líneas separadas por `;` y maneja de forma segura los errores de conversión o de lógica mediante bloques `try-catch`.
* **`service`**
    * `TourService.java`: Capa de negocio que encapsula la colección `ArrayList<Tour>` y provee las operaciones automatizadas de recorrido completo de catálogo y filtrado/búsqueda simple por tipo.
* **`app`**
    * `Main.java`: Punto de entrada de la aplicación. Coordina la carga de datos, inicializa los servicios y despliega los resultados en la consola.

## Recursos Externos
* `resources/tours.txt`: Archivo de texto que actúa como base de datos del sistema, estructurado en formato de texto plano separado por puntos y comas (`;`).

## Instrucciones para Ejecutar el Programa
1. Asegúrate de tener instalado **Java JDK 11 o superior** (el proyecto fue compilado exitosamente con JDK 26).
2. Clona o descarga este repositorio.
3. Abre el proyecto en tu IDE de preferencia (como **IntelliJ IDEA**).
4. Verifica que el archivo `tours.txt` se encuentre dentro de la carpeta `resources/` en la raíz del proyecto.
5. Dirígete al paquete `app` dentro de `src/`.
6. Haz clic derecho sobre la clase `Main.java` y selecciona **Run 'Main.main()'** para ejecutar la aplicación por consola.