import copy

class Enemigo:
    def clonar(self):
        return copy.deepcopy(self) # devolver una copia exacta del objeto

class Zombi(Enemigo):
    def __init__(self, vida, daño, velocidad):
        self.vida = vida
        self.daño = daño
        self.velocidad = velocidad

    def __str__(self):
        base = f"Zombi {{vida={self.vida}, daño={self.daño}, velocidad={self.velocidad}"
        # Verifica si tiene una habilidad y la agrega al string
        if hasattr(self, 'habilidad'):
            base += f", habilidad={self.habilidad}"
        base += "}"
        return base

# Simulación del juego
def juego():
    zombi_base = Zombi(100, 10, 1.5) # se crea un zombi base

    zombi1 = zombi_base.clonar()
    zombi2 = zombi_base.clonar()

    # Personalizar clones
    zombi1.vida = 120
    zombi2.velocidad = 2.0

    # Clonar un nuevo zombi y agregarle una habilidad
    zombi_con_habilidad = zombi_base.clonar()
    zombi_con_habilidad.vida = 150
    zombi_con_habilidad.daño = 15
    zombi_con_habilidad.velocidad = 3.0
    zombi_con_habilidad.habilidad = "regeneración"

    print("Zombi base:", zombi_base)
    print("Zombi 1:", zombi1)
    print("Zombi 2:", zombi2)
    print("Zombi 3:", zombi_con_habilidad)

# Ejecutar
juego()