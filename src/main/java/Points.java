import java.util.ArrayList;

public class Points {
    private final int idStudent;
    private final int javaPoint;
    private final int DSAPoint;
    private final int databasesPoint;
    private final int springPoint;


    @Override
    public String toString() {
        return "Points{" +
                "idStudent=" + idStudent +
                ", javaPoint=" + javaPoint +
                ", DSAPoint=" + DSAPoint +
                ", databasesPoint=" + databasesPoint +
                ", springPoint=" + springPoint +
                ", courses=" + courses +
                '}';
    }

    private final ArrayList<String> courses = new ArrayList<>();

    public ArrayList<String> getCourses() {
        return courses;
    }


    public Points(int idStudent, int javaPoint, int DSAPoint, int databasesPoint, int springPoint) {
        this.idStudent = idStudent;
        this.javaPoint = javaPoint;
        this.DSAPoint = DSAPoint;
        this.databasesPoint = databasesPoint;
        this.springPoint = springPoint;
        if (javaPoint > 0) {
            courses.add("Java");
        }
        if (DSAPoint > 0) {
            courses.add("DSA");
        }
        if (databasesPoint > 0) {
            courses.add("Databases");
        }
        if (springPoint > 0) {
            courses.add("Spring");
        }
    }

    public int getIdStudent() {
        return idStudent;
    }

    public int getJavaPoint() {
        return javaPoint;
    }

    public int getDSAPoint() {
        return DSAPoint;
    }


    public int getDatabasesPoint() {
        return databasesPoint;
    }

    public int getSpringPoint() {
        return springPoint;
    }

}

