class Vertice: 
    def __init__(self, rotulo):
        self._rotulo = rotulo
        self._grau_incidencia = self._grau_saida = self._grau = 0

    @property
    def rotulo(self):
        return self._rotulo
    
    @property
    def grau_incidencia(self):
        return self._grau_incidencia

    @property
    def grau_saida(self):
        return self._grau_saida
    
    @property
    def grau(self):
        return self._grau

    def update_grau_incidencia(self):
        self._grau_incidencia += 1
    
    def update_grau_saida(self):
        self._grau_saida += 1
    
    def update_grau(self):
        self._grau += 1
        self._grau_saida = self._grau_incidencia = self._grau
            
    def to_string(self):
        result = f"Rotulo: {self.rotulo}\n"
        result += f" - Grau entrada: {self._grau_incidencia}\n"
        result += f" - Grau saida: {self._grau_saida}"
        return result;
