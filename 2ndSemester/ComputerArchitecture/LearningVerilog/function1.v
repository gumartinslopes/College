module function1;

function [1:1] add1; // definir função
    input e1, e2; // duas entradas
    reg A;
    begin
        A = 1;
        if ( e1 == e2 )
        add1 = 1 & A;
        else
        add1 = 0;
    end
endfunction

initial begin:
    reg B;
    B = add1(1, 0); // invocação da função com dois argumentos
    $display( "Saida = %b", B );
end;
endmodule // function1