/*
 Guia_0101.
*/
module Guia_0101;
// define data
 integer x = 54; // decimal
 reg [7:0] b = 0; // binary
// actions
 initial
 begin : main
 $display ( "Guia_0101 - Tests" );
 $display ( "x = %d" , x );
 $display ( "b = %8b", b );
 b = x;
 $display ( "%d em binario equivale a  %8b",x , b );
 end // main
endmodule // Guia_0101