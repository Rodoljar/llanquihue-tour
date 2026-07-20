Este proyecto corresponde a la entrega final de la asignatura de Programación Orientada a Objetos. Desarrollado por **Rodolfo Jaramillo Pezoa**, el sistema proporciona una solución robusta y orientada a objetos para la gestión de operaciones comerciales de la agencia **Llanquihue Tour**.

## Descripción del Sistema
El software permite la gestión integral de clientes, proveedores y productos (tours), unificando las operaciones en un flujo de datos coherente, validado y trazable. El sistema destaca por su arquitectura modular, asegurando escalabilidad y facilidad de mantenimiento.

## Datos del Alumno
* **Nombre:** Rodolfo Jaramillo Pezoa
* **Carrera:** Analista Programador Computacional
* **Institución:** Duoc UC

## Estructura de Paquetes
* **`app`**: Punto de entrada de la aplicación (`Main`).
* **`model`**: Define las entidades del negocio (Persona, Cliente, Proveedor, Producto, OrdenDeCompra), la interfaz `Registrable` y las clases de soporte (Rut, Dirección, Tarjeta).
* **`data`**: Contiene `GestorSistema`, responsable de la lógica de negocio, manejo de colecciones y persistencia en memoria.
* **`utils`**: Clases utilitarias, incluyendo el `LectorArchivos` (para cargar datos desde .txt) y excepciones personalizadas (`RutInvalidoException`).

## Características Técnicas (Cumplimiento de la Pauta)
* **Programación Orientada a Objetos (POO):** Implementación de herencia, encapsulamiento y composición en todas las entidades.
* **Polimorfismo:** Uso de la interfaz `Registrable` para gestionar diferentes tipos de objetos (Clientes, Proveedores, Órdenes) en una única colección (`List<Registrable>`).
* **Colecciones Avanzadas:** Uso de `ArrayList` para almacenamiento secuencial y `HashMap` para búsquedas eficientes de personas por RUT.
* **Gestión de Errores:** Validación estricta de datos (RUT) mediante excepciones personalizadas y manejo de IO para archivos externos.
* **Lógica de Negocio Diferenciada:** Uso del operador `instanceof` para aplicar reglas de validación específicas (alertas de crédito para tarjetas, límites de aprobación para órdenes de alto valor).

## Instrucciones de Ejecución
1. Asegúrese de tener el entorno de desarrollo IntelliJ IDEA configurado con JDK 17+.
2. Coloque los archivos `clientes.txt`, `productos.txt` y `proveedores.txt` en la raíz del proyecto.
3. Ejecute la clase `app.Main` para desplegar el sistema.
4. El sistema mostrará automáticamente el resumen comercial detallado en la consola.
```eof

