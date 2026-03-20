# AUTO_FRONT_POM_FACTORY

Proyecto de automatizacion Front-End en Java con Serenity BDD, Gradle, Cucumber y una implementacion hibrida de POM (Page Object Model) con Page Factory y Screenplay.

Este repositorio contiene:
- Codigo fuente funcional de automatizacion E2E para el flujo de registro de usuarios.
- Instrucciones de ejecucion de pruebas automatizadas en local.

## Cobertura funcional automatizada

- Registro exitoso de un colaborador nuevo.
- Registro fallido por correo corporativo con formato invalido.

## Estructura del proyecto

- `src/test/resources/features`: escenarios Gherkin.
- `src/test/java/com/sofka/reservas/pages`: objetos de pagina (POM) con `@FindBy`.
- `src/test/java/com/sofka/reservas/tasks`: tareas Screenplay.
- `src/test/java/com/sofka/reservas/questions`: validaciones Screenplay.
- `src/test/java/com/sofka/reservas/stepdefinitions`: definicion de pasos Cucumber.
- `src/test/java/com/sofka/reservas/runners`: runners de ejecucion.

## Prerrequisitos

- Java 17 o superior.
- Google Chrome instalado.
- Aplicacion objetivo ejecutandose en `http://localhost:8080`.

## Ejecucion de tests

En Windows (PowerShell):

```powershell
.\gradlew.bat clean test
```

En Linux/macOS:

```bash
./gradlew clean test
```

## Ejecutar tests sin cache (forzar re-ejecucion)

```powershell
.\gradlew.bat clean test aggregate --rerun-tasks
```

## Reportes

Despues de ejecutar tests:

- Reporte de Gradle: `build/reports/tests/test/index.html`
- Reporte de Serenity: `target/site/serenity/index.html`

Si ves datos antiguos en Serenity, ejecuta:

```powershell
.\gradlew.bat clean test aggregate --rerun-tasks
```
