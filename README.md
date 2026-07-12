# Llanquihue Tour App - Sistema de Gestión (Semana 8)

Este proyecto corresponde a la entrega de la Semana 8 de la asignatura de Programación Orientada a Objetos. Consiste en la optimización y extensión del software para la agencia **Llanquihue Tour**, unificando los servicios turísticos desarrollados previamente con el control de infraestructura y personal mediante el uso de interfaces y polimorfismo en colecciones.

---

## Datos del Alumno
*   **Nombre:** Rodolfo Jaramillo Pezoa
*   **Carrera:** Analista Programador Computacional
*   **Institución:** Duoc UC

---

## Estructura de Paquetes

El código fuente se encuentra organizado en tres capas para garantizar la modularidad del sistema:
*   **`model`**: Aloja la interfaz `Registrable`, la clase base `ServicioTuristico` (con sus respectivas subclases de servicios) y las entidades de control como `GuiaTuristico`, `Vehiculo` y `ColaboradorExterno`.
*   **`data`**: Contiene la clase `GestorEntidades`, la cual administra la lógica de negocio y el almacenamiento de datos en memoria.
*   **`ui`**: Contiene el punto de entrada de la aplicación (`Main`) junto con las interfaces gráficas (`WelcomeGUI` y `MenuGUI`).

---

## Detalle del Desarrollo (Cumplimiento de la Pauta)

### Paso 1 y 2: Interfaz y Jerarquía de Clases
*   Se creó la interfaz **`Registrable`** dentro del paquete `model`, definiendo el método abstracto `mostrarResumen()` sin implementar, el cual actúa como el contrato común del sistema.
*   Para optimizar el diseño del código, se aplicó herencia mediante una clase base abstracta llamada **`Persona`**, de la cual extienden `GuiaTuristico` y `ColaboradorExterno`.
*   La clase **`Vehiculo`** implementa `Registrable` de forma directa, demostrando cómo objetos de distinta naturaleza se acoplan al mismo comportamiento.
*   Se adaptó la clase base **`ServicioTuristico`** para implementar `Registrable`, permitiendo que los paseos y excursiones anteriores se integren al nuevo flujo de datos unificado.

### Paso 3: Colección y Uso de `instanceof`
*   En la clase `GestorEntidades` se definió una lista genérica estructurada como `ArrayList<Registrable>`. Esto hace posible almacenar de forma centralizada guías, vehículos y servicios en una misma estructura.
*   Se utilizó un ciclo `for-each` para recorrer la colección, aplicando el operador **`instanceof`** para identificar el tipo exacto del objeto en tiempo de ejecución. Con esto se despliegan alertas diferenciadas (como el aviso de licencia profesional para vehículos que superan los 15 pasajeros o recordatorios de seguridad en paseos lacustres).

### Paso 4: Interfaz Gráfica (GUI con Swing)
Se desarrolló un entorno visual interactivo utilizando componentes de la librería `javax.swing`:
*   **`WelcomeGUI`**: Ventana de bienvenida inicial que controla el acceso al sistema y se destruye mediante `dispose()` para optimizar el uso de memoria al pasar a la siguiente pantalla.
*   **`MenuGUI`**: Ventana principal de operaciones que utiliza un componente `JTable` para organizar los registros en filas y columnas. Las celdas están configuradas como no editables para proteger la integridad de los datos.
*   **Botones de Acción**: Permiten el ingreso dinámico de nuevos Guías y Vehículos mediante capturas de datos con `JOptionPane`. También se incorporó la funcionalidad de eliminar registros directamente seleccionando la fila de la tabla.
*   **Botón Salir**: Finaliza la ejecución de todos los hilos del programa de manera segura a través de `System.exit(0)`.
*   **Doble Reporte**: Cada modificación realizada en la tabla visual gatilla automáticamente la actualización del reporte estructurado por la consola de comandos.

---

## Instrucciones de Ejecución
1. Importar el proyecto en IntelliJ IDEA.
2. Configurar el SDK del proyecto (compatible con JDK 17 en adelante).
3. Ejecutar la clase `Main.java` ubicada dentro del paquete `ui`.