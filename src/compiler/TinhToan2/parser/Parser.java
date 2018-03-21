package compiler.TinhToan2.parser;

import compiler.TinhToan2.ast.AST;
import compiler.TinhToan2.lexer.Lexer;
import compiler.TinhToan2.lexer.Token;

/**
 * @author JINX_NHI on 2/26/2018.
 */
public class Parser {
    public Lexer lexer;
    public Token current;

    public Parser(String input) {
        lexer = new Lexer(input);
        current = lexer.nextToken();
    }

    private void eatToKen(Token.Kind kind) {
        if (current.kind == kind) {
            current = lexer.nextToken();
        }
    }


    private AST.Exp.T heSoNho() {
        Token token = current;
        if (token.kind == Token.Kind.Num) {
            eatToKen(Token.Kind.Num);
            return new AST.Exp.Number(Double.parseDouble(token.value), token.index);
        } else {
            eatToKen(Token.Kind.LPAREN);
            AST.Exp.T node = parseExp();
            eatToKen(Token.Kind.RPAREN);
            return node;
        }
    }


    private AST.Exp.T parseSuperPriority() {
        AST.Exp.T left = heSoNho();
        while ( current.kind == Token.Kind.Exponential ||current.kind == Token.Kind.Rational) {
            Token token = current;
            if (token.kind == Token.Kind.Exponential) {
                eatToKen(Token.Kind.Exponential);
                left = new AST.Exp.Exponential(left, heSoNho(), current.index);
            } else if (token.kind == Token.Kind.Rational) {
                eatToKen(Token.Kind.Rational);
                left = new AST.Exp.Rational(left,heSoNho(), current.index);
            }
        }
        return left;
    }

    private AST.Exp.T parsePriority() {
        AST.Exp.T left = parseSuperPriority();
        while (current.kind == Token.Kind.Mul || current.kind == Token.Kind.Div ) {
            Token token = current;
            if (token.kind == Token.Kind.Mul) {
                eatToKen(Token.Kind.Mul);
                left = new AST.Exp.Mul(left, parseSuperPriority(), current.index);
            } else if (token.kind == Token.Kind.Div) {
                eatToKen(Token.Kind.Div);
                left = new AST.Exp.Div(left, parseSuperPriority(), current.index);
            }
        }
        return left;

    }

    private AST.Exp.T parseExp() {
        AST.Exp.T left = parsePriority();
        while (current.kind == Token.Kind.Add || current.kind == Token.Kind.Sub) {
            Token token = current;
            if (token.kind == Token.Kind.Add) {
                eatToKen(Token.Kind.Add);
                left = new AST.Exp.Add(left, parsePriority(), current.index);
            } else if (token.kind == Token.Kind.Sub) {
                eatToKen(Token.Kind.Sub);
                left = new AST.Exp.Sub(left, parsePriority(), current.index);
            }
        }
        return left;
    }

    public AST.Exp.T parse() {
        return parseExp();
    }
}
