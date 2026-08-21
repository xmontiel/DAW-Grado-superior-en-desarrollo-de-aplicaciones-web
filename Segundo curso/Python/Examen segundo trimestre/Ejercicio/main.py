from fastapi import FastAPI
from routers import incidencias, auth_router

app = FastAPI(
    title="API REST - Gestión de Incidencias",
    description="API para gestionar incidencias de soporte técnico con autenticación JWT",
    version="1.0.0"
)

app.include_router(auth_router.router)
app.include_router(incidencias.router)


@app.get("/", tags=["Root"])
def root():
    return {"mensaje": "Bienvenido a la API de Incidencias. Visita /docs para la documentación."}
