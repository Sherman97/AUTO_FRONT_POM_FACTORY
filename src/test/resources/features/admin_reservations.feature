# language: es
Característica: HU01 consultar reservas desde modulo administrador
  Como usuario administrador
  Quiero consultar reservas con filtros y paginacion
  Para gestionar y validar la informacion del modulo

  Antecedentes:
    Dado que el usuario administrador ingresa al modulo de reservas

  Escenario: Consulta con filtros
    Cuando aplica filtros de consulta por fecha estado sede y usuario
    Entonces visualiza los resultados filtrados en la tabla

  Escenario: Ver detalle de reserva
    Cuando abre el detalle de una reserva existente
    Entonces el sistema muestra la informacion de detalle

  Escenario: Paginacion del listado
    Cuando navega a la siguiente pagina del listado de reservas
    Entonces el listado mantiene la paginacion activa

  Escenario: Consulta negativa sin resultados
    Cuando aplica una combinacion de filtros sin coincidencias
    Entonces el sistema informa que no hay resultados
