package Amazon;

import java.util.Stack;

/**
 * Created by shiyanch on 1/20/17.
 */
public class Parenthese {
    public static boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && (c - stack.peek() == 1 || c - stack.peek() == 2)) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] ss = {"(", ")", "()", ")(", "", "())", "(())", "()(())"};
        for (String s : ss) {
            System.out.println(isValidParentheses(s));
        }
    }
}
