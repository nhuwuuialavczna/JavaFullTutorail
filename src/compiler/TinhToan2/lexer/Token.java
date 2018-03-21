package compiler.TinhToan2.lexer;

public class Token {

    public enum Kind {
        Add, // dấu +
        Sub, // dấu -
        Mul, // dấu *
        Div, // dấu /
        LPAREN, // (
        RPAREN, // )
        Exponential, // ^
        SQRT, // căn
        End, // kết thúc
        Num,  // 1 con số
        Sin,//sin
        Cos,//cos
        Tan,//tan
        Mod,// chia phan du
        Rational, //dau phan so
    }

    public Kind kind;
    public int index;
    public String value;
    public Token(Kind kind, int index) {
        this.kind = kind;
        this.index = index;
        this.value = null;
    }

    public Token(Kind kind, int index, String value) {
        this.kind = kind;
        this.index = index;
        this.value = value;
    }

    @Override
    public String toString() {
        return kind + "\t" + index + "\t" + value;
    }


}
