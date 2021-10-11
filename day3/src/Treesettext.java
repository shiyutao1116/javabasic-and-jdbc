import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author shiyutao
 * @create 2021-08-29 21:31
 */
public class Treesettext {
    public static void main(String[] args) {
        Employee a1=new Employee("小明",18,new Mydate(1999,5,13));
        Employee a2=new Employee("小赵",19,new Mydate(1980,11,14));
        Employee a3=new Employee("小钱",17,new Mydate(1980,6,15));
        Employee a4=new Employee("小孙",40,new Mydate(1970,7,16));
        Employee a5=new Employee("小李",36,new Mydate(1959,9,17));
        TreeSet set=new TreeSet();
        set.add(a1);
        set.add(a2);
        set.add(a3);
        set.add(a4);
        set.add(a5);
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }


}
class Mydate{
    private int year;
    private int month;
    private int day;

    public Mydate() {
    }

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Mydate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


}
class Employee implements Comparable {
    private  String name;
    private  int age;
    private Mydate birthday;

    public Employee() {
    }

    public Employee(String name, int age, Mydate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            return this.name.compareTo(employee.name);
        }
       throw new RuntimeException("类型不一致");
    }

}