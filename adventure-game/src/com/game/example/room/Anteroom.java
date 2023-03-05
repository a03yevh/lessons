package com.game.example.room;

import com.game.example.item.Furniture;
import com.game.example.item.Item;
import com.game.example.item.Key;
import com.game.example.item.Window;
import java.util.ArrayList;
import java.util.List;

public class Anteroom extends Room {

    public Anteroom(String name, String description) {
        super(name, description);
        this.items = new ArrayList<>() {{
            add(new Window("Окно", "Окно над дверью", "Окно над дверью, через него проходят солнечние лучи"));
            add(new Furniture("Дверь", "Входная дверь", "Надо найти ключ и запереть дверь"));
            add(new Furniture("Тумбочка", "Маленькая тумбочка около двери", "На тумбочке стоит ключ от входной двери"));
            add(new Key("Старинный ключ", "Ключ от входной двери"));
            add(new Furniture("Шкаф", "Огромный шкаф", "Шкаф, ничего интересного"));
        }};
    }

    public Anteroom(String name, String description, List<Item> items) {
        super(name, description, items);
    }

    public Anteroom(String name) {
        super(name);
    }
}
