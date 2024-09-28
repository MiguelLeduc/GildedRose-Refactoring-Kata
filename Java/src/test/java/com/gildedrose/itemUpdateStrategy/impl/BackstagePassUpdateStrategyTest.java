package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassUpdateStrategyTest {

    private Item item;
    private ItemUpdateStrategy strategy;

    @BeforeEach
    public void init() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        strategy = new BackstagePassUpdateStrategy();
    }

    @Test
    public void testBackStagePassQualityCannotExceed50() {
        // Set the quality to 50
        item.quality = 50;

        // Update the item
        strategy.update(item);

        assertEquals(14, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    public void testBackStagePassIncreasesBy1WhenSellingInGreaterThan10() {
        // Update the item
        strategy.update(item);

        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    public void testBackStagePassIncreasesBy2WhenSellIngLowerThan11() {
        // Set the sell in to 10
        item.sellIn = 10;

        // Update the item
        strategy.update(item);

        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    public void testBackStagePassIncreasesBy3WhenSellIngLowerThan6AndGreaterThanZero() {
        // Set the sell in to 5
        item.sellIn = 5;

        // Update the item
        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    public void testBackStagePassQualityDropsToZeroAfterConcert() {
        // Set the sell in to 0
        item.sellIn = 0;

        // Update the item
        strategy.update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
}
