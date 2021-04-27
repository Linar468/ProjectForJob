import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 5045021286548731167L;
    private transient int id; // transient - не включать объект
    private String personName;

    public Person(int id, String name){
        this.id = id;
        this.personName = name;
    }
    public String toString(){
        return id + ":" +personName;
    }
}
