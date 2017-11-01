package eu.sig.training.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import eu.sig.training.ch04.v1.Accounts;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader isr = 
            new BufferedReader(new InputStreamReader(System.in));
        String acct;
        do {
            System.out.println("다음 라인에 은행 계좌 번호를 입력하세요.");
            acct = isr.readLine();
            System.out.println("은행 계좌 번호 '" + acct + "'(은)는 " +
                (Accounts.isValid(acct) ? "올바른" : "잘못된") + " 번호입니다.");
        } while (acct != null && acct.length() != 0);
    }
}
