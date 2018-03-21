package compiler.tinhtoan;

/**
 * @author JINX_NHI on 3/21/2018.
 */
public class Token {

    public Token(Kind kind, int index) {
        this.kind = kind;
        this.index = index;
        this.value = null;
    }

    enum Kind {
        ADD,
        SUB, MUL, DIV, LPAREN, RPARENT, EXPONENTIAL, END, NUM
    }

    public Kind kind;
    public String value;
    public int index;

    public Token(Kind kind, String value, int index) {
        this.kind = kind;
        this.value = value;
        this.index = index;
    }

    @Override
    public String toString() {
        return kind + " : " + value + " : " + index;
    }
}
