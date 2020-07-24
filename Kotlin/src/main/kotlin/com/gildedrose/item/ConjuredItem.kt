package com.gildedrose.item

class ConjuredItem(private val item: Item) : StandardItem(item) {
    override fun decreasingValueOverZeroDaysToSell(): Int {
        return 2
    }
}