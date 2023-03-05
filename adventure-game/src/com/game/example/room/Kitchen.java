package com.game.example.room;

import com.game.example.item.Furniture;
import com.game.example.item.Key;
import com.game.example.item.Window;
import java.util.ArrayList;

public class Kitchen extends Room {
    public Kitchen(String name, String description) {
        super(name, description);
        this.items = new ArrayList<>() {{
            add(new Furniture("Выдвижной ящик", "Верхний ящик под столешницей", "Здесь ничево интересного"));
            add(new Window("Окно", "Окно во двор", "Окно во двор, надворе хорошая погода"));
            add(new Furniture("Выдвижной ящик", "Нижний ящик под столешницей", "Здесь ничево интересного"));
            add(new Furniture("Стол", "Обеденний стол", "На столе не помытая посуда..."));
            add(new Furniture("Табуретка", "Табуретка для обеденного стола", "Оттодвинутая табуретка"));
            add(new Key("Ключ от гостинной", "Ключ от гостинной", "Гостевая"));
        }};
    }

    public Kitchen(String name) {
        super(name);
    }
}
