#include <stdio.h>

#define MAX_OPERANDS 3
#define MAX_EXPRESSION_SIZE 200

typedef struct Interpreter Interpreter;
struct Interpreter
{
  char *str;
  int pos;
  int operands[MAX_OPERANDS];
};

int readExpression (Interpreter *interpreter)
{
  int result, aux;
  char character = interpreter->str[interpreter->pos++];
  if(character == 'A')
    result = interpreter->operands[0];
  else if(character == 'B')
    result = interpreter->operands[1];
  else if(character == 'C')
    result = interpreter->operands[2];
  else if(character == 'n')//not
  {
    interpreter->pos += 3;
    result = !readExpression(interpreter);
    interpreter->pos++;
  }
  else if(character == 'a') //and
  {
    interpreter->pos+= 3;
    result = readExpression(interpreter);
    while(interpreter->str[interpreter->pos] == ',')
    {
      interpreter->pos++;
      aux = readExpression(interpreter);
      result = result && aux;
    }
    interpreter->pos++;
  }
  else if(character == 'o') //or
  {
      interpreter->pos += 2;
      result = readExpression(interpreter);
      while(interpreter->str[interpreter->pos] == ',')
      {
        interpreter->pos++;
        aux = readExpression(interpreter);
        result = result || aux;
      }
      interpreter->pos++;
  }

  return result;
}

void removeWhiteSpacesFrom(char *source, char *destination){
  while(*source != '\0' && *source !=  '\r' && *source != '\n')
  {
    if(*source != ' ')
      *destination++ = *source;
    source++;
  }
  *destination = '\0';
}

int main()
{
  Interpreter interpreter;
  char expr[MAX_EXPRESSION_SIZE], exprWithoutSpaces[MAX_EXPRESSION_SIZE];
  int numOperands;
  scanf("%d", &numOperands);

  for(int i = 0; i < numOperands; i++)
    scanf("%d",&interpreter.operands[i]);

  scanf("%*c");//evitando leitura de caractere em branco

  fgets(expr, MAX_EXPRESSION_SIZE, stdin);
  removeWhiteSpacesFrom(expr, exprWithoutSpaces);

  interpreter.str = exprWithoutSpaces;
  interpreter.pos = 0;

  int result = readExpression(&interpreter);
  printf("'%s' = %d\n", interpreter.str, result);
  return 0;
}
