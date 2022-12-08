package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoC7 {
    public static void main(String[] args) {
        Directory root = new Directory("/");
        Directory wd = root;
        try (Scanner scanner = new Scanner(new File("input_test"))) {
            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    wd.add(new TreeFile(scanner.nextInt(), scanner.next(), wd));
                }
                else{
                    String first = scanner.next();
                    if(first == "$" && scanner.next()=="cd"){
                        wd=(Directory) wd.get(scanner.next());
                    }
                    else if(first == "dir"){
                        wd.add(new Directory(scanner.next(),wd));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = 0;
        for (String string : root.listContents()) {
            if(root.get(string).getSize()<=100000){
                count+=root.get(string).getSize();
            }
        }
        System.out.println(count);
    }
}
