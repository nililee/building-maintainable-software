package eu.sig.training.ch04.v1;

import eu.sig.training.ch04.BusinessException;
import eu.sig.training.ch04.Money;

// tag::CheckingAccount[]
public class CheckingAccount {
    private int transferLimit = 100;

    public Transfer makeTransfer(String counterAccount, Money amount)
        throws BusinessException {
        // 1. ��ü �ѵ��� üũ�Ѵ�.
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("�ѵ� �ʰ�!");
        }
        // 2. result�� 9�ڸ� ���� ���� ��ȣ��� ���� 11-�׽�Ʈ�� �����Ѵ�.
        int sum = 0;
        for (int i = 0; i < counterAccount.length(); i++) {
            sum = sum + (9-i) * Character.getNumericValue(
                counterAccount.charAt(i));
        }
        if (sum % 11 == 0) {
            // 3. ����� ���¸� ã�� ���� ��ü�� �����.
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount);
            return result;
        } else {
            throw new BusinessException("�߸��� ���� ��ȣ�Դϴ�!!");
        }
    }
}
// end::CheckingAccount[]
