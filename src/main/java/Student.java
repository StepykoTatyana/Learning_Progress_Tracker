import java.util.LinkedList;
import java.util.List;

public class Student {
    private final int id;

    public int getId() {
        return id;
    }

    private final String name;
    private final String lastName;
    private final List<Boolean> notifySend= new LinkedList<>();

    public List<Boolean> getNotifySend() {
        return notifySend;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    private final String email;

    public Student(Integer id, String name, String lastName, String email) {
        this.id=id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        notifySend.add(false);
        notifySend.add(false);
        notifySend.add(false);
        notifySend.add(false);
    }

    public String getEmail() {
        return email;
    }

}
