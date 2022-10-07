Feature: Booking

  Scenario: Busqueda de Reserva en Cusco Correcto
    Given realizo la seleccion de "cusco"
    And realizo la seleccion de fechas
    When selecciono cantidad de habitacion
    And selecciono cantidad de personas
    Then selecciono habitacion a mi preferencia
    And verifico el precio total a pagar "559"