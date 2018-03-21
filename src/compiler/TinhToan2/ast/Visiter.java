package compiler.TinhToan2.ast;

/**
 * @author JINX_NHI on 2/26/2018.
 */
public interface Visiter {

    default double visit(AST.Exp.T t) {

        if (t instanceof AST.Exp.Add) {
            return visit((AST.Exp.Add) t);
        }
        if (t instanceof AST.Exp.Sub) {
            return visit((AST.Exp.Sub) t);
        }
        if (t instanceof AST.Exp.Mul) {
            return visit((AST.Exp.Mul) t);
        }
        if (t instanceof AST.Exp.Div) {
            return visit((AST.Exp.Div) t);
        }
        if (t instanceof AST.Exp.Exponential) {
            return visit((AST.Exp.Exponential) t);
        }
        if (t instanceof AST.Exp.SQRT) {
            return visit((AST.Exp.SQRT) t);
        }
        if (t instanceof AST.Exp.Number) {
            return visit((AST.Exp.Number) t);
        }
        if (t instanceof AST.Exp.PI) {
            return visit((AST.Exp.PI) t);
        }
        if (t instanceof AST.Exp.Mod) {
            return visit((AST.Exp.Mod) t);
        }
        if (t instanceof AST.Exp.Rational) {
            return visit((AST.Exp.Rational) t);
        }
        if (t instanceof AST.Exp.Sin) {
            return visit((AST.Exp.Sin) t);
        }
        if (t instanceof AST.Exp.Cos) {
            return visit((AST.Exp.Cos) t);
        }
        return visit((AST.Exp.Tan) t);
    }

    double visit(AST.Exp.Sub sub);

    double visit(AST.Exp.Add add);

    double visit(AST.Exp.Mul mul);

    double visit(AST.Exp.Div div);

    double visit(AST.Exp.Number number);

    double visit(AST.Exp.Exponential exponential);

    double visit(AST.Exp.SQRT sqrt);

    double visit(AST.Exp.Sin sin);

    double visit(AST.Exp.Cos cos);

    double visit(AST.Exp.Tan tan);

    double visit(AST.Exp.PI pi);

    double visit(AST.Exp.Mod mod);

    double visit(AST.Exp.Rational rational);

}
