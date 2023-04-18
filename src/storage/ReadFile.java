package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<T> {
    public List<T> read(){
        File file = new File("student.txt");
        List<T> student=new ArrayList<>();
        try{
            FileInputStream fileInputStream=new FileInputStream(file);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            student= (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
}
