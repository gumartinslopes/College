#include <iostream>
#include <locale>

#define MAX 10


using namespace std;
class Pessoa{
    private:
        string nome;
        int diaNascimento;//Dom�nio do dia 1 a 31
        int mesNascimento;//Dom�nio do mes 1 a 12
    public:
        static int quantidade;
        Pessoa(){
            quantidade++;
        }
        Pessoa(string Nome, int diaDoNascimento, int mesDoNascimento){
            setNome(Nome);
            setDia(diaDoNascimento);
            setMes(mesDoNascimento);
            quantidade++;
        }
        ~Pessoa(){
            quantidade--;
        }
        void setNome(string Nome){
            this->nome = Nome;
        }
        void setDia(int diaDoNascimento){
            if(diaDoNascimento >= 1 && diaDoNascimento <= 31)
                this->diaNascimento = diaDoNascimento;
            else
                this->diaNascimento = 0;
        }
        void setMes(int mesDoNascimento){
            if(mesDoNascimento >= 1 && mesDoNascimento <= 12)
                this->mesNascimento = mesDoNascimento;
            else mesNascimento = 0;
        }
        static int getQuantidade(){
            return quantidade;
        }
        string getNome(){
            return nome;
        }
        int getDia(){
            return diaNascimento;
        }
        int getMes(){
            return mesNascimento;
        }
        bool aniversarianteMes(int mesMeu, int Mes){
            bool ehAniversariante;
            if(mesMeu == Mes)
                ehAniversariante = true;
            else
                ehAniversariante = false;
            return ehAniversariante;
        }
        virtual void le(){}
       virtual void escreve(){
            cout << "\n A pessoa cadastrada � " << getNome();
            cout << ", ela nasceu no dia "<< getDia() << " do m�s " << getMes();
        }
};

class Cliente : public Pessoa{
    private:
        float limiteCredito;
    public:
        static int quantidadeCliente;

        void setlimite(float limite){
            this->limiteCredito = limite;
        }
        float getLimite(){
            return limiteCredito;
        }
        void le(){
            string nome;
            int mes,
            dia;
            float limite;

            cout << "\nPor favor insira o nome do cliente "; cin >> nome;
            setNome(nome);
            cout << "\nInsira o n�mero do m�s de nascimento "; cin >> mes;
            setMes(mes);
            cout << "\nAgora insira a data de nascimento "; cin >> dia;
            setDia(dia);
            cout << "\nInsira o limite de cr�dito do seu cliente " ; cin >> limite;
            setlimite(limite);
            cout << "\n Um cliente foi criado!" <<  endl;
        }
        void escreve(){
            cout << "\n\t O nome do cliente � " << getNome();
            cout << ", ele nasceu no dia "<< getDia() << " do m�s " << getMes() << endl;
            cout <<"\tE seu limite de cr�dito � " << getLimite();
        }
        bool creditoAprovado(float compra){
            bool aprovado = true;
            if(compra > limiteCredito)
                aprovado = false;
            return aprovado;
        }
};

class Funcionario : public Pessoa{
    private:
        float salarioBruto;
    public:
        static int quantidadeFuncionario;

