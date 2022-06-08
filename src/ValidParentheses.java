import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(string.charAt(i));
                    break;
            }
        }
        return stack.isEmpty();
    }
}
