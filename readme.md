# Sistema de Gestión de Parqueadero

![Parqueadero](imagen-parqueadero.png)

## Descripción

Sistema REST API desarrollado en Spring Boot para la gestión de un parqueadero. Permite el registro, control y cálculo de tarifas por tiempo de uso de vehículos estacionados.

## Funcionalidades

- **Registrar vehículos**: Agregar carros al parqueadero con información de placa, marca, modelo y tiempo inicial
- **Consultar vehículos**: Ver todos los vehículos registrados en el sistema
- **Actualizar tiempo**: Modificar el tiempo de uso de un vehículo específico
- **Calcular tarifa**: Obtener el cálculo del monto a pagar basado en el tiempo de uso (tarifa: $3000 por hora)
- **Eliminar registros**: Remover vehículos del sistema

## Tecnologías

- Java
- Spring Boot
- Spring Web (REST API)
- Maven

## Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/parqueadero/vercarros` | Obtener todos los carros |
| POST | `/api/parqueadero/carro` | Registrar un nuevo carro |
| PATCH | `/api/parqueadero/carro/{placa}` | Actualizar tiempo de un carro |
| GET | `/api/parqueadero/carro/tiempo/{placa}` | Calcular pago de un carro |
| DELETE | `/api/parqueadero/carro/{placa}` | Eliminar un carro |

## Ejecución

```bash
mvn spring-boot:run
```

La aplicación se ejecuta en: `http://localhost:8080`

## Pruebas

El proyecto incluye un archivo `http/peticiones.http` con ejemplos de peticiones HTTP para probar todos los endpoints.
