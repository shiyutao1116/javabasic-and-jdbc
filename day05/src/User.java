import java.util.Objects;

/**
 * @author shiyutao
 * @create 2021-08-31 17:32
 */
public class User {
    private int id;
    private int age;
    private String name;
    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public User() {

    }

    public void setName(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, age, name);
    }
}
