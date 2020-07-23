package com.gildedrose.item

class CustomizedItemFactory {
    companion object {
        val SULFURAS = "Sulfuras, Hand of Ragnaros"
        val BRIE = "Aged Brie"
        val BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert"
    }

    fun customiseItem(item: Item): CustomizedItem {
        return when (item.name) {
            SULFURAS -> {
                SulfurasItem(item)
            }
            BRIE -> {
                AgedBrie(item)
            }
            BACKSTAGE_PASSES_ITEM -> {
                BackstagePassesItem(item)
            }
            else -> {
                StandardItem(item)
            }
        }
    }
}