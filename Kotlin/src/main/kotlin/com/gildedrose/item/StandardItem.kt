package com.gildedrose.item

open class StandardItem(private val item: Item) : CustomizedItem {
    override fun updateState() {
        decreaseSellByDayValueByOne();
        if (sellByDayValueIsOverZero()) {
            decreaseQualityBy(decreasingValueOverZeroDaysToSell());
        } else {
            decreaseQualityBy(decreasingValueForZeroOrLessDaysToSell());
        }
    }

    private fun decreaseSellByDayValueByOne() {
        item.sellIn -= 1
    }

    private fun sellByDayValueIsOverZero() = item.sellIn > 0

    private fun decreaseQualityBy(qualityValue: Int) {
        item.quality -= qualityValue
    }

    open fun decreasingValueOverZeroDaysToSell(): Int = 1

    private fun decreasingValueForZeroOrLessDaysToSell(): Int {
        return decreasingValueOverZeroDaysToSell() * 2
    }
}