package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;

public class SulfurasUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        // No need to sell
        if (item.sellIn < 0) item.sellIn = 0;
    }

}
