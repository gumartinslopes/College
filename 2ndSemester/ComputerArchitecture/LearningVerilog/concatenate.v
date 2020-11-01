module concatenate;
reg A;
reg [2:0] B;
reg [4:0] C;
initial begin
    A = 1'b1;
    B = 3'b000;
    C = 5'b10101;
    $display ( {a, b} ); // 4-bits equals to 4'b1000
    $display ( {c[5:3], a} ); // 4-bits equals to 4'b1011
end
endmodule // concatenate