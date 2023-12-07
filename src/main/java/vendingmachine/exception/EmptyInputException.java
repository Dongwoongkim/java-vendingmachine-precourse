package vendingmachine.exception;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super("[ERROR] 빈 값은 허용되지 않습니다. 다시 입력 해주세요.");
    }
}
