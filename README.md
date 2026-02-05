# SGC-Enterprise: Sistema de Gestión de Concesionario

**SGC-Enterprise** es una solución integral de gestión para compra-venta de vehículos, desarrollada en **Java SE**. El sistema combina una arquitectura orientada a objetos con validaciones legales estrictas y un motor de simulación financiera.



## Tecnologías y Metodología de Desarrollo

Este proyecto ha sido desarrollado bajo un modelo de **aprendizaje activo y colaborativo**:

* **Lógica de Negocio y Estructura (100% propia):** He diseñado y programado íntegramente toda la jerarquía de clases, la lógica de validación de DNI/NIE, la gestión de excepciones personalizadas y el flujo de control del inventario.
* **Persistencia de Datos (IA Cooperativa):** Para elevar el proyecto a un nivel profesional, implementé la persistencia mediante serialización de objetos en archivos `.dat` colaborando con una Inteligencia Artificial. Este proceso me permitió aprender a gestionar flujos de entrada/salida (`ObjectOutputStream` e `ObjectInputStream`) y aplicarlos de forma práctica para asegurar que los datos no se pierdan al cerrar el programa.

## Características Técnicas

* **Jerarquía de Clases (POO):** Uso de clases abstractas (`VehiculoBase`) y herencia para especializar tipos de vehículos como `Turismo` e `Industrial`.
* **Motor de Depreciación:** Implementación de `java.time` para calcular la pérdida de valor de los vehículos (5% anual) de forma dinámica según su fecha de matriculación.
* **Validación Documental Robusta:** Sistema centralizado para validar la autenticidad de NIF y NIE españoles antes de permitir registros.
* **Patrones de Diseño:** Implementación del patrón **Singleton** en la clase `Inventario` para garantizar una fuente única de verdad en los datos.
* **Gestión de Errores:** Excepciones personalizadas para un control preciso sobre fallos en documentos o lógica del sistema.



## Estructura del Proyecto

* `modelo`: Clases base y derivadas de la jerarquía de vehículos.
* `control`: Lógica del inventario y persistencia.
* `utilidades`: Validadores, cálculos financieros y herramientas de redondeo.
* `excepciones`: Definición de errores a medida.
* `aplicacionCoches`: Interfaz de usuario por consola y punto de entrada.

## Cómo ejecutarlo

1. Clonar el repositorio.
2. Abrir el proyecto en **NetBeans** o cualquier IDE compatible con Ant.
3. Ejecutar la clase `GestionCoches.java`.
4. Al registrar un coche, se creará automáticamente el archivo `concesionario.dat` para guardar tu stock.

## Plan a Futuro

* **Interfaz Gráfica (GUI):** Evolucionar el sistema actual hacia una interfaz interactiva y visualmente atractiva (utilizando Swing o JavaFX).
* **Experiencia de Usuario:** Crear una apariencia amigable e intuitiva que facilite su implementación real en concesionarios.
* **Carácter Profesional:** Integrar paneles de control estadísticos, gestión de imágenes de vehículos y reportes exportables para elevar el estándar profesional del software.
