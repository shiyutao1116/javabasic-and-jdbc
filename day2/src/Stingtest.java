/**
 * @author shiyutao
 * @create 2021-08-25 15:55
 */
public class Stingtest {
    public static void main(String[] args) {
    String a1="abdbdcbbd";String a3="bd";
    method a2=new method();
     //   System.out.println(a2.a1(a1,3,10));
        System.out.println(a2.a2(a1,a3));
    }

}
class method {
    public String a1(String s, int start, int end){
        char[] arr = s.toCharArray();
        for (int x = start, y = end; x < y; x++, y--){
            char temp=arr[x];
            arr[x]=arr[y];
            arr[y]=temp;
        }
        return new String(arr);



}
    public int a2(String smain, String s2){
        int Number=0;
        char[] arrmain = smain.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (int i=0;i< smain.length();i++){
            for (int j=0;j<s2.length();j++){
                int k=i;
                if (arrmain[k]==arr2[j]){
                    k++;j++;


                }if(arrmain[k]!=arr2[j]){
                    break;
                }
                if(j==s2.length()-1){
                    Number++;
                }


                }

            }






        return Number;
    }

}

