public class Window extends Item implements Useful {

    private String text;

    public Window(String name, String description, String text) {
        super(name, description);
        this.text = text;
    }

    public Window(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        System.out.println(text);
    }
}