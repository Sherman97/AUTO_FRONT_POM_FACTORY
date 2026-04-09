# AUTO_FRONT_POM_FACTORY

Automatizacion E2E Front-End con Java, Serenity BDD, Cucumber y enfoque POM (con tareas Screenplay de soporte).

## HU cubierta

- `HU-01`: Consultar reservas desde modulo administrador.

## Escenarios automatizados (HU-01)

- Filtros de consulta (fecha, estado, sede y usuario).
- Ver detalle de reserva.
- Paginacion del listado (20 resultados por pagina).
- Escenario negativo sin resultados / validacion de filtros.

## Configuracion base

- URL por defecto: `http://localhost:5173`
- Login: `/login`
- Vista admin: `/admin-reservations`
- Credenciales admin por defecto:
  - `prueba.admin@demo.com`
  - `admin123`

Se pueden sobrescribir por propiedades:

```powershell
.\gradlew.bat clean test -Dwebdriver.base.url=http://localhost:5173 -Dadmin.email=prueba.admin@demo.com -Dadmin.password=admin123
```

## Prerrequisitos

- Java 17+
- Chrome instalado
- Frontend y backend operativos

## Ejecucion

Windows:

```powershell
.\gradlew.bat clean test aggregate --rerun-tasks
```

Linux/macOS:

```bash
./gradlew clean test aggregate --rerun-tasks
```

Solo runner principal:

```powershell
.\gradlew.bat test --tests com.sofka.reservas.runners.AdminReservationsRunner --rerun-tasks
```

## Reportes

- Gradle: `build/reports/tests/test/index.html`
- Serenity: `target/site/serenity/index.html`
