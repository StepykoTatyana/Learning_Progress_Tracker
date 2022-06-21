public class StringUtils {
    public static boolean isPalindrome(String string) {
        if (string == null || string.isBlank() || string.length() < 2) {
            return false;
        }

        int start = 0;
        int end = string.length() - 1;

        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}