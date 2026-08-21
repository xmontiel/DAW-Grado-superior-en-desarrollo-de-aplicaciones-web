productos = []
id_global = 0

class Producto:
    def __init__(self, id, nombre, precio, cantidad):
        self.id = id
        self.nombre = nombre
        self.precio = precio
        self.cantidad = cantidad

    def __str__(self):
        return "ID: " + str(self.id) + " Nombre: " + self.nombre + " Precio: " + format(self.precio) + " Cantidad: " + str(self.cantidad)

def create():

    global id_global
    nombre = input("\nNombre: ")

    precio = input("Precio: ")
    if precio.replace('.', '', 1).isdigit() and precio.count('.') <= 1:
        precio = float(precio)
    else:
        print("Escribe un precio correcto")
        precio = input("Precio: ")

    cantidad = input("Cantidad: ")
    if cantidad.isdigit():
        cantidad = int(cantidad)
    else:
        print("Escribe un cantidad correcta")
        cantidad = input("Cantidad: ")

    id_global += 1
    nuevo_producto = Producto(id_global, nombre, precio, cantidad)
    productos.append(nuevo_producto)
    print("Creado nuevo producto!\n")

def read():
    print("\nProductos:")
    if len(productos) == 0:
        print("No hay productos...\n")
    else:
        for p in productos:
            print(p)
            print("")

def update():

    id_escrita = input("ID del producto a actualizar: ")
    if not id_escrita.isdigit():
        print("ID incorrecto\n")
        return

    id_buscar = int(id_escrita)
    for p in productos:
        if p.id == id_buscar:
            print("Producto encontrado: " + str(p))

            nuevo_nombre = input("Nuevo nombre, ENTER para mantener actual: ")
            if nuevo_nombre != "":
                p.nombre = nuevo_nombre

            nuevo_precio = input("Nuevo precio, ENTER para mantener actual: ")
            if nuevo_precio.replace('.', '', 1).isdigit() and nuevo_precio.count('.') <= 1:
                p.precio = float(nuevo_precio)
            elif nuevo_precio != "":
                print("Escribe un precio correcto: ")
                return

            nueva_cantidad = input("Nueva cantidad, ENTER para mantener actual: ")
            if nueva_cantidad.isdigit():
                p.cantidad = int(nueva_cantidad)
            elif nueva_cantidad != "":
                print("Escribe una cantidad correcta.")
                return

            print("Producto actualizado!\n")
            return

    print("Este producto no existe :(\n")


def delete():

    id_escrita = input("ID del producto a eliminar: ")
    if not id_escrita.isdigit():
        print("ID incorrecto\n")
        return

    id_eliminar = int(id_escrita)
    indice = -1

    for i in range(len(productos)):
        if productos[i].id == id_eliminar:
            indice = i

    if indice != -1:
        del productos[indice]
        print("Producto eliminado\n")
    else:
        print("Este producto no existe :(\n")



def menu():
    opcion = ""
    while opcion != "5":
        print("1: Crear producto")
        print("2: Leer productos")
        print("3: Actualizar producto")
        print("4: Eliminar producto")
        print("5: Salir")

        opcion = input("Selecciona una opción: ")

        if opcion == "1":
            create()
        elif opcion == "2":
            read()
        elif opcion == "3":
            update()
        elif opcion == "4":
            delete()
        elif opcion == "5":
            print("Hasta luego!")
        else:
            print("Opción no válida, vuelva a intentarlo")


menu()
