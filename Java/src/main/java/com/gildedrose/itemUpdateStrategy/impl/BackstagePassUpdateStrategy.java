package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;

public class BackstagePassUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        // Decrease sell in
        item.sellIn -= 1;

        // Set quality to 0 if sell in is lower than 0 else increase if quality lower than 50
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.quality < 50) {
            // Increase quality
            item.quality += 1;

            // Increase quality by additional 1 if sell in lower than 11
            if (item.sellIn < 11) item.quality += 1;

            // Increase quality by additional 1 if sell in lower than 6
            if (item.sellIn < 6) item.quality += 1;
        }
    }

}
