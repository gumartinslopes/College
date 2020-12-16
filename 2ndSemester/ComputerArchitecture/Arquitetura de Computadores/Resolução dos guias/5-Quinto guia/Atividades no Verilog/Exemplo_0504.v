// Exemplo_0504 - GATES
// Nome: Gustavo Martins Lopes da Costa 
// Matricula: 6907733

module f5 ( output s,input a, input b );
// definir dado local
wire  A, B;
// Resolução por meio de portas
not NOT1 ( not_a, a );
nor NOR1( A, a, a);  
nor NOR2( B, b, b);
nor NOR3( s, A, B);
endmodule // f5

module f5b ( output s, input a, input b );
// descrever por expressao
assign s = (~|a) ~| (~|b);   //conjunção por expressao representando vários nors
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
    $display("Exemplo_0504 - Gustavo Martins Lopes da Costa - 6907733");
    $display("Test module da conjuncao utilizando NOR");
    $display("   x    y    a    b");
    // ------------------------- Testes para montar a tabela verdade
    $monitor("%4b %4b %4b %4b", x, y, a, b);
    x = 1'b0; y = 1'b0;
    #1 x = 1'b0; y = 1'b1;
    #1 x = 1'b1; y = 1'b0;
    #1 x = 1'b1; y = 1'b1;
end
endmodule 