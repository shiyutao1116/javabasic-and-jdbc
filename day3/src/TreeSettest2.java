import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author shiyutao
 * @create 2021-08-30 12:42
 */
public class TreeSettest2 {
    public static void main(String[] args) {

        Employee a1=new Employee("小明",18,new Mydate(1999,5,13));
        Employee a2=new Employee("小赵",19,new Mydate(1980,11,14));
        Employee a3=new Employee("小钱",17,new Mydate(1980,11,14));
        Employee a4=new Employee("小孙",40,new Mydate(1970,7,16));
        Employee a5=new Employee("小李",36,new Mydate(1959,9,17));
        TreeSet set=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                        Employee e1=(Employee)o1;
                        Employee e2=(Employee)o2;
                        if(e1.getBirthday().getYear()!=e2.getBirthday().getYear()){
                            return e1.getBirthday().getYear()-e2.getBirthday().getYear();

                        }
                        if(e1.getBirthday().getMonth()!=e2.getBirthday().getMonth()){
                            return e1.getBirthday().getMonth()-e2.getBirthday().getMonth();

                        }

                            return e1.getBirthday().getDay()-e2.getBirthday().getDay();



                }
                throw new RuntimeException("类型不匹配");
            }
        });
        set.add(a1);
        set.add(a2);
        set.add(a3);
        set.add(a4);
        set.add(a5);
        Iterator iterator= set.iterator();
        int i=0;
        while (i<3)
        {
            i++;
            System.out.println(iterator.next());

        }


        }
    }



