package com.gildedrose.item

class StandardItem(val item: Item) : CustomizedItem {
    override fun updateState() {
        item.sellIn -= 1;
        if (item.sellIn > 0) {
            item.quality -= 1;
        } else {
            item.quality -= 2;
        }
    }
}