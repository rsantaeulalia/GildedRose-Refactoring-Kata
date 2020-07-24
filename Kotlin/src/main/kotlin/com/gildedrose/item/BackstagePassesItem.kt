package com.gildedrose.item

class BackstagePassesItem(private val item: Item) : CustomizedItem {
    override fun updateState() {
        decreaseSellByDayValueByOne();
        when {
            sellByDayValueIsOver(10) -> increaseQualityBy(1)
            sellByDayValueIsOver(5) -> increaseQualityBy(2)
            sellByDayValueIsOver(0) -> increaseQualityBy(3)
            else -> dropQualityToZero()
        }
    }

    private fun decreaseSellByDayValueByOne() {
        item.sellIn -= 1
    }

    private fun sellByDayValueIsOver(dayNumber: Int)= item.sellIn > dayNumber

    private fun increaseQualityBy(qualityValue: Int) {
        item.quality += qualityValue
    }

    private fun dropQualityToZero() {
        item.quality = 0
    }
}