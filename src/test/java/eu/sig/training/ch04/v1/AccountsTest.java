// tag::AccountsTest[]
package eu.sig.training.ch04.v1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class AccountsTest {

    @Test
    public void testIsValidNormalCases() {
        assertTrue(Accounts.isValid("123456789"));
        assertFalse(Accounts.isValid("123456788"));
    }

    // end::AccountsTest[]

    @Ignore("���ø� ���� �Ϻη� �����ϰ� �Ѵ�.")
    // tag::testEmptyString[]
    @Test
    public void testEmptyString() {
        assertFalse(Accounts.isValid(""));
    }
    // end::testEmptyString[]

    @SuppressWarnings("unused")
    @Ignore("���ø� ���� �Ϻη� �����ϰ� �Ѵ�.")
    // tag::showError[]
    @Test
    public void showError() {
        int dummy = 1 / 0;
        // �� ���ο��� ���ܰ� �߻������Ƿ� ���� ������ ���� ������� �ʴ´�.
        // ����Ǹ� �� �׽�Ʈ�� �׻� �����ϹǷ� ���Ʈ �޽����� �� ���� ���� ���̴�.
        assertTrue("�� ������ �� ���� �����ž�!", true);
    }
    // end::showError[]
}
