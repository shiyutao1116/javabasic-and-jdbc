import java.lang.Runnable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shiyutao
 * @create 2021-08-22 20:45
 */
public class Test1 {
  public static void main(String[] args) {
    costomer c1=new costomer();
    Thread a1=new Thread(c1);
    Thread a2=new Thread(c1);
    a1.setName("甲");
    a2.setName("乙");
    a1.start();
    a2.start();

  }
  }



class costomer implements Runnable{
private  static double account;
private ReentrantLock lock=new ReentrantLock();
public void run(){
  for(int i=0;i<3;i++){
 lock.lock();
  getmonney(1000);
lock.unlock();
  }


  }
  public  void getmonney (double tmp){
    account +=tmp;
    System.out.println(Thread.currentThread().getName()+"存钱成功"+account);

}

}

