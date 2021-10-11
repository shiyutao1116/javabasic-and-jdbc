import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

/**
 * @author shiyutao
 * @create 2021-09-25 13:48
 */
public class PreparedStatementUpdateTset{
    @Test
    public void test1()  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            InputStream is = PreparedStatementUpdateTset.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String sql="INSERT INTO customers(name,email,birth)VALUE(?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"侍宇韬");
            preparedStatement.setString(2,"shiyutao1116@qq.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = simpleDateFormat.parse("1999-11-16");
            preparedStatement.setDate(3,new Date(date.getTime()));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(preparedStatement!=null)
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null)
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void Test2() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Util.getconnection();
            String sql = "UPDATE customers set NAME  = ? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "莫扎特");
            preparedStatement.setObject(2, 18);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection, preparedStatement);
        }

    }
        @Test
        public void Test3 () {
        String sql="delete from customers where id=?";
        Util.update(sql,3);
        }


    @Test
    public void Test4 () {

    String sql="update  `order` set order_name=?  where order_id=?";
    Util.update(sql,"DD","2");
    }
    @Test//固定的查询
    public void Testselect()  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Util.getconnection();
            String sql="select id,name,email,birth from customers where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,1);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int anInt = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email=resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                Bean bean = new Bean(anInt, name, email, birth);
                System.out.println(bean.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Util.closeresouse(connection,preparedStatement,resultSet);
        }





        }
@Test
    public void testselect2(){
      String sql="select id,name,birth,email from customers where id=?";
    String sql1="select name,email from customers where name=?";
      Bean customer = Util.qureyforcustomer(sql, 13);
    Bean s1 = Util.qureyforcustomer(sql1, "周杰伦");
    System.out.println(s1);
    System.out.println(customer);



}
    @Test
    public void testselect3()  {
        String sql="select order_id id,order_name name,order_date date from `order` where order_id=?";
        Order qureyfororder = Util.qureyfororder(sql, 1);
        System.out.println(qureyfororder);
}

    @Test
    public void testselect4()  {
       String sql="select order_id id,order_name name,order_date date from `order` where order_id<?";
        List<Order> list = Util.qureyforall1(Order.class,sql,5);
        list.forEach(System.out::println);

    }
    @Test//修改blob类型
    public void testblob() throws Exception {
        Connection connection = Util.getconnection();
        String sql="INSERT INTO customers(name,email,birth,photo)VALUE(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"宋方昀");
        preparedStatement.setObject(2,"sfy@qq.com");
        preparedStatement.setObject(3,"1999-11-22");
        FileInputStream fileInputStream = new FileInputStream("F:\\idea\\work\\Jdbc\\src\\标准证件照.jpg");
        preparedStatement.setBlob(4,fileInputStream);
        preparedStatement.execute();
        Util.closeresouse(connection,preparedStatement);
    }

    @Test//查询blob类型
    public void testblob2()  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        InputStream binaryStream=null;
        FileOutputStream fileOutputStream=null;

        try {
            connection = Util.getconnection();
            String sql="select id, name ,email,birth ,photo from customers where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,20);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");
                Bean bean = new Bean(id, name, email, birth);
                System.out.println(bean);

                Blob photo = resultSet.getBlob("photo");
                binaryStream = photo.getBinaryStream();
                fileOutputStream = new FileOutputStream("shiyutao.jpg");
                byte buf[]=new byte[1024];
                int len;
                while ((len =binaryStream.read(buf))!=-1){
                fileOutputStream.write(buf,0,len);

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

                try {if (binaryStream!=null)
                    binaryStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            try {
                    if(fileOutputStream!=null)
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Util.closeresouse(connection,preparedStatement,resultSet);


        }

    }
    @Test//批量插入
    public void testin()  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long l = System.currentTimeMillis();
            connection = Util.getconnection();
            String sql="INSERT INTO goods(NAME )VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i=1;i<=20000;i++){
            preparedStatement.setObject(1,"name_"+i);
            preparedStatement.execute();


            }
             long end=System.currentTimeMillis();
            System.out.println(end-l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection,preparedStatement);
        }
        }

    @Test//批量插入2提升效率
    public void testin2()  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long l = System.currentTimeMillis();
            connection = Util.getconnection();
            String sql="INSERT INTO goods(NAME )VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i=1;i<=20000;i++){

                preparedStatement.setObject(1,"name_"+i);
                preparedStatement.addBatch();
                if(i%500==0){
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();

                }



            }
            long end=System.currentTimeMillis();
            System.out.println(end-l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection,preparedStatement);
        }
    }
    @Test//批量插入2再次提升效率
    public void testin3()  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            long l = System.currentTimeMillis();
            connection = Util.getconnection();
            connection.setAutoCommit(false);
            String sql="INSERT INTO goods(NAME )VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            for (int i=1;i<=20000;i++){

                preparedStatement.setObject(1,"name_"+i);
                preparedStatement.addBatch();
                if(i%500==0){
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();

                }



            }
            connection.commit();
            long end=System.currentTimeMillis();
            System.out.println(end-l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.closeresouse(connection,preparedStatement);
        }
    }

}