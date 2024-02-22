package com.gildedrose;

public class GildedRose {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItem() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                updateAgedBrieQuality(item);
            } else if (isBackstagePasses(item)) {
                updateBackstagePassesQuality(item);
            } else if (isConjuredItem(item)) {
                updateConjuredItemQuality(item);
            } else if (isNormalItem(item)) {
                updateNormalItemQuality(item);
            }
            updateSellIn(item);
        }
    }

    private boolean isNormalItem(Item item) {
        return !isAgedBrie(item) && !isBackstagePasses(item) && !isSulfuras(item);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isConjuredItem(Item item) {
        return item.name.equals("Conjured");
    }

    private void updateNormalItemQuality(Item item) {
        decreaseQuality(item);
        if (item.sellIn <= 0) {
            decreaseQuality(item);
        }
    }

    private void updateAgedBrieQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 0) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePassesQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 10) {
            increaseQuality(item);
        }
        if (item.sellIn <= 5) {
            increaseQuality(item);
        }
        if (item.sellIn <= 0) {
            item.quality = MIN_QUALITY;
        }
    }

    private void updateConjuredItemQuality(Item item) {
        decreaseQuality(item, 2);
        if (item.sellIn <= 0) {
            decreaseQuality(item, 2);
        }
    }

    private void updateSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item, int decrement) {
        for (int i = 0; i < decrement; i++) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality = item.quality - 1;
        }
    }
}
