package com.github.Shimado.instances;

import com.github.Shimado.enums.TableAnimationType;
import org.bukkit.inventory.ItemStack;
import org.shimado.basicutils.BasicUtils;
import org.shimado.basicutils.utils.MaterialUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CasinoTableItem {

    private String id;
    private ItemStack tableItem;
    private int customModelData = 0;
    private String game = "ALL";
    private double yOffset = 0.0;
    private ItemStack carpet;
    private ItemStack concrete;
    private ItemStack glass;
    private TableAnimation tableAnimation;

    public CasinoTableItem(String id, ItemStack tableItem){
        this.id = id;
        this.tableItem = BasicUtils.getVersionControl().getVersionControl().createItemWithTag(tableItem, "VegasTables", id);
    }


    @Nullable
    public String getID(){
        return id;
    }


    @Nullable
    public ItemStack getTableItem(){
        return tableItem;
    }

    public CasinoTableItem setTableItem(ItemStack tableItem){
        this.tableItem = BasicUtils.getVersionControl().getVersionControl().createItemWithTag(tableItem, "VegasTables", this.id);
        return this;
    }


    public int getCustomModelData(){
        return customModelData;
    }

    public CasinoTableItem setCustomModelData(int customModelData){
        this.customModelData = customModelData;
        return this;
    }


    @Nullable
    public String getGame(){
        return game;
    }

    public CasinoTableItem setGame(String game){
        this.game = game;
        return this;
    }


    public double getYOffset(){
        return yOffset;
    }

    public CasinoTableItem setYOffset(double yOffset){
        this.yOffset = yOffset;
        return this;
    }


    @Nullable
    public ItemStack getCarpet(){
        return carpet;
    }

    public CasinoTableItem setCarpet(ItemStack carpet){
        this.carpet = carpet;
        return this;
    }


    @Nullable
    public ItemStack getConcrete(){
        return concrete;
    }

    public CasinoTableItem setConcrete(ItemStack concrete){
        this.concrete = concrete;
        return this;
    }


    @Nullable
    public ItemStack getGlass(){
        return glass;
    }

    public CasinoTableItem setGlass(ItemStack glass){
        this.glass = glass;
        return this;
    }


    @Nullable
    public TableAnimation getTableAnimation(){
        return tableAnimation;
    }

    public CasinoTableItem setTableAnimation(TableAnimationType tableAnimationType, List<ItemStack> itemsToDrop, double spawnChance, int itemsAmount){
        this.tableAnimation = new TableAnimation(tableAnimationType, itemsToDrop, spawnChance, itemsAmount);
        return this;
    }

    public CasinoTableItem setTableAnimation(String tableAnimationTypeString, List<String> itemsToDropString, double spawnChance, int itemsAmount){
        this.tableAnimation = new TableAnimation(tableAnimationTypeString, itemsToDropString, spawnChance, itemsAmount);
        return this;
    }


    public class TableAnimation{

        private TableAnimationType tableAnimationType;
        private List<ItemStack> itemsToDrop = new ArrayList<>();
        private double dropSpawnChance = 0.0;
        private int itemsAmount = 0;

        public TableAnimation(TableAnimationType tableAnimationType, List<ItemStack> itemsToDrop, double dropSpawnChance, int itemsAmount){
            this.tableAnimationType = tableAnimationType;
            this.itemsToDrop = itemsToDrop;
            this.dropSpawnChance = dropSpawnChance;
            this.itemsAmount = itemsAmount;
        }

        public TableAnimation(String tableAnimationTypeString, List<String> itemsToDropString, double dropSpawnChance, int itemsAmount){
            try{
                this.tableAnimationType = TableAnimationType.valueOf(tableAnimationTypeString);
            }catch (Exception ex){
                return;
            }
            this.itemsToDrop = itemsToDropString.stream()
                    .map(it -> MaterialUtil.getItemByName(it))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            this.dropSpawnChance = dropSpawnChance;
            this.itemsAmount = itemsAmount;
        }


        @Nullable
        public TableAnimationType getTableAnimationType(){
            return tableAnimationType;
        }

        public void setTableAnimationType(TableAnimationType tableAnimationType){
            this.tableAnimationType = tableAnimationType;
        }


        @Nonnull
        public List<ItemStack> getItemsToDrop(){
            return itemsToDrop;
        }

        public void setItemsToDrop(List<ItemStack> itemsToDrop){
            this.itemsToDrop = itemsToDrop;
        }


        public double getDropSpawnChance() {
            return dropSpawnChance;
        }

        public void setDropSpawnChance(double dropSpawnChance) {
            this.dropSpawnChance = dropSpawnChance;
        }


        public int getItemsAmount() {
            return itemsAmount;
        }

        public void setItemsAmount(int itemsAmount) {
            this.itemsAmount = itemsAmount;
        }
    }

}
