import java.sql.Date;

/**
 * @author shiyutao
 * @create 2021-09-25 16:48
 */
public class Bean {
   private int id;
   public  String name;
   public  String email ;
   public Date birth;

   public Bean(int id, String name, String email, Date birth) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.birth = birth;
   }

   public Bean() {
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getEmail() {
      return email;
   }

   public Date getBirth() {
      return birth;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setBirth(Date birth) {
      this.birth = birth;
   }

   @Override
   public String toString() {
      return "Bean{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", email='" + email + '\'' +
              ", birth=" + birth +
              '}';
   }
}
