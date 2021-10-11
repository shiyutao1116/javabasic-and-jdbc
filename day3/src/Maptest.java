import org.junit.Test;

import java.util.*;

/**
 * @author shiyutao
 * @create 2021-08-30 17:40
 */
public class Maptest {
    @Test
    public void test1(){
        Map m1=new HashMap();//containsKey(value)  size   isEmpty  equals  remove clean
        m1.put("1号",1);
        m1.put("2号",4);
        m1.put("3号",6);
        m1.put("4号",8);
        m1.put("5号",10);
        m1.put("6号",187);
        System.out.println(m1);
        Map m2=new HashMap();
        m2.putAll(m1);
        m2.remove("1号");
        m1.get("1号");
        Set set=m1.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
        Collection collection=m1.values();
        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());

        }
        Set set1=m1.entrySet();
       for(Object obj:set1){
           Map.Entry obj1 = (Map.Entry) obj;
           System.out.println(obj1.getKey() +""+ obj1.getValue());
       }


    }
@Test
    public void test2(){
        TreeMap map=new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });



}





}
