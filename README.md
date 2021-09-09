# infix2postfix

The `InfixToPostfixConverter` class implements the infix 
to postfix conversion algorithm in the `convert` method.

Given an expressoion in the __infix__ format as a Java String
object, the `convert` method returns a String object of
the expression in the __postfix__ format. Both the input and
the output expressions must use one or more space characters as
the delimiter between the operators and the operands as
shown in the following test cases:
```
infix                 | postfix
-------------------------------------
2 + 3 * 4             | a b +
2 + 3 * 4             | 2 3 4 * +
( a + b ) * ( c - d ) | a b + c d - *
A + B * C - D         | A B C * + D -
```

The `Tester.java` shows test code that calls the `convert` 
method on all above-mentioned test cases. You can compile and
run this class to get the actual conversion results.
