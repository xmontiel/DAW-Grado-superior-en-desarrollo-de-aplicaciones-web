from fastapi import APIRouter, HTTPException, status, Depends
from fastapi.security import OAuth2PasswordRequestForm
from schemas import Token, TokenData
from jwt_utils import crear_token, verificar_credenciales, obtener_usuario_actual

router = APIRouter(tags=["Autenticación"])


@router.post("/login", response_model=Token)
def login(form_data: OAuth2PasswordRequestForm = Depends()):
    """
    Endpoint público. Devuelve un token JWT si las credenciales son correctas.

    - **username**: admin
    - **password**: admin123
    """
    if not verificar_credenciales(form_data.username, form_data.password):
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail="Credenciales incorrectas"
        )
    token = crear_token({"sub": form_data.username})
    return {"access_token": token, "token_type": "bearer"}


@router.get("/me", tags=["Autenticación"])
def obtener_mi_usuario(usuario_actual: TokenData = Depends(obtener_usuario_actual)):
    """
    Endpoint protegido. Devuelve el nombre del usuario autenticado extraído del token JWT.
    """
    return {"usuario_autenticado": usuario_actual.username, "mensaje": "Token válido ✓"}
