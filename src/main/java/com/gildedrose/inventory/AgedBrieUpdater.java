package com.gildedrose.inventory;

import static com.gildedrose.utils.constants.Misc.MAX_QUALITY;

/**
 * A class to update the quality of Aged Brie items.
 */
public class AgedBrieUpdater extends ItemUpdater {

    /**
     * Updates the quality of the given item based on its sellIn value.
     *
     * @param item The item to update.
     */
    @Override
    public void updateQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 0) {
            increaseQuality(item);
        }
    }

    /**
     * Increases the quality of the given item.
     *
     * @param item The item whose quality to increase.
     */
    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }
}
