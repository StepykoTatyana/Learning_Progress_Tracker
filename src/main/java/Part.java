import java.util.*;

public class Part {
    static HashSet<String> set = new HashSet<>();
    static Scanner scanner = new Scanner(System.in);

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
                System.out.println("Enter student credentials or 'back' to return:");
                String string = scanner.nextLine();
                while (!string.equals("back")) {
                    checkName(string);
                    string = scanner.nextLine();
                }
                System.out.println("Total " + set.size() + " students have been added.");
            } else if (str.equals("back")) {
                System.out.println("Enter 'exit' to exit the program.");

            } else {
                System.out.println("Error: unknown command!");
            }
            str = scanner.nextLine();
        }
        System.out.println("Bye!");
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
                    } else if (!checkString.checkLName(email)) {
                        System.out.println("Incorrect email.");
                    } else {
                        set.add(s);
                        System.out.println("The student has been added.");
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect credentials.");
                }
            }

        }
    }
}
