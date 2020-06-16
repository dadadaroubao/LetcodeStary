package com.queueANDstack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	public static void main(String[] args) {
		String[] s={"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(s));
	}
	
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<Integer>();
		Integer num1,num2;
		for (String s : tokens) {
			switch (s) {
			case "+":
				num2=stack.pop();
				num1=stack.pop();
				stack.push(num1+num2);
				break;
			case "-":
				num2=stack.pop();
				num1=stack.pop();
				stack.push(num1-num2);
				break;
			case "*":
				num1=stack.pop();
				num2=stack.pop();
				stack.push(num1*num2);
				break;
			case "/":
				num2=stack.pop();
				num1=stack.pop();			
				stack.push(num1/num2);
				break;
			default:
				stack.push(Integer.parseInt(s));
				break;
			}
		}
		return stack.pop();
    }

}
/*根据逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

说明：

整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：

输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: ((2 + 1) * 3) = 9
*/
