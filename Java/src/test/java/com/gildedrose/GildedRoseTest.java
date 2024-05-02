package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] items;

    @Test
    void qualityRemains0_WhenStartsAt0() {
        Item item = new Item("foo", 0, 0);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(-1, item.sellIn, "sellin");
        assertEquals(0, item.quality, "quality");
    }

    @Test
    void sellinDecreasesBy1_WhenStartsAt2() {
        Item item = new Item("foo", 2, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(1, item.sellIn);
    }

    @Test
    void qualityDecreasesBy1_WhenStartsAt2() {
        Item item = new Item("foo", 2, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", item.name);
        assertEquals(1, item.quality);
    }

    @Test
    void agedBrie_QualityIncreases() {
        Item item = new Item("Aged Brie", 2, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", item.name);
        assertEquals(3, item.quality);
    }

    @Test
    void agedBrieQuality50_QualityRemainsSame() {
        Item item = new Item("Aged Brie", 2, 50);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, item.quality);
    }

    @Test
    void backstagePassesAndSellin2AndQuality2_QualityBecomes5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, item.quality);
    }

    @Test
    void sulfurasAndNegativeSellin_QualityStaysSame() {
        Item item = new Item("foo", -1, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void backstagePassesAndNegativeSellIn_QualityIsZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void agedBrieQualityLessThan50_QualityIs11() {
        Item item = new Item("Aged Brie", -1, 10);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, item.quality);
    }

    @Test
    void backstagePassesAndxxx() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, item.quality);
    }

    @Test
    void sulfurasAndxxx() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 7, 2);
        items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, item.quality);
    }
}
