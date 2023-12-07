package vendingmachine.model.vo;

public class Name {

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name create(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }
}
