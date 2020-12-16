// ---------------------------
// -- test clock generator (1) 690773 Gustavo Martins Lopes da Costa
// ---------------------------
module clock ( output clk );
reg clk;
initial
 begin
 clk = 1'b0;
 end
always
 begin
 #4 clk = ~clk;             //aqui dividimos o período por 3 para que a frqência triplique.
 end
endmodule // clock ( )
module Exemplo_0901;
wire clk;
clock CLK1 ( clk );
initial begin
 $dumpfile ( "Exemplo_0905.vcd" );
 $dumpvars;
 #120 $finish;
end
endmodule // Exemplo_0901 ( )