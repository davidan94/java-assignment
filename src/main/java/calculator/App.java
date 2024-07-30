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

            // Step 3: 가장 먼저 저장된 연산 결과를 삭제할지 묻는 기능 추가
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");

            if (sc.nextLine().equals("remove")) { // Step 3: 결과 삭제 기능 추가
                if (!opArr.isEmpty()) {
                    System.out.println("remove = " + opArr.poll());
                }
            }

            // Step 4: 저장된 연산 결과 조회 기능 추가
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if (sc.nextLine().equals("inquiry")) { // Step 4: 결과 조회 기능 추가
                int index = 1;
                for (Integer i : opArr) { // 향상된 for문 사용
                    System.out.println(index + "번째 결과는 = " + i);
                    index++;
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.nextLine().equals("exit")) {
                break;
            }
        }
    }
}
