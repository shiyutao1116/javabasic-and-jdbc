import java.util.*;

/**
 * @author shiyutao
 * @create 2021-08-30 20:13
 */
public class Collections1 {
    public static void main(String[] args) {
        List list= new ArrayList();
        list.add(123);list.add(4);list.add(56);list.add(783);list.add(9);list.add(0000);


        List dest= Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
        List list1 = Collections.synchronizedList(list);//线程安全
    }

    }

