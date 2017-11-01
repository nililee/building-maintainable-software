package eu.sig.training.ch04.v1;

import eu.sig.training.ch04.BusinessException;
import eu.sig.training.ch04.Money;

// tag::SavingsAccount[]
public class SavingsAccount {
    CheckingAccount registeredCounterAccount;

    public Transfer makeTransfer(String counterAccount, Money amount) 
        throws BusinessException {
        // 1. result가 9자리 은행 계좌 번호라고 보고 11-테스트로 검증한다.
        int sum = 0; // <1>
        for (int i = 0; i < counterAccount.length(); i++) {
            sum = sum + (9 - i) * Character.getNumericValue(
                counterAccount.charAt(i));
        }
        if (sum % 11 == 0) {
            // 2. 상대편 계좌를 찾아 전송 객체를 만든다.
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount); // <2>
            // 3. 이체 한도가 상대편 계좌와 동일한지 체크한다.
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
