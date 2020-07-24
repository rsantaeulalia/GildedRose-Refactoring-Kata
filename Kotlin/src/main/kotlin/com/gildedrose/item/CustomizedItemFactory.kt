package com.gildedrose.item


class CustomizedItemFactory(item: Item) {
    companion object {
        private val ITEM_TYPES_LIST: MutableMap<String, CustomizedItem> = mutableMapOf()
        val SULFURAS = "Sulfuras, Hand of Ragnaros"
        val BRIE = "Aged Brie"
        val BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert"
        val CONJURED_ITEM = "Conjured"
    }

    init {
        ITEM_TYPES_LIST[SULFURAS] = SulfurasItem()
        ITEM_TYPES_LIST[BRIE] = AgedBrie(item)
        ITEM_TYPES_LIST[BACKSTAGE_PASSES_ITEM] = BackstagePassesItem(item)
        ITEM_TYPES_LIST[CONJURED_ITEM] = ConjuredItem(item)
    }

    fun customiseItem(item: Item): CustomizedItem {
        if (isStandardItem(item)) {
            return StandardItem(item);
        }
        return ITEM_TYPES_LIST.getValue(item.name);
    }

    private fun isStandardItem(item: Item): Boolean {
        return !ITEM_TYPES_LIST.containsKey(item.name)
    }
}