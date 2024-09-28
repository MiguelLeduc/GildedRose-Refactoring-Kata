package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;

public class DefaultItemUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        // Decrease sell in
        item.sellIn -= 1;

        // Decrease quality if quality is higher than 0
        if (item.quality > 0) item.quality -= 1;

        // Decrease quality by additional 1 if sell in is lower than 0 & quality is higher than 0
        if (item.sellIn < 0 && item.quality > 0) item.quality -= 1;
    }

}
