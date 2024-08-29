package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MagasinTest {

    @ParameterizedTest
    @CsvSource({
            "Comté, 15,5",
            "Comté, 4,4",
            "Comté, -1,3",
    })
    void foo(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(sellIn-1, app.items[0].sellIn);
        assertEquals(quality+1, app.items[0].quality);
        assertEquals(name, app.items[0].name);
    }



@Test
void foobyzero() {
    Item[] items = new Item[] { new Item("Comté", 0, 4) };
    Magasin app = new Magasin(items);
    app.updateQuality();
    assertEquals(-1, app.items[0].sellIn);
    assertEquals(5, app.items[0].quality);
    assertEquals("Comté", app.items[0].name);
}



@Test
void qualityEgaleQualityPlusUn() {
    Item[] items = new Item[] { new Item("Comté", 4, 4) };
    Magasin app = new Magasin(items);
    app.updateQuality();
    assertEquals(3, app.items[0].sellIn);
    assertEquals(5, app.items[0].quality);
    assertEquals("Comté", app.items[0].name);
}

}
