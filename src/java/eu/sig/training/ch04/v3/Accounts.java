package eu.sig.training.ch04.v3;

import java.util.HashMap;
import java.util.Map;

import eu.sig.training.ch04.BusinessException;

public class Accounts {
    
    // Account 클래스는 자바판에서 번호가 문자열 프로퍼티로 나와 있지 않다.
    // 이미 책을 인쇄하고 있는 중이므로 계좌와 해당 번호를 연관지어 밖으로 빼냈다.
    public static Map<String, Account> ACCOUNTS = new HashMap<String, Account>();
    public static Map<Account, String> NUMBERS = new HashMap<Account, String>();
    
    // @SuppressWarnings("unused")
    public static CheckingAccount findAcctByNumber(String number)
        throws BusinessException {
        Object myAccount = ACCOUNTS.get(number);
        if (myAccount instanceof CheckingAccount) {
            return (CheckingAccount)myAccount;
        } else {
            throw new BusinessException("당좌 계좌가 아닙니다.");
        }
    }
    
    public static <T extends Account> T makeAccount(Class<T> clazz,
        String number) {
        try {
            T myAccount = clazz.newInstance();
            ACCOUNTS.put(number, myAccount);
            NUMBERS.put(myAccount, number);
            return myAccount;
        } catch (Exception e) {
            System.exit(1);
            return null;
        }
    }
    
    public static String getAccountNumber(Account acct) {
        return NUMBERS.get(acct);
    }
}