        void setSalario(float salario){
            this->salarioBruto = salario;
        }
        float getSalario(){
            return salarioBruto;
        }
        void le(){
            string nome;
            int mes,
            dia;
            float salBruto;

            cout << "\nPor favor insira o nome do funcion�rio: "; cin >> nome;
            setNome(nome);
            cout << "\nInsira o n�mero do m�s de nascimento: "; cin >> mes;
            setMes(mes);
            cout << "\nAgora insira a data de nascimento: "; cin >> dia;
            setDia(dia);
            cout << "\nInsira o seu sal�rio bruto: "; cin >> salBruto;
            setSalario(salBruto);
            cout << "\n Um funcion�rio foi criado!" <<  endl;
        }
        void escreve(){
            cout << "\n\t O nome do funcion�rio � " << getNome();
            cout << ", ele nasceu no dia "<< getDia() << " do m�s " << getMes() << endl;
            cout << "\t E seu sal�rio � R$" << getSalario() << endl;
        }
        float salarioLiquido(){
            float INSS = (getSalario() * 8) / 100;
            float liquido = getSalario() - INSS;
            return liquido;
        }
        float salarioLiquido(float taxa){
            float INSS = (getSalario() * taxa) / 100;
            float liquido = getSalario() - INSS;
            return liquido;
        }
};
class passouDoLimite{
    public:
        void mensagem(){
            cout<<"\nVoc� excedeu o limite de usu�rios\n";
        }
};
void pulaLinha(int l){
    for(int i = 1; i <= l; i++){
        cout <<"\n";
    }
}
void listaCliente(Cliente* C[]){
    int quantC = Cliente::quantidadeCliente;
    for(int i = 0; i < quantC; i++){
            C[i]->escreve();
            pulaLinha(2);
    }
}
void listaFuncionario(Funcionario* F[]){
     int quantF = Funcionario::quantidadeFuncionario;
     for(int f = 0; f < quantF; f++){
            F[f]->escreve();
            pulaLinha(2);
    }
}
void listaGeral(Cliente* c[], Funcionario* f[]){
    cout << "\tEsses s�o os seus clientes cadastrados" << endl;
        listaCliente(c);
        pulaLinha(1);
    cout << "\tEsses s�o os seus funcion�rios cadastrados" << endl;
        listaFuncionario(f);
        pulaLinha(1);
}

void pesquisaAniversariante(Pessoa* P[]){
    cout << "\t\tAniversariante do M�s"<< endl;
    int mes = 0;
                 do{
                     cout << "Insira o m�s que voc� quer pesquisar ";cin >> mes;
                  if(mes >12 || mes < 1)
                        cout << "valor inv�lido"<< endl;
                 }while(mes >12 || mes < 1);
                 cout << "Estes s�o os aniversariantes do mes " << mes << " ";

                 for(int i = 0; i < Pessoa::quantidade;i++){
                    int meuMes = P[i]->getMes();

                    bool fazAniversario = P[i]->aniversarianteMes(meuMes ,mes);
                    if(fazAniversario){
                        cout << P[i]->getNome() << ", ";
                    }
                 }
}
void cadastraCliente(Cliente* C[], Pessoa* P[]){
    int quantC = Cliente::quantidadeCliente;
    int quantT = Pessoa::quantidade;
    try{
        if(quantC > MAX)
            throw passouDoLimite();
        else{
        cout << "\t\tCadastrar Cliente" << endl;
        C[quantC] = new Cliente();
        C[quantC]->le();
        pulaLinha(2);
        C[quantC]->escreve();
        pulaLinha(3);
        P[quantT]= C[quantC];

        quantC++;
        Cliente::quantidadeCliente++;
        }
    }
    catch(passouDoLimite passouDoLimite){
        passouDoLimite.mensagem();
    }

}

void consultaAprovacao(Cliente* C[]){
    float valorCompra;
    int quantC = Cliente::quantidadeCliente;
    if(quantC > 0){
                cout << "\nQual o valor da compra que o �ltimo cliente cadastrado que fazer? " ;cin >> valorCompra;
                bool aprovado = C[quantC-1]->creditoAprovado(valorCompra);

                if(aprovado == true)
                    cout << "\tA compra pode ser efetuada!"<<endl;
                else
                    cout <<"\a\tA compra n�o pode ser efetuada com sucesso, por favor verifique a sua conta!"<<endl;
            }
            else
                cout <<"\aNenhum cliente foi cadastrado!"<< endl;
}

