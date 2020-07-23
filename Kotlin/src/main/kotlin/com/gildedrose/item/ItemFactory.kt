package com.gildedrose.item

class ItemFactory {
    fun createItem(itemName: String, sellIn: Int, quality: Int): Item {
        return when (itemName) {
            "Sulfuras, Hand of Ragnaros" -> {
                SulfurasItem(itemName, sellIn, quality)
            }
            "Aged Brie" -> {
                AgedBrie(itemName, sellIn, quality)
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                BackstagePassesItem(itemName, sellIn, quality)
            }
            else -> {
                StandardItem(itemName, sellIn, quality)
            }
        }
    }
}