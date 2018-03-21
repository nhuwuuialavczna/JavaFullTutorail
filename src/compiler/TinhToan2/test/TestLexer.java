package compiler.TinhToan2.test;


import compiler.TinhToan2.lexer.Lexer;

public class TestLexer {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("2 ^(2+1)");
        while (lexer.hasNextToken()) {
            System.out.println(lexer.nextToken());
        }

    }
}
