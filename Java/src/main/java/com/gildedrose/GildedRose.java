package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    final int MAX_QUALITY = 50;
    final String AGED_BRIE = "Aged Brie";
    final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    List<String> specialItems = new ArrayList<String>(){{
        add(AGED_BRIE);
        add(BACKSTAGE_PASSES);
        add(SULFURAS);
    }};

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (specialItems.contains(items[i].name)) {
                if (items[i].quality < MAX_QUALITY) {
                    items[i].quality = items[i].quality + 1;

                    handleIminentBackstagePasses(i);
                }
            } else {
                decreaseQuality(i);
            }

            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
               // if (!specialItems.contains(items[i].name)) {
                if (items[i].name.equals(AGED_BRIE)) {
                    increaseQuality(i);
                } else {
                    if (!items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (!items[i].name.equals(SULFURAS)) {
                            decreaseQuality(i);
                        }
                    } else {
                        items[i].quality = 0;
                    }
                }
            }
        }
    }

    private void handleIminentBackstagePasses(int i) {
        if (items[i].name.equals(BACKSTAGE_PASSES)) {
            if (items[i].sellIn < 11) {
                increaseQuality(i);
            }

            if (items[i].sellIn < 6) {
                increaseQuality(i);
            }
        }
    }

    private void decreaseQuality(int i) {
        if (items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
        }
    }

    private void increaseQuality(int i) {
        if (items[i].quality < MAX_QUALITY) {
            items[i].quality = items[i].quality + 1;
        }
    }
}
