from abc import ABC, abstractmethod

# Interfaz común
class Documento(ABC):
    @abstractmethod
    def mostrar(self):
        pass

    @abstractmethod
    def editar(self, nuevo_contenido):
        pass

# Documento real
class DocumentoReal(Documento):
    def __init__(self, contenido):
        self.contenido = contenido

    def mostrar(self):
        print("Contenido del documento:", self.contenido)

    def editar(self, nuevo_contenido):
        self.contenido = nuevo_contenido
        print("El documento ha sido editado.")

# Proxy con control de acceso y permisos
class DocumentoProxy(Documento):
    def __init__(self, contenido, contraseña, permisos):
        """
        permisos: string, 'lectura' o 'edicion'
        """
        self.documento_real = DocumentoReal(contenido)
        self.contraseña = contraseña
        self.permisos = permisos  # 'lectura' o 'edicion'

    def mostrar(self):
        if self.verificar_acceso():
            self.documento_real.mostrar()
        else:
            print("¡Acceso denegado! Contraseña incorrecta.")

    def editar(self, nuevo_contenido):
        if not self.verificar_acceso():
            print("¡Acceso denegado! Contraseña incorrecta.")
            return
        if self.verificar_permiso_edicion():
            self.documento_real.editar(nuevo_contenido)
        else:
            print("¡Permiso denegado! Solo tiene permiso de lectura.")

    def verificar_acceso(self):
        intento = input("Ingrese la contraseña para ver el documento: ")
        return intento == self.contraseña

    def verificar_permiso_edicion(self):
        return self.permisos == "edicion"

# Uso
if __name__ == "__main__":
    # Cambia 'lectura' por 'edicion' para probar ambos casos
    doc = DocumentoProxy("Este es un documento confidencial.", "1234", "lectura")
    doc.mostrar()
    doc.editar("Nuevo contenido secreto")

    print("\n--- Prueba con permisos de edición ---")
    doc2 = DocumentoProxy("Documento editable.", "abcd", "edicion")
    doc2.mostrar()
    doc2.editar("Texto editado correctamente.")