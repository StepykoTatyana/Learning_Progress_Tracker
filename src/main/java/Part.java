import java.util.*;
import java.util.stream.Collectors;

public class Part {
    static HashSet<String> set = new HashSet<>();
    static LinkedHashSet<Student> setStudents = new LinkedHashSet<>();
    static LinkedHashMap<Integer, Student> mapStudents = new LinkedHashMap<>();
    static Map<Integer, Points> map = new LinkedHashMap<>();
    static Map<String, List<Integer>> mapList = new LinkedHashMap<>();
    static Map<String, List<String>> stringListLinkedHashMap = new LinkedHashMap<>();

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> mostPopular = new ArrayList<>();
    static ArrayList<String> leastPopular = new ArrayList<>();
    static ArrayList<String> highestActivity = new ArrayList<>();
    static ArrayList<String> lowestActivity = new ArrayList<>();
    static ArrayList<String> easiestCourse = new ArrayList<>();
    static ArrayList<String> hardestCourse = new ArrayList<>();

    static int id = 10000;

    public static void main(String[] args) {
        System.out.println("Learning Progress Tracker");
        printMenu();

    }

    private static void printMenu() {
        String str = scanner.nextLine();
        while (!str.equals("exit")) {
            if (str.matches("[\\s]*")) {
                System.out.println("No input.");
            } else if (str.equals("add students")) {
                addStudents();
            } else if (str.equals("back")) {
                System.out.println("Enter 'exit' to exit the program.");
            } else if (str.equals("list")) {
                printList();
            } else if (str.equals("add points")) {
                addPoints();
            } else if (str.equals("find")) {
                findById();
            } else if (str.equals("statistics")) {
                printMenuStatistic();
            } else if (str.equals("notify")) {
                notifyStudent();
            } else {
                System.out.println("Unknown command!");
            }
            str = scanner.nextLine();
        }
        System.out.println("Bye!");
    }

    private static void notifyStudent() {
        boolean sendAnyMessage = false;
        int countStudents = 0;
        for (Points points : map.values()) {
            sendAnyMessage = false;
            if (points.getJavaPoint() == 600) {
                Student student = mapStudents.get(points.getIdStudent());
                if (!student.getNotifySend().get(0)) {
                    System.out.println("To: " + student.getEmail() + "\n" +
                            "Re: Your Learning Progress\n" +
                            "Hello, " + student.getName() + " " + student.getLastName() + "! You have accomplished our Java course!");
                    student.getNotifySend().set(0, true);
                    sendAnyMessage = true;
                }
            }
            if (points.getDatabasesPoint() == 480) {
                Student student = mapStudents.get(points.getIdStudent());
                if (!student.getNotifySend().get(1)) {
                    System.out.println("To: " + student.getEmail() + "\n" +
                            "Re: Your Learning Progress\n" +
                            "Hello, " + student.getName() + " " + student.getLastName() + "! You have accomplished our Databases course!");
                    student.getNotifySend().set(1, true);
                    sendAnyMessage = true;
                }
            }
            if (points.getDSAPoint() == 400) {
                Student student = mapStudents.get(points.getIdStudent());
                if (!student.getNotifySend().get(2)) {
                    System.out.println("To: " + student.getEmail() + "\n" +
                            "Re: Your Learning Progress\n" +
                            "Hello, " + student.getName() + " " + student.getLastName() + "! You have accomplished our DSA course!");
                    student.getNotifySend().set(2, true);
                    sendAnyMessage = true;
                }
            }
            if (points.getSpringPoint() == 550) {
                Student student = mapStudents.get(points.getIdStudent());
                if (!student.getNotifySend().get(3)) {
                    System.out.println("To: " + student.getEmail() + "\n" +
                            "Re: Your Learning Progress\n" +
                            "Hello, " + student.getName() + " " + student.getLastName() + "! You have accomplished our Spring course!");
                    student.getNotifySend().set(3, true);
                    sendAnyMessage = true;
                }
            }
            if (sendAnyMessage) {
                countStudents++;
            }
        }

        if (!sendAnyMessage) {
            System.out.println("Total 0 students have been notified.");
        } else {
            System.out.println("Total " + countStudents + " students have been notified.");
        }
    }

    private static void printMenuStatistic() {
        System.out.println("Type the name of a course to see details or 'back' to quit:");
        getMostPopular();
        getLeastPopular();
        getHighestActivity();
        getLowestActivity();
        getEasiestCourse();
        getHardestCourse();
        String string = scanner.nextLine();
        while (!string.equals("back")) {
            menuCourse(string);
            string = scanner.nextLine();
        }
    }

    private static void getMostPopular() {
        int max = 1;
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().get(0) >= max) {
                max = s.getValue().get(0);
            }
        }
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().get(0) == max) {
                mostPopular.add(s.getKey());
            }
        }
        if (mostPopular.size() == 0) {
            System.out.println("Most popular: " + "n/a");
        } else {
            System.out.println("Most popular: " + String.join(", ", mostPopular));
        }
    }

    private static void getLeastPopular() {
        int max = 1;
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().get(0) >= max) {
                max = s.getValue().get(0);
            }
        }
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().get(0) == max - 1) {
                if (!mostPopular.contains(s.getKey())) {
                    leastPopular.add(s.getKey());
                }
            }
        }
        if (leastPopular.size() == 0) {
            System.out.println("Least popular: " + "n/a");
        } else {
            System.out.println("Least popular: " + String.join(", ", leastPopular));
        }
    }

    private static void getHighestActivity() {
        int max = 1;
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().get(1) >= max) {
                max = s.getValue().get(1);
            }
        }
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().get(1) == max) {
                highestActivity.add(s.getKey());
            }
        }
        if (highestActivity.size() == 0) {
            System.out.println("Highest activity: " + "n/a");
        } else {
            System.out.println("Highest activity: " + String.join(", ", highestActivity));
        }
    }

    private static void getLowestActivity() {
        int min = 100;
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().size() != 0) {
                if (s.getValue().get(1) <= min) {
                    min = s.getValue().get(1);
                }
            } else {
                min = 0;
            }
        }
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().size() != 0) {
                if (s.getValue().get(1) == min) {
                    if (!highestActivity.contains(s.getKey())) {
                        lowestActivity.add(s.getKey());
                    }
                }
            } else {
                lowestActivity.add(s.getKey());
            }
        }
        if (lowestActivity.size() == 0) {
            System.out.println("Lowest activity: " + "n/a");
        } else {
            System.out.println("Lowest activity: " + String.join(", ", lowestActivity));
        }
    }

    private static void getHardestCourse() {
        int min = 10000;
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().size() != 0) {
                if (s.getValue().get(2) / s.getValue().get(1) <= min) {
                    min = s.getValue().get(2) / s.getValue().get(1);
                }
            } else {
                min = 0;
            }
        }
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().size() != 0) {
                if (s.getValue().get(2) / s.getValue().get(1) == min) {
                    if (!easiestCourse.contains(s.getKey())) {
                        hardestCourse.add(s.getKey());
                    }
                }
            } else {
                hardestCourse.add(s.getKey());
            }

        }
        if (hardestCourse.size() == 0) {
            System.out.println("Hardest course: " + "n/a");
        } else {
            System.out.println("Hardest course: " + String.join(", ", hardestCourse));
        }
    }

    private static void getEasiestCourse() {
        int max = 0;
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().get(2) / s.getValue().get(1) >= max) {
                max = s.getValue().get(2) / s.getValue().get(1);
            }
        }
        for (Map.Entry<String, List<Integer>> s : mapList.entrySet()) {
            if (s.getValue().get(2) / s.getValue().get(1) == max) {
                easiestCourse.add(s.getKey());
            }
        }
        if (easiestCourse.size() == 0) {
            System.out.println("Easiest course: " + "n/a");
        } else {
            System.out.println("Easiest course: " + String.join(", ", easiestCourse));
        }
    }

    private static void menuCourse(String string) {
        if (string.equals("java") | string.equals("Java")) {
            System.out.println(string);
            System.out.println("id\tpoints\tcompleted");
            Map<Integer, Points> map1 = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Points::getJavaPoint).reversed()
                            .thenComparingInt(Points::getIdStudent)))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new));

            for (Integer integer : map1.keySet()) {
                int point = map1.get(integer).getJavaPoint();
                if (point != 0) {
                    String a = String.format("%d\t%d\t%.1f", integer, point, (point * 100.0) / 600.0);
                    System.out.println(a + "%");
                }
            }
        } else if (string.equals("Databases") | string.equals("databases")) {
            System.out.println(string);
            System.out.println("id\tpoints\tcompleted");
            Map<Integer, Points> map1 = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Points::getDatabasesPoint).reversed()
                            .thenComparingInt(Points::getIdStudent)))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new));

            for (Integer integer : map1.keySet()) {
                int point = map1.get(integer).getDatabasesPoint();
                if (point != 0) {
                    String a = String.format("%d\t%d\t%.1f", integer, point, (point * 100.0) / 480.0);
                    System.out.println(a + "%");
                }
            }
        } else if (string.equals("DSA") | string.equals("dsa")) {
            System.out.println(string);
            System.out.println("id\tpoints\tcompleted");
            Map<Integer, Points> map1 = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Points::getDSAPoint).reversed()
                            .thenComparingInt(Points::getIdStudent)))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new));

            for (Integer integer : map1.keySet()) {
                int point = map1.get(integer).getDSAPoint();
                if (point != 0) {
                    String a = String.format("%d\t%d\t%.1f", integer, point, (point * 100.0) / 400.0);
                    System.out.println(a + "%");
                }
            }
        } else if (string.equals("Spring") | string.equals("spring")) {
            System.out.println(string);
            System.out.println("id\tpoints\tcompleted");
            Map<Integer, Points> map1 = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Points::getSpringPoint).reversed()
                            .thenComparingInt(Points::getIdStudent)))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new));

            for (Integer integer : map1.keySet()) {
                int point = map1.get(integer).getSpringPoint();
                if (point != 0) {
                    String a = String.format("%d\t%d\t%.1f", integer, point, (point * 100.0) / 550.0);
                    System.out.println(a + "%");
                }

            }

        } else {
            System.out.println("Unknown course.");
        }
    }

    private static void findById() {
        System.out.println("Enter an id or 'back' to return:");
        String string = scanner.nextLine();
        while (!string.equals("back")) {
            findPointsStudentById(string);
            string = scanner.nextLine();
        }
    }

    private static void findPointsStudentById(String idStudent) {
        if (setStudents.stream().noneMatch(x -> x.getId() == Integer.parseInt(idStudent))) {
            System.out.println("No student is found for id=" + idStudent + ".");
        } else {
            Points points = map.get(Integer.parseInt(idStudent));
            System.out.printf("%s points: Java=%d; DSA=%d; Databases=%d; Spring=%d\n",
                    idStudent, points.getJavaPoint(), points.getDSAPoint(), points.getDatabasesPoint(),
                    points.getSpringPoint());
        }
    }

    private static void addPoints() {
        System.out.println("Enter an id and points or 'back' to return");
        String string = scanner.nextLine();
        while (!string.equals("back")) {
            checkPoints(string);
            string = scanner.nextLine();
        }
    }

    private static void printList() {
        if (setStudents.size() == 0) {
            System.out.println("No students found");
        } else {
            System.out.println("Students:");
            setStudents.forEach(x -> System.out.println(x.getId()));
        }
    }

    private static void addStudents() {
        System.out.println("Enter student credentials or 'back' to return:");
        String string = scanner.nextLine();
        while (!string.equals("back")) {
            checkName(string);
            string = scanner.nextLine();
        }
        System.out.println("Total " + setStudents.size() + " students have been added.");
    }

    private static void checkPoints(String ints) {
        try {
            List<String> stringList = Arrays.asList(ints.split(" "));
            int idStudent = 0;
            try {
                idStudent = Integer.parseInt(stringList.get(0));
            } catch (Exception e) {
                System.out.println("No student is found for id=" + stringList.get(0) + ".");
            }
            int javaPoint = Integer.parseInt(stringList.get(1));
            int DSAPoint = Integer.parseInt(stringList.get(2));
            int databasesPoint = Integer.parseInt(stringList.get(3));
            int springPoint = Integer.parseInt(stringList.get(4));
            int finalIdStudent = idStudent;
            if (setStudents.stream().noneMatch(x -> x.getId() == finalIdStudent)) {
                System.out.println("No student is found for id=" + idStudent + ".");
            } else if (stringList.size() > 5 | javaPoint < 0 | DSAPoint < 0 | databasesPoint < 0 | springPoint < 0) {
                System.out.println("Incorrect points format.");
            } else {
                if (map.containsKey(idStudent)) {
                    if (javaPoint > 0) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        if (mapList.get("Java").get(0) == 0) {
                            mapList.get("Java").add(1);
                            arrayList.add(1);
                        } else {
                            arrayList.add(mapList.get("Java").get(0));
                        }
                        arrayList.add(mapList.get("Java").get(1) + 1);
                        arrayList.add(mapList.get("Java").get(2) + javaPoint);
                        arrayList.add(mapList.get("Java").get(2) / mapList.get("Java").get(1));
                        mapList.put("Java", arrayList);
                    }
                    if (DSAPoint > 0) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        if (mapList.get("DSA").get(0) == 0) {
                            mapList.get("DSA").add(1);
                            arrayList.add(1);
                        } else {
                            arrayList.add(mapList.get("DSA").get(0));
                        }
                        arrayList.add(mapList.get("DSA").get(1) + 1);
                        arrayList.add(mapList.get("DSA").get(2) + DSAPoint);
                        arrayList.add(mapList.get("DSA").get(2) / mapList.get("DSA").get(1));
                        mapList.put("DSA", arrayList);
                    }
                    if (databasesPoint > 0) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        if (mapList.get("Databases").get(0) == 0) {
                            mapList.get("Databases").add(1);
                            arrayList.add(1);
                        } else {
                            arrayList.add(mapList.get("Databases").get(0));
                        }
                        arrayList.add(mapList.get("Databases").get(1) + 1);
                        arrayList.add(mapList.get("Databases").get(2) + databasesPoint);
                        arrayList.add(mapList.get("Databases").get(2) / mapList.get("Databases").get(1));
                        mapList.put("Databases", arrayList);
                    }
                    if (springPoint > 0) {
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        if (mapList.get("Spring").get(0) == 0) {
                            mapList.get("Spring").add(1);
                            arrayList.add(1);
                        } else {
                            arrayList.add(mapList.get("Spring").get(0));
                        }
                        arrayList.add(mapList.get("Spring").get(1) + 1);
                        arrayList.add(mapList.get("Spring").get(2) + springPoint);
                        arrayList.add(mapList.get("Spring").get(2) / mapList.get("Spring").get(1));
                        mapList.put("Spring", arrayList);
                    }
                    int javaPointExists = map.get(idStudent).getJavaPoint() + javaPoint;
                    int DSAPointExists = map.get(idStudent).getDSAPoint() + DSAPoint;
                    int databasesPointExists = map.get(idStudent).getDatabasesPoint() + databasesPoint;
                    int springPointExists = map.get(idStudent).getSpringPoint() + springPoint;
                    map.put(idStudent, new Points(idStudent, javaPointExists, DSAPointExists, databasesPointExists, springPointExists));
                } else {
                    Points points = new Points(idStudent, javaPoint, DSAPoint, databasesPoint, springPoint);
                    map.put(idStudent, points);
                    stringListLinkedHashMap.put("Highest activity:", points.getCourses());
                    stringListLinkedHashMap.put("Lowest activity:", points.getCourses());
                    stringListLinkedHashMap.put("Easiest course:", points.getCourses());
                    stringListLinkedHashMap.put("Hardest course:", points.getCourses());
                    if (javaPoint > 0) {
                        if (mapList.get("Java") == null) {
                            mapList.put("Java", new ArrayList<>(1));
                            mapList.get("Java").add(1);
                            mapList.get("Java").add(1);
                            mapList.get("Java").add(javaPoint);
                            mapList.get("Java").add(javaPoint);
                        } else {
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            arrayList.add(mapList.get("Java").get(0) + 1);
                            arrayList.add(mapList.get("Java").get(1) + 1);
                            arrayList.add(mapList.get("Java").get(2) + javaPoint);
                            if (mapList.get("Java").get(1) == 0) {
                                arrayList.add(mapList.get("Java").get(2));
                            } else {
                                arrayList.add(mapList.get("Java").get(2) / mapList.get("Java").get(1));
                            }
                            mapList.put("Java", arrayList);
                        }
                    } else {
                        if (mapList.get("Java") == null) {
                            mapList.put("Java", new ArrayList<>(0));
                            mapList.get("Java").add(0);
                            mapList.get("Java").add(0);
                            mapList.get("Java").add(0);
                            mapList.get("Java").add(0);
                        }
                    }
                    if (DSAPoint > 0) {
                        if (mapList.get("DSA") == null) {
                            mapList.put("DSA", new ArrayList<>(1));
                            mapList.get("DSA").add(1);
                            mapList.get("DSA").add(1);
                            mapList.get("DSA").add(DSAPoint);
                            mapList.get("DSA").add(DSAPoint);
                        } else {
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            arrayList.add(mapList.get("DSA").get(0) + 1);
                            arrayList.add(mapList.get("DSA").get(1) + 1);
                            arrayList.add(mapList.get("DSA").get(2) + DSAPoint);
                            if (mapList.get("DSA").get(1) == 0) {
                                arrayList.add(mapList.get("DSA").get(2));
                            } else {
                                arrayList.add(mapList.get("DSA").get(2) / mapList.get("DSA").get(1));
                            }
                            mapList.put("DSA", arrayList);
                        }
                    } else {
                        if (mapList.get("DSA") == null) {
                            mapList.put("DSA", new ArrayList<>(0));
                            mapList.get("DSA").add(0);
                            mapList.get("DSA").add(0);
                            mapList.get("DSA").add(0);
                            mapList.get("DSA").add(0);
                        }
                    }
                    if (databasesPoint > 0) {
                        if (mapList.get("Databases") == null) {
                            mapList.put("Databases", new ArrayList<>(1));
                            mapList.get("Databases").add(1);
                            mapList.get("Databases").add(1);
                            mapList.get("Databases").add(databasesPoint);
                            mapList.get("Databases").add(databasesPoint);
                        } else {
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            arrayList.add(mapList.get("Databases").get(0) + 1);
                            arrayList.add(mapList.get("Databases").get(1) + 1);
                            arrayList.add(mapList.get("Databases").get(2) + databasesPoint);
                            if (mapList.get("Databases").get(1) == 0) {
                                arrayList.add(mapList.get("Databases").get(2));
                            } else {
                                arrayList.add(mapList.get("Databases").get(2) / mapList.get("Databases").get(1));
                            }
                            mapList.put("Databases", arrayList);
                        }
                    } else {
                        if (mapList.get("Databases") == null) {
                            mapList.put("Databases", new ArrayList<>(0));
                            mapList.get("Databases").add(0);
                            mapList.get("Databases").add(0);
                            mapList.get("Databases").add(0);
                            mapList.get("Databases").add(0);
                        }
                    }
                    if (springPoint > 0) {
                        if (mapList.get("Spring") == null) {
                            mapList.put("Spring", new ArrayList<>(1));
                            mapList.get("Spring").add(1);
                            mapList.get("Spring").add(1);
                            mapList.get("Spring").add(springPoint);
                            mapList.get("Spring").add(springPoint);
                        } else {
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            arrayList.add(mapList.get("Spring").get(0) + 1);
                            arrayList.add(mapList.get("Spring").get(1) + 1);
                            arrayList.add(mapList.get("Spring").get(2) + springPoint);
                            if (mapList.get("Spring").get(1) == 0) {
                                arrayList.add(mapList.get("Spring").get(2));
                            } else {
                                arrayList.add(mapList.get("Spring").get(2) / mapList.get("Spring").get(1));
                            }
                            mapList.put("Spring", arrayList);
                        }
                    } else {
                        if (mapList.get("Spring") == null) {
                            mapList.put("Spring", new ArrayList<>(0));
                            mapList.get("Spring").add(0);
                            mapList.get("Spring").add(0);
                            mapList.get("Spring").add(0);
                            mapList.get("Spring").add(0);
                        }
                    }
                }
                System.out.println("Points updated.");
            }
        } catch (Exception e) {
            System.out.println("Incorrect points format.");
        }
    }

    private static void checkName(String s) {
        if (s.matches("[\\s]*")) {
            System.out.println("Incorrect credentials.");
        } else {
            List<String> arrayList = Arrays.asList(s.split(" "));
            if (arrayList.size() < 3) {
                System.out.println("Incorrect credentials.");
            } else {
                try {
                    CheckString checkString = new CheckString();
                    String fName = arrayList.get(0);
                    String email = arrayList.get(arrayList.size() - 1);
                    String lNAme = String.join(" ", arrayList.subList(1, arrayList.size() - 1));
                    if (!checkString.checkFName(fName)) {
                        System.out.println("Incorrect first name.");
                    } else if (!checkString.checkLName(lNAme)) {
                        System.out.println("Incorrect last name.");
                    } else if (!checkString.checkEmail(email)) {
                        System.out.println("Incorrect email.");
                    } else {
                        if (setStudents.stream().anyMatch(x -> x.getEmail().equals(email))) {
                            System.out.println("This email is already taken.");
                        } else {
                            set.add(s);
                            Student student = new Student(id, fName, lNAme, email);
                            setStudents.add(student);
                            mapStudents.put(id, student);
                            System.out.println("The student has been added.");
                            id++;
                        }

                    }
                } catch (Exception e) {
                    System.out.println("Incorrect credentials.");
                }
            }

        }
    }
}
