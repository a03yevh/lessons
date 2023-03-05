package com.game.example.room;

import com.game.example.item.Furniture;
import com.game.example.item.Key;
import com.game.example.item.Window;
import java.util.ArrayList;

public class Bathroom extends Room {

    public Bathroom(String name, String description) {
        super(name, description);
        this.items = new ArrayList<>() {{
            add(new Window("Окно", "Окно во задний двор", "Через окно видно задний двор"));
            add(new Furniture("Зеркало", "Круглое зеркало над раковиной", "Круглое зеркало над раковиной"));
            add(new Furniture("Раковина", "Белая керамическая раковина", "Белая керамическая раковина"));
            add(new Furniture("Душ", "Душ", "Душ, видно что кто-то очень спешил, все залито водой"));
            add(new Key("Ключ", "Старый ключ от двери"));
        }};
    }

    public Bathroom(String name) {
        super(name);
    }
}
