package com.nhnacademy.servlet.demo;

import java.util.ArrayList;

public class BuyList {
    private final ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public static class Item {
        private final String name;

        private final int amount;
        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return this.name;
        }
        public int getAmount() {
            return this.amount;
        }
    }
}