void cadastraFuncionario(Funcionario* F[], Pessoa* P[]){
     int quantF = Funcionario::quantidadeFuncionario;
     int quantT = Pessoa::quantidade;
    cout << "\t\tCadastrar Funcion�rio" << endl;

    try{
        if(quantF > MAX)
            throw passouDoLimite();
        else{
        F[quantF] = new Funcionario();
        F[quantF]->le();
        pulaLinha(2);
        F[quantF]->escreve();
        pulaLinha(3);
        P[quantT] = F[quantF];
        quantF++;
        Funcionario::quantidadeFuncionario++;
        }
    }
    catch(passouDoLimite passouDoLimite){
        passouDoLimite.mensagem();
    }

}

void consultaSalario(Funcionario* F[]){
    int quantF = Funcionario::quantidadeFuncionario;
    float valorInss;
    char escolha2;
    float salarioLiq;
    bool validado = false;
    cout << "Voc� gostaria de informar um percentual padr�o para o inss?";
        do{
            cout << "\nDigite s para sim ou n para n�o";cin >> escolha2;
                if(escolha2 == 's'){
                    cout << "insira o valor do inss";cin >> valorInss;
                    salarioLiq = F[quantF-1]->salarioLiquido(valorInss);
                    validado = true;
                }
                else if(escolha2 == 'n')
                {
                    salarioLiq = F[quantF-1]->salarioLiquido();
                    validado = true;
                }
                else cout << "\aValor inv�lido, tente novamente por favor"<< endl;

                }while(validado == false);
                 cout << "O sal�rio l�quido do funcion�rio "<< F[quantF-1]->getNome() << " � R$" << salarioLiq;
}
int menu(){
  setlocale(LC_ALL,"Portuguese");
  int escolha;
  do{
    cout << "\n\t\tMenu Principal" << endl;
    cout << "\n Para listar todos os usu�rios aperte 1" << endl;
    cout << " Para Pesquisar o anivers�riante do m�s pressione 2" << endl;
        pulaLinha(1);
    cout << " Para cadastrar um cliente pressione 3" << endl;
    cout << " Para consultar uma aprova��o pressione 4"<< endl;
    cout << " Para listar todos os clientes pressione 5" << endl;
        pulaLinha(1);
    cout << " Para cadastrar um funcionario pressione 6" << endl;
    cout << " Para calcular o salario de um funcionario pressione 7" << endl;
    cout << " Para listar os funcionarios pressione 8" << endl;
        pulaLinha(1);
    cout << " Para sair do programa pressione 0" << endl;
    cout << " Sua escolha: "; cin >> escolha;
    if(escolha < 0 || escolha > 8)
        cout << "\n\t\t\t\aValor invaido, por favor insira novamente!" << endl;
  }while(escolha < 0 || escolha > 8);
  return escolha;
};


int Cliente::quantidadeCliente = 0;
int Funcionario::quantidadeFuncionario = 0;
int Pessoa::quantidade = 0;

int main()
{
    cout << "Bem vindo a agenda do seu banco!" << endl;
    int  Escolha;

    Pessoa* P[MAX*2];
    Cliente* C[MAX];
    Funcionario* F[MAX];

    do{
        Escolha = menu();
        switch(Escolha){
            case 0:{
                pulaLinha(25);
                cout <<"\t\t\t Obrigado por usar nosso programa!" << endl;
                pulaLinha(15);
            break;
            }
            case 1:{
                 listaGeral(C,F);
            break;
            }
            case 2:{
                 pesquisaAniversariante(P);
                 pulaLinha(3);
            break;
            }
            case 3:{
                cadastraCliente(C,P);
            break;
            }
            case 4:{
                cout << "\t\tConsultando Aprovacao" << endl;
                consultaAprovacao(C);
            break;
            }
            case 5:{
                cout << "\t\tListar clientes" << endl;
                listaCliente(C);
            break;
            }
            case 6:{
                cadastraFuncionario(F,P);
            break;
            }
            case 7:{
                cout << "Consultar Salario";
                consultaSalario(F);
            break;
            }

            case 8:{
                cout << "\t\tListar funcionarios"<< endl;
                listaFuncionario(F);
            break;
            }

        }


    }while(Escolha != 0);

    return 0;
}
