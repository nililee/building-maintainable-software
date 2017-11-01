package eu.sig.training.ch04.v4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountsTest {

    @Test
    public void testIsValidNormalCases() {
        assertTrue("isValid(\"123456789\")는 true를 반환해야 한다.",
            Accounts.isValid("123456789"));
        assertFalse("isValid(\"123456788\") false를 반환해야 한다.",
            Accounts.isValid("123456788"));
    }

    @Test
    public void testIsValidLetters() {
        assertFalse("isValid(\"abcdefghi\") false를 반환해야 한다.",
            Accounts.isValid("ABCDEFGHK"));
    }

    @Test
    public void testIsValidNonNormal() {
        assertFalse("빈 문자열은 유효한 숫자가 아니다", Accounts.isValid(""));
    }

    @Test
    public void testIsValidNonNumeric() {
        assertFalse("숫자 아닌 것들은 반드시 잘못된 것이다",
            Accounts.isValid("12.34.56."));
    }

    @Test
    public void testIsValidToolong() {
        assertFalse("9자리를 초과하는 숫자는 반드시 잘못된 것이다",
            Accounts.isValid("1234567890"));
    }

    @Test
    public void testIsValidTooshort() {
        assertFalse("9자리 미만 숫자는 반드시 잘못된 것이다",
            Accounts.isValid("12345677"));
    }

}
