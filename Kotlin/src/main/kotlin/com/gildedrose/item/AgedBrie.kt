package com.gildedrose.item

class AgedBrie(private val item: Item) : CustomizedItem {
    override fun updateState() {
        decreaseQualityByOne()
        increaseQualityByOne()
    }

    private fun decreaseQualityByOne() {
        item.quality -= 1
    }

    private fun increaseQualityByOne() {
        item.sellIn += 1
    }
}