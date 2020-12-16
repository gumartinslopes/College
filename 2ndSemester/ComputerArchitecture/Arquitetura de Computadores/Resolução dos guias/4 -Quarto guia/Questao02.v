// ---------------------
// TRUTH TABLE
// Nome: xxx yyy zzz
// Matricula: 999999
// ---------------------
// ---------------------
// -- expression
// ---------------------

module PoS (output S,
input X, Y);
// MAXTERMOS
assign S = ( X | Y ) // 0
& ( X | ~Y ); // 3
endmodule // PoS

module SoP (output sa, sc, sd, input x, y);
// mintermos
assign sa = ~y & x;
assign sc = x + y;
assign sd = (~x | ~y ) | (x | y);
endmodule // SoP

// ---------------------
// -- test_module
// ---------------------
module test_module;
reg x, y;
wire sa, sb, sc, sd, ;
// instancias
SoP SOP1 (sa, sc, sd, x, y);
PoS POS1 (s3, x, y);
// valores iniciais
initial begin: start
x=1'bx; 
y=1'bx; // indefinidos
end
// parte principal
initial begin: main
// identificacao
$display("Gustavo Martins Lopes da Costa - 690773");
$display("Tabela verdade das expressoes simplificadas");

// monitoramento
$display("Questao A");
$display("Expressao original: x . ~(~x + y)");
$display("Propriedades utilizadas: De Morgan, Associativa e Indepotencia");
$display("Expressao simplificada : ~y . x)");
$display("Tabela verdade");
$monitor("%2b %2b = %2b", x, y, sa);
// sinalizacao
#1 x=0; y=0;
#1 x=0; y=1;
#1 x=1; y=0;
#1 x=1; y=1;


$display("Questao B");
$display("Expressao original: (x + y) + (x . ~y)");
$display("Propriedades utilizadas: ");
$display("Expressao simplificada : ~y . x)");
$display("Tabela verdade");
$monitor("%2b %2b = %2b", x, y, sb);
// sinalizacao
#1 x=0; y=0;
#1 x=0; y=1;
#1 x=1; y=0;
#1 x=1; y=1;

$display("Questao C");
$display("Expressao original: (x + y) + (x . ~y)");
$display("Propriedades utilizadas: De Morgan, idempotencia");
$display("Expressao simplificada : (x + y)");
$display("Tabela verdade");
$monitor("%2b %2b = %2b", x, y, sc);
// sinalizacao
#1 x=0; y=0;
#1 x=0; y=1;
#1 x=1; y=0;
#1 x=1; y=1;

$display("Questao D");
$display("Expressao original: ~(x . y) + (x + y)");
$display("Propriedades utilizadas: De Morgan, tautologia");
$display("Expressao simplificada: (~x + ~y) + (x + y)");
$display("Tabela verdade");
$monitor("%2b %2b = %2b", x, y, sd);
// sinalizacao
#1 x=0; y=0;
#1 x=0; y=1;
#1 x=1; y=0;
#1 x=1; y=1;

// sinalizacao
#1 x=0; y=0;
#1 x=0; y=1;
#1 x=1; y=0;
#1 x=1; y=1;
end
endmodule // test_module