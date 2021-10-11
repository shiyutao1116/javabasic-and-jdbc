import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;


/**
 * @author shiyutao
 * @create 2021-08-28 18:19
 */
public class ListTest {
   @Test
    public  void test1(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add("aa");
       list.add("Ss");
       list.add(new Date());
       list.add(456);

       ArrayList list1=new ArrayList();
       list1.add("qwer");
       list.add(1,"bb");
        list.addAll(6,list1);
       System.out.println(list);


   }




}
