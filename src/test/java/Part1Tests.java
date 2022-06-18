import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Part1Tests {
    @Test
    @DisplayName("a'a")
    void test1() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("a'a"));
    }
    @Test
    @DisplayName("John")
    void test2() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("John"));
        assertTrue(checkString.checkLName("Smith"));
        assertTrue(checkString.checkEmail("jsmith@hotmail.com"));
    }
    @Test
    @DisplayName("Jean-Claude")
    void test3() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("Jean-Claude"));
        assertTrue(checkString.checkLName("O'Connor"));
        assertTrue(checkString.checkEmail("jcda123@google.net"));
    }
    @Test
    @DisplayName("Al")
    void test4() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("Al"));
        assertTrue(checkString.checkLName("Owen"));
        assertTrue(checkString.checkEmail("u15da125@a1s2f4f7.a1c2c5s4"));
    }


    @Test
    @DisplayName("na'me")
    void test5() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("na'me"));
        assertTrue(checkString.checkLName("s-u"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }


    @Test
    @DisplayName("n'a")
    void test6() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("n'a"));
        assertTrue(checkString.checkLName("me su aa-b'b"));
        assertTrue(checkString.checkEmail("ab@ab.ab"));
    }


    @Test
    @DisplayName("n")
    void test7() {
        CheckString checkString = new CheckString();
        assertFalse(checkString.checkFName("n"));
        assertTrue(checkString.checkLName("surname"));
        assertTrue(checkString.checkEmail("email@email.xyz"));

    }
    @Test
    @DisplayName("'name")
    void test9() {
        CheckString checkString = new CheckString();
        assertFalse(checkString.checkFName("'name"));
        assertTrue(checkString.checkLName("surname"));
        assertTrue(checkString.checkEmail("email@email.xyz"));
    }
    @Test
    @DisplayName("name-")
    void test10() {
        CheckString checkString = new CheckString();
        assertFalse(checkString.checkFName("name-"));
        assertTrue(checkString.checkLName("s-u"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }
    @Test
    @DisplayName("nam-'e")
    void test11() {
        CheckString checkString = new CheckString();
        assertFalse(checkString.checkFName("nam-'e"));
        assertTrue(checkString.checkLName("s-u"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }
    @Test
    @DisplayName("na--me")
    void test12() {
        CheckString checkString = new CheckString();
        assertFalse(checkString.checkFName("na--me"));
        assertTrue(checkString.checkLName("s-u"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }


    @Test
    @DisplayName("námé")
    void test13() {
        CheckString checkString = new CheckString();
        assertFalse(checkString.checkFName("námé"));
        assertTrue(checkString.checkLName("surname"));
        assertTrue(checkString.checkEmail("email@email.xyz"));
    }
    @Test
    @DisplayName("-surname")
    void test14() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("name"));
        assertFalse(checkString.checkLName("-surname"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }
    @Test
    @DisplayName("'surname")
    void test15() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("name"));
        assertFalse(checkString.checkLName("'surname"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }
    @Test
    @DisplayName("surnam''e")
    void test16() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("name"));
        assertFalse(checkString.checkLName("surnam''e"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }
    @Test
    @DisplayName("surn--ame")
    void test17() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("name"));
        assertFalse(checkString.checkLName("surn--ame"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }
    @Test
    @DisplayName("surname'")
    void test18() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("name"));
        assertFalse(checkString.checkLName("surname'"));
        assertTrue(checkString.checkEmail("ii@ii.ii"));
    }
    @Test
    @DisplayName("emailemail.xyz")
    void test19() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("name"));
        assertTrue(checkString.checkLName("su"));
        assertFalse(checkString.checkEmail("emailemail.xyz"));
    }
    @Test
    @DisplayName("email@emailxyz")
    void test20() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("name"));
        assertTrue(checkString.checkLName("su"));
        assertFalse(checkString.checkEmail("email@emailxyz"));
    }
    @Test
    @DisplayName("email@e@mail.xyz")
    void test21() {
        CheckString checkString = new CheckString();
        assertTrue(checkString.checkFName("name"));
        assertTrue(checkString.checkLName("su"));
        assertFalse(checkString.checkEmail("email@e@mail.xyz"));
    }
}
