/**
 Запись в файл массива
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        Person[] People = {new Person(1, "Tom"), new Person(2, "Jack"), new Person(3, "Kate")};
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("People.bin"))) {
            oos.writeObject(People);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
