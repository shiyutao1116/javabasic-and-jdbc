import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shiyutao
 * @create 2021-09-06 18:40
 */
public class ProxyTest {
    //动态代理
    interface Human {
        String getbelief();

        void eat(String food);
    }

    static class Superman implements Human {


        @Override
        public String getbelief() {
            return "I believe I can fly";
        }

        @Override
        public void eat(String food) {
            System.out.println("我喜欢吃" + food);
        }
    }
static class proxyt{
public  static Object getproxyinstance (Object obj){
    Myinvocation hander=new Myinvocation();
    hander.bind(obj);
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),hander);


}



}
static class Myinvocation implements InvocationHandler{
private Object object;
public void bind(Object obj){
    this.object=obj;

}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
     Object returnvelue=   method.invoke(object, args);
     return returnvelue;
    }
}

    public static void main(String[] args) {
        Superman superman = new Superman();
        Human getproxyinstance =(Human) proxyt.getproxyinstance(superman);
        System.out.println(getproxyinstance.getbelief());
        getproxyinstance.eat("xihuanchisichuancai");

    }

}