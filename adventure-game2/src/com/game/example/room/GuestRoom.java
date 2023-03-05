package com.game.example.room;

import com.game.example.item.Item;
import java.util.List;

public class GuestRoom extends Room {
    public GuestRoom(String name, String description) {
        super(name, description);
        setLocked(true);
    }

    public GuestRoom(String name, String description, List<Item> items) {
        super(name, description, items);
        setLocked(true);
    }

    public GuestRoom(String name) {
        super(name);
        setLocked(true);
    }

    @Override
    public void printItems() {
        System.out.println("Похоже здесь нет никаких предметов...");
    }
}
