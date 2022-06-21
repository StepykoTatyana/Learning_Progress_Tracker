import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest {

    static String[] names;
    static String[] passwords;
    static boolean[] expectedOutcomes;
    static boolean[] expectedOutcomesPassword;
    static boolean[] expectedOutcomesUserName;

    static int index = 0;

    User user;
    boolean expected;
    boolean expectedPassword;
    boolean expectedUserName;

    @BeforeAll
    static void setUp() {
        names = new String[]{"Alice", "Alice", "Alice", "", null, "    "};
        passwords = new String[]{"12345678", "123", null, "12345678", "12345678", "12345678"};
        expectedOutcomes = new boolean[]{true, false, false, false, false, false};
        expectedOutcomesPassword = new boolean[]{true, false, false, true, true, true};
        expectedOutcomesUserName = new boolean[]{true, true, true, false, false, false};
    }

    @BeforeEach
    void createUser() {
        user = new User(names[index], passwords[index]);
        expected = expectedOutcomes[index];
        expectedPassword = expectedOutcomesPassword[index];
        expectedUserName = expectedOutcomesUserName[index];
    }

    @AfterEach
    void incrementIndex() {
        index++;
        if (index == 6) {
            index = 0;
        }
    }


    @RepeatedTest(value = 6, name = "user.isValid() test {currentRepetition}/{totalRepetitions}")
    void isValid() {
        assertEquals(expected, user.isValid());
    }

    @RepeatedTest(value = 6, name = "user.hasStrongPassword() test {currentRepetition}/{totalRepetitions}")
    void hasStrongPassword() {
        assertEquals(expectedPassword, user.hasStrongPassword());
    }

    @RepeatedTest(value = 6, name = "user.hasValidUsername() test {currentRepetition}/{totalRepetitions}")
    void hasValidUsername() {
        assertEquals(expectedUserName, user.hasValidUsername());
    }
}