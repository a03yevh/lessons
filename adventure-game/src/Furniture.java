public class Furniture extends Item {
    public Furniture(String name, String description) {
        super(name, description);
    }

    public void move() {
        System.out.println("The furniture has been moved.");
    }
}