import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author shiyutao
 * @create 2021-08-25 19:35
 */
public class Date {

    @Test
    public  void datetest(){
        SimpleDateFormat a  =new  SimpleDateFormat();
        java.util.Date a1=new java.util.Date();
        String format = a.format(a1);
        System.out.println(a1+ format);

    }
    @Test
    public void date1test() throws ParseException {
        String birth="2020-11-16";
        SimpleDateFormat a1=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parse = a1.parse(birth);
        System.out.println(parse);
        java.sql.Date birthdate=new java.sql.Date(parse.getTime());
        System.out.println(birthdate);


    }
    @Test
    public void date2test() {
        java.util.Date date1 = new java.util.Date(2021,8,21);
        java.util.Date date2 = new java.util.Date(1999,11,18);
        long l = date1.getTime() - date2.getTime();
        long l1 = l / (24*60*60*1000);
        System.out.println(l1);
        Calendar instance = Calendar.getInstance();
        long time = instance.getTime().getTime();
        LocalDate.now();
    }
}
