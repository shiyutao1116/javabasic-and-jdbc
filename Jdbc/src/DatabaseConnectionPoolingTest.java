import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author shiyutao
 * @create 2021-09-28 21:11
 */
public class DatabaseConnectionPoolingTest {
    @Test//硬编码
    public void C3P0test() throws Exception {
        //获取C3P0数据库链接
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("root");
        cpds.setPassword("1116");
        cpds.setInitialPoolSize(10);//设置初始连接数
        Connection connection = cpds.getConnection();
        System.out.println(connection);

    }
    @Test//反射
    public void C3P0test1() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);

    }
}
