package eu.sig.training.ch04.v4;

import eu.sig.training.ch04.v3.CheckingAccount;

public class Accounts {
    @SuppressWarnings("unused")
    public static CheckingAccount findAcctByNumber(String number) {
        return new CheckingAccount();
    }

    // 반드시 성공하는 테스트 (책에는 수록되지 않음)
    public static boolean isValid(String number) {
        if (number.length() != 9) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
            sum = sum + (9 - i) * Character.getNumericValue(number.charAt(i));
        }
        return sum % 11 == 0;
    }
}
