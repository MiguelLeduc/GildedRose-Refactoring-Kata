package com.gildedrose;

import com.gildedrose.itemUpdateStrategyFactory.ItemUpdateStrategyFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        ItemUpdateStrategyFactory strategyFactory = new ItemUpdateStrategyFactory();
        GildedRose app = new GildedRose(items, strategyFactory);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
