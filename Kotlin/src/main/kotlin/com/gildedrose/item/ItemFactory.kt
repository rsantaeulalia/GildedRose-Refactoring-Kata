package com.gildedrose.item

class ItemFactory {
    fun customiseItem(item: Item): CustomizedItem {
        return when (item.name) {
            "Sulfuras, Hand of Ragnaros" -> {
                SulfurasItem(item)
            }
            "Aged Brie" -> {
                AgedBrie(item)
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                BackstagePassesItem(item)
            }
            else -> {
                StandardItem(item)
            }
        }
    }
}