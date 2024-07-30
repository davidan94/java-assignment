package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            try {
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("연산 결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("삭제하시겠습니까? (yes 입력 시 삭제)");
            if (sc.next().equals("yes")) {
                try {
                    calculator.removeResult();
                    System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("결과를 조회하시겠습니까? (yes 입력 시 조회)");
            if (sc.next().equals("yes")) {
                try {
                    calculator.inquiryResults(); // 결과 조회 메서드 호출
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) {
                break;
            }
        }
        sc.close();
    }
}
