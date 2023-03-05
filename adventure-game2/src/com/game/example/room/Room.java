package com.game.example.room;

import com.game.example.item.Item;
import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private final String name;
    private String description;
    private boolean locked;
    protected List<Item> items = new ArrayList<>();

    public String name() {
        return name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Room(String name, String description, List<Item> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }

    public Room(String name) {
        this.name = name;
    }

    public void removeItemFromRoom(Item itemToRemove) {
        items.remove(itemToRemove);
    }

    public boolean hasItems() {
        return items.size() > 0;
    }

    public void printItems() {
        System.out.println("Предметы в комнате " + name() + ": ");

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, items.get(i).getName());
        }
    }
}
