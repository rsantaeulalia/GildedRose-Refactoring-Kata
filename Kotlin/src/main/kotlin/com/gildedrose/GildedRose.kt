package com.gildedrose

import com.gildedrose.item.CustomizedItemFactory
import com.gildedrose.item.Item
import com.gildedrose.item.QualityValues


class GildedRose(var items: Array<Item>) {

    private val LOWEST_QUALITY_VALUE_POSSIBLE = 0
    
    fun updateQuality() {
        items.forEach { item ->
            customisedItem(item).updateState()
            if (hasReachedLowestQualityValue(item)) {
                item.quality = LOWEST_QUALITY_VALUE_POSSIBLE
            } else if (hasReachedHighestQualityValue(item)) {
                item.quality = QualityValues.highestValuePossible(item)
            }
        }
    }

    private fun customisedItem(item: Item) = CustomizedItemFactory(item).customiseItem(item)

    private fun hasReachedLowestQualityValue(item: Item) = item.quality < LOWEST_QUALITY_VALUE_POSSIBLE

    private fun hasReachedHighestQualityValue(item: Item) = item.quality > QualityValues.highestValuePossible(item)
}

