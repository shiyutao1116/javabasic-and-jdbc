import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author shiyutao
 * @create 2021-09-25 14:42
 */
public class Util {
    public static Connection getconnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void closeresouse(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void closeresouse(Connection connection, PreparedStatement preparedStatement, ResultSet resultSetlt) {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSetlt != null)
                resultSetlt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Util.getconnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);


            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection, preparedStatement);
        }


    }

    //一个表中的通用查询 customers
    public static Bean qureyforcustomer(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Util.getconnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();//获取结果集的元数据
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                Bean cust = new Bean();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String name = metaData.getColumnName(i + 1);
                    Field field = Bean.class.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(cust, value);
                }
                return cust;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection, preparedStatement, resultSet);
        }


        return null;
    }

    //一个表中的通用查询 order
    public static Order qureyfororder(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Util.getconnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field declaredField = order.getClass().getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(order, value);
                }

                    return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {Util.closeresouse(connection, preparedStatement, resultSet);
        }

                return null;
    }
    //所有表的通用查询一条数据
    public static <T>T qureyforall(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Util.getconnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();//获取结果集的元数据
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                return t;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection, preparedStatement, resultSet);
        }


        return null;
    }
    //所有表的通用查询多条数据
    public static <T>List<T> qureyforall1(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Util.getconnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();//获取结果集的元数据
            int columnCount = metaData.getColumnCount();
            ArrayList<T> list = new ArrayList<T>();

            while (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                    list.add(t);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection, preparedStatement, resultSet);
        }


        return null;
    }
    //造数据库连接池C3P0
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    //获得连接池中的链接
    public static Connection getconnectionc3p0() throws SQLException {
        Connection connection = cpds.getConnection();
        return connection;

    }


    //数据库连接池DBCP
    private static DataSource dataSource;
static {
    try {
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        pros.load(is);
        dataSource = BasicDataSourceFactory.createDataSource(pros);
    } catch (Exception e) {
        e.printStackTrace();
    }

}
    public static Connection getconnectiondbcp() throws Exception {


        Connection connection = dataSource.getConnection();
        return connection;

    }
    //数据库连接池druid
    private static DataSource dataSource1;
    static {
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
             dataSource1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getconnctiondruid() throws Exception {


        Connection connection = dataSource1.getConnection();
        return connection;

    }

    public static void closeresouse1(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
    DbUtils.closeQuietly(connection);
    DbUtils.closeQuietly(preparedStatement);
    DbUtils.closeQuietly(resultSet);


}


}







