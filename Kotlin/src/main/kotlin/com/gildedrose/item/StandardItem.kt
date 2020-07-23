package com.gildedrose.item

class StandardItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateYourState() {
        sellIn -= 1
        quality -= if (sellIn > 0) {
            1
        } else {
            2
        }
    }
}