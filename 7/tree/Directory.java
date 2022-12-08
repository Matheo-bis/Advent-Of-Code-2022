package tree;

import java.util.Set;
import java.util.TreeMap;

public class Directory implements Sizeable, Nameable{
    private TreeMap<String, Sizeable> content;
    private String name;

    Directory(String _name){
        name=_name;
        content = new TreeMap<>();
    }

    Directory(String _name, Directory _parent){
        this(_name);
        content.put("..", _parent);
    }

    @Override
    public int getSize() {
        int size = 0;
        for (String iterable_element : content.keySet()) {
            if(iterable_element.equalsIgnoreCase("..")){continue;}
            size+=content.get(iterable_element).getSize();
        }
        return size;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    public void add(Directory directory){
        content.put(directory.getName(), directory);
    }

    public void add(TreeFile file){
        content.put(file.getName(), file);
    }

    public Sizeable get(String key){
        return content.get(key);
    }

    public Set<String> listContents(){
        return content.keySet();
    }
}
