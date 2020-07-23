package com.gildedrose.item

class AgedBrie(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateYourState() {
        sellIn -= 1
        quality += 1
    }
}