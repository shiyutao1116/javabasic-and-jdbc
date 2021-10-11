import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyutao
 * @create 2021-09-28 17:11
 */
public class Transection {
    public  static void update(Connection connection, String sql, Object... args) {
    PreparedStatement preparedStatement = null;
    try {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);


        }
        preparedStatement.execute();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        Util.closeresouse(null, preparedStatement);
    }


}
    //所有表的通用查询一条数据(考虑事务)
    public  static  <T>T qureyforall(Connection connection,Class<T>clazz, String sql, Object... args) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

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
            Util.closeresouse(null, preparedStatement, resultSet);
        }


        return null;
    }
    //所有表的通用查询多条数据
    public static  <T> List<T> qureyforall1(Connection connection,Class<T>clazz, String sql, Object... args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
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
            Util.closeresouse(null, preparedStatement, resultSet);
        }


        return null;
    }

}
