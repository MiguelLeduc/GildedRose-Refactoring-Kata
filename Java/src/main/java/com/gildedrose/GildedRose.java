package com.gildedrose;

import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;
import com.gildedrose.itemUpdateStrategyFactory.ItemUpdateStrategyFactory;

class GildedRose {
    Item[] items;
    ItemUpdateStrategyFactory strategyFactory;

    // Constructor
    public GildedRose(Item[] items, ItemUpdateStrategyFactory strategyFactory) {
        this.items = items;
        this.strategyFactory = strategyFactory;
    }

    // Actions
    public void updateQuality() {
        for (Item item : items) {
            // Get update strategy for each item and apply it
            ItemUpdateStrategy strategy = strategyFactory.createStrategy(item);
            strategy.update(item);
        }
    }

}
