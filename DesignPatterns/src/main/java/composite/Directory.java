package composite;

import java.util.ArrayList;

public class Directory implements AbstractFile {
    private String name;
    private ArrayList<Object> insertedFiles = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println(Demo.buffer + name);
        Demo.buffer.append("   ");
        for (Object obj : insertedFiles) {
            AbstractFile af = (AbstractFile) obj;
            af.ls();
        }
        Demo.buffer.setLength(Demo.buffer.length() - 3);
    }

    public void add(Object obj) {
        insertedFiles.add(obj);
    }
}
