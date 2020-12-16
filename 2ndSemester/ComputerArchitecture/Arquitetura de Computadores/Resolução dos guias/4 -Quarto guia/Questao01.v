module SoP (output sa, sb, sc, sd, se,
input x, y, z);
// mintermos
assign sa = ~x & (~y + z);
assign sb = (~x | ~y) & ~z;
assign sc = ~(~x & y) & ~z;
assign sd = ~(x & y) & z;
assign se = (x | ~y) & (~y | ~z);
endmodule // SoP

// ---------------------
// -- test_module
// ---------------------
module test_module;
reg x, y, z;
wire sa, sb, sc, sd, se;
// instancias
SoP SOP1 (sa, sb, sc, sd, se, x, y, z);
// valores iniciais
initial begin: start
x=1'bx; 
y=1'bx; 
z=1'bx;// indefinidos
end
// parte principal
initial begin: main
// identificacao
$display("Gustavo Martins Lopes da Costa - 690773");
$display("Guia 04 Questao 01");

// monitoramento
$display("Questao A");
$display(" ~x & (~y + z) = sa ");
$monitor("%2b %2b %2b igual a  %2b", x, y, z,sa);



// sinalizacao
#1 x=0; y=0; z=0;       
#1 x=0; y=0; z=1; 
#1 x=0; y=1; z=1;
#1 x=1; y=1; z=1;   
#1 x=1; y=1; z=0;
#1 x=1; y=0; z=0;
#1 x=0; y=1; z=0;
#1 x=0; y=1; z=0;

$display("\nQuestao b");
$display(" (~x | ~y) & ~z = sb ");
$monitor("%2b %2b %2b igual a  %2b", x, y, z,sb);
#1 x=0; y=0; z=0;       
#1 x=0; y=0; z=1; 
#1 x=0; y=1; z=1;
#1 x=1; y=1; z=1;   
#1 x=1; y=1; z=0;
#1 x=1; y=0; z=0;
#1 x=0; y=1; z=0;
#1 x=0; y=1; z=0;

$display("\nQuestao c");
$display(" ~(~x & y) & ~z = sc ");
$monitor("%2b %2b %2b igual a  %2b", x, y, z,sc);
#1 x=0; y=0; z=0;       
#1 x=0; y=0; z=1; 
#1 x=0; y=1; z=1;
#1 x=1; y=1; z=1;   
#1 x=1; y=1; z=0;
#1 x=1; y=0; z=0;
#1 x=0; y=1; z=0;
#1 x=0; y=1; z=0;

$display("Questao d");
$display("~(x & y) & z= sd ");
$monitor("%2b %2b %2b igual a  %2b", x, y, z,sd);
#1 x=0; y=0; z=0;       
#1 x=0; y=0; z=1; 
#1 x=0; y=1; z=1;
#1 x=1; y=1; z=1;   
#1 x=1; y=1; z=0;
#1 x=1; y=0; z=0;
#1 x=0; y=1; z=0;
#1 x=0; y=1; z=0;

$display("Questao e");
$display("(x | ~y) & (~y | ~z) = se ");
$monitor("%2b %2b %2b igual a  %2b", x, y, z,se);
#1 x=0; y=0; z=0;       
#1 x=0; y=0; z=1; 
#1 x=0; y=1; z=1;
#1 x=1; y=1; z=1;   
#1 x=1; y=1; z=0;
#1 x=1; y=0; z=0;
#1 x=0; y=1; z=0;
#1 x=0; y=1; z=0;
end
endmodule // test_module