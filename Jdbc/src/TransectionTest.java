import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author shiyutao
 * @create 2021-09-27 20:02
 */
public class TransectionTest {
//考虑到数据库中事件要回滚使用事务操作多条语句是其一起执行或者一起不执行
    @Test//2个事务演示
    public void test1() {
        Connection connection = null;
        try {
            connection = Util.getconnection();
            connection.setAutoCommit(false);//不自动提交
            String sql="update user_table set balance=balance-100 where user =?";
            String sql2="update user_table set balance=balance+100 where user =?";
            Transection.update(connection,sql,"aa");
            Transection.update(connection,sql2,"bb");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
          Util.closeresouse(connection,null);//关流自动提交
        }

    }
    @Test//2个事务演示(查询)
    public void test2() throws Exception {
        Connection connection = Util.getconnection();
        System.out.println(connection.getTransactionIsolation());//获取隔离级别
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);//设置隔离级别

        connection.setAutoCommit(false);
        String sql="select user, password ,balance from user_table where user=?";
        User cc = Transection.qureyforall(connection, User.class, sql, "cc");
        System.out.println(cc);


    }
    @Test//2个事务演示(查询)负责修改
    public void test3() throws Exception {
        Connection connection = Util.getconnection();
        connection.setAutoCommit(false);
        String sql="update user_table set balance=? where user=? ";
        Transection.update(connection,sql,5000,"cc");


    }




}
