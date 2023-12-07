package vendingmachine.exception;

public class InvalidItemsFormatException extends IllegalArgumentException {

    public InvalidItemsFormatException() {
        super("[ERROR] 판매하고자 하는 아이템을 형식에 맞게 다시 입력해주세요.");
    }
}
