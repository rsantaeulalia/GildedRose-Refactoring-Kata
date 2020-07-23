package com.gildedrose.item

class AgedBrie(val item: Item) : CustomizedItem {
    override fun updateState() {
        item.sellIn -= 1;
        item.quality += 1;
    }
}