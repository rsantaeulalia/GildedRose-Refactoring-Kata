package com.gildedrose.item

class AgedBrie(private val item: Item) : CustomizedItem {
    override fun updateState() {
        decreaseSellByDayValueByOne()
        increaseQualityByOne()
    }

    private fun decreaseSellByDayValueByOne() {
        item.sellIn -= 1
    }

    private fun increaseQualityByOne() {
        item.quality += 1
    }
}