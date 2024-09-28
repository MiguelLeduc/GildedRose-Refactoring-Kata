package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasUpdateStrategyTest {

    @Test
    void testSulfurasSellInCannotGoBelowZero() {
        // Init
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        ItemUpdateStrategy strategy = new SulfurasUpdateStrategy();

        // Update item
        strategy.update(item);

        assertEquals(0, item.sellIn);
    }

}
