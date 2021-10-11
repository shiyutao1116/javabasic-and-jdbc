import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author shiyutao
 * @create 2021-08-31 21:55
 */
public class Filetest {
    @Test
    public void test() {
        File file1 = new File("hello.txt");
        File file2 = new File("f:\\idea\\hi.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        System.out.println("-------------------------------------");
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());


    }

    @Test
    public void test2() {
        File file = new File("F:\\idea\\work");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);

        }
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);


        }

    }

    @Test
    public void test3() {
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\idea\\io\\hi.txt");
        boolean re = file2.renameTo(file1);
        System.out.println(re);

    }

    @Test
    public void test4() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists())
        {
            file1.createNewFile();
            System.out.println("成功");

        }else{
            file1.delete();

        }



    }
    @Test
    public void test5(){
        File file2=new File("F:\\idea\\io\\io1");
        boolean mkdir = file2.mkdir();
        if(mkdir){

            System.out.println("创建成功");
        }
        File file3=new File("F:\\idea\\io\\io2");
        boolean mkdirs = file3.mkdirs();
        if(mkdirs){

            System.out.println("创建成功1");

    }

}}