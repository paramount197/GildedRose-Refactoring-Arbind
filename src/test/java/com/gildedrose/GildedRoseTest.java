package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private GildedRose gildedRose;
    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[]{
                new Item("Normal Item", 10, 20),
                new Item("Aged Brie", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };
        gildedRose = new GildedRose(items);
    }


    @Nested
    @DisplayName("Normal Item Tests")
    class NormalItemTests {
        @Test
        @DisplayName("Update Normal Item Quality")
        void testUpdateNormalItemQuality() {
            gildedRose.updateQuality();
            Item normalItem = items[0];
            assertEquals(19, normalItem.quality);
        }
    }

    @Nested
    @DisplayName("Aged Brie Tests")
    class AgedBrieTests {
        @Test
        @DisplayName("Update Aged Brie Quality")
        void testUpdateAgedBrieQuality() {
            gildedRose.updateQuality();
            Item agedBrie = items[1];
            assertEquals(11, agedBrie.quality);
        }
    }

    @Nested
    @DisplayName("Backstage Passes Tests")
    class BackstagePassesTests {
        @Test
        @DisplayName("Update Backstage Passes Quality")
        void testUpdateBackstagePassesQuality() {
            gildedRose.updateQuality();
            Item backstagePasses = items[2];
            assertEquals(21, backstagePasses.quality);
        }
    }

    @Nested
    @DisplayName("Sulfuras Tests")
    class SulfurasTests {
        @Test
        @DisplayName("Update Sulfuras Quality")
        void testUpdateSulfurasQuality() {
            gildedRose.updateQuality();
            Item sulfuras = items[3];
            assertEquals(80, sulfuras.quality);
        }
    }

}