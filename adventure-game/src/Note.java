public class Note extends Item implements Useful {

    private String text;

    public Note(String name, String description, String text) {
        super(name, description);
        this.text = text;
    }

    public Note(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        System.out.println("Текст из записки: \"" + text + "\".");
    }
}