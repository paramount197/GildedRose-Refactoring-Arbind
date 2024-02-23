package com.gildedrose;

import com.gildedrose.inventory.*;
import com.gildedrose.utils.constants.ItemNames;

public class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

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

    private void updateSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(ItemNames.SULFURAS);
    }
}


