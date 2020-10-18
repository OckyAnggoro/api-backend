import java.util.ArrayList;
import java.util.List;

public class GenerikStack<E> {
    List<E> daftar = new ArrayList<E>();

    public int getSize(){
        return daftar.size();
    }

    public void push(E o){
        daftar.add(o);
    }

    public E peek(){
        return daftar.get(getSize() - 1);
    }

    public E poop(){
        E o = daftar.get(getSize() - 1);
        daftar.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty (){
        return daftar.isEmpty();
    }
}
