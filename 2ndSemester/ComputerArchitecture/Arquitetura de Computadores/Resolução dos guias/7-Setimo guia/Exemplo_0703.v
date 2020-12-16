// -------------------------
// Exemplo_0703 - GATES
// Nome: Gustavo Martins Lopes da Costa
// Matricula: 690773
// -------------------------
// -------------------------
// f7_gate
// -------------------------
module f7 ( output s, input a, input b );
// descrever por portas
endmodule // f7

// -------------------------
// multiplexer
// -------------------------
module mux ( output sf, input a, input b, input selectT, input select1, input select2);
// definir dados locais

wire sa;
wire sb;
wire sc;    
wire sd;
wire se;
wire sAN; //saida do grupo and/nand
wire sON; //saida do grupo or/nor
wire sf1;
wire sf2;
wire sf;  // saida final do grupo or

// descrever por portas
and  AND(sa, a, select1);
nand NAND1(sb, b, select1);
nand NAND2(sc, sa, sb);
nand NAND3(sAN, sc, sc);

nor NOR1 (sd, a, select2);
or  OR1 (se, b, select2);
nor NOR2 (sf, sd, se);
nor NOR3 (sON, sc, sf);

nand NAND1(sf1, sAN, selectT);
nand NAND2(sf2, sON, selectT);
nand NAND3(sf, sf1, sf2);

endmodule // mux


module Exemplo_0701;
// ------------------------- definir dados
reg x;
reg y;
reg st;
reg sAndNand;
reg sOrNor;
wire w;
wire z;
f7 modulo ( w, x, y );
mux MUX1 ( z, x, y, st , sAndNand, sOrNor);
// ------------------------- parte principal
initial
begin : main
$display("Exemplo_0703 - Gustavo Martins Lopes da Costa - 690773");
$display("Test LU's module");
$display("   x    y    s   sAnd/Nand sOr/nor  z");
x = 1'b0;
y = 1'b1; 
sAndNand = 1'b0;   //chave de grupo1
sOrNor = 1'b0;     //cahve de grupo 2 
st= 1'b0;  //chave total
// projetar testes do modulo
#1 $monitor("%4b %4b %4b %4b %4b %4b", x, y, st, sAndNand, sOrNor,  z); //entrada1, entrada2, saida, chave
#1 st = 1'b1;
#1 sAndNand = 1'b1;
#1 sOrNor = 1'b1;
end
endmodule // test_f7