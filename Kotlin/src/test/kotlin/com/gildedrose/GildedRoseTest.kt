package com.gildedrose

import com.gildedrose.item.Item
import com.gildedrose.item.ItemFactory
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
        val app = newGildedRose("Aged Brie", 0, 0)
        app.updateQuality()
        assertEquals(-1, itemSellByDayNumber(app))
    }

    @Test
    fun backstagePassesItemDecreasesSellByDayNumberEachTime() {
        val app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 0)
        app.updateQuality()
        assertEquals(-1, itemSellByDayNumber(app))
    }

    @Test
    fun sulfurasItemDoesNotDecreaseSellByDayNumberEachTime() {
        val app = newGildedRose("Sulfuras, Hand of Ragnaros", 0, 0)
        app.updateQuality()
        assertEquals(0, itemSellByDayNumber(app))
    }

    @Test
    fun brieIncreasesInQualityEachTime() {
        val app = newGildedRose("Aged Brie", 1, 1)
        app.updateQuality()
        assertEquals(2, itemQualityNumber(app))
    }

    @Test
    fun brieQualityCannotGoAboveFiftyWhenIncreasing() {
        val app = newGildedRose("Aged Brie", 1, 49)
        app.updateQuality()
        app.updateQuality()
        assertEquals(50, itemQualityNumber(app))
    }

    @Test
    fun backstagePassesItemDecreasesQualityByOneIfSellByDayMoreThanEleven() {
        val app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 12, 1)
        app.updateQuality()
        assertEquals(2, itemQualityNumber(app))
    }

    @Test
    fun backstagePassesItemDecreasesQualityByTwoIfSellByDayLessThanEleven() {
        val app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 1)
        app.updateQuality()
        assertEquals(3, itemQualityNumber(app))
    }

    @Test
    fun backstagePassesItemDecreasesQualityByThreeIfSellByDayLessThanSix() {
        val app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 1)
        app.updateQuality()
        assertEquals(4, itemQualityNumber(app))
    }

    @Test
    fun backstagePassesItemQualityDropsToZeroIfSellByDayHasPassed() {
        val app = newGildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 50)
        app.updateQuality()
        assertEquals(0, itemQualityNumber(app))
    }

    @Test
    fun normalItemDecreasesQualityByOneIfSellByDayIsAboveZero() {
        val app = newGildedRose("foo", 2, 1)
        app.updateQuality()
        assertEquals(0, itemQualityNumber(app))
    }

    @Test
    fun normalItemDecreasesQualityByTwoOnceSellByDayHasPassed() {
        val app = newGildedRose("foo", 0, 5)
        app.updateQuality()
        assertEquals(3, itemQualityNumber(app))
    }

    @Test
    fun normalItemCannotHaveQualityBelowZero() {
        val app = newGildedRose("foo", 0, 0)
        app.updateQuality()
        assertEquals(0, itemQualityNumber(app))
    }

    @Test
    fun nothingHappensToSulfurasItem() {
        val app = newGildedRose("Sulfuras, Hand of Ragnaros", 1, 1)
        app.updateQuality()
        assertEquals(1, itemQualityNumber(app))
        assertEquals(1, itemSellByDayNumber(app))
    }

    private fun newGildedRose(itemName: String, itemSellIn: Int, itemQuality: Int): GildedRose {
        val items = arrayOf(Item(itemName, itemSellIn, itemQuality))
        return GildedRose(items, ItemFactory())
    }

    private fun itemSellByDayNumber(app: GildedRose): Int {
        return app.items[0].sellIn
    }

    private fun itemQualityNumber(app: GildedRose): Int {
        return app.items[0].quality
    }
}


