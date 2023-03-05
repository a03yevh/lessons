package com.game.example.item;

public class Note extends Item implements Useful, Collectible {

    private final String text;

    public Note(String name, String description, String text) {
        super(name, description);
        this.text = text;
    }

    @Override
    public void use() {
        System.out.printf("Текст из записки: \"%s\"%n", text);
    }
}
