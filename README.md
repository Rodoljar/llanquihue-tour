# Llanquihue Tour App - Semana 6

Estructura de software digital para la agencia de turismo **Llanquihue Tour**, desarrollada en Java aplicando los principios de la Programación Orientada a Objetos (POO).

##  Mejoras e Implementaciones de esta Semana

En esta sexta semana se migró el modelo hacia una arquitectura jerárquica y modular, resolviendo directamente las observaciones de la evaluación anterior:

1. **Jerarquía de Clases (Herencia Simple):** Se implementó una superclase base `ServicioTuristico` de la cual extienden tres subclases especializadas utilizando la palabra clave `extends` y constructores alineados con `super()`:
    * `RutaGastronomica` (Atributo exclusivo: `numeroDeParadas`)
    * `PaseoLacustre` (Atributo exclusivo: `tipoEmbarcacion`)
    * `ExcursionCultural` (Atributo exclusivo: `lugarHistorico`)
2. **Composición entre Clases (Corrección de Falencia):** Para asegurar una relación compuesta real en el dominio, se integró la clase `GuiaTuristico` como atributo protegido de la clase madre. De esta forma, todo servicio "tiene un" guía asignado de manera obligatoria.
3. **Encapsulamiento y Buenas Prácticas:** Atributos protegidos/privados, métodos accesores (Getters/Setters) y sobreescritura estricta del método `@Override toString()` en cada nivel de la jerarquía.
4. **Organización por Capas (Paquetes):**
    * `model/`: Entidades de dominio, herencia y composición.
    * `data/`: Lógica de persistencia de prueba estática (`GestorServicios`).
    * `ui/`: Punto de entrada de la aplicación (`Main`) con lógica de filtrado por consola utilizando discriminación de tipos.

---

##  Estructura del Proyecto

```text
src/
├── data/
│   └── GestorServicios.java
├── model/
│   ├── ExcursionCultural.java
│   ├── GuiaTuristico.java
│   ├── PaseoLacustre.java
│   ├── RutaGastronomica.java
│   └── ServicioTuristico.java
└── ui/
    └── Main.java