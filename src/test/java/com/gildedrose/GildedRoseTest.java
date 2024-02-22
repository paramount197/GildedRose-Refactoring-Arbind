package com.gildedrose;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private GildedRose gildedRose;

    @Nested
    @DisplayName("Normal Item Tests")
    class NormalItemTests {
        private Item normalItem;

        @BeforeEach
        void setUp() {
            normalItem = new Item("Normal Item", 10, 20);
            gildedRose = new GildedRose(new Item[]{normalItem});
        }

        @Test
        @DisplayName("Update Normal Item Quality Before Sell-by Date")
        void testUpdateNormalItemQualityBeforeSellBy() {
            gildedRose.updateItem();
            assertEquals(19, normalItem.quality);
        }

        @Test
        @DisplayName("Update Normal Item Quality After Sell-by Date")
        void testUpdateNormalItemQualityAfterSellBy() {
            normalItem.sellIn = 0;
            gildedRose.updateItem();
            assertEquals(18, normalItem.quality);
        }

        @Test
        @DisplayName("Update Normal Item Quality At Zero Quality")
        void testUpdateNormalItemQualityAtZeroQuality() {
            normalItem.quality = 0;
            gildedRose.updateItem();
            assertEquals(0, normalItem.quality);
        }
    }

    @Nested
    // @Disabled
    @DisplayName("Aged Brie Tests")
    class AgedBrieTests {
        private Item agedBrie;

        @BeforeEach
        void setUp() {
            agedBrie = new Item("Aged Brie", 5, 10);
            gildedRose = new GildedRose(new Item[]{agedBrie});
        }

        @Test
        @DisplayName("Update Aged Brie Quality Before Sell-by Date")
        void testUpdateAgedBrieQualityBeforeSellBy() {
            gildedRose.updateItem();
            assertEquals(11, agedBrie.quality);
        }

        @Test
        @DisplayName("Update Aged Brie Quality After Sell-by Date")
        void testUpdateAgedBrieQualityAfterSellBy() {
            agedBrie.sellIn = 0; // Past sell-by date
            gildedRose.updateItem();
            assertEquals(12, agedBrie.quality);
        }

        @Test
        @DisplayName("Update Aged Brie Quality At Maximum Quality")
        void testUpdateAgedBrieQualityAtMaxQuality() {
            agedBrie.quality = 50; // Maximum quality
            gildedRose.updateItem();
            assertEquals(50, agedBrie.quality);
        }
    }

    @Nested
    @DisplayName("Backstage Passes Tests")
    class BackstagePassesTests {
        private Item backstagePasses;

        @BeforeEach
        void setUp() {
            backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
            gildedRose = new GildedRose(new Item[]{backstagePasses});
        }

        @Test
        @DisplayName("Update Backstage Passes Quality Before Sell-By Date")
        void testUpdateBackstagePassesQualityBeforeSellBy() {
            gildedRose.updateItem();
            assertEquals(21, backstagePasses.quality);
        }

        @Test
        @DisplayName("Update Backstage Passes Quality When 10 Days or Less Before Concert")
        void testUpdateBackstagePassesQualityTenDaysBeforeConcert() {
            backstagePasses.sellIn = 10;
            gildedRose.updateItem();
            assertEquals(22, backstagePasses.quality);
        }

        @Test
        @DisplayName("Update Backstage Passes Quality When 5 Days or Less Before Concert")
        void testUpdateBackstagePassesQualityFiveDaysBeforeConcert() {
            backstagePasses.sellIn = 5;
            gildedRose.updateItem();
            assertEquals(23, backstagePasses.quality);
        }

        @Test
        @DisplayName("Update Backstage Passes Quality After Concert")
        void testUpdateBackstagePassesQualityAfterConcert() {
            backstagePasses.sellIn = 0; // Past sell-by date
            gildedRose.updateItem();
            assertEquals(0, backstagePasses.quality);
        }

        @Test
        @DisplayName("Update Backstage Passes Quality At Maximum Quality")
        void testUpdateBackstagePassesQualityAtMaxQuality() {
            backstagePasses.quality = 50; // Maximum quality
            gildedRose.updateItem();
            assertEquals(50, backstagePasses.quality);
        }
    }

    @Nested
    @DisplayName("Sulfuras Tests")
    class SulfurasTests {
        private Item sulfuras;

        @BeforeEach
        void setUp() {
            sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
            gildedRose = new GildedRose(new Item[]{sulfuras});
        }

        @Test
        @DisplayName("Update Sulfuras Quality Before Sell-By Date")
        void testUpdateSulfurasQualityBeforeSellBy() {
            gildedRose.updateItem();
            assertEquals(80, sulfuras.quality);
        }

        @Test
        @DisplayName("Update Sulfuras Quality After Sell-By Date")
        void testUpdateSulfurasQualityAfterSellBy() {
            sulfuras.sellIn = -1;
            gildedRose.updateItem();
            assertEquals(80, sulfuras.quality);
        }

        @Test
        @DisplayName("Update Sulfuras Quality At Maximum Quality")
        void testUpdateSulfurasQualityAtMaxQuality() {
            sulfuras.quality = 80;
            gildedRose.updateItem();
            assertEquals(80, sulfuras.quality);
        }
    }

    @Nested
    @DisplayName("Conjured Item Tests")
    class ConjuredItemTests {
        private Item conjuredItem;

        @BeforeEach
        void setUp() {
            conjuredItem = new Item("Conjured", 5, 10);
            gildedRose = new GildedRose(new Item[]{conjuredItem});
        }

        @Test
        @DisplayName("Update Conjured Item Quality Before Sell-By Date")
        void testUpdateConjuredItemQualityBeforeSellBy() {
            gildedRose.updateItem();
            assertEquals(8, conjuredItem.quality);
        }

        @Test
        @DisplayName("Update Conjured Item Quality After Sell-By Date")
        void testUpdateConjuredItemQualityAfterSellBy() {
            conjuredItem.sellIn = 0;
            gildedRose.updateItem();
            assertEquals(6, conjuredItem.quality);
        }

        @Test
        @DisplayName("Update Conjured Item Quality At Minimum Quality")
        void testUpdateConjuredItemQualityAtMinQuality() {
            conjuredItem.quality = 0;
            gildedRose.updateItem();
            assertEquals(0, conjuredItem.quality);
        }

        @Test
        @DisplayName("Update Conjured Item Quality At Maximum Quality")
        void testUpdateConjuredItemQualityAtMaxQuality() {
            conjuredItem.quality = 50;
            gildedRose.updateItem();
            assertEquals(48, conjuredItem.quality);
        }
    }
}