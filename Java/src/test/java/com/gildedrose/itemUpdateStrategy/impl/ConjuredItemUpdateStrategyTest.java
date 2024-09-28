package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredItemUpdateStrategyTest {

    private Item item;
    private ItemUpdateStrategy strategy;

    @BeforeEach
    public void init() {
        item = new Item("Conjured Mana Cake", 10, 20);
        strategy = new ConjuredItemUpdateStrategy();
    }

    @Test
    public void testConjuredItemQualityCannotGoBelowZero() {
        // Set the quality to 1
        item.quality = 1;

        // Update the item (-2 quality for conjured items)
        strategy.update(item);

        assertEquals(0, item.quality);
    }

    @Test
    public void testConjuredItemDecreasesQualityTwiceAsFastBeforeSellIn() {
        // Update the item
        strategy.update(item);

        assertEquals(9, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    public void testConjuredItemDecreasesQualityFourTimesAsFastAfterSellIn() {
        // Set the sell in to -1
        item.sellIn = -1;

        // Update the item
        strategy.update(item);

        assertEquals(-2, item.sellIn);
        assertEquals(16, item.quality);
    }

}
