import java.util.*;

/**
 * @author shiyutao
 * @create 2021-08-31 17:14
 */
public class DAO<T> {
    private Map<String,T>map=new HashMap<>();
    public void save(String id,T entity){
            map.put(id,entity);
    }

    public T get(String id){
         return map.get(id);
    }

    public  void update(String id,T entity){
        if(map.containsKey(id)){
        map.put(id,entity);}


    }

    public List<T>list(){
        List<T> list = new ArrayList<>();
        Collection<T> collection= map.values();
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());

        }
        return list;
    }
    public void delete(String id){
        map.remove(id);

    }




}
