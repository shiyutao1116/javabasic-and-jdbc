import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author shiyutao
 * @create 2021-08-30 19:28
 */
public class Propertiestest {
    public static void main(String[] args)  {
        FileInputStream fileInputStream= null;
        try {
            Properties properties=new Properties();
            fileInputStream = new FileInputStream("jdbc.properties");
            properties.load(fileInputStream);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            System.out.println(name+password);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
