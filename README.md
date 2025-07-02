# API de Gestión de Envíos - Perfunlandia

Esta es la API para gestionar envíos en el sistema de Perfunlandia.

## 🚀 Características

- **HATEOAS**: Incluye enlaces hipermedia para navegación
- **Swagger**: Documentación automática de la API
- **JPA/Hibernate**: Persistencia de datos
- **MariaDB**: Base de datos

## 📋 Endpoints

### Envíos
- `POST /api/envios` - Crear un nuevo envío
- `GET /api/envios/{id}` - Obtener envío por ID
- `GET /api/envios/venta/{idVenta}` - Obtener envío por ID de venta
- `PUT /api/envios` - Actualizar envío
- `GET /api/envios` - Listar todos los envíos

## 🔧 Configuración

### Requisitos
- Java 17
- Maven
- MariaDB

### Instalación
1. Clona el repositorio
2. Configura la base de datos en `application.properties`
3. Ejecuta: `mvn spring-boot:run`

### Documentación
- Swagger UI: `http://localhost:8085/swagger-ui.html`

## 🌐 API Gateway

Los enlaces HATEOAS apuntan al API Gateway en el puerto 8888:
- `http://localhost:8888/api/envios`

## 📝 Estructura del Envío

```json
{
  "idEnvio": 1,
  "idVenta": 123,
  "estadoEnvio": "EN_TRANSITO",
  "fechaEnvio": "2024-01-15",
  "fechaEntrega": "2024-01-20",
  "idDireccion": 456
}
```

## 🔗 Enlaces HATEOAS

Cada respuesta incluye enlaces para:
- `self` - Enlace al recurso actual
- `all-envios` - Listar todos los envíos
- `by-venta` - Buscar por ID de venta
- `create` - Crear nuevo envío
- `update` - Actualizar envío
