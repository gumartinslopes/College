
module Guia_0102;
// define data
 integer xa = 0; // criamos uma variável decimal x
 integer xb = 0; 
 integer xc = 0; 
 integer xd = 0; 
 integer xe = 0; 
 reg[7:0] a = 8'b00001011;
 reg[7:0] b = 8'b00010110; 
 reg[7:0] c = 8'b00101101;
 reg[7:0] d = 8'b00111011;
 reg[7:0] e = 8'b00111001;
// actions
 initial
 begin : main
 $display ( "Guia_0102 - Tests" );
 
 xa = a;
 $display ( "a) b = %d", xa );
 xb = b;
 $display ( "b)b = %d", xb );
 xc = c;
 $display ( "c)b = %d", xc );
 xd = d;
 $display ( "d)b = %d", xd );
 xe = e;
 $display ( "e)b = %d", xe );
 end // main
endmodule // Guia_0102