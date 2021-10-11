import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyutao
 * @create 2021-09-28 11:48
 */
public abstract class DAO<T> {
    //考虑到数据库中事件要回滚使用事务操作多条语句是其一起执行或者一起不执行
   private Class<T> clazz=null;
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();//父类
        ParameterizedType parameterizedType= (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz= (Class<T>) actualTypeArguments[0];


    }

    public  void update(Connection connection, String sql, Object... args) {
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
    public  T qureyforall(Connection connection, String sql, Object... args) {

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
    public  List<T> qureyforall1(Connection connection, String sql, Object... args) {
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
        public <E>E getvealue(Connection connection,String sql,Object...args){
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return (E) resultSet.getObject(1);


                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Util.closeresouse(null,preparedStatement,resultSet);
            }
                return null;
        }


}
