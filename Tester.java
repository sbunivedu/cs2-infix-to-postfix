import java.util.Scanner;

public class Tester{
  /**
   * Reads and evaluates multiple postfix expressions.
   */
  public static void main(String[] args){
    InfixToPostfixConverter converter = new InfixToPostfixConverter();
    System.out.println(converter.convert("a + b"));
    System.out.println(converter.convert("2 + 3 * 4"));
    System.out.println(converter.convert("( a + b ) * ( c - d )"));
    System.out.println(converter.convert("A + B * C - D"));
  }
}
