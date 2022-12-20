package com.magasin;

import com.magasin.items.Comte;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    Item[] listItems = new Item[]{
            new Item("Comte", 23, 4),
            new Item("PassVipConcert", 32, 6),
            new Item("PassVipConcert", 1, -5),
            new Item("Kryptonite", 12, 80),
            new Item("Chocolat", 18, 7),
            new Item("Poire pour Loris", 2, 4),
            new Item("PouvoirMagiques", 7, 6),
            new Item("PouvoirMagiques", 10, 60),
            new Item("over50", 7, 60),
    };
    Item[] list = new Item[]{
            new Item("over50", 7, 60),
    };


    @Test
    void testFindClass() {
        Magasin app = new Magasin(listItems);
        List<String> classesName = app.getAllClassesName();

        ItemToUpdate toTest = app.findClass(listItems[0], classesName);

        assertEquals(Comte.class, toTest.getClass());
    }

    @Test
    void testUpdateItemOneDay() {
        Magasin app = new Magasin(listItems);

        app.updateQuality();

        Item[] response = new Item[]{
                new Item("Comte", 22, 5),
                new Item("PassVipConcert", 31, 7),
                new Item("PassVipConcert", 0, 0),
                new Item("Kryptonite", 12, 80),
                new Item("Chocolat", 17, 6),
                new Item("Poire pour Loris", 1, 3),
                new Item("PouvoirMagiques", 6, 4),
                new Item("PouvoirMagiques", 9, 50),
                new Item("over50", 6, 50),


        };
        int index = 0;
        for (Item item : listItems) {
            assertEquals(response[index].name, item.name);
            assertEquals(response[index].sellIn, item.sellIn);
            assertEquals(response[index].quality, item.quality);
            index++;
        }

    }

    @Test
    void testUpdateItem50Days() {
        Magasin app = new Magasin(listItems);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }

        Item[] response = new Item[]{
                new Item("Comte", -27, 50),
                new Item("PassVipConcert", -18, 0),
                new Item("PassVipConcert", -49, 0),
                new Item("Kryptonite", 12, 80),
                new Item("Chocolat", -32, 0),
                new Item("Poire pour Loris", -48, 0),
                new Item("PouvoirMagiques", -43, 0),
                new Item("PouvoirMagiques", -40, 0),
                new Item("over50", -43, 0),


        };
        int index = 0;
        for (Item item : listItems) {
            assertEquals(response[index].name, item.name);
            assertEquals(response[index].sellIn, item.sellIn);
            assertEquals(response[index].quality, item.quality);
            index++;
        }

    }
    @Test
    void testUpdateItem50Days2() {
        Magasin app = new Magasin(list);
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }

        Item[] response = new Item[]{
                new Item("over50", -43, 0),
        };
        for (Item item : list) {
            assertEquals(response[0].name, item.name);
            assertEquals(response[0].sellIn, item.sellIn);
            assertEquals(response[0].quality, item.quality);
        }

    }
}
//    @Test
//    void goldenMasterDayMax() {
//        Magasin app = new Magasin(listItems);
//        List<String> classesName = app.getAllClassesName();
//        try {
//            PrintWriter writer = new PrintWriter("GM-max-day2.txt", "UTF-8");
//            for (int i = 0; i < 50; i++) {
//                int index=0;
//                for (Item item : listItems) {
//                    ItemToUpdate test = app.findClass(item, classesName);
//                    listItems[index] = test.updateItem();
//                    writer.println(listItems[index]);
//                    index++;
//                }
//                writer.println("----------------------------");
//            }
//            writer.close();
//        } catch (Exception e) {
//            System.out.println("Impossible de créer le fichier.");
//        }
//    }
//    @Test
//    void goldenMasterStart() {
//        Magasin app = new Magasin(listItems);
//        try {
//            PrintWriter writer = new PrintWriter("GM-max-day.txt", "UTF-8");
//            for (int i = 0; i < 50; i++) {
//                app.updateQuality();
//                for (Item item : listItems) {
//                    writer.println(item);
//                }
//                writer.println("----------------------------");
//            }
//            writer.close();
//        } catch (Exception e) {
//            System.out.println("Impossible de créer le fichier.");
//        }
//    }

