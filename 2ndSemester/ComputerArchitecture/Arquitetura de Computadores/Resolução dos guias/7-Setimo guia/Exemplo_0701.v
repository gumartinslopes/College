// -------------------------
// Exemplo_0701 - GATES
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
module mux ( output s, input a, input b, input select );
// definir dados locais

wire sa;
wire sb;
wire sc;
// descrever por portas

and NAND(sa, a, select);
nand NAND1(sb, b, select);
nand NAND2(sc, sa, sb);
nand NAND3(s, sc, sc);
endmodule // mux


module Exemplo_0701;
// ------------------------- definir dados
reg x;
reg y;
reg s;
wire w;
wire z;
f7 modulo ( w, x, y );
mux MUX1 ( z, x, y, s );
// ------------------------- parte principal
initial
begin : main
$display("Exemplo_0702 - Gustavo Martins Lopes da Costa - 690773");
$display("Test LU's module");
$display("   x    y    s    z");
x = 1'b0; y = 1'b1; s = 1'b0;
// projetar testes do modulo
#1 $monitor("%4b %4b %4b %4b", x, y, s, z);
#1 s = 1'b1;
end
endmodule // test_f7