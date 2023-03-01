public class Key extends Item {
    public int code;

    public Key(String name, String description, int code) {
        super(name, description);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}