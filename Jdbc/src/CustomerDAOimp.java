import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author shiyutao
 * @create 2021-09-28 15:47
 */
public class CustomerDAOimp   extends DAO<Bean> implements CustomerDAO{
    @Override
    public void insert(Connection connection, Bean customer) {
       String sql= "INSERT INTO customers(name,email,birth)VALUE(?,?,?)";
       update(connection,sql,customer.getName(),customer.getEmail(), customer.getBirth() );
    }

    @Override
    public void delectbyid(Connection connection, int id) {
        String sql="delete from customers where id=?";
        update(connection,sql,id);
    }

    @Override
    public void update(Connection connection, Bean customer) {
        String sql="update customers set name=?,email=?, birth=? where id=?";
        update(connection,sql,customer.getName(),customer.getEmail(), customer.getBirth(),customer.getId());
    }

    @Override
    public Bean getcustomerbyid(Connection connection, int id) {
        String sql="select id,name,email,birth from customers where id=?";
        return  qureyforall(connection,sql,id);
    }

    @Override
    public List<Bean> getallcustomers(Connection connection) {
        String sql="select id,name,email,birth from customers ";
        return qureyforall1(connection,sql);
    }

    @Override
    public Long getcount(Connection connection) {
       String sql="select count(*) from customers";
        return getvealue(connection,sql);
    }

    @Override
    public Date getbirthmax(Connection connection) {
        String sql="select max(birth) from customers";
        return getvealue(connection,sql);
    }
}
