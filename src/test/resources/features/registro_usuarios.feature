# language: es
Característica: Registro de usuarios en la plataforma de gestion de reservas
  Como colaborador no registrado
  Quiero registrar una cuenta
  Para acceder a la plataforma de reservas

  Escenario: Registro exitoso de un colaborador
    Dado un colaborador no registrado requiere una cuenta de acceso
    Cuando diligencia correctamente la informacion requerida para el registro
    Entonces la cuenta del colaborador es creada correctamente
    Y el colaborador accede exitosamente a la plataforma

  Escenario: Registro fallido por correo corporativo con formato invalido
    Dado un colaborador no registrado requiere una cuenta de acceso
    Cuando diligencia la informacion requerida para el registro utilizando un correo corporativo invalido
    Entonces la cuenta del colaborador no es creada
    Y el sistema informa que el correo corporativo no cumple con el formato valido
