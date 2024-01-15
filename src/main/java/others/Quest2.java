package others;

import java.io.IOException;

public class Quest2 {

    private int id;
    private String name;
    private int age;

    public Quest2() {
    }

    public Quest2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Quest2(String name, int id, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void Quest2() {

    }
    public static void ioRead() throws IOException {
        throw new IOException();
    }
    //declaring ioRead()
    public static void main(String[] args) {
        try {
            ioRead();
        } catch(IOException e){}
    }
}
