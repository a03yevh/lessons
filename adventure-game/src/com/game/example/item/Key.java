package com.game.example.item;

import com.game.example.Game;

public class Key extends Item implements Useful, Collectible {

    private static final String KEY_NAME_TO_FINISH_GAME = "Старинный ключ";
    private static final String NOTHING_HAPPENED_MESSAGE = "Ничего не произошло";

    private String roomToOpen;

    public Key(String name, String description, String roomToOpen) {
        super(name, description);
        this.roomToOpen = roomToOpen;
    }

    public Key(String name, String description) {
        super(name, description);
    }

    @Override
    public void use() {
        if (roomToOpen != null) {
            System.out.printf("Вы можете открыть комнату %s%n", roomToOpen);
            return;
        }

        if (KEY_NAME_TO_FINISH_GAME.equals(name)) {
            Game.isGameFinished = true;
        } else {
            System.out.println(NOTHING_HAPPENED_MESSAGE);
        }
    }

    public String getRoomToOpen() {
        return roomToOpen;
    }

    public void setRoomToOpen(String roomToOpen) {
        this.roomToOpen = roomToOpen;
    }
}
