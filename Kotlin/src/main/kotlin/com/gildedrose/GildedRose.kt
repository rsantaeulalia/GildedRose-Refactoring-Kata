package com.gildedrose

import com.gildedrose.item.Item
import com.gildedrose.item.CustomizedItemFactory
import com.gildedrose.item.QualityValues


class GildedRose(var items: Array<Item>, var customizedItemFactory: CustomizedItemFactory) {

    private val LOWEST_QUALITY_VALUE_POSSIBLE = 0

    fun updateQuality() {
        items.forEach { item ->
            customizedItemFactory.customiseItem(item).updateState();
            if (hasReachedLowestQualityValue(item)) {
                item.quality = LOWEST_QUALITY_VALUE_POSSIBLE;
            } else if (hasReachedHighestQualityValue(item)) {
                item.quality = QualityValues.highestValuePossible(item);
            }
        }
    }

    private fun hasReachedLowestQualityValue(item: Item) = item.quality < LOWEST_QUALITY_VALUE_POSSIBLE
    private fun hasReachedHighestQualityValue(item: Item) = item.quality > QualityValues.highestValuePossible(item)
}

