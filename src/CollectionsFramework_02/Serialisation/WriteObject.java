package CollectionsFramework_02.Serialisation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        Person p1 = new Person(1,"Stella");
        Person p2 = new Person(2, "Zhenya");

        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(p1);
            oos.writeObject(p2);

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
