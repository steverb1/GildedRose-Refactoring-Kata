package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] items;

    @Test
    void typicalItemsDecreaseInBothQualityAndSellIn() {
        Item item = new Item("foo", 2, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(1, item.sellIn, "sellin");
        assertEquals(1, item.quality, "quality");
    }

    @Test
    void qualityIsNeverNegative() {
        Item item = new Item("foo", 2, 0);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(1, item.sellIn, "sellin");
        assertEquals(0, item.quality, "quality");
    }

    @Test
    void qualityDegradesTwiceAsFastWhenSellInHasPassed() {
        Item item = new Item("foo", 0, 4);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(-1, item.sellIn);
        assertEquals(2, item.quality);
    }

    @Test
    void agedBrieQualityIncreases() {
        Item item = new Item("Aged Brie", 2, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", item.name);
        assertEquals(3, item.quality);
    }

    @Test
    void qualityNeverExceeds50() {
        Item item = new Item("Aged Brie", 2, 50);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, item.quality);
    }

    @Test
    void backstagePassesQualityIncreasesByThreeWithSellIn5OrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, item.quality);
    }

    @Test
    void backstagePassesQualityIncreasesByTwoWithSellIn10OrLess() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, item.quality);
    }

    @Test
    void sulfurasQualityAndSellInRemainTheSame() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 80);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void backstagePassesQualityIsZeroAfterSellIn() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void agedBrieQualityIncreasesDoubleAfterSellData() {
        Item item = new Item("Aged Brie", -1, 10);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, item.quality);
    }

    @Test
    void backstagePassesQualityIncreasesOnlyByOneWhenNotIminent() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 14, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, item.quality);
    }
}
