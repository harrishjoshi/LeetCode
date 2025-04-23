package leetcode.java.arrays;

import java.util.Stack;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>Note:
 * The valid operators are '+', '-', '*', and '/'.
 * </p>
 * LeetCode problem: <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/description/">Evaluate Reverse Polish Notation</a>
 */
public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
                    break;
                case "-":
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b - a));
                    break;
                case "*":
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
                    break;
                case "/":
                    int divisor = Integer.parseInt(stack.pop());
                    int dividend = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(dividend / divisor));
                    break;
                default:
                    stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
}
