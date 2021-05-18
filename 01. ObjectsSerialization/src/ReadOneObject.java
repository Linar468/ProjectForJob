/**
 Чтение из файла по одному экземпляру
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadOneObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("People.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                Person person1 = (Person) ois.readObject();
                Person person2 = (Person) ois.readObject();
                System.out.println(person1);
                System.out.println(person2);
                ois.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
