class Instrucao():
    def __init__(self, op_code, clocks_necessarios):
        self.op_code = op_code
        self.stall = False
        self.clocks_necessarios = clocks_necessarios

class InstrucaoDesvio(Instrucao):
    def __init__(self, op_code, label):
        self.label = label
        super().__init__(op_code, 1)

class InstrucaoBeq(InstrucaoDesvio):
    def __init__(self, op_code, op_1, op_2, label):
        self.op_1 = op_1
        self.op_2 = op_2
        super().__init__(op_code, label)

    def __str__(self):
        str_rep = f'Instrucao: {self.op_code} {self.op_1}, {self.op_2}, {self.label}'
        str_rep += f'\nStall: {self.stall}'
        return str_rep
        

class InstrucaoMemoria(Instrucao):
    def __init__(self, op_code,op_1, imediato, reg_deslocamento):
        self.op_1 = op_1
        self.imediato = imediato
        self.reg_deslocamento = reg_deslocamento
        super().__init__(op_code, 2)

    def __str__(self):
        str_rep = f'Instrucao: {self.op_code} {self.op_1}, {self.imediato}({self.reg_deslocamento})'
        str_rep += f'\nStall: {self.stall}'
        return str_rep

class InstrucaoAritmetica(Instrucao):
    def __init__(self, op_code, dest, op_1, op_2):
        self.dest = dest
        self.op_1 = op_1
        self.op_2 = op_2
        super().__init__(op_code, 1)

    def __str__(self):
        str_rep = f'Instrucao: {self.op_code} {self.dest}, {self.op_1}, {self.op_2}'
        str_rep += f'\nStall: {self.stall}'
        return str_rep