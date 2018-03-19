package Thread;

/**
 * @author  JINX_NHI on 3/19/2018.
 */
public class TaoThread {

    public static void main(String[] args) {

        Thread thread = new Thread("ok"){
            @Override
            public void run() {
                System.out.println("Nguyen tan hau");
            }
        };
        thread.start();

    }

}
