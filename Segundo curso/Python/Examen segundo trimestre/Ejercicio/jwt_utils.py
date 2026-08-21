from datetime import datetime, timedelta
from jose import JWTError, jwt
from fastapi import Depends, HTTPException, status
from fastapi.security import OAuth2PasswordBearer
from schemas import TokenData

SECRET_KEY = "clave_secreta_super_segura_cambiame_en_produccion"
ALGORITHM = "HS256"
ACCESS_TOKEN_EXPIRE_MINUTES = 30

FAKE_USER = {
    "username": "admin",
    "password": "admin123"
}

oauth2_scheme = OAuth2PasswordBearer(tokenUrl="login")


def crear_token(data: dict) -> str:
    payload = data.copy()
    expiracion = datetime.utcnow() + timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)
    payload.update({"exp": expiracion})
    return jwt.encode(payload, SECRET_KEY, algorithm=ALGORITHM)


def verificar_credenciales(username: str, password: str) -> bool:
    return username == FAKE_USER["username"] and password == FAKE_USER["password"]


def obtener_usuario_actual(token: str = Depends(oauth2_scheme)) -> TokenData:
    credenciales_exception = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail="Token inválido o expirado",
        headers={"WWW-Authenticate": "Bearer"},
    )
    try:
        payload = jwt.decode(token, SECRET_KEY, algorithms=[ALGORITHM])
        username: str = payload.get("sub")
        if username is None:
            raise credenciales_exception
        return TokenData(username=username)
    except JWTError:
        raise credenciales_exception
