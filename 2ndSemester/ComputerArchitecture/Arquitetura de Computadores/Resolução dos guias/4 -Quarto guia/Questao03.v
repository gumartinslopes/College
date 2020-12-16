
module SoP (output s, input x, y, w, z);
// mintermos
assign s = ~x & y // 1
| x & ~y; // 2
endmodule // SoP

// ---------------------
// -- test_module
// ---------------------
module test_module;
reg x, y, w, z;
wire s1, s2, s3;

SoP SOP1 (s2, x, y, w, z);

// valores iniciais
initial begin: start
x=1'bx; 
y=1'bx;
end

// parte principal
initial begin: main
// identificacao
$display("Questão 03- Gustavo Martins Lopes da Costa - 690773");

// monitoramento
$display(" x  y = s1 ");
$monitor("%2b %2b = %2b %2b %2b", x, y, s1);
// sinalizacao

#1 w=1;	x=1; y=1; z=1;	
#1 w=1;	x=1; y=1; z=0;	
#1 w=1;	x=1; y=0; z=1;	
#1 w=1;	x=0; y=1; z=1;	
#1 w=0;	x=1; y=1; z=1;	
#1 w=0;	x=0; y=0; z=1;	
#1 w=0;	x=0; y=1; z=0;	
#1 w=0;	x=1; y=0; z=0;	
#1 w=1;	x=0; y=0; z=0;	
#1 w=0;	x=0; y=0; z=0;	
#1 w=1;	x=1; y=0; z=0;	
#1 w=0;	x=0; y=1; z=1;	
#1 w=1;	x=0; y=0; z=1;	
#1 w=0;	x=1; y=1; z=0;	
#1 w=1;	x=0; y=1; z=0;	
#1 w=0;	x=1; y=0; z=1;	

end
endmodule // test_module