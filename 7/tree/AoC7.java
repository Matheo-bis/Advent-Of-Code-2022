package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC7 {
    public static void main(String[] args) {
        Directory root = new Directory("/");
        Directory wd = root;
        ArrayList<Directory> directories = new ArrayList<>();
        directories.add(root);
        try (Scanner scanner = new Scanner(new File("input"))) {
            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    wd.add(new TreeFile(scanner.nextInt(), scanner.next(), wd));
                }
                else{
                    String first = scanner.next();
                    String second = scanner.next();
                    if(first.equalsIgnoreCase("$") && second.equalsIgnoreCase("cd")){
                        String nextwd = scanner.next();
                        if (nextwd.equalsIgnoreCase("/")){wd = root;}
                        else{wd=(Directory) wd.get(nextwd);}
                    }
                    else if(first.equalsIgnoreCase("dir")){
                        wd.add(new Directory(second,wd));
                        directories.add((Directory)wd.get(second));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int count = 0;
        for (Directory directory : directories) {
            if(directory.getSize()<=100000) {count += directory.getSize();}
        }
        System.out.println(count);

        int total = 70000000;
        int needed = 30000000;
        int used = root.getSize();
        
    }
}
