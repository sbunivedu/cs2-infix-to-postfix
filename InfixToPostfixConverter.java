import java.util.Stack;
import java.util.Scanner;
/**
 *Convert an expression from infix notation to postfix notation.
 */
public class InfixToPostfixConverter{
  private final static char ADD = '+';
  private final static char SUBTRACT = '-';
  private final static char MULTIPLY = '*';
  private final static char DIVIDE = '/';

  private Stack<String> stack;

  /**
   * Sets up this converter creating a new stack.
   */
  public InfixToPostfixConverter(){
    stack = new Stack<String>();
  }

  /**
   * Convert the specified infix expression to postfix.
   * @param expr string representation of a infix expression
   * @return string representation of the postfix expression
   */
  public String convert(String expr){
    String result = "";
    String token;
    Scanner scan = new Scanner(expr);

    while (scan.hasNext()){
      token = scan.next();
      //System.out.println("token: -"+token+"-");

      if (isOperand(token)){
        result += " " + token;
      } else if(token.equals("(")){
        stack.push(token);
      } else if(token.equals(")")){
        while(!stack.isEmpty() && !stack.peek().equals("(")){
          result += " " + stack.pop();
        }
        stack.pop(); // pop "("
      } else if(isOperator(token)){
        while (!stack.isEmpty() && isOperator(stack.peek()) &&
          precedenceOrder(stack.peek()) >= precedenceOrder(token)){
          result += " " + stack.pop();
        }
        stack.push(token);
      } else {
        System.out.println("invalid input: "+token);
      }
    }

    while(!stack.isEmpty()){
      result += " " + stack.pop();
    }

    return result;
  }

  /**
   * Determines if the specified token is an operator.
   * @param token the token to be evaluated 
   * @return true if token is operator
   */
  private boolean isOperator(String token){
    char operator = token.charAt(0);
    return operator == ADD || operator == SUBTRACT ||
      operator == MULTIPLY || operator == DIVIDE;
  }

  private boolean isOperand(String token){
    return !isOperator(token) && !token.equals("(") && !token.equals(")");
  }

  private int precedenceOrder(String token){
    char operator = token.charAt(0);
    if(operator == MULTIPLY || operator == DIVIDE){
      return 2;
    }else {
      return 1;
    }
  }
}
