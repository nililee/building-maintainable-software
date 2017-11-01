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

    @Ignore("예시를 위해 일부러 실패하게 한다.")
    // tag::testEmptyString[]
    @Test
    public void testEmptyString() {
        assertFalse(Accounts.isValid(""));
    }
    // end::testEmptyString[]

    @SuppressWarnings("unused")
    @Ignore("예시를 위해 일부러 실패하게 한다.")
    // tag::showError[]
    @Test
    public void showError() {
        int dummy = 1 / 0;
        // 앞 라인에서 예외가 발생했으므로 다음 라인은 절대 실행되지 않는다.
        // 실행되면 이 테스트는 항상 성공하므로 어썰트 메시지를 볼 일은 없을 것이다.
        assertTrue("이 문장을 볼 일은 없을거야!", true);
    }
    // end::showError[]
}
