package eu.sig.training.ch04.v4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountsTest {

    @Test
    public void testIsValidNormalCases() {
        assertTrue("isValid(\"123456789\")�� true�� ��ȯ�ؾ� �Ѵ�.",
            Accounts.isValid("123456789"));
        assertFalse("isValid(\"123456788\") false�� ��ȯ�ؾ� �Ѵ�.",
            Accounts.isValid("123456788"));
    }

    @Test
    public void testIsValidLetters() {
        assertFalse("isValid(\"abcdefghi\") false�� ��ȯ�ؾ� �Ѵ�.",
            Accounts.isValid("ABCDEFGHK"));
    }

    @Test
    public void testIsValidNonNormal() {
        assertFalse("�� ���ڿ��� ��ȿ�� ���ڰ� �ƴϴ�", Accounts.isValid(""));
    }

    @Test
    public void testIsValidNonNumeric() {
        assertFalse("���� �ƴ� �͵��� �ݵ�� �߸��� ���̴�",
            Accounts.isValid("12.34.56."));
    }

    @Test
    public void testIsValidToolong() {
        assertFalse("9�ڸ��� �ʰ��ϴ� ���ڴ� �ݵ�� �߸��� ���̴�",
            Accounts.isValid("1234567890"));
    }

    @Test
    public void testIsValidTooshort() {
        assertFalse("9�ڸ� �̸� ���ڴ� �ݵ�� �߸��� ���̴�",
            Accounts.isValid("12345677"));
    }

}
