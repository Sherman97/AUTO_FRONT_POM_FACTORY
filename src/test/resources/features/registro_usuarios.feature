# language: en
Feature: Registro de usuarios en la plataforma de gestion de reservas
  Como colaborador no registrado
  Quiero registrar una cuenta
  Para acceder a la plataforma de reservas

  Scenario: Registro exitoso de un colaborador
    Given un colaborador no registrado requiere una cuenta de acceso
    When diligencia correctamente la informacion requerida para el registro
    Then la cuenta del colaborador es creada correctamente
    And el colaborador accede exitosamente a la plataforma

  Scenario: Registro fallido por correo corporativo con formato invalido
    Given un colaborador no registrado requiere una cuenta de acceso
    When diligencia la informacion requerida para el registro utilizando un correo corporativo invalido
    Then la cuenta del colaborador no es creada
    And el sistema informa que el correo corporativo no cumple con el formato valido
