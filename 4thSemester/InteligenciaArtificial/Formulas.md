=-CONT.se(L1:L13;"SIM"); LOG(CONT.se(L1:L13;"SIM"),2)

MULT(-CONT.se(L1:L13;"SIM"); LOG(CONT.se(L1:L13;"SIM"),2))

LOG(P12CONT.SE(L1:L13;"Sim");2)/12

Contagem dos valores na classe para sim:``N15 = CONT.se(L1:L13; "Sim")``
Contagem dos valores na classe para não:``N16 = CONT.se(L1:L13; "Não")``

Cálculo de entropia da classe = ``MULT(-N15/12;LOG(n15/12;2)) + MULT(-N15/12;LOG(n16/12;2))``