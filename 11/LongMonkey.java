import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class LongMonkey {
    private final ArrayList<Long> items;
    private final Function<Long, Long> operation;
    private final long divisor;
    private final long throw_true;
    private final long throw_false;
    private long processed_items=0;

    LongMonkey(Long[] _items, Function<Long, Long> _operation, long _divisor, long _throw_true, long _throw_false){
        items = new ArrayList<>(Arrays.asList(_items));
        operation=_operation;
        divisor=_divisor;
        throw_true=_throw_true;
        throw_false=_throw_false;
    }

    public long[] execute(){
        processed_items++;
        long[] ret = new long[2];
        long item = items.get(0);
        items.remove(0);
        item=operation.apply(item);
        ret[0]=item;
        if (item % divisor == 0){
            ret[1]=throw_true;
        }
        else{
            ret[1]=throw_false;
        }
        return ret;
    }

    public long getProcessed_items() {
        return processed_items;
    }

    public boolean has_items_left(){
        return !items.isEmpty();
    }

    public void add(Long item){
        items.add(item);
    }
}
