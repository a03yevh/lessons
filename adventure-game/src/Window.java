public class Window extends Item {
    public Window(String name, String description) {
        super(name, description);
    }

    public void open() {
        System.out.println("The window is now open.");
    }

    public void close() {
        System.out.println("The window is now closed.");
    }
}
