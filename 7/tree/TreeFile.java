package tree;

public class TreeFile implements Sizeable, Nameable{
    private int size;
    private String name;
    private Directory parent;

    TreeFile(int _size, String _name, Directory _parent){
        size=_size;
        name=_name;
        parent=_parent;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName(){
        return name;
    }

    public Directory getParent(){
        return parent;
    }
    
}
