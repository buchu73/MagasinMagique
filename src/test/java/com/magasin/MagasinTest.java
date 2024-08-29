package com.magasin;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {
    Random random = new Random();

    @ParameterizedTest
    @CsvSource({
            "Kryptonite, 80, 80", //To test if the quality and the sellIn are still the same
            "Kryptonite, 30, 35", //To test if the quality must always be 80
    })
    void Kryptonite(String name, int sellIn, int quality) {


        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(sellIn, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);
    }
}
