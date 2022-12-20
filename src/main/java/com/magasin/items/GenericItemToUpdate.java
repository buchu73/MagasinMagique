package com.magasin.items;

import com.magasin.Item;
import com.magasin.ItemToUpdate;

public class GenericItemToUpdate extends Item implements ItemToUpdate {
    public GenericItemToUpdate(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public Item updateItem() {

        this.sellIn--;
        this.quality--;
        if (sellIn < 0) {
            this.quality--;
        }
        if(quality > 50){
            this.quality =50;
        }
        else if(quality < 0){
            this.quality =0;
        }
        return this;
    }

}
