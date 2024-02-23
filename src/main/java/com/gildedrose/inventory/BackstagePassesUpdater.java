package com.gildedrose.inventory;

import static com.gildedrose.utils.constants.Misc.MAX_QUALITY;

public class BackstagePassesUpdater extends ItemUpdater {

    @Override
    public void updateQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 10) {
            increaseQuality(item);
        }
        if (item.sellIn <= 5) {
            increaseQuality(item);
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
