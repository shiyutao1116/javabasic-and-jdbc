import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author shiyutao
 * @create 2021-08-28 19:43
 */
public class SetcTest {
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add("aa");
        set.add("Ss");
        set.add(new Date());
        set.add(456);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }


    }
}