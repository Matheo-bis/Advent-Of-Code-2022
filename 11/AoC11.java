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

        ArrayList<LongMonkey> Longmonkeys = new ArrayList<>();
//        Longmonkeys.add(new LongMonkey(new Long[]{79L, 98L}, aLong -> aLong*19L, 23L, 2L,3L));
//        Longmonkeys.add(new LongMonkey(new Long[]{54L, 65L, 75L, 74L}, aLong -> aLong+6L, 19L, 2L, 0L));
//        Longmonkeys.add(new LongMonkey(new Long[]{79L, 60L, 97L}, aLong -> aLong*aLong, 13L, 1L,3L));
//        Longmonkeys.add(new LongMonkey(new Long[]{74L}, aLong -> aLong+3L, 17L, 0L, 1L));
        Longmonkeys.add(new LongMonkey(new Long[]{91L, 66L}, integer -> integer*13, 19,6,2));
        Longmonkeys.add(new LongMonkey(new Long[]{78L, 97L, 59L}, integer -> integer+7, 5,0,3));
        Longmonkeys.add(new LongMonkey(new Long[]{57L, 59L, 97L, 84L, 72L, 83L, 56L, 76L}, integer -> integer+6, 11,5,7));
        Longmonkeys.add(new LongMonkey(new Long[]{81L, 78L, 70L, 58L, 84L}, integer -> integer+5, 17,6,0));
        Longmonkeys.add(new LongMonkey(new Long[]{60L}, integer -> integer+8, 7,1,3));
        Longmonkeys.add(new LongMonkey(new Long[]{57L, 69L, 63L, 75L, 62L, 77L, 72L}, integer -> integer*5, 13,7,4));
        Longmonkeys.add(new LongMonkey(new Long[]{73L, 66L, 86L, 79L, 98L, 87L}, integer -> integer*integer, 3,5,2));
        Longmonkeys.add(new LongMonkey(new Long[]{95L, 89L, 63L, 67L}, integer -> integer+2, 2,1,4));

        for (int i = 0; i < 10000; i++) {
            for(LongMonkey monkey : Longmonkeys){
                while (monkey.has_items_left()){
                    long[] instruction = monkey.execute();
                    Longmonkeys.get((int) instruction[1]).add(instruction[0]);
                }
            }
        }
        long[] Longbuisnesses = new long[8];
        for (int i = 0; i < Longmonkeys.size(); i++) {
            Longbuisnesses[i]=Longmonkeys.get(i).getProcessed_items();
            System.out.println(Longmonkeys.get(i).getProcessed_items());
        }
        Arrays.sort(Longbuisnesses);
        System.out.println(Longbuisnesses[7]*Longbuisnesses[6]);

    }
}
