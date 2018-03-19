package Exception;

/**
 * @author  JINX_NHI on 3/2/2018.
 */
public class Demo {

    public static boolean isNumber(String s) {
        Double.parseDouble(s);
//        try {
//            Double.parseDouble(s);
//            System.out.println(5);
//        } catch (NumberFormatException e) {
//            return false;
//        }finally {
//            ///khong chay dc
//        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("d"));
    }
}
