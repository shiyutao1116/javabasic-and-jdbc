/**
 * @author shiyutao
 * @create 2021-09-06 18:43
 */
public class ProxyTest00 {
    //静态代理
    interface ff{
        //
        void clothes();
        //

    }
    static class factory implements ff{
        private ff factory;



        public  factory(ff factory){
            this.factory=factory;

        }


    @Override
    public void clothes() {
        System.out.println("代理工厂准备工作");
        factory.clothes();
        System.out.println("代理工厂善后工作");
    }

    }
    static class  NKfactory implements  ff{

    @Override
    public void clothes() {
        System.out.println("制造耐克鞋");
    }


    }

    public static void main(String[] args) {
        ff nike =  new  NKfactory();
        ff factory=  new factory(nike);
        factory.clothes();
    }
}
