package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieUpdateStrategyTest {

    private Item item;
    private ItemUpdateStrategy strategy;

    @BeforeEach
    public void init() {
        item = new Item("Aged Brie", 5, 10);
        strategy = new AgedBrieUpdateStrategy();
    }

    @Test
    public void testAgedBrieQualityCannotExceed50() {
        // Set the quality to 50
        item.quality = 50;

        // Update the item
        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void testAgedBrieIncreaseQualityBeforeSellIn() {
        // Update the item
        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    public void testAgedBrieIncreaseQualityAfterSellIn() {
        // Set the sell in to -1
        item.sellIn = -1;

        // Update the item
        strategy.update(item);

        assertEquals(-2, item.sellIn);
        assertEquals(12, item.quality);
    }
}
