package com.magasin.items;

import com.magasin.Item;
import com.magasin.ItemToUpdate;

public class Kryptonite extends Item implements ItemToUpdate {

    public Kryptonite(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public Item updateItem() {
        return this;
    }
}
