import java.util.Scanner;
import java.util.Stack;

public class BalancedBracketChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expression = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        boolean isBalanced = true;

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(') {
                    isBalanced = false;
                    break;
                } 
                else if (ch == '}' && top != '{') {
                    isBalanced = false;
                    break;
                } 
                else if (ch == ']' && top != '[') {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            isBalanced = false;
        }

        System.out.println("\n----- Balanced Bracket Result -----");

        if (isBalanced) {
            System.out.println("The brackets are balanced.");
        } else {
            System.out.println("The brackets are not balanced.");
        }

        sc.close();
    }
}