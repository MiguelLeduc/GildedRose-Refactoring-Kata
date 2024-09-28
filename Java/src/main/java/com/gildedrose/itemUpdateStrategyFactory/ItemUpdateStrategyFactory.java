package com.gildedrose.itemUpdateStrategyFactory;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;
import com.gildedrose.itemUpdateStrategy.impl.*;

public class ItemUpdateStrategyFactory {

    public ItemUpdateStrategy createStrategy(Item item) {
        if (item.name.equals("Aged Brie")) {
            return new AgedBrieUpdateStrategy();
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePassUpdateStrategy();
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new SulfurasUpdateStrategy();
        } else if (item.name.contains("Conjured")) {
            return new ConjuredItemUpdateStrategy();
        } else {
            return new DefaultItemUpdateStrategy();
        }
    }

}
