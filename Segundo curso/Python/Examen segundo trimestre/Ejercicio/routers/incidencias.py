from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from typing import List

from database import get_db
from models import Incidencia
from schemas import IncidenciaResponse, IncidenciaCreate, TokenData
from jwt_utils import obtener_usuario_actual

router = APIRouter(
    prefix="/incidencias",
    tags=["Incidencias"]
)


@router.get("/", response_model=List[IncidenciaResponse])
def listar_incidencias(db: Session = Depends(get_db)):
    """
    Endpoint público. Devuelve el listado completo de incidencias desde MySQL.
    """
    return db.query(Incidencia).all()


@router.post("/", response_model=IncidenciaResponse, status_code=status.HTTP_201_CREATED)
def crear_incidencia(
    incidencia: IncidenciaCreate,
    db: Session = Depends(get_db),
    usuario_actual: TokenData = Depends(obtener_usuario_actual)
):
    """
    Endpoint protegido (requiere JWT). Inserta una nueva incidencia en la base de datos.
    """
    nueva = Incidencia(**incidencia.model_dump())
    db.add(nueva)
    db.commit()
    db.refresh(nueva)
    return nueva


@router.get("/{incidencia_id}", response_model=IncidenciaResponse)
def obtener_incidencia(incidencia_id: int, db: Session = Depends(get_db)):
    """
    Endpoint público. Devuelve una incidencia por su ID.
    """
    incidencia = db.query(Incidencia).filter(Incidencia.id == incidencia_id).first()
    if not incidencia:
        raise HTTPException(
            status_code=status.HTTP_404_NOT_FOUND,
            detail=f"Incidencia con id {incidencia_id} no encontrada"
        )
    return incidencia


@router.delete("/{incidencia_id}", status_code=status.HTTP_204_NO_CONTENT)
def eliminar_incidencia(
    incidencia_id: int,
    db: Session = Depends(get_db),
    usuario_actual: TokenData = Depends(obtener_usuario_actual)
):
    """
    Endpoint protegido (requiere JWT). Elimina una incidencia por su ID.
    """
    incidencia = db.query(Incidencia).filter(Incidencia.id == incidencia_id).first()
    if not incidencia:
        raise HTTPException(
            status_code=status.HTTP_404_NOT_FOUND,
            detail=f"Incidencia con id {incidencia_id} no encontrada"
        )
    db.delete(incidencia)
    db.commit()
