package compiler.TinhToan2.test;

import compiler.TinhToan2.ast.AST;
import compiler.TinhToan2.parser.Parser;

/**
 * @author JINX_NHI on 2/26/2018.
 */
public class ParseTest {
    public static void main(String[] args) {
        Parser parser = new Parser("2 ^ sqrt(3+2*3) * 6 + 2");
        AST.Exp.T t = parser.parse();
    }
}
