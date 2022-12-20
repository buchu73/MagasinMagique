package com.magasin;

import com.magasin.items.GenericItemToUpdate;

import java.io.File;

import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        List<String> classesName = getAllClassesName();
        int index=0;

        for(Item item : items){
            ItemToUpdate toUpdate = findClass(item, classesName);
            items[index] = toUpdate.updateItem();
            index++;
        }

//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Comte")
//                    && !items[i].name.equals("PassVipConcert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Kryptonite")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("PassVipConcert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Kryptonite")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Comte")) {
//                    if (!items[i].name.equals("PassVipConcert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Kryptonite")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
    }

    public ItemToUpdate findClass(Item item, List<String> classesName) {
        if (!classesName.contains(item.name)) {
            return new GenericItemToUpdate(item);
        }
        try {
            Class result = Class.forName("com.magasin.items." + item.name);
            return (ItemToUpdate) result.getConstructor(Item.class).newInstance(item);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<String> getAllClassesName(){
        List<String> classesName = new ArrayList<String>();
        File folder = new File("C:\\Users\\allan.le-lay\\IdeaProjects\\MagasinMagique\\src\\main\\java\\com\\magasin\\items");
        if (folder.exists() && folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                String test = file.getName().split("\\.")[0];
                classesName.add(test);
            }
        } else {
            System.out.println("Le dossier n'existe pas ou il s'agit d'un fichier");
        }
        return classesName;
    }
}
