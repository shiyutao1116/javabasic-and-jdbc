/**
 * @author shiyutao
 * @create 2021-08-22 13:18
 */
public class Runnable {
    public static void main(String[] args) {
    Runtest t1=new Runtest();
    Runtest t2=new Runtest();
    Runtest t3=new Runtest();

        t1.start();
        t2.start();
        t3.start();

    }
}
class Runtest extends Thread{
   private static int ticket=100;
    public void run(){

        for(;;)
   synchronized (Runnable.class){
        {if(ticket>0)
            System.out.println(Thread.currentThread().getName()+ticket--);

        }}

    }

}
