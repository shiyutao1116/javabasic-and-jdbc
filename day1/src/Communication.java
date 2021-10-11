import java.lang.Runnable;

/**
 * @author shiyutao
 * @create 2021-08-24 13:09
 */
public class Communication
{
    public static void main(String[] args) {
        customer c1=new customer();
        starff c2=new starff();
        Thread a1=new Thread(c1);
        Thread a2=new Thread(c1);
        Thread a3=new Thread(c1);
        Thread a4=new Thread(c1);
        Thread a5=new Thread(c1);
        Thread a6=new Thread(c2);
        Thread a7=new Thread(c2);
        Thread a8=new Thread(c2);
        Thread a9=new Thread(c2);
        a1.setName("生产者1");a2.setName("生产者2");a3.setName("生产者3");a4.setName("生产者4");
        a5.setName("生产者5");a6.setName("消费者1");a7.setName("消费者2");a8.setName("消费者3");
        a9.setName("消费者4");
        a1.start();
       // a2.start();a3.start();a4.start();a5.start();a6.start();
        a7.start();//a8.start();a9.start();

    }
}
class product {
   public static double p1;
}
class customer implements Runnable{
  private product p;

    @Override
    public void run() {
        while (true){

         synchronized (product.class) {
            product.class.notifyAll();
             if (p.p1 > 0) {
                 p.p1--;
                 try {
                     Thread.sleep(100);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 System.out.println("目前有" + p.p1);

             } else
             {System.out.println("暂时空了");

             try {
                 product.class.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }}
    }
    }
}
class starff implements Runnable{
    private product p;


    @Override
    public void run() {
        while (true){
            synchronized (product.class) {
                product.class.notifyAll();
                if (p.p1 < 5000) {
                    p.p1++;
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("目前有" + p.p1);
                } else{
                    System.out.println("暂时满了");
                try {
                    product.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}
            }}
    }
}