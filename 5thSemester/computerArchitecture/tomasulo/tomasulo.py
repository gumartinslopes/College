from instrucao import *
from processador import Processador
from unidades_funcionais.somador import Somador

op1 = InstrucaoAritmetica('ADD', '$r1', '$r2', '$r3')
op2 = InstrucaoBeq('BEQ', '$r1','$r2', '#saida')
op3 = InstrucaoMemoria('LW', '$r1', 10, '$r2')
p = Processador()
p.inserir_fila(op1)
p.inserir_fila(op2)
p.inserir_fila(op3)
p.visualiza_fila()