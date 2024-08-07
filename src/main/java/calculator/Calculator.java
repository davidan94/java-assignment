import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException; // 추가된 import

public class Calculator {
    private Queue<Double> results;

    public Calculator() {
        results = new LinkedList<>();
    }

    public double calculate(double num1, double num2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모에 0이 들어올 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
        }
        results.add(result);
        return result;
    }

    public Queue<Double> getResults() {
        return results;
    }

    public void removeResult() {
        if (results.isEmpty()) {
            throw new NoSuchElementException("삭제할 연산 결과가 없습니다.");
        }
        results.poll();
    }

    // 결과 조회 메서드
    public void inquiryResults() {
        if (results.isEmpty()) {
            throw new NoSuchElementException("조회할 연산 결과가 없습니다.");
        }
        results.forEach(System.out::println);
    }
}
