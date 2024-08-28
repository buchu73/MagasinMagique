package com.magasin;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {
    Random random = new Random();

    @Test

    void Kryptonite() {
        int sellIn = random.nextInt(80);
        int quality = random.nextInt(80);

        Item[] items = new Item[] { new Item("Kryptonite", sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);
        assertEquals("Kryptonite", app.items[0].name);
    }
}
