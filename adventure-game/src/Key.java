public class Key extends Item implements Useful {

    public Key(String name, String description) {
        super(name, description);
    }

    public void use(Game game) {
        if (getName().equals("Старинный ключ")) {
            game.setGameFinished(true);
            System.out.println("Вы нашли ключ от выхода! Поздравляем, вы победили!");
        } else {
            System.out.println("Ничего не произошло.");
        }
    }


    @Override
    public void use() {
        if (getName().equals("Старинный ключ")) {
            System.out.println("Вы нашли ключ от выхода! Поздравляю, вы выиграли!");
            Game.setGameFinished(true);
        } else {
            System.out.println("Ничего не произошло.");
        }
    }
}
