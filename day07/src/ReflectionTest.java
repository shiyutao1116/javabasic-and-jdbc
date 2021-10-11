import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author shiyutao
 * @create 2021-09-04 17:48
 */
public class ReflectionTest {
    @Test
    public void test() throws Exception {
        Class personClass = person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        person p=(person)tom;
        System.out.println(p.toString());
        Field age = personClass.getDeclaredField("age");

        age.set(p,10);
        System.out.println(p.toString());
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p);
        Constructor declaredConstructor = personClass.getDeclaredConstructor(String.class, int.class, String.class);
        declaredConstructor.setAccessible(true);
        person p1=(person)declaredConstructor.newInstance("jarry",18,"中国人");
        System.out.println(p1);
        Method shownation=personClass.getDeclaredMethod("nation");
        shownation.setAccessible(true);
        shownation.invoke(p1);
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"hanmeimei");
        System.out.println(p1);
    }

}
class person{
        public String name;
        public int age;
        private String nation;
    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private person(String name, int age, String nation) {
        this.name = name;
        this.age = age;
        this.nation = nation;
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

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void show(){
        System.out.println("我是person类");

    }
    private String nation(){
        System.out.println("我是一个"+nation+"人");
        return nation;

    }
}
