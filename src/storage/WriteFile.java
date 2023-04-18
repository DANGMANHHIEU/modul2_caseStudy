package storage;

import java.io.*;
import java.util.List;

public class WriteFile<T> {
    public void write(List<T> list){
        File file = new File("student.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
