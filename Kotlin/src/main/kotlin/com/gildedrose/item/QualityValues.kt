package com.gildedrose.item

class QualityValues {
    companion object {
        fun highestValuePossible(item: Item): Int {
            return if (item.name == CustomizedItemFactory.SULFURAS) {
                80
            } else 50
        }
    }
}