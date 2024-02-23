package com.gildedrose.inventory;

import static com.gildedrose.utils.constants.Misc.MIN_QUALITY;

public class ConjuredItemUpdater extends ItemUpdater {

    @Override
    public void updateQuality(Item item) {
        decreaseQuality(item, 2);
        if (item.sellIn <= 0) {
            decreaseQuality(item, 2);
        }
    }

    private void decreaseQuality(Item item, int decrement) {
        for (int i = 0; i < decrement; i++) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}
