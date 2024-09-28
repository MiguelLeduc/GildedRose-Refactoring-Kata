package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;

public class AgedBrieUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        // Decrease sell in
        item.sellIn -= 1;

        // Increase the item quality if it's below 50
        if (item.quality < 50) item.quality += 1;

        // Increase the item quality again if the sell in is lower than 0 & quality is lower than 50
        if (item.sellIn < 0 && item.quality < 50) item.quality += 1;
    }

}
