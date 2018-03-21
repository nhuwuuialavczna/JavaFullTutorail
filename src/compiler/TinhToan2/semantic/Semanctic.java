package compiler.TinhToan2.semantic;

import compiler.TinhToan2.ast.AST;
import compiler.TinhToan2.ast.Visiter;
import compiler.TinhToan2.parser.Parser;

public class Semanctic implements Visiter {

    private AST.Exp.T abstratSyntaxTree;

    public Semanctic(String input) {
        this.abstratSyntaxTree = new Parser(input).parse();

    }

    public double culc() {
        return visit(abstratSyntaxTree);
    }

    @Override
    public double visit(AST.Exp.Sub sub) {
        AST.Exp.T left = sub.left;
        AST.Exp.T right = sub.right;
        return visit(left) - visit(right);
    }

    @Override
    public double visit(AST.Exp.Add add) {
        AST.Exp.T left = add.left;
        AST.Exp.T right = add.right;
        return visit(left) + visit(right);
    }

    @Override
    public double visit(AST.Exp.Mul mul) {
        AST.Exp.T left = mul.left;
        AST.Exp.T right = mul.right;
        return visit(left) * visit(right);
    }

    @Override
    public double visit(AST.Exp.Div div) {
        AST.Exp.T left = div.left;
        AST.Exp.T right = div.right;
        return visit(left) / visit(right);
    }

    @Override
    public double visit(AST.Exp.Number number) {
        return number.value;
    }

    @Override
    public double visit(AST.Exp.Exponential exponential) {
        AST.Exp.T left = exponential.left;
        AST.Exp.T right = exponential.right;
        return Math.pow(visit(left),  visit(right));
    }

    @Override
    public double visit(AST.Exp.SQRT sqrt) {
        return Math.sqrt(visit(sqrt.body));
    }

    @Override
    public double visit(AST.Exp.Sin sin) {
        return Math.sin(visit(sin.body));
    }

    @Override
    public double visit(AST.Exp.Cos cos) {
        return Math.cos(visit(cos.body));
    }

    @Override
    public double visit(AST.Exp.Tan tan) {
        return Math.tan(visit(tan.body));
    }

    @Override
    public double visit(AST.Exp.PI pi) {
        return pi.value;
    }

    @Override
    public double visit(AST.Exp.Mod mod) {
        AST.Exp.T left = mod.left;
        AST.Exp.T right = mod.right;
        return visit(left)% visit(right);
    }

    @Override
    public double visit(AST.Exp.Rational rational) {
        AST.Exp.T left = rational.left;
        AST.Exp.T right = rational.right;
        return visit(left) / visit(right);
    }
}
