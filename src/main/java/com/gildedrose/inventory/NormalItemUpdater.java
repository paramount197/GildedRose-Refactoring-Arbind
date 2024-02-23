package com.gildedrose.inventory;

import static com.gildedrose.utils.constants.Misc.MIN_QUALITY;

/**
 * A class to update the quality of normal items.
 */
public class NormalItemUpdater extends ItemUpdater {

    /**
     * Updates the quality of the given item based on its sellIn value.
     *
     * @param item The item to update.
     */
    @Override
    public void updateQuality(Item item) {
        decreaseQuality(item);
        if (item.sellIn <= 0) {
            decreaseQuality(item);
        }
    }

    /**
     * Decreases the quality of the given item, if possible.
     *
     * @param item The item whose quality to decrease.
     */
    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}
