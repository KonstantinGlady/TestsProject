package composite;

public class Demo {
    public static StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) {
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");
        Directory dir3 = new Directory("dir3");
        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file4");
        File file5 = new File("file5");
        dir1.add(file1);
        dir1.add(dir2);
        dir1.add(file2);
        dir2.add(file3);
        dir2.add(file4);
        dir2.add(dir3);
        dir3.add(file5);
        dir1.ls();
    }
}
