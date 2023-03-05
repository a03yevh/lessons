package com.game.example.room;

import com.game.example.item.Furniture;
import com.game.example.item.Note;
import com.game.example.item.Window;
import java.util.ArrayList;

public class Bedroom extends Room {
    public Bedroom(String name, String description) {
        super(name, description);
        this.items = new ArrayList<>() {{
            add(new Window("Окно", "Окно с ручкой в дальней стене", "Окно с ручкой в дальней стене"));
            add(new Furniture("Тумбочка", "Деревянная тумбочка у кровати", "Деревянная тумбочка у кровати"));
            add(new Furniture("Кровать", "Незаправленная кровать из Икеи", "Незаправленная кровать из Икеи"));
            add(new Note("Записка", "Записка на тумбочке",
                    "Привет, я сегодня очень спешу и оставляю ключи в прихожей. Закрой двери когда будешь выходить!"));
        }};
    }

    public Bedroom(String name) {
        super(name);
    }
}
