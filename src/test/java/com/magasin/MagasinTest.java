package com.magasin;
import java.util.Random;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {


    @Test
    void PassVIPQualityPlusTrois() {
        int quality= 10;
        int sellIn= 4;
        Item[] items = new Item[]{new Item("Pass VIP Concert",sellIn,quality)};
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(13 , app.items[0].quality,"quality");
        assertEquals(3, app.items[0].sellIn,"sellIn");
    }
    @Test
    void PassVIPQualityPlusDeux() {
        int quality= 10;
        int sellIn= 7;
        Item[] items = new Item[]{new Item("Pass VIP Concert",sellIn,quality)};
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(12 , app.items[0].quality,"quality");
        assertEquals(6, app.items[0].sellIn,"sellIn");
    }
    @Test
    void PassVIPQualityPlusUn() {
        int quality= 10;
        int sellIn= 11;
        Item[] items = new Item[]{new Item("Pass VIP Concert",sellIn,quality)};
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(11 , app.items[0].quality,"quality");
        assertEquals(10, app.items[0].sellIn,"sellIn");
    }
    @Test
    void PassVIPQualitySellInZero() {
        int quality= 50;
        int sellIn= 0;
        Item[] items = new Item[]{new Item("Pass VIP Concert",sellIn,quality)};
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(0 , app.items[0].quality,"quality");
        assertEquals(-1, app.items[0].sellIn,"sellIn");
    }

}