# AUTO_FRONT_POM_FACTORY

Proyecto de automatización Front-End en Java con Serenity BDD, Gradle, Cucumber y una implementación híbrida de POM con Page Factory y Screenplay.

## Cobertura

- Registro exitoso de un colaborador nuevo.
- Registro fallido por correo corporativo con formato inválido.

## Estructura

- `src/test/resources/features`: escenarios Gherkin.
- `src/test/java/com/sofka/reservas/pages`: páginas POM con `@FindBy`.
- `src/test/java/com/sofka/reservas/tasks`: tareas Screenplay.
- `src/test/java/com/sofka/reservas/questions`: validaciones Screenplay.
- `src/test/java/com/sofka/reservas/stepdefinitions`: definición de pasos Cucumber.

## Prerrequisitos

- Java 17 o superior.
- Frontend de la aplicación ejecutándose en `http://localhost:8080`.
- Backend de autenticación ejecutándose y accesible desde el frontend.
- Google Chrome disponible en la máquina.

## Ejecución

```bash
./gradlew clean test
```

Si necesitas apuntar a otra URL base:

```bash
./gradlew clean test -Dwebdriver.base.url=http://localhost:4173
```

La URL base por defecto de la automatización está centralizada en [TestEnvironment.java](/Users/germanrojas/Desktop/sofka/reservasSofka/AUTO_FRONT_POM_FACTORY/src/test/java/com/sofka/reservas/utils/TestEnvironment.java).
