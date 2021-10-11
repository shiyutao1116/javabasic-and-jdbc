import java.util.HashMap;
import java.util.Scanner;

/**
 * @author shiyutao
 * @create 2021-08-30 22:40
 */
public class E {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);


        HashMap map = new HashMap();
       while (true){
           String string = scan.next();
           if(!map.containsKey(string)){
               map.put(string,0);

           }
           else {
               int a1=(int)map.get(string);
               a1++;
               map.put(string,a1);


       }
           System.out.println(map);
        }
    }
}
