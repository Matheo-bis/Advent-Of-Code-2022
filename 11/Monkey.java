import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class Monkey{
    private final ArrayList<Integer> items;
    private final Function<Integer, Integer> operation;
    private final int divisor;
    private final int throw_true;
    private final int throw_false;
    private int processed_items=0;

    Monkey(Integer[] _items, Function<Integer, Integer> _operation, int _divisor, int _throw_true, int _throw_false){
        items = new ArrayList<>(Arrays.asList(_items));
        operation=_operation;
        divisor=_divisor;
        throw_true=_throw_true;
        throw_false=_throw_false;
    }

    public int[] execute(){
        processed_items++;
        int[] ret = new int[2];
        int item = items.get(0);
        items.remove(0);
        item=operation.apply(item);
        item/=3;
        ret[0]=item;
        if (item % divisor == 0){
            ret[1]=throw_true;
        }
        else{
            ret[1]=throw_false;
        }
        return ret;
    }

    public int getProcessed_items() {
        return processed_items;
    }

    public boolean has_items_left(){
        return !items.isEmpty();
    }

    public void add(Integer item){
        items.add(item);
    }
}
