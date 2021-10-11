import org.junit.Test;

import java.util.*;

/**
 * @author shiyutao
 * @create 2021-08-27 20:16
 */
public class CollectionTest {

    @Test
    public  void test1(){
    Collection col=new ArrayList();
    col.add("aa");
    col.add(123);
    col.add(new Date());
    System.out.println(col.size());
    Collection col1=new ArrayList();
    col.add(3232);
    col1.addAll(col);
    System.out.println(col1.size());
        System.out.println(col1);
        System.out.println(col.contains(123));//重写eqals
        System.out.println(col.isEmpty());

        System.out.println(col1.containsAll(col));


    }
    @Test
    public  void test2(){
        Collection col=new ArrayList();
        col.add("aa");
        col.add(123);
        col.add(new Date());
        col.add("bb");
        col.add(456);
        col.remove(123);
        Collection col1=new ArrayList();
        col1.addAll(col);

        //col.removeAll(col1);//移除两个集合中相同的元素
       // System.out.println(col);
        Collection col3=new ArrayList();
        col3.add("aa");
        col3.add(789);
        col3.add(new Date());
        col3.add("cc");
        col3.add(456);
        col3.retainAll(col);
        System.out.println(col3);

    }
    @Test
    public  void test3(){
        Collection col=new ArrayList();
        col.add("aa");
        col.add(123);
        col.add(new Date());
        col.add("bb");
        col.add(456);
        Collection col3=new ArrayList();
        col3.add("aa");
        col3.add(789);
        col3.add(new Date());
        col3.add("cc");
        col3.add(456);
        System.out.println(col3.equals(col));
        System.out.println(col.hashCode());
        Object[] objects = col.toArray();//集合到数组
        for(int i=0;i<objects.length;i++){
            System.out.println(objects[i]);

        }
        System.out.println(Arrays.asList(objects));//数组到集合
        Iterator iterator = col.iterator();//遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            for(Object obj:col){
                System.out.println(obj);

            }
        }

    }

}
