package com.magasin;


import java.util.Random;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
  
    // Tester que dans un fonctionnement normal, la qualité pert 1 point par jour et le sellIn perd 1 point également
    @RepeatedTest(100)
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

    // Tester que la qualité ne passe jamais sous zéro
    @RepeatedTest(10)
    void otherProductQualitySupZero() {
        Item[] items = new Item[] { new Item("Boite", 4, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    // tester qu'avec un sellIn < 0, la qualité diminue de 2
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
        int quality = 10;
        int sellIn = 11;
        Item[] items = new Item[]{new Item("Pass VIP Concert", sellIn, quality)};
        Magasin app = new Magasin(items);

        app.updateQuality();

        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(11, app.items[0].quality, "quality");
        assertEquals(10, app.items[0].sellIn, "sellIn");
    }

    // Tester l'impossibilité d'une qualitée > 50 -> Ne fonctionne pas
    @Test
    void otherProductQualityUnderFifteen() {
        Item[] items = new Item[] { new Item("Boite", 4, 80) };
        Magasin app = new Magasin(items);
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, app::updateQuality);
      assertEquals("La qualité ne peut pas être supérieure à 50", error.getMessage());
    }

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
