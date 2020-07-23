package com.gildedrose.item

class BackstagePassesItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateYourState() {
        sellIn -= 1;
        when {
            sellIn >= 11 -> {
                quality += 1;
            }
            sellIn > 5 -> {
                quality += 2;
            }
            sellIn > 0 -> {
                quality += 3;
            }
            else -> {
                quality = 0;
            }
        }
    }
}