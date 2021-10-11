

import org.junit.Test;

import java.io.*;
import java.util.Objects;

/**
 * @author shiyutao
 * @create 2021-09-02 16:03
 */
public class InputstreamTest {
   @Test
   public void test1(){
        InputStreamReader inputStreamReader= null;
        OutputStreamWriter outputStreamWriter= null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(new File("F:\\idea\\work\\day05\\hello1.txt")));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File("output.txt")),"gbk");
            char[]chars=new char[4];
            int len;
            while ((len=inputStreamReader.read(chars))!=-1){
                outputStreamWriter.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }



        @Test
    public void test2()  {
            ObjectOutputStream stream= null;
            try {
                stream = new ObjectOutputStream(new FileOutputStream("hello.dat"));
                stream.writeObject(new java.lang.String("woaibeijing天安门"));
                stream.writeObject(new person("侍宇韬",18));
                stream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }
    @Test
    public void test3() {
        ObjectInputStream stream= null;
        try {
            stream = new ObjectInputStream(new FileInputStream("hello.dat"));
            String object=(String)stream.readObject();
            person p1=(person)stream.readObject();

            System.out.println(object);
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ;










   }



}
class person implements Serializable{
        String name;
        int age;
    public static final long serialVersionUID = 42L;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
