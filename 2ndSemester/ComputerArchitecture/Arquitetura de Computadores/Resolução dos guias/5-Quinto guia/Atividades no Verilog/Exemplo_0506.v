// Exemplo_0509 - GATES
// Nome: Gustavo Martins Lopes da Costa 
// Matricula: 6907733

module f5 ( output s,input a, input b );
// definir dado local
wire  A, B, c, C;
// Resolução por meio de portas
 
nor NOR1( c, a, b );  
nor NOR2( A, a, a );
nor NOR3( B, b, b );
nor NOR4( C, A, B );
nor NOR5( s, c, C );
endmodule // f5

module f5b ( output s, input a, input b );
// descrever por expressao
assign s = ((a~|b)~|((~|a)~|(~|b)));   //A xor B utilizando apenas nor
endmodule 

module test_f5;
// ------------------------- definindo dados
reg x;
reg y;
wire a, b;
f5 moduloA ( a, x, y );
f5b moduloB ( b, x, y );
// ------------------------- main
initial
begin : main
    $display("Exemplo_0506 - Gustavo Martins Lopes da Costa - 6907733");
    $display("Test module do xor utilizando NOR");
    $display("   x    y    a    b");
    // ------------------------- Testes para montar a tabela verdade
    $monitor("%4b %4b %4b %4b", x, y, a, b);
    x = 1'b0; y = 1'b0;
    #1 x = 1'b0; y = 1'b1;
    #1 x = 1'b1; y = 1'b0;
    #1 x = 1'b1; y = 1'b1;
end
endmodule 