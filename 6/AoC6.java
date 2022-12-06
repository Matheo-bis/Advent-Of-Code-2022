import java.io.FileReader;
import java.io.IOException;

public class AoC6 {
    public static void main(String[] args) {
        RollingCharList rcl = new RollingCharList((short) 4);
        try (FileReader fr = new FileReader("6/input")) {
            for (int i = 0; i < 4; i++) {
                rcl.put((char)fr.read());
            }
            int count = 4;
            while(!rcl.allDifferent()){
                count++;
                int c = fr.read();
                if(c==-1){break;}
                rcl.put((char)c);
            }
            System.out.println(count);
            System.out.println(rcl);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        rcl = new RollingCharList((short)14);
        try (FileReader fr = new FileReader("6/input")) {
            for (int i = 0; i < 14; i++) {
                rcl.put((char)fr.read());
            }
            int count = 14;
            while(!rcl.allDifferent()){
                count++;
                int c = fr.read();
                if(c==-1){break;}
                rcl.put((char)c);
            }
            System.out.println(count);
            System.out.println(rcl);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
