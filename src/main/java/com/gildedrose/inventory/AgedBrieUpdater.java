package com.gildedrose.inventory;

import static com.gildedrose.utils.constants.Misc.MAX_QUALITY;

public class AgedBrieUpdater extends ItemUpdater {

    @Override
    public void updateQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 0) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
