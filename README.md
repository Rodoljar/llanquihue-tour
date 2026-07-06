# Llanquihue Tour App - Semana 7

Este proyecto corresponde a la entrega de la Semana 7, donde refactoricé el sistema de Llanquihue Tour para aplicar colecciones dinámicas y polimorfismo puro, eliminando las estructuras fijas que veníamos usando.

##  Cambios e Implementaciones de esta Semana

* **Migración a Listas Dinámicas (`List` y `ArrayList`):** Eliminé los arreglos estáticos del `GestorServicios` que tenían un tamaño fijo. Ahora los tours se guardan en un `ArrayList<ServicioTuristico>`, lo que permite agregar la cantidad de servicios que queramos sin que se caiga el sistema.
* **Polimorfismo Real (`@Override`):** Modifiqué el método `mostrarInformacion()` en la superclase `ServicioTuristico`. Las subclases (`RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural`) ahora lo sobrescriben con sus atributos propios.
* **Bucle Único sin `instanceof`:** Para cumplir de forma estricta con la pauta, el catálogo se recorre usando un solo bucle `for-each`. Eliminé por completo el uso de `instanceof`. El sistema ahora es capaz de reconocer el tipo de objeto en tiempo de ejecución de forma automática.
* **Diseño de Consola:** Mantuve el orden visual por secciones de la semana pasada de forma dinámica. El código detecta mediante `.getClass()` cuándo cambia el tipo de servicio e imprime los títulos correspondientes en español, sin alterar el flujo del bucle único.

---

##  Organización del Código

* `src/model/`: Contiene la superclase `ServicioTuristico`, las subclases de los tours y la clase `GuiaTuristico` (aplicando composición).
* `src/data/`: Contiene la clase `GestorServicios.java`, que ahora inicializa la lista dinámica con 6 servicios de prueba (cumpliendo con el mínimo de 5 de la pauta) y ejecuta el recorrido polimórfico.
* `src/ui/`: Contiene la clase `Main.java` que da el arranque a la aplicación.

---

##  Cómo Ejecutar
1. Abrir el proyecto en IntelliJ IDEA (configurado con JDK 26).
2. Ir a `src/ui/Main.java`.
3. Hacer clic derecho y seleccionar **Run 'Main.main()'**.
4. La consola desplegará el catálogo completo ordenado limpiamente por secciones.