package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("계산을 선택하세요: 1) 사칙연산 2) 원의 계산");
            int choice = sc.nextInt();

            if (choice == 1) {
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
                        calculator.inquiryResults();
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (choice == 2) {
                System.out.print("반지름을 입력하세요:");
                double radius = sc.nextDouble();

                System.out.print("계산할 항목을 선택하세요: 1) 넓이 2) 둘레 3) 체적 4) 부피: ");
                int circleChoice = sc.nextInt();

                double result = 0;
                switch (circleChoice) {
                    case 1:
                        result = Math.PI * radius * radius;
                        System.out.println("원의 넓이: " + result);
                        break;
                    case 2:
                        result = 2 * Math.PI * radius;
                        System.out.println("원의 둘레: " + result);
                        break;
                    case 3:
                        result = (4 / 3) * Math.PI * Math.pow(radius, 3);
                        System.out.println("구의 체적: " + result);
                        break;
                    case 4:
                        result = Math.PI * Math.pow(radius, 2) * radius;
                        System.out.println("원기둥의 부피: " + result);
                        break;
                    default:
                        System.out.println("올바른 선택이 아닙니다.");
                }
                calculator.getResults().add(result); // 결과를 저장
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) {
                break;
            }
        }
        sc.close();
    }
}
