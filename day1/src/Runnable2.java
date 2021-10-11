import java.lang.Runnable;

/**
 * @author shiyutao
 * @create 2021-08-22 14:21
 */
public class Runnable2 {

    public static void main(String[] args) {
        Runtest2 t1=new Runtest2();
        Thread a1=new Thread(t1);
        Thread a2=new Thread(t1);
        Thread a3=new Thread(t1);
        a1.start();
        a2.start();
        a3.start();
    }


}
class Runtest2 implements Runnable{
    private  int ticket=50;
    public void run(){
        for(;;)
        {show();
        }

    }
public  synchronized void show(){
            if(ticket>0)
            System.out.println(Thread.currentThread().getName()+ticket--);


}
}