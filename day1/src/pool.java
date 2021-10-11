import java.lang.Runnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shiyutao
 * @create 2021-08-24 18:21
 */
public class pool {
    public static void main(String[] args) {
       ExecutorService service= Executors.newFixedThreadPool(10);
        service.execute(new  Run());
        service.shutdown();
    }

}
class Run implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }}
