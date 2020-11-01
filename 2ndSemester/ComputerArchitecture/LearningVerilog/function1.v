module function1;
function [1:1] equals; // definir função
    input e1, e2; // duas entradas
    reg A;
    begin
        A = 1;
        if ( e1 == e2 )
        equals = 1 & A;
        else
        equals = 0;
    end
endfunction

task print;
    input B;
    if(B == 1)
    $display("They are the same");
    else 
    $display("Different values bro");
endtask

 reg B;

initial begin
    B = equals(1, 1); // invocação da função com dois argumentos
    print(B);
    $display( "Output = %b", B );
end
endmodule // function1