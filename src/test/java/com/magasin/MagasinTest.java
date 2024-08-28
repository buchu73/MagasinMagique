package com.magasin;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MagasinTest {
    Random random = new Random();

    @Test
    void otherProduct() {
        // random.nextInt(50) génère un nombre aléatoire entre 0 (inclus) et 49 (inclus).
        int quality = random.nextInt(50) +1;
        int sellIn = random.nextInt(50) +1;
        Item[] items = new Item[] { new Item("Boite", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Boite", app.items[0].name);
        assertEquals(quality-1, app.items[0].quality);
        assertEquals(sellIn-1, app.items[0].sellIn);
    }

    @Test
    void otherProductQualitySupZero() {
        Item[] items = new Item[] { new Item("Boite", 4, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void otherProductSellInUnderZero() {
        int quality = 8;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Boite", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("Boite", app.items[0].name);
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertEquals(quality-2, app.items[0].quality);
    }
}
