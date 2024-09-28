package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;

public class ConjuredItemUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        // Decrease sell in
        item.sellIn -= 1;

        // Decrease quality twice as fast (2 a day), if quality is higher than 0
        if (item.quality > 0) item.quality -= 2;

        // Decrease quality by additional 2 if sell in is lower than 0 & quality is higher than 0
        if (item.sellIn < 0 && item.quality > 0) item.quality -= 2;

        // Set quality to 0 if quality is lower than 0
        if (item.quality < 0) item.quality = 0;
    }

}
