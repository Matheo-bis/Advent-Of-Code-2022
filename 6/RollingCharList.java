import java.util.Arrays;
import java.util.HashSet;

public class RollingCharList {
    private short length;
    private char[] array;
    private short size;

    RollingCharList(short _length){
        length = _length;
        size = 0;
        array = new char[length];
    }

    public short getLength(){
        return length;
    }

    public void put(char c){
        if(size<length){
            array[size]=c;
            size++;
        }
        else{
            for(short i=1; i<length; i++){
                array[i-1]=array[i];
            }
            array[length-1]=c;
        }
    }

    public char[] getList(){
        return array;
    }

    public boolean allDifferent(){
        String[] sArray = new String[length];
        for (short i = 0; i < length; i++) {
            sArray[i]=new StringBuilder().append(array[i]).toString();
        }
        HashSet<String> hs = new HashSet<>(Arrays.asList(sArray));

        if(hs.size() == length) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }
    
}