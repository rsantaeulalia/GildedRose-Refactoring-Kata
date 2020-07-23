package com.gildedrose.item

class BackstagePassesItem(val item: Item) : CustomizedItem {
    override fun updateState() {
        item.sellIn -= 1;
        when {
            item.sellIn >= 11 -> {
                item.quality += 1;
            }
            item.sellIn > 5 -> {
                item.quality += 2;
            }
            item.sellIn > 0 -> {
                item.quality += 3;
            }
            else -> {
                item.quality = 0;
            }
        }
    }
}