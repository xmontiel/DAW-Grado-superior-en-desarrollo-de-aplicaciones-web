from django.contrib import admin
from django.urls import path, include

from rest_framework.routers import DefaultRouter
from productos.api import ProductoViewSet

router = DefaultRouter()
router.register('productos', ProductoViewSet, basename='producto')

urlpatterns = [
    path('admin/', admin.site.urls),
    path('productos/',include('productos.urls')),
    path('api/', include(router.urls)),
]