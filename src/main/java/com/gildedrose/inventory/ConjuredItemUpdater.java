package com.gildedrose.inventory;

import static com.gildedrose.utils.constants.Misc.MIN_QUALITY;

/**
 * A class to update the quality of conjured items.
 */
public class ConjuredItemUpdater extends ItemUpdater {

    /**
     * Updates the quality of the given item based on its sellIn value.
     *
     * @param item The item to update.
     */
    @Override
    public void updateQuality(Item item) {
        decreaseQuality(item, 2);
        if (item.sellIn <= 0) {
            decreaseQuality(item, 2);
        }
    }

    /**
     * Decreases the quality of the given item by the specified decrement.
     *
     * @param item      The item whose quality to decrease.
     * @param decrement The amount by which to decrease the quality.
     */
    private void decreaseQuality(Item item, int decrement) {
        for (int i = 0; i < decrement; i++) {
            decreaseQuality(item);
        }
    }


    /**
     * Decreases the quality of the given item.
     *
     * @param item The item whose quality to decrease.
     */
    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}
