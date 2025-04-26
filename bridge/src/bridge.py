# Abstracción: La clase Dispositivo
class Dispositivo:
    def __init__(self, implementacion):
        self.implementacion = implementacion

    def encender(self):
        self.implementacion.encender()

    def apagar(self):
        self.implementacion.apagar()

    def establecer_canal(self, canal):
        self.implementacion.establecer_canal(canal)


# Implementaciones Concretas
class TVImplementacion:
    def encender(self):
        print("TV: Encendiendo")

    def apagar(self):
        print("TV: Apagando")

    def establecer_canal(self, canal):
        print(f"TV: Estableciendo canal en {canal}")


class RadioImplementacion:
    def encender(self):
        print("Radio: Encendiendo")

    def apagar(self):
        print("Radio: Apagando")

    def establecer_canal(self, canal):
        print(f"Radio: Sintonizando estación {canal}")


class DVDImplementacion:
    def encender(self):
        print("DVD: Encendiendo")

    def apagar(self):
        print("DVD: Apagando")

    def agregar_cd(self, cd):
        print(f"DVD: Agregando CD '{cd}'")


# Clientes
tv = Dispositivo(TVImplementacion())
radio = Dispositivo(RadioImplementacion())
dvd = Dispositivo(DVDImplementacion())

# Operaciones para TV
tv.encender()
tv.establecer_canal(5)
tv.apagar()

# Operaciones para Radio
radio.encender()
radio.establecer_canal("98.5 FM")
radio.apagar()

# Operaciones para DVD
dvd.encender()
dvd.implementacion.agregar_cd("Película: El Señor de los Anillos")
dvd.apagar()