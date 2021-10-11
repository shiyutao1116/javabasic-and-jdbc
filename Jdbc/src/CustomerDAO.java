import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author shiyutao
 * @create 2021-09-28 15:22
 */
//用于规范customer类的DAO
public interface CustomerDAO {
       public abstract void insert(Connection connection, Bean customer);
       public abstract void delectbyid(Connection connection,int id);
       public abstract void update(Connection connection,Bean customer);
       public abstract Bean getcustomerbyid(Connection connection,int id);
       public abstract List<Bean>getallcustomers(Connection connection);
       public abstract Long getcount(Connection connection);
       public abstract Date getbirthmax(Connection connection);


}
