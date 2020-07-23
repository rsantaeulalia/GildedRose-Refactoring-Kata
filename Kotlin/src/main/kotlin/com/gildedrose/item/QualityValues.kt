package com.gildedrose.item

class QualityValues {
    companion object {
        fun highestValuePossible(item: Item): Int {
            return if (item.name == "Sulfuras, Hand of Ragnaros") {
                80
            } else 50
        }
    }
}