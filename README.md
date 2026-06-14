# Llanquihue Tour App

## Descripción del Proyecto
Este proyecto es una aplicación de consola desarrollada en Java para la agencia de turismo **Llanquihue Tour**, ubicada en la Región de Los Lagos.

El sistema resuelve la necesidad de gestionar eficientemente la información de los tours disponibles. Implementa la lectura de datos desde un archivo de texto externo (`.txt`), parsea la información para instanciar objetos de la clase `Tour` y los almacena en una colección dinámica (`ArrayList`). Finalmente, realiza operaciones de recorrido y filtrado de datos en base a criterios específicos.

## Estructura de Carpetas
El proyecto sigue una estructura organizada por capas para separar las responsabilidades del código:

```text
LlanquihueTourApp/
├── resources/
│   └── tours.txt          # Archivo con los datos de los tours separados por ";"
├── src/
│   ├── data/
│   │   └── GestorDatos    # Clase encargada de la lectura y procesamiento del archivo
│   ├── model/
│   │   └── Tour           # Clase molde (objeto) con atributos, constructor y getters/setters
│   └── ui/
│       └── Main           # Clase principal que ejecuta el programa y muestra los filtros
└── README.md              # Documentación del proyecto