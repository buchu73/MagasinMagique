package com.magasin;

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

    // Tester l'impossibilité d'une qualitée > 50 -> Ne fonctionne pas
    @Test
    void otherProductQualityUnderFifteen() {
        Item[] items = new Item[] { new Item("Boite", 4, 80) };
        Magasin app = new Magasin(items);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, app::updateQuality);
        assertEquals("La qualité ne peut pas être supérieure à 50", thrown.getMessage());
    }
}
