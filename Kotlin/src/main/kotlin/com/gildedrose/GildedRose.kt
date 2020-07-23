package com.gildedrose

import com.gildedrose.item.Item
import com.gildedrose.item.ItemFactory


class GildedRose(var items: Array<Item>, var itemFactory: ItemFactory) {

    private val LOWEST_QUALITY_LEVEL_POSSIBLE = 0
    private val HIGHEST_QUALITY_LEVEL_POSSIBLE = 50

    fun updateQuality() {
        customizeItems()
        items.forEach { item ->
            item.updateYourState();
            if (hasReachedLowestQualityLimit(item.quality)) {
                item.quality = LOWEST_QUALITY_LEVEL_POSSIBLE;
            } else if (hasReachedHighestQualityLimit(item.quality)) {
                item.quality = HIGHEST_QUALITY_LEVEL_POSSIBLE;
            }
        }
    }

    private fun customizeItems() {
        for (item in items) {
            items = arrayOf(itemFactory.createItem(item.name, item.sellIn, item.quality))
        }
    }

    private fun hasReachedLowestQualityLimit(itemQuality: Int) = itemQuality < LOWEST_QUALITY_LEVEL_POSSIBLE
    private fun hasReachedHighestQualityLimit(itemQuality: Int) = itemQuality > HIGHEST_QUALITY_LEVEL_POSSIBLE
}

