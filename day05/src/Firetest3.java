import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author shiyutao
 * @create 2021-09-01 16:58
 */
public class Firetest3 {
    @Test
    public void test1() {
//流的使用
        FileReader reader = null;
        try {
            File file = new File("hello.txt");
            reader = new FileReader(file);
            int read;
            while ((read = reader.read()) != -1) {
                System.out.println((char) read);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        FileReader reader = null;
        try {
            File file = new File("hello.txt");
            reader = new FileReader(file);
            char[] chars = new char[5];
            int len;

           while ((len = reader.read(chars)) != -1) {
//                for(int i=0;i<len;i++){
//                    System.out.println(chars[i]);

//                }
               String string=new String(chars,0,len);
               System.out.println(string);


           }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void test3()  {
        FileWriter fileWriter= null;
        try {
            File file = new File("hello1.txt");
            fileWriter = new FileWriter(file,false);

            fileWriter.write("I have a dream\n".toCharArray());
            fileWriter.write("you need have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    @Test
    public void test4()  {
        FileWriter fileWriter= null;
        FileReader fileReader= null;
        try {
            File file = new File("hello.txt");
            File file2 = new File("hello1.txt");
            fileWriter = new FileWriter(file2,false);
            fileReader = new FileReader("hello.txt");
            char[] chars = new char[3];
            int len;
            while ((len=fileReader.read(chars))!=-1){
                fileWriter.write(chars,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

















}