package vendingmachine.exception;

public class InvalidItemsFormatException extends IllegalArgumentException {

    public InvalidItemsFormatException() {
        super("[ERROR] 판매하고자 하는 아이템을 대괄호로 묶어서 다시 입력해주세요.");
    }
}
