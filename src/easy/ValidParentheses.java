package easy;

import java.util.Stack;

/**
 * Created by Genustin on 12/10/14.
 * <p/>
 * Given a string containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order,
 * "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> leftParen = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            switch (item) {
                case '(':
                case '[':
                case '{':
                    leftParen.push(item);
                    break;
                case ')':
                case ']':
                case '}':
                    // no left items?
                    if (leftParen.empty())
                        return false;
                    if (!equal(leftParen.pop(), item))
                        return false;
            }
        }
        // if stack is clean, then it's good.
        return leftParen.empty();
    }

    private boolean equal(char pop, char item) {
        return pop == '(' && item == ')'
                || pop == '[' && item == ']'
                || pop == '{' && item == '}';
    }
}
