// ---------------------------
// -- test clock generator (1) 690773 Gustavo Martins Lopes da Costa
// ---------------------------
module clock ( output clk );
reg clk;
initial
 begin
 clk = 1'b0;
 end
 event data_in = #12 clk = ~clk; // evento definido pelo usuário
always @ (posgedge clock) 
 begin
 if ( data [8] ==1 ) -> data_in;
 end
endmodule // clock ( )
module Exemplo_0901;
wire clk;
clock CLK1 ( clk );
initial begin
 $dumpfile ( "Exemplo_0801.vcd" );
 $dumpvars;
 #120 $finish;
end
endmodule // Exemplo_0901 ( )