package eu.sig.training.ch04.v2;

import eu.sig.training.ch04.BusinessException;
import eu.sig.training.ch04.Money;

// tag::CheckingAccount[]
public class CheckingAccount {
    private int transferLimit = 100;

    public Transfer makeTransfer(String counterAccount, Money amount)
        throws BusinessException {
        // 1. 이체 한도를 체크한다.
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("한도 초과!");
        }
        if (Accounts.isValid(counterAccount)) { // <1>
            // 2. 상대편 계좌를 찾아 전송 객체를 만든다.
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount); // <2>
            return result;
        } else {
            throw new BusinessException("잘못된 계좌 번호입니다!");
        }
    }

}
// end::CheckingAccount[]
