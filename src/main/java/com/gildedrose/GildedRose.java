package com.gildedrose;

import com.gildedrose.inventory.*;
import com.gildedrose.utils.constants.ItemNames;

/**
 * Class to manage the inventory of the Gilded Rose shop.
 */
public class GildedRose {
    private final Item[] items;

    /**
     * Constructs a new GildedRose object with the given array of items.
     *
     * @param items The array of items to manage.
     */
    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Updates the quality and sellIn values of all items in the inventory.
     */
    public void updateItem() {
        for (Item item : items) {
            if (item.name.equals(ItemNames.SULFURAS)) {
                continue;
            }
            ItemUpdater updater = getItemUpdater(item);
            updater.updateQuality(item);
            updateSellIn(item);
        }
    }

    /**
     * Returns the appropriate ItemUpdater for the given item.
     *
     * @param item The item to get the updater for.
     * @return The ItemUpdater for the item.
     */
    private ItemUpdater getItemUpdater(Item item) {
        if (item.name.equals(ItemNames.AGED_BRIE)) {
            return new AgedBrieUpdater();
        } else if (item.name.equals(ItemNames.BACKSTAGE_PASSES)) {
            return new BackstagePassesUpdater();
        } else if (item.name.equals(ItemNames.CONJURED)) {
            return new ConjuredItemUpdater();
        } else{
            return new NormalItemUpdater();
        }
    }

    /**
     * Updates the sellIn value of the given item, except for Sulfuras items.
     *
     * @param item The item whose sellIn value to update.
     */
    private void updateSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn--;
        }
    }

    /**
     * Checks if the given item is of type Sulfuras.
     *
     * @param item The item to check.
     * @return True if the item is of type Sulfuras, false otherwise.
     */
    private boolean isSulfuras(Item item) {
        return item.name.equals(ItemNames.SULFURAS);
    }
}


