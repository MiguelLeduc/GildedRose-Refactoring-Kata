package com.gildedrose.itemUpdateStrategy.impl;

import com.gildedrose.Item;
import com.gildedrose.itemUpdateStrategy.ItemUpdateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultItemUpdateStrategyTest {

    private Item item;
    private ItemUpdateStrategy strategy;

    @BeforeEach
    public void init() {
        item = new Item("Elixir of the Mongoose", 5, 7);
        strategy = new DefaultItemUpdateStrategy();
    }

    @Test
    public void testDefaultItemQualityCannotGoBelowZero() {
        // Set the quality to 0
        item.quality = 0;

        // Update the item
        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    public void testDefaultItemQualityDecreasesBy1BeforeSellIn() {
        // Update the item
        strategy.update(item);

        assertEquals(4, item.sellIn);
        assertEquals(6, item.quality);
    }

    @Test
    public void testDefaultItemQualityDecreasesBy2AfterSellIn() {
        // Set the sell in to 0
        item.sellIn = 0;

        // Update the item
        strategy.update(item);

        assertEquals(-1, item.sellIn);
        assertEquals(5, item.quality);
    }

}
