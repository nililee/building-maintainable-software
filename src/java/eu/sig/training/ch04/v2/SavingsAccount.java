package eu.sig.training.ch04.v2;

import eu.sig.training.ch04.BusinessException;
import eu.sig.training.ch04.Money;

// tag::SavingsAccount[]
public class SavingsAccount {
    CheckingAccount registeredCounterAccount;

    public Transfer makeTransfer(String counterAccount, Money amount) 
        throws BusinessException {
        // 1. result�� 9�ڸ� ���� ���� ��ȣ��� ���� 11-�׽�Ʈ�� �����Ѵ�.
        if (Accounts.isValid(counterAccount)) { // <1>
            // 2. ����� ���¸� ã�� ���� ��ü�� �����.
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount); // <2>
            if (result.getCounterAccount().equals(this.registeredCounterAccount)) 
            {
                return result;
            } else {
                throw new BusinessException("����� ���°� ��ϵ��� �ʾҽ��ϴ�!");
            }
        } else {
            throw new BusinessException("�߸��� ���� ��ȣ�Դϴ�!!");
        }
    }

}
// end::SavingsAccount[]
