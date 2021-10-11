import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author shiyutao
 * @create 2021-09-05 10:51
 */
public class ReflectionTest2 {

    @Test
    public void test1() throws ClassNotFoundException {
       //方法一
        Class personClass = person.class;
        System.out.println(personClass);
        //方式二
        person p1=new person();
        Class aClass = p1.getClass();
        //方式三
        Class class3 = Class.forName("person");
        System.out.println(class3);
        //方式四
        ClassLoader classLoader = ReflectionTest2.class.getClassLoader();
        Class person = classLoader.loadClass("person");

    }
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        /*FileInputStream fileInputStream = new FileInputStream("src\\jdbc.properties");
        properties.load(fileInputStream);*/

        ClassLoader classLoader = ReflectionTest2.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);

        String user = properties.getProperty("user");


        String password = properties.getProperty("password");
        System.out.println(user+"pass"+password);
    }
    @Test
    public void test3() throws Exception {
        Class<person> personClass = person.class;
        person person = personClass.newInstance();//new person p1相当于
        System.out.println(person);


    }
}
