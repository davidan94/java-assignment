package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> opArr = new LinkedList<>(); // Step 2: 연산 결과를 저장하는 큐

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String firstStr = sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요: ");
            String secondStr = sc.nextLine();

            int firstNum, secondNum;
            try {
                firstNum = Integer.parseInt(firstStr);
                secondNum = Integer.parseInt(secondStr);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.nextLine().charAt(0);

            int result = 0;
            try {
                result = switch (operator) {
                    case '+' -> firstNum + secondNum;
                    case '-' -> firstNum - secondNum;
                    case '*' -> firstNum * secondNum;
                    case '/' -> {
                        if (secondNum == 0) {
                            throw new IllegalArgumentException("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        }
                        yield firstNum / secondNum;
                    }
                    default -> throw new IllegalArgumentException("[ +, -, /, * ] 이외에 입력되었습니다.");
                };
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            opArr.add(result); // Step 2: 연산 결과 저장
            System.out.println("결과 = " + opArr.peek() + "\n");

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.nextLine().equals("exit")) {
                break;
            }
        }
    }
}
