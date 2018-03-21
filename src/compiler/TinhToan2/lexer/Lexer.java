package compiler.TinhToan2.lexer;

/**
 * @author JINX_NHI on 2/26/2018.
 */
public class Lexer {

    private String input;
    private int index;

    public Lexer(String input) {
        this.input = input.replace("pi", Math.PI + "");
        this.index = -1;
    }

    public Token nextToken() {
        try {
            return nextTokenInternal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean hasNextToken() {
        return index != input.length() - 1;
    }

    public Token nextTokenInternal() throws Exception {
        index++;
        if (index == input.length()) return new Token(Token.Kind.End, index);
        char c = input.charAt(index);
//        if (!isIdentifier(c)) {
//            throw new UnsupportedOperationException("Phần tử vào không đúng. Đây không phải là số");
//        }
        while (c == ' ') {
            c = input.charAt(++index);
        }

        switch (c) {
            case '+':
                return new Token(Token.Kind.Add, index);
            case '*':
                return new Token(Token.Kind.Mul, index);
            case '-':
                return new Token(Token.Kind.Sub, index);
            case '/':
                return new Token(Token.Kind.Div, index);
            case '(':
                return new Token(Token.Kind.LPAREN, index);
            case ')':
                return new Token(Token.Kind.LPAREN, index);
            case '^':
                return new Token(Token.Kind.Exponential, index);
            case '%':
                return new Token(Token.Kind.Mod, index);
            case '_':
                return new Token(Token.Kind.Rational, index);
            default:
                StringBuilder sb = new StringBuilder();
                if (index == input.length()) {
                    return new Token(Token.Kind.End, index);
                } else {
                    while (true) {
                        sb.append((char) c);
                        index++;
                        if (end(index)) break;
                        c = input.charAt(index);
                        if (isTonken(c)) {
                            break;
                        }
                    }
                    index--;
                }
                switch (sb.toString()) {
                    case "sin":
                        return new Token(Token.Kind.Sin, index);
                    case "cos":
                        return new Token(Token.Kind.Cos, index);
                    case "tan":
                        return new Token(Token.Kind.Tan, index);
                    case "sqrt":
                        return new Token(Token.Kind.SQRT, index);
                    default:
                        return new Token(Token.Kind.Num, index, sb.toString());
                }

        }

    }

    private boolean isTonken(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^' || c == '_' || c == '(' || c == ')';
    }

    private boolean end(int index) {
        return index == input.length();
    }

    private boolean isNumber(char c) {
        String s = String.valueOf(c);
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isIdentifier(char c) {
        String str = c + "";
        return str.charAt(0) >= 'a' || str.charAt(0) <= 'z'
                || str.charAt(0) >= 'A' || str.charAt(0) <= 'Z'
                || str.charAt(0) == '_';
    }
}
