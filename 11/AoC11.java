import java.util.ArrayList;
import java.util.Arrays;

public class AoC11 {
    public static void main(String[] args) {
        ArrayList<Monkey> monkeys = new ArrayList<>();
        monkeys.add(new Monkey(new Integer[]{91, 66}, integer -> integer*13, 19,6,2));
        monkeys.add(new Monkey(new Integer[]{78, 97, 59}, integer -> integer+7, 5,0,3));
        monkeys.add(new Monkey(new Integer[]{57, 59, 97, 84, 72, 83, 56, 76}, integer -> integer+6, 11,5,7));
        monkeys.add(new Monkey(new Integer[]{81, 78, 70, 58, 84}, integer -> integer+5, 17,6,0));
        monkeys.add(new Monkey(new Integer[]{60}, integer -> integer+8, 7,1,3));
        monkeys.add(new Monkey(new Integer[]{57, 69, 63, 75, 62, 77, 72}, integer -> integer*5, 13,7,4));
        monkeys.add(new Monkey(new Integer[]{73, 66, 86, 79, 98, 87}, integer -> integer*integer, 3,5,2));
        monkeys.add(new Monkey(new Integer[]{95, 89, 63, 67}, integer -> integer+2, 2,1,4));

        for (int i = 0; i < 20; i++) {
            for(Monkey monkey : monkeys){
                while (monkey.has_items_left()){
                    int[] instruction = monkey.execute();
                    monkeys.get(instruction[1]).add(instruction[0]);
                }
            }
        }
        int[] buisnesses = new int[8];
        for (int i = 0; i < 8; i++) {
            buisnesses[i]=monkeys.get(i).getProcessed_items();
        }
        Arrays.sort(buisnesses);
        System.out.println(buisnesses[7]*buisnesses[6]);
    }
}
