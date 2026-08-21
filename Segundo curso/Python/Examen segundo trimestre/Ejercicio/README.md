# API REST - Gestión de Incidencias con FastAPI + MySQL + JWT

## Estructura del proyecto

```
fastapi_incidentes/
├── main.py              # Punto de entrada
├── database.py          # Conexión MySQL con SQLAlchemy
├── models.py            # Modelo ORM tabla incidencias
├── schemas.py           # Esquemas Pydantic
├── jwt_utils.py         # Lógica JWT
├── requirements.txt
└── routers/
    ├── __init__.py
    ├── auth_router.py   # POST /login · GET /me
    └── incidencias.py   # CRUD incidencias
```

## Instalación

```bash
python -m venv venv
venv\Scripts\activate        # Windows
pip install -r requirements.txt
```

## Base de datos

Credenciales configuradas en `database.py`: `root / root`

Ejecuta el SQL del enunciado en MySQL para crear la base de datos y la tabla.

## Arrancar

```bash
uvicorn main:app --reload
```

Swagger: http://127.0.0.1:8000/docs

## Credenciales JWT

- **username**: admin  
- **password**: admin123

## Endpoints

| Método | Ruta | Auth | Descripción |
|--------|------|------|-------------|
| GET | `/` | No | Bienvenida |
| POST | `/login` | No | Obtener token JWT |
| GET | `/me` | Sí | Usuario del token |
| GET | `/incidencias/` | No | Listar incidencias |
| POST | `/incidencias/` | Sí | Crear incidencia |
| GET | `/incidencias/{id}` | No | Obtener por ID |
| DELETE | `/incidencias/{id}` | Sí | Eliminar incidencia |
