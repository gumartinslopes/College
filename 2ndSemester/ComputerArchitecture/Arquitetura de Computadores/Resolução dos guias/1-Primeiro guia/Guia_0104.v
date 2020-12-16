module Guia_0104;
// define data
 integer a = 113; // 4
 integer b = 23; // 8
 integer c = 45; // 16
 integer d = 45; // 8
 integer e = 233; // 4

 reg [7:0] ba = 0; // binary
 reg [7:0] bb = 0; // binary
 reg [7:0] bc = 0; // binary
 reg [7:0] bd = 0; // binary
 reg [7:0] be = 0; // binary
// actions
 initial
 begin : main
 $display ( "Guia_0104 - Tests" );
 ba = a;
 bb = b;
 bc = c;
 bd = d;
 be = e;
 $display ( "a = [%2b] [%2b] [%2b] [%2b] = %d", ba[7:6], ba[5:4],ba[3:2],ba[1:0] ,a );
 $display ( "b = [%2b] [%3b] [%3b] = %d", bb[7:6], bb[5:3], bb[2:0], b);
 $display ( "c = [%4b] [%4b] = %X", bc[7:4], bc[3:0],c );
 $display ( "d = [%2b] [%3b] [%3b] = %d", bd[7:6], bd[5:3], bd[2:0], d );
 $display ( "e = [%2b] [%2b] [%2b] [%2b] = %d",be[7:6], be[5:4],be[3:2],be[1:0] ,e );
 end // main
endmodule // Guia_0104