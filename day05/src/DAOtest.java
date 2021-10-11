import java.util.List;

/**
 * @author shiyutao
 * @create 2021-08-31 17:34
 */
public class DAOtest {
    public static void main(String[] args) {
        DAO<User>dao=new DAO<>();

        dao.save("1001",new User(1001,34,"侍宇韬"));
        dao.save("1003",new User(1003,24,"侍宇"));
        dao.save("1002",new User(1002,64,"侍"));
        dao.save("1004",new User(1004,14,"宇韬"));

        dao.update("1002",new User(1,2,"peter" ));
        dao.delete("1004");
        List<User> list = dao.list();
        System.out.println(list);

    }

}
