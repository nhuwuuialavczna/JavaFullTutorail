package compiler.tinhtoan;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class TestLexer {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("1+2*3");
        while (lexer.hasNextToken()) {
            System.out.println(lexer.nextToken());
        }
    }
}
