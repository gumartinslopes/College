import random
class neuronio:
    def __init__(self, x, target, max_epocas):
        self._x = x
        self._target = target
        self._bias = random.uniform(-1, 1)
        self._lr = 0.2
        for line in self._x:
            line.append(self._bias)
        self._w = [random.uniform(-1,1) for _ in range (len(x[0]))]
        self._max_epocas = max_epocas
        self._predicoes = [-1 for _ in range(len(x))]
        self.err = 0.5
        self.epoca_atual = 0
    
    def somatorio(self, linha_x):
        soma = 0
        for x, w in zip(linha_x, self._w):
            soma += x * w 
        return soma 

    def ativacao(self, linha_x):
        if self.somatorio(linha_x) > 0:
            return 1
        else:
            return 0
    
    def atualiza_pesos(self,  linha_x, result_ativacao, target):
        self.err = target - result_ativacao
        for i in range(len(self._w)):
            self._w[i] += (self.err *  linha_x[i] *  self._lr)
    
    #  Método que faz a execução do algoritmo
    def fit(self):
        while self.err > 0 and self.epoca_atual <(self._max_epocas):
           self.epoca_atual += 1
           i = 0
           for linha, target in zip(self._x, self._target):
               resultado = self.ativacao(linha)
               if(resultado != target):
                    self.atualiza_pesos(linha, resultado, target)
               self._predicoes[i] = resultado
               i += 1
            
            
        return self._predicoes.copy()