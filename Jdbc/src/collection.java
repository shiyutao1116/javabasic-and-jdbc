import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shiyutao
 * @create 2021-09-24 13:54
 */
public class collection {

    @Test
    public void testcollection() throws SQLException {
        Driver driver=new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/test";
        Properties info =new Properties();
        info.setProperty("user","root");
        info.setProperty("password","1116");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);

    }
    @Test
    public void testcollection2() throws Exception {
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver =(Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info =new Properties();
        info.setProperty("user","root");
        info.setProperty("password","1116");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);

    }

    @Test
    public void testcollection3() throws Exception {
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver =(Driver) aClass.newInstance();
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="1116";
        Connection con = DriverManager.getConnection(url,user,password);
        System.out.println(con);

    }
    @Test
    public void testcollection4() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="1116";
        Connection con = DriverManager.getConnection(url,user,password);
        System.out.println(con);
    }
    @Test
    public void testcollection5() throws Exception {
        InputStream is = collection.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);


    }



    }


