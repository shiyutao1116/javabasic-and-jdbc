import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author shiyutao
 * @create 2021-09-29 14:46
 */
public class QueryRunnerTest {
    @Test
    public void testinsert1() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = Util.getconnctiondruid();
            String sql="insert into customers(name,email,birth)values(?,?,?)";

            int update = runner.update(connection, sql, "坤坤", "kun.com", "1998-11-13");
            System.out.println(update);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection,null);

        }


    }

    @Test//返回一条记录
    public void testselect1() throws Exception {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = Util.getconnctiondruid();
            String sql="select id,name,email,birth from customers where id =?";
            BeanHandler<Bean> b = new BeanHandler<>(Bean.class);

            Bean customer = runner.query(connection, sql, b, 20);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection,null);
        }


    }

    @Test//返回多条记录
    public void testselect2() {
        Connection connection=null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = Util.getconnctiondruid();
            String sql="select id,name,email,birth from customers where id <?";
            BeanListHandler<Bean> b = new BeanListHandler<>(Bean.class);

            List<Bean> query = runner.query(connection, sql, b, 20);
            query.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection,null);
        }


    }

    @Test//count*
    public void test1() throws Exception {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = Util.getconnctiondruid();
            String sql="select count(*) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();

            Long count = (Long)runner.query(connection, sql,scalarHandler);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection,null);
        }


    }


}
