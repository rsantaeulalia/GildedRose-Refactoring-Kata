package com.gildedrose

import com.gildedrose.item.CustomizedItemFactory
import com.gildedrose.item.Item
import org.junit.Assert.assertEquals
import org.junit.Test


class GildedRoseTest {
    @Test
    fun foo() {
        val app = newGildedRose("foo", 0, 0)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun standardItemDecreasesSellByDayNumberEachTime() {
        val app = newGildedRose("standard item", 0, 0)
        app.updateQuality()
        assertEquals(-1, itemSellByDayNumber(app))
    }

    @Test
    fun brieDecreasesSellByDayNumberEachTime() {
        val app = newGildedRose(CustomizedItemFactory.BRIE, 0, 0)
        app.updateQuality()
        assertEquals(-1, itemSellByDayNumber(app))
    }

    @Test
    fun backstagePassesItemDecreasesSellByDayNumberEachTime() {
        val app = newGildedRose(CustomizedItemFactory.BACKSTAGE_PASSES_ITEM, 0, 0)
        app.updateQuality()
        assertEquals(-1, itemSellByDayNumber(app))
    }

    @Test
    fun conjuredItemDecreasesSellByDayNumberEachTime() {
        val app = newGildedRose(CustomizedItemFactory.CONJURED_ITEM, 0, 0)
        app.updateQuality()
        assertEquals(-1, itemSellByDayNumber(app))
    }

    @Test
    fun brieIncreasesInQualityEachTime() {
        val app = newGildedRose(CustomizedItemFactory.BRIE, 1, 1)
        app.updateQuality()
        assertEquals(2, itemQualityValue(app))
    }

    @Test
    fun brieQualityCannotGoAboveFiftyWhenIncreasing() {
        val app = newGildedRose(CustomizedItemFactory.BRIE, 1, 49)
        app.updateQuality()
        app.updateQuality()
        assertEquals(50, itemQualityValue(app))
    }

    @Test
    fun backstagePassesItemDecreasesQualityByOneIfSellByDayMoreThanEleven() {
        val app = newGildedRose(CustomizedItemFactory.BACKSTAGE_PASSES_ITEM, 12, 1)
        app.updateQuality()
        assertEquals(2, itemQualityValue(app))
    }

    @Test
    fun backstagePassesItemDecreasesQualityByTwoIfSellByDayIsMoreThanSix() {
        val app = newGildedRose(CustomizedItemFactory.BACKSTAGE_PASSES_ITEM, 10, 1)
        app.updateQuality()
        assertEquals(3, itemQualityValue(app))
    }

    @Test
    fun backstagePassesItemDecreasesQualityByThreeIfSellByDayIsMoreThanZero() {
        val app = newGildedRose(CustomizedItemFactory.BACKSTAGE_PASSES_ITEM, 5, 1)
        app.updateQuality()
        assertEquals(4, itemQualityValue(app))
    }

    @Test
    fun backstagePassesItemQualityDropsToZeroIfSellByDayIsZeroOrLess() {
        val app = newGildedRose(CustomizedItemFactory.BACKSTAGE_PASSES_ITEM, 0, 50)
        app.updateQuality()
        assertEquals(0, itemQualityValue(app))
    }

    @Test
    fun backstagePassesItemQualityCannotGoAboveFiftyWhenIncreasing() {
        val app = newGildedRose(CustomizedItemFactory.BACKSTAGE_PASSES_ITEM, 5, 50)
        app.updateQuality()
        assertEquals(50, itemQualityValue(app))
    }

    @Test
    fun standardItemDecreasesQualityByOneIfSellByDayIsAboveZero() {
        val app = newGildedRose("foo", 2, 1)
        app.updateQuality()
        assertEquals(0, itemQualityValue(app))
    }

    @Test
    fun standardItemDecreasesQualityByTwoOnceSellByDayIsZeroOrLess() {
        val app = newGildedRose("foo", 0, 5)
        app.updateQuality()
        assertEquals(3, itemQualityValue(app))
    }

    @Test
    fun standardItemCannotHaveQualityBelowZero() {
        val app = newGildedRose("foo", 0, 0)
        app.updateQuality()
        assertEquals(0, itemQualityValue(app))
    }

    @Test
    fun sulfurasHasQualityEighty() {
        val app = newGildedRose(CustomizedItemFactory.SULFURAS, 1, 80)
        assertEquals(80, itemQualityValue(app))
    }

    @Test
    fun sulfurasItemDoesNotAlterValues() {
        val app = newGildedRose(CustomizedItemFactory.SULFURAS, 1, 80)
        app.updateQuality()
        assertEquals(80, itemQualityValue(app))
        assertEquals(1, itemSellByDayNumber(app))
    }

    @Test
    fun conjuredItemDecreasesQualityByTwoIfSellByDayIsAboveZero() {
        val app = newGildedRose(CustomizedItemFactory.CONJURED_ITEM, 2, 5)
        app.updateQuality()
        assertEquals(3, itemQualityValue(app))
    }

    @Test
    fun conjuredItemDecreasesQualityByFourOnceSellByDayIsZeroOrLess() {
        val app = newGildedRose(CustomizedItemFactory.CONJURED_ITEM, 0, 5)
        app.updateQuality()
        assertEquals(1, itemQualityValue(app))
    }

    @Test
    fun conjuredItemCannotHaveQualityBelowZero() {
        val app = newGildedRose(CustomizedItemFactory.CONJURED_ITEM, 0, 0)
        app.updateQuality()
        assertEquals(0, itemQualityValue(app))
    }

    private fun newGildedRose(itemName: String, itemSellIn: Int, itemQuality: Int): GildedRose {
        val items = arrayOf(Item(itemName, itemSellIn, itemQuality))
        return GildedRose(items)
    }

    private fun itemSellByDayNumber(app: GildedRose): Int {
        return app.items[0].sellIn
    }

    private fun itemQualityValue(app: GildedRose): Int {
        return app.items[0].quality
    }
}


