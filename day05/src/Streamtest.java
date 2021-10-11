import org.junit.Test;

import java.io.*;

/**
 * @author shiyutao
 * @create 2021-09-01 21:22
 */
public class Streamtest {
@Test
    public void test1()  {
    FileInputStream stream = null;
    FileOutputStream fileOutputStream = null;
    try {
        File file = new File("aq.jpg");
        boolean newFile = file.createNewFile();
        File file1 = new File("aq1.jpg");
        stream = new FileInputStream(file);
        fileOutputStream = new FileOutputStream(file1);
        byte[] bytes = new byte[4];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int len;
        while ((len=bufferedInputStream.read(bytes))!=-1){

            bufferedOutputStream.write(bytes,0,len);


        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if(fileOutputStream!=null)

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(stream!=null)
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
    public  void copyfile(String src,String dest){
        FileInputStream stream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(src);
            boolean newFile = file.createNewFile();
            File file1 = new File(dest);
            stream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(stream);

            fileOutputStream = new FileOutputStream(file1);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] bytes = new byte[1024];
            int len;
            while ((len=stream.read(bytes))!=-1){

                fileOutputStream.write(bytes,0,len);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if(bufferedInputStream!=null)

                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedOutputStream!=null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void tset2(){
        long l = System.currentTimeMillis();
        copyfile("F:\\英雄时刻\\178975422\\英雄时刻_20190829-20点25分02s.avi","1.avi");
            long l1=System.currentTimeMillis();
        System.out.println(l1-l);

    }


}


