module Guia_0103;
// define data
 integer xa = 71; // decimal
 integer xb = 43; // decimal
 integer xc = 67; // decimal
 integer xd = 157; // decimal
 integer xe = 151; // decimal

 reg [7:0] a = 0; // binary
 reg [7:0] b = 0; // binary
 reg [7:0] c = 0; // binary
 reg [7:0] d = 0; // binary
 reg [7:0] e = 0; // binary
// actions
 initial
 begin : main
 $display ( "Guia_0103 - Tests" );
 
 a = xa;
 b = xb;
 c = xc;
 d = xd;
 e = xe;
 $display ( "b = %B (2), = %o (8),  = %X (16)", a, a, a, a);
 $display ( "b = %B (2), = %o (8),  = %X (16)", b, b, b, b);
 $display ( "b = %B (2), = %o (8),  = %X (16)", c, c, c, c);
 $display ( "b = %B (2), = %o (8),  = %X (16)", d, d, d, d);
 $display ( "b = %B (2), = %o (8),  = %X (16)", e, e, e, e);
 end // main
endmodule // Guia_0103