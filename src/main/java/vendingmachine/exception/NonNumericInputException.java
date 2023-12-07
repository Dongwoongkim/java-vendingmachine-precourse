package vendingmachine.exception;

public class NonNumericInputException extends IllegalArgumentException {

    public NonNumericInputException() {
        super("[ERROR] 문자가 입력에 포함되어 있습니다. 다시 입력해주세요.");
    }
}
