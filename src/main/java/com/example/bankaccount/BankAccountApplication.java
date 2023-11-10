package com.example.bankaccount;

import com.example.bankaccount.Controller.BankForAdminController;
import com.example.bankaccount.Controller.BankForClientController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.Scanner;

@SpringBootApplication
public class BankAccountApplication {

    private final BankForClientController bankForClientController;
    private final BankForAdminController bankForAdminController;

    public BankAccountApplication(BankForClientController bankForClientController, BankForAdminController bankForAdminController) {

        this.bankForClientController = bankForClientController;
        this.bankForAdminController = bankForAdminController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BankAccountApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("\n은행 계좌 애플리케이션에 오신 것을 환영합니다.");
                    System.out.println("1: 계좌 생성");
                    System.out.println("2: 입금");
                    System.out.println("3: 출금");
                    System.out.println("4: 계좌 조회");
                    System.out.println("5: 종료");
                    System.out.print("원하는 작업의 번호를 입력하세요: ");

                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1":
                            createAccount(scanner);
                            break;
                        case "2":
                            deposit(scanner);
                            break;
                        case "3":
                            withdraw(scanner);
                            break;
                        case "4":
                            listAccounts(scanner);
                            break;
                        case "5":
                            System.out.println("애플리케이션을 종료합니다.");
                            return;
                        case "A12":
                            adminGetClient(scanner);
                            System.out.println("직원 전용 탭입니다");
                        default:
                            System.out.println("잘못된 선택입니다. 1부터 5까지의 숫자를 입력하세요.");
                            break;
                    }
                }
            }
        };
    }

    private void adminGetClient(Scanner scanner) {
        System.out.println("직원 전용 탭입니다.");
        System.out.print("관리자 ID: ");
        String inputAdminId = scanner.nextLine();
        System.out.print("관리자 비밀번호: ");
        String inputAdminPw = scanner.nextLine();
        System.out.print("사용자 이름: ");
        String inputUserName = scanner.nextLine();
        System.out.print("사용자 ID: ");
        String inputUserId = scanner.nextLine();

        ResponseEntity<?> response = bankForAdminController.AdminClientInfo(inputAdminId, inputAdminPw, inputUserName, inputUserId);
        System.out.println(response.getBody());
    }


    private void createAccount(Scanner scanner) {
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("전화번호: ");
        String phone = scanner.nextLine();
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호: ");
        String Pw = scanner.nextLine();
        System.out.print("계좌 별명: ");
        String accountName = scanner.nextLine();
        System.out.print("초기 입금액: ");
        double firstDeposit = Double.parseDouble(scanner.nextLine());

        ResponseEntity<String> response = bankForClientController.makeFirstAccount(name, phone, userId, Pw, accountName, firstDeposit);
        System.out.println(response.getBody());
    }

    private void deposit(Scanner scanner) {
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pw = scanner.nextLine();
        System.out.print("계좌번호: ");
        String accountNumber = scanner.nextLine();
        System.out.print("입금액: ");
        double depositAmount = Double.parseDouble(scanner.nextLine());

        ResponseEntity<String> response = bankForClientController.deposit(userId, pw, accountNumber, depositAmount);
        System.out.println(response.getBody());
    }

    private void withdraw(Scanner scanner) {
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pw = scanner.nextLine();
        System.out.print("계좌번호: ");
        String accountNumber = scanner.nextLine();
        System.out.print("출금액: ");
        double withdrawAmount = Double.parseDouble(scanner.nextLine());

        ResponseEntity<String> response = bankForClientController.withdraw(userId, pw, accountNumber, withdrawAmount);
        System.out.println(response.getBody());
    }

    private void listAccounts(Scanner scanner) {
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호: ");
        String Pw = scanner.nextLine();

        ResponseEntity<?> response = bankForClientController.getAllAccountsForUser(userId, Pw);
        System.out.println(response.getBody());
    }
}