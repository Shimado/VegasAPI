package com.github.Shimado.instances;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

public class ShopItem {

    private int slot = -1;
    private ItemStack item;
    private ItemStack itemToShow;
    private double purchasePrice = 0.0;
    private double sellingPrice = 0.0;


    public ShopItem(int slot, ItemStack item, ItemStack itemToShow, double purchasePrice, double sellingPrice){
        this.slot = slot;
        this.item = item;
        this.itemToShow = itemToShow;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }


    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }


    @Nullable
    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }


    @Nullable
    public ItemStack getItemToShow() {
        return itemToShow;
    }

    public void setItemToShow(ItemStack itemToShow) {
        this.itemToShow = itemToShow;
    }


    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
