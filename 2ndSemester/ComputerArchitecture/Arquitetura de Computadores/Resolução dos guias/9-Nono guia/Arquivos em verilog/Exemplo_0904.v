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
 #6 clk = ~clk;         //aqui diminuimos o período pela metade para dobrar a frequência.
 end
endmodule // clock ( )
module Exemplo_0901;
wire clk;
clock CLK1 ( clk );
initial begin
 $dumpfile ( "Exemplo_0804.vcd" );
 $dumpvars;
 #120 $finish;
end
endmodule // Exemplo_0901 ( )