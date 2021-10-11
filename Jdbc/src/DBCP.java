import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shiyutao
 * @create 2021-09-28 22:33
 */
public class DBCP {
@Test
    public void testdbcp() throws SQLException {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setPassword("1116");
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        basicDataSource.setUsername("root");
        Connection connection = basicDataSource.getConnection();
        System.out.println(connection);
    }
    @Test
    public void testdbcp2() throws Exception {
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //FileInputStream is=new FileInputStream(new File("src/dbcp.properties"));(另一种方式)
        pros.load(is);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
