import java.util.ArrayList;
import java.util.List;

public class Calculations extends AnotherClass{
    private List<Integer> list = new ArrayList<>();

    public Calculations(){
        super.print();
    }

    public Calculations(boolean clean){
        if (clean)
            clear();
    }

    public void storeToList(int a){
        list.add(a);
    }

    public List<Integer> getList(){
        return list;
    }

    public void clear(){
        list.clear();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
