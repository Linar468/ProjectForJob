/**
 Запись в файл по одному экземпляру
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteOneObject {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Betty");
        Person person2 = new Person(2, "Bobby");
        try{
            FileOutputStream fos = new FileOutputStream("People.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
