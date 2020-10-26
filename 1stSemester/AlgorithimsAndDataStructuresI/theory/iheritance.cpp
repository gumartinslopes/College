#include <iostream>
#include <locale.h>

using namespace std;

class FigGeo{
    private :
        string cor;
        static int quantidade;

    public :
        static int getQuantidade(){
            return quantidade;
        }
        FigGeo(){
            quantidade++;
        }
        FigGeo(string cor){
            quantidade++;
            setCor(cor);
        }
        ~FigGeo(){
            quantidade--;
        }
        void setCor(string cor){
            this->cor= cor;
        }
        string getCor(){
            return this->cor;
        }

        void le(){
            string cor;
            cout << "\nCor: ";
            cin  >> cor;
            setCor(cor);
        }
        void escreve(){
            cout << "\nCor: " << getCor();
        }
};

class Quadrado : public FigGeo{
    private :
        float lado = 0;
        static int quantidade;

    public :
        static int getQuantidade(){
            return quantidade;
        }
        Quadrado(){
            quantidade++;
        }
        Quadrado(float lado){
            quantidade++;
            setLado(lado);
        }
        Quadrado(float lado, string cor){
            quantidade++;
            setLado(lado);
            setCor(cor);
        }
        ~Quadrado(){
            quantidade--;
        }
        void setLado(float lado){
            if(lado >= 0){
                this->lado= lado;
            }
        }
        float getLado(){
            if(this->lado >= 0){
                return this->lado;
            }
            else{
                return 0;
            }
        }
        float area(){
            return getLado() * getLado();
        }
        float perimetro(){
            return 4 * getLado();
        }
        void le(){
            float lado;
            cout << "\nLado= ";
            cin  >> lado;
            setLado(lado);
            FigGeo::le();
        }
        void escreve(){
            cout << "\nLado: " << getLado();
            FigGeo::escreve();
            cout << "\nÁrea= " << area();
            cout << "\nPerímetro= " << perimetro();
        }
};

class Circulo : public FigGeo{
    private:
        float raio= 0;
        static int quantidade;

    public:
        static int getQuantidade(){
            return quantidade;
        }
        Circulo(){
            quantidade++;
        }
        Circulo(float raio){
            quantidade++;
            setRaio(raio);
        }
        Circulo(float raio, string cor){
            quantidade++;
            setRaio(raio);
            setCor(cor);
        }
        ~Circulo(){
            quantidade--;
        }
        void setRaio(float raio){
            if(raio >= 0){
                this->raio = raio;
            }
        }
        float getRaio(){
            return this->raio;
        }
        float area(){
            return 3.14 * getRaio() * getRaio();
        }
        float perimetro(){
            return 2 * 3.4 * getRaio();
        }
        void le(){
            float raio;
            cout << "\nRaio= ";
            cin  >> raio;
            setRaio(raio);
            FigGeo::le();
        }
        void escreve(){
            cout << "\nRaio: " << getRaio();
            FigGeo::escreve();
            cout << "\nÁrea= " << area();
            cout << "\nPerímetro= " << perimetro();
        }
};

int Quadrado::quantidade= 0;
int  Circulo::quantidade= 0;
int   FigGeo::quantidade= 0;

int main()
{
    setlocale(LC_ALL, "portuguese");
    cout << "\nHerança" << endl;

    cout << "\n\nFigura Geométrica: ";
    FigGeo F1;
    F1.setCor("Amarela");
    F1.escreve();

    cout << "\n\nQuadrados";
    Quadrado Q1;
    Q1.setLado(7);
    Q1.setCor("Azul");
    Q1.escreve();

    Quadrado* Q2 = new Quadrado(5.0,"Marron");
    Q2->escreve();

    cout << "\n\nCírculos";
    Circulo *C1 = new Circulo();
    C1->le();
    C1->escreve();

    cout << "\n\nQuant. de quadrados= "      << Quadrado::getQuantidade();
    cout << "\nQuant. de círculos= "         <<  Circulo::getQuantidade();
    cout << "\nQuant. de Fig. Geométricas= " <<   FigGeo::getQuantidade();

    return 0;
}
