package com.gildedrose.item

class ConjuredItem(val item: Item) : CustomizedItem {
    override fun updateState() {
        item.sellIn -= 1
        if (item.sellIn > 0) {
            item.quality -= 2
        } else {
            item.quality -= 4
        }
    }
}