package com.magasin;

import com.magasin.items.Comte;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    Item[] listItems = new Item[]{
            new Item("Comte", 23, 4),
            new Item("PassVipConcert", 32, 6),
            new Item("Kryptonite", 12, 80),
            new Item("Chocolat", 18, 7),
            new Item("Poire pour Loris", 2, 4),
            new Item("Toto", 12, 60),
            new Item("truc", 12, -12),
            new Item("Comte", 12, -12),
    };

    @Test
    void testFindClass(){
        Magasin app = new Magasin(listItems);
        ItemToUpdate test = app.findClass(listItems[3]);
        test.updateItem();
        System.out.println(test);



    }

  /*  @Test
    void goldenMasterDayMax() {
        Magasin app = new Magasin(listItems);
        try {
            PrintWriter writer = new PrintWriter("GM-max-day.txt", "UTF-8");
            for (int i = 0; i < 50; i++) {
                app.updateQuality();
                for (Item item : listItems) {
                    writer.println(item);
                }
                writer.println("----------------------------");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Impossible de créer le fichier.");
        }
    }*/


}
