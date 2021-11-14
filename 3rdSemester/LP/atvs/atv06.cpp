#include <iostream>
#include <string>
using namespace std;
class hero
{
	public:
		string secretIdentity;
		string superPower;
		string group;
		hero(string id, string rn, string pw,string gp)
		{
			secretIdentity = id;
			realName = rn;
			superPower = pw;
			group = gp;
		}
	
	private:
		string realName;
};

int main()
{
	hero batman = ("Batman", "Bruce Wayne", "Ser milhonário", "Liga da Justiça");//instanciação de um objeto da classe hero
}
