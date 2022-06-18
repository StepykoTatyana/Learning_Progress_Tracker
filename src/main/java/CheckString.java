public class CheckString {
    boolean checkFName(String s) {
        return s.matches("([A-Za-z]{2,})|([A-Za-z]+['-]?[A-Za-z]+)|([A-za-z]+['-]?[A-Za-z]+['-]?[A-za-z]+)");
    }
    boolean checkLName(String s) {
        return s.matches("((([A-Za-z]{2,})|([A-Za-z]+['-]?[A-Za-z]+)|([A-za-z]+['-]?[a-z]+['-]?[A-za-z]+))[\s]*)+");
    }
    boolean checkEmail(String s) {
        return s.matches("[a-z.0-9]+[@][a-z0-9]+[.][a-z0-9]+");
    }
}
