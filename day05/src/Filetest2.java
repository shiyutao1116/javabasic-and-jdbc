import java.io.File;
import java.io.IOException;

/**
 * @author shiyutao
 * @create 2021-09-01 13:08
 */
public class Filetest2 {
    public static void main(String[] args) throws IOException {
        File file=new File("F:\\idea\\io\\io2\\hello.txt");
        File file2=new File(file.getParent(),"haha.txt");
        boolean newFile = file2.createNewFile();
        
    }


}
