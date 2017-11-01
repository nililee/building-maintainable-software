package eu.sig.training.ch04.v2;

import eu.sig.training.ch04.BusinessException;
import eu.sig.training.ch04.Money;

// tag::SavingsAccount[]
public class SavingsAccount {
    CheckingAccount registeredCounterAccount;

    public Transfer makeTransfer(String counterAccount, Money amount) 
        throws BusinessException {
        // 1. result가 9자리 은행 계좌 번호라고 보고 11-테스트로 검증한다.
        if (Accounts.isValid(counterAccount)) { // <1>
            // 2. 상대편 계좌를 찾아 전송 객체를 만든다.
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount); // <2>
            if (result.getCounterAccount().equals(this.registeredCounterAccount)) 
            {
                return result;
            } else {
                throw new BusinessException("상대편 계좌가 등록되지 않았습니다!");
            }
        } else {
            throw new BusinessException("잘못된 계좌 번호입니다!!");
        }
    }

}
// end::SavingsAccount[]
