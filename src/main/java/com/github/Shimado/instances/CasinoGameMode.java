package com.github.Shimado.instances;

import com.github.Shimado.interfaces.IBoomboxSong;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a casino game mode configuration.
 * Includes GUI settings, jackpot/victory/bonus/defeat behavior,
 * commands to execute, HTTP requests, betting restrictions, and music settings.
 */

public class CasinoGameMode {

    private String modeName;                                                 // For usage in commands/placeholders/code and etc
    private int guiSize = 6;                                                 // The size of the GUI (lines)
    private String guiTitle = "";                                            // Title of the GUI
    private String permission = "";                                          // The permission to open the game mode
    private List<Integer> slotInGUI = new ArrayList<>();                     // Slots occupied by the icon in the main GUI
    private List<Integer> slotInOneGameGUI = new ArrayList<>();              // Slots occupied by an icon in the main GUI for one game
    private ItemStack iconItem;                                              // The icon in the main GUI

    private double jackpotChance = 0.0;                                      // Chance to hit the jackpot if you win
    private double jackpotBoost = 1.0;                                       // Jackpot Payout Boost
    private double chargedPercentage = 0.0;                                  // Percentage of the bet that goes to the jackpot
    private boolean sendJackpotMessage = true;                               // Sends jackpot message to the player
    private boolean sendJackpotMessageToAll = false;                         // Sends jackpot message to all players
    private boolean sendJackpotMessageToDiscord = false;                     // Sends jackpot message to Discord
    private boolean useOnlyJackpotCommands = false;                          // Whether only commands will be executed
    private List<String> jackpotCommandsToDispatch = new ArrayList<>();      // Commands executed when player hits jackpot [Placeholders: %player%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpJackpotURL;                                           // URL to be processed
    private String httpJackpotMethod = "POST";                               // Request method
    private Map<String, Object> httpJackpotHeaders = new HashMap<>();        // Request headers
    private IBoomboxSong jackpotMusic;                                       // Music in .nbs format from Boombox plugin

    private boolean spawnVictoryFireWorks = false;                           // Whether to spawn fireworks on victory
    private boolean sendVictoryMessage = false;                              // Sends victory message to the winning player
    private boolean sendVictoryMessageToAll = false;                         // Sends victory message to all players
    private boolean sendVictoryMessageToDiscord = false;                     // Sends victory message to Discord
    private boolean useOnlyVictoryCommands = false;                          // Whether only commands will be executed
    private List<String> victoryCommandsToDispatch = new ArrayList<>();      // Commands executed when player wins [Placeholders: %player%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpVictoryURL;                                           // URL to be processed
    private String httpVictoryMethod = "POST";                               // Request method
    private Map<String, Object> httpVictoryHeaders = new HashMap<>();        // Request headers
    private IBoomboxSong victoryMusic;                                       // Music in .nbs format from Boombox plugin

    private boolean useOnlyBonusCommands = false;                            // Whether only commands will be executed
    private List<String> bonusCommandsToDispatch = new ArrayList<>();        // Commands executed when player wins [Placeholders: %player%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpBonusURL;                                             // URL to be processed
    private String httpBonusMethod = "POST";                                 // Request method
    private Map<String, Object> httpBonusHeaders = new HashMap<>();          // Request headers
    private IBoomboxSong bonusMusic;                                         // Music in .nbs format from Boombox plugin

    private boolean sendDefeatMessage = false;                               // Sends defeat message to the losing player
    private boolean sendDefeatMessageToAll = false;                          // Sends defeat message to all players
    private boolean sendDefeatMessageToDiscord = false;                      // Sends defeat message to Discord
    private List<String> defeatCommandsToDispatch = new ArrayList<>();       // Commands executed when player loses [Placeholders: %player%, %bet_price%, %bet_price_rounded%]
    private String httpDefeatURL;                                            // URL to be processed
    private String httpDefeatMethod = "POST";                                // Request method
    private Map<String, Object> httpDefeatHeaders = new HashMap<>();         // Request headers
    private IBoomboxSong defeatMusic;                                        // Music in .nbs format from Boombox plugin

    private double minBetPrice = 0.01;                                       // Minimum bet amount in currency
    private int minBetPriceInItems = 1;                                      // Minimum number of items a player can bet
    private double maxBetPrice = 10000000.0;                                 // Maximum bet amount in currency
    private int maxBetPriceInItems = 64;                                     // Maximum number of items a player can bet
    private double maxDiffBetweenBets = 100.0;                               // Maximum difference between bets, if exceeded, betting is not allowed

    private List<Integer> moneyBetSlots = new ArrayList<>();                 // Money bet slots
    private ItemStack moneyBetItem;                                          // Bet change button
    private String moneyBetItemTitle;                                        // Bet change button title
    private List<String> moneyBetItemLore = new ArrayList<>();               // Bet change button lore
    private double moneyBetDefault = 1000.0;                                 // Default bet amount
    private double moneyBetChangePerClick = 1000.0;                          // Bet change amount per click
    private double moneyBetChangePerClickBig = 10000.0;                      // Bet change amount per big click

    private List<Integer> spotSlots = new ArrayList<>();                     // Betting spots
    private ItemStack spotItem;                                              // Betting spot icon

    private List<Integer> leverSlots = new ArrayList<>();                    // Control lever slots
    private ItemStack leverItemInactive;                                     // Inactive lever (when no bet is placed)
    private ItemStack leverItemActive;                                       // Active lever (when player has placed a bet)
    private ItemStack leverItemRolling;                                      // Rolling lever (when player has placed a bet and started the game)

    private IBoomboxSong backgroundMusic;                                    // Background music in .nbs format from Boombox plugin
    private List<Integer> musicButtonSlots = new ArrayList<>();              // Slot occupied by the button
    private ItemStack musicButtonItemInactive;                               // Background music button (inactive)
    private ItemStack musicButtonItemActive;                                 // Background music button (active)
    private String musicButtonItemActiveTitle;                               // Active background button title
    private List<Integer> statsButtonSlots = new ArrayList<>();              // This game mode statistics slots
    private ItemStack statsButtonItem;                                       // This game mode statistics item
    private List<String> statsButtonLore = new ArrayList<>();                // This game mode statistics item lore with all placeholders
    private Map<Integer, ItemStack> emptySlots = new HashMap<>();            // Background slot items


    public CasinoGameMode(@Nonnull String modeName){
        this.modeName = modeName;
    }


    @Nonnull
    public String getModeName(){
        return this.modeName;
    }


    @Nonnull
    public String getGuiTitle(){
        return this.guiTitle;
    }

    public CasinoGameMode setGuiTitle(@Nonnull String guiTitle){
        if(guiTitle == null) return this;
        this.guiTitle = guiTitle;
        return this;
    }


    public int getGuiSize(){
        return this.guiSize;
    }

    public CasinoGameMode setGuiSize(int guiSize){
        this.guiSize = guiSize;
        return this;
    }


    @Nonnull
    public String getPermission(){
        return this.permission;
    }

    public CasinoGameMode setPermission(@Nonnull String permission){
        if(permission == null) return this;
        this.permission = permission;
        return this;
    }


    @Nonnull
    public List<Integer> getSlotInGUI() {
        return slotInGUI;
    }

    public CasinoGameMode setSlotInGUI(@Nonnull List<Integer> slotInGUI) {
        if(slotInGUI == null) return this;
        this.slotInGUI = slotInGUI;
        return this;
    }


    @Nonnull
    public List<Integer> getSlotInOneGameGUI() {
        return slotInOneGameGUI;
    }

    public CasinoGameMode setSlotInOneGameGUI(@Nonnull List<Integer> slotInOneGameGUI) {
        if(slotInOneGameGUI == null) return this;
        this.slotInOneGameGUI = slotInOneGameGUI;
        return this;
    }


    @Nullable
    public ItemStack getIconItem() {
        return iconItem;
    }

    public CasinoGameMode setIconItem(@Nullable ItemStack iconItem) {
        this.iconItem = iconItem;
        return this;
    }


    public double getJackpotChance() {
        return jackpotChance;
    }

    public CasinoGameMode setJackpotChance(double jackpotChance) {
        this.jackpotChance = jackpotChance;
        return this;
    }


    public double getJackpotBoost() {
        return jackpotBoost;
    }

    public CasinoGameMode setJackpotBoost(double jackpotBoost) {
        this.jackpotBoost = jackpotBoost;
        return this;
    }


    public double getChargedPercentage() {
        return chargedPercentage;
    }

    public CasinoGameMode setChargedPercentage(double chargedPercentage) {
        this.chargedPercentage = chargedPercentage;
        return this;
    }


    public boolean isSendJackpotMessage() {
        return sendJackpotMessage;
    }

    public CasinoGameMode setSendJackpotMessage(boolean sendJackpotMessage) {
        this.sendJackpotMessage = sendJackpotMessage;
        return this;
    }


    public boolean isSendJackpotMessageToAll() {
        return sendJackpotMessageToAll;
    }

    public CasinoGameMode setSendJackpotMessageToAll(boolean sendJackpotMessageToAll) {
        this.sendJackpotMessageToAll = sendJackpotMessageToAll;
        return this;
    }


    public boolean isSendJackpotMessageToDiscord() {
        return sendJackpotMessageToDiscord;
    }

    public CasinoGameMode setSendJackpotMessageToDiscord(boolean sendJackpotMessageToDiscord) {
        this.sendJackpotMessageToDiscord = sendJackpotMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyJackpotCommands(){
        return useOnlyJackpotCommands;
    }

    public CasinoGameMode setUseOnlyJackpotCommands(boolean useOnlyJackpotCommands){
        this.useOnlyJackpotCommands = useOnlyJackpotCommands;
        return this;
    }


    @Nonnull
    public List<String> getJackpotCommandsToDispatch() {
        return jackpotCommandsToDispatch;
    }

    public CasinoGameMode setJackpotCommandsToDispatch(@Nonnull List<String> jackpotCommandsToDispatch) {
        if(jackpotCommandsToDispatch == null) return this;
        this.jackpotCommandsToDispatch = jackpotCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpJackpotURL() {
        return httpJackpotURL;
    }

    public CasinoGameMode setHttpJackpotURL(@Nullable String httpJackpotURL) {
        this.httpJackpotURL = httpJackpotURL;
        return this;
    }


    @Nullable
    public String getHttpJackpotMethod() {
        return httpJackpotMethod;
    }

    public CasinoGameMode setHttpJackpotMethod(@Nullable String httpJackpotMethod) {
        this.httpJackpotMethod = httpJackpotMethod;
        return this;
    }


    @Nonnull
    public Map<String, Object> getHttpJackpotHeaders() {
        return httpJackpotHeaders;
    }

    public CasinoGameMode setHttpJackpotHeaders(@Nonnull Map<String, Object> httpJackpotHeaders) {
        if(httpJackpotHeaders == null) return this;
        this.httpJackpotHeaders = httpJackpotHeaders;
        return this;
    }


    @Nullable
    public IBoomboxSong getJackpotMusic() {
        return jackpotMusic;
    }

    public CasinoGameMode setJackpotMusic(@Nullable IBoomboxSong jackpotMusic) {
        this.jackpotMusic = jackpotMusic;
        return this;
    }


    public boolean isSpawnVictoryFireWorks() {
        return spawnVictoryFireWorks;
    }

    public CasinoGameMode setSpawnVictoryFireWorks(boolean spawnVictoryFireWorks) {
        this.spawnVictoryFireWorks = spawnVictoryFireWorks;
        return this;
    }


    public boolean isSendVictoryMessage() {
        return sendVictoryMessage;
    }

    public CasinoGameMode setSendVictoryMessage(boolean sendVictoryMessage) {
        this.sendVictoryMessage = sendVictoryMessage;
        return this;
    }


    public boolean isSendVictoryMessageToAll() {
        return sendVictoryMessageToAll;
    }

    public CasinoGameMode setSendVictoryMessageToAll(boolean sendVictoryMessageToAll) {
        this.sendVictoryMessageToAll = sendVictoryMessageToAll;
        return this;
    }


    public boolean isSendVictoryMessageToDiscord() {
        return sendVictoryMessageToDiscord;
    }

    public CasinoGameMode setSendVictoryMessageToDiscord(boolean sendVictoryMessageToDiscord) {
        this.sendVictoryMessageToDiscord = sendVictoryMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyVictoryCommands(){
        return useOnlyVictoryCommands;
    }

    public CasinoGameMode setUseOnlyVictoryCommands(boolean useOnlyVictoryCommands){
        this.useOnlyVictoryCommands = useOnlyVictoryCommands;
        return this;
    }


    @Nonnull
    public List<String> getVictoryCommandsToDispatch() {
        return victoryCommandsToDispatch;
    }

    public CasinoGameMode setVictoryCommandsToDispatch(@Nonnull List<String> victoryCommandsToDispatch) {
        if(victoryCommandsToDispatch == null) return this;
        this.victoryCommandsToDispatch = victoryCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpVictoryURL() {
        return httpVictoryURL;
    }

    public CasinoGameMode setHttpVictoryURL(@Nullable String httpVictoryURL) {
        this.httpVictoryURL = httpVictoryURL;
        return this;
    }


    @Nullable
    public String getHttpVictoryMethod() {
        return httpVictoryMethod;
    }

    public CasinoGameMode setHttpVictoryMethod(@Nullable String httpVictoryMethod) {
        this.httpVictoryMethod = httpVictoryMethod;
        return this;
    }


    @Nonnull
    public Map<String, Object> getHttpVictoryHeaders() {
        return httpVictoryHeaders;
    }

    public CasinoGameMode setHttpVictoryHeaders(@Nonnull Map<String, Object> httpVictoryHeaders) {
        if(httpVictoryHeaders == null) return this;
        this.httpVictoryHeaders = httpVictoryHeaders;
        return this;
    }


    @Nullable
    public IBoomboxSong getVictoryMusic() {
        return victoryMusic;
    }

    public CasinoGameMode setVictoryMusic(@Nullable IBoomboxSong victoryMusic) {
        this.victoryMusic = victoryMusic;
        return this;
    }


    public boolean isUseOnlyBonusCommands(){
        return useOnlyBonusCommands;
    }

    public CasinoGameMode setUseOnlyBonusCommands(boolean useOnlyBonusCommands){
        this.useOnlyBonusCommands = useOnlyBonusCommands;
        return this;
    }


    @Nonnull
    public List<String> getBonusCommandsToDispatch() {
        return bonusCommandsToDispatch;
    }

    public CasinoGameMode setBonusCommandsToDispatch(@Nonnull List<String> bonusCommandsToDispatch) {
        if(bonusCommandsToDispatch == null) return this;
        this.bonusCommandsToDispatch = bonusCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpBonusURL() {
        return httpBonusURL;
    }

    public CasinoGameMode setHttpBonusURL(@Nullable String httpBonusURL) {
        this.httpBonusURL = httpBonusURL;
        return this;
    }


    @Nullable
    public String getHttpBonusMethod() {
        return httpBonusMethod;
    }

    public CasinoGameMode setHttpBonusMethod(@Nullable String httpBonusMethod) {
        this.httpBonusMethod = httpBonusMethod;
        return this;
    }


    @Nonnull
    public Map<String, Object> getHttpBonusHeaders() {
        return httpBonusHeaders;
    }

    public CasinoGameMode setHttpBonusHeaders(@Nonnull Map<String, Object> httpBonusHeaders) {
        if(httpBonusHeaders == null) return this;
        this.httpBonusHeaders = httpBonusHeaders;
        return this;
    }


    @Nullable
    public IBoomboxSong getBonusMusic() {
        return bonusMusic;
    }

    public CasinoGameMode setBonusMusic(@Nullable IBoomboxSong bonusMusic) {
        this.bonusMusic = bonusMusic;
        return this;
    }


    public boolean isSendDefeatMessage() {
        return sendDefeatMessage;
    }

    public CasinoGameMode setSendDefeatMessage(boolean sendDefeatMessage) {
        this.sendDefeatMessage = sendDefeatMessage;
        return this;
    }


    public boolean isSendDefeatMessageToAll() {
        return sendDefeatMessageToAll;
    }

    public CasinoGameMode setSendDefeatMessageToAll(boolean sendDefeatMessageToAll) {
        this.sendDefeatMessageToAll = sendDefeatMessageToAll;
        return this;
    }


    public boolean isSendDefeatMessageToDiscord() {
        return sendDefeatMessageToDiscord;
    }

    public CasinoGameMode setSendDefeatMessageToDiscord(boolean sendDefeatMessageToDiscord) {
        this.sendDefeatMessageToDiscord = sendDefeatMessageToDiscord;
        return this;
    }


    @Nonnull
    public List<String> getDefeatCommandsToDispatch() {
        return defeatCommandsToDispatch;
    }

    public CasinoGameMode setDefeatCommandsToDispatch(@Nonnull List<String> defeatCommandsToDispatch) {
        if(defeatCommandsToDispatch == null) return this;
        this.defeatCommandsToDispatch = defeatCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpDefeatURL() {
        return httpDefeatURL;
    }

    public CasinoGameMode setHttpDefeatURL(@Nullable String httpDefeatURL) {
        this.httpDefeatURL = httpDefeatURL;
        return this;
    }


    @Nullable
    public String getHttpDefeatMethod() {
        return httpDefeatMethod;
    }

    public CasinoGameMode setHttpDefeatMethod(@Nullable String httpDefeatMethod) {
        this.httpDefeatMethod = httpDefeatMethod;
        return this;
    }


    @Nonnull
    public Map<String, Object> getHttpDefeatHeaders() {
        return httpDefeatHeaders;
    }

    public CasinoGameMode setHttpDefeatHeaders(@Nonnull Map<String, Object> httpDefeatHeaders) {
        if(httpDefeatHeaders == null) return this;
        this.httpDefeatHeaders = httpDefeatHeaders;
        return this;
    }


    @Nullable
    public IBoomboxSong getDefeatMusic() {
        return defeatMusic;
    }

    public CasinoGameMode setDefeatMusic(@Nullable IBoomboxSong defeatMusic) {
        this.defeatMusic = defeatMusic;
        return this;
    }


    public double getMinBetPrice() {
        return minBetPrice;
    }

    public CasinoGameMode setMinBetPrice(double minBetPrice) {
        this.minBetPrice = minBetPrice;
        return this;
    }


    public int getMinBetPriceInItems() {
        return minBetPriceInItems;
    }

    public CasinoGameMode setMinBetPriceInItems(int minBetPriceInItems) {
        this.minBetPriceInItems = minBetPriceInItems;
        return this;
    }


    public double getMaxBetPrice() {
        return maxBetPrice;
    }

    public CasinoGameMode setMaxBetPrice(double maxBetPrice) {
        this.maxBetPrice = maxBetPrice;
        return this;
    }


    public int getMaxBetPriceInItems() {
        return maxBetPriceInItems;
    }

    public CasinoGameMode setMaxBetPriceInItems(int maxBetPriceInItems) {
        this.maxBetPriceInItems = maxBetPriceInItems;
        return this;
    }


    public double getMaxDiffBetweenBets() {
        return maxDiffBetweenBets;
    }

    public CasinoGameMode setMaxDiffBetweenBets(double maxDiffBetweenBets) {
        this.maxDiffBetweenBets = maxDiffBetweenBets;
        return this;
    }


    @Nonnull
    public List<Integer> getMoneyBetSlots() {
        return moneyBetSlots;
    }

    public CasinoGameMode setMoneyBetSlots(@Nonnull List<Integer> moneyBetSlots) {
        if(moneyBetSlots == null) return this;
        this.moneyBetSlots = moneyBetSlots;
        return this;
    }


    @Nullable
    public ItemStack getMoneyBetItem() {
        return moneyBetItem;
    }

    public CasinoGameMode setMoneyBetItem(@Nullable ItemStack moneyBetItem) {
        this.moneyBetItem = moneyBetItem;
        return this;
    }


    @Nullable
    public String getMoneyBetItemTitle() {
        return moneyBetItemTitle;
    }

    public CasinoGameMode setMoneyBetItemTitle(@Nullable String moneyBetItemTitle) {
        this.moneyBetItemTitle = moneyBetItemTitle;
        return this;
    }


    @Nonnull
    public List<String> getMoneyBetItemLore() {
        return moneyBetItemLore;
    }

    public CasinoGameMode setMoneyBetItemLore(@Nonnull List<String> moneyBetItemLore) {
        if(moneyBetItemLore == null) return this;
        this.moneyBetItemLore = moneyBetItemLore;
        return this;
    }


    public double getMoneyBetDefault() {
        return moneyBetDefault;
    }

    public CasinoGameMode setMoneyBetDefault(double moneyBetDefault) {
        this.moneyBetDefault = moneyBetDefault;
        return this;
    }


    public double getMoneyBetChangePerClick() {
        return moneyBetChangePerClick;
    }

    public CasinoGameMode setMoneyBetChangePerClick(double moneyBetChangePerClick) {
        this.moneyBetChangePerClick = moneyBetChangePerClick;
        return this;
    }


    public double getMoneyBetChangePerClickBig() {
        return moneyBetChangePerClickBig;
    }

    public CasinoGameMode setMoneyBetChangePerClickBig(double moneyBetChangePerClickBig) {
        this.moneyBetChangePerClickBig = moneyBetChangePerClickBig;
        return this;
    }


    @Nonnull
    public List<Integer> getSpotSlots() {
        return spotSlots;
    }

    public CasinoGameMode setSpotSlots(@Nonnull List<Integer> spotSlots) {
        if(spotSlots == null) return this;
        this.spotSlots = spotSlots;
        return this;
    }


    @Nullable
    public ItemStack getSpotItem() {
        return spotItem;
    }

    public CasinoGameMode setSpotItem(@Nullable ItemStack spotItem) {
        this.spotItem = spotItem;
        return this;
    }


    @Nonnull
    public List<Integer> getLeverSlots() {
        return leverSlots;
    }

    public CasinoGameMode setLeverSlots(@Nonnull List<Integer> leverSlots) {
        if(leverSlots == null) return this;
        this.leverSlots = leverSlots;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemInactive() {
        return leverItemInactive;
    }

    public CasinoGameMode setLeverItemInactive(@Nullable ItemStack leverItemInactive) {
        this.leverItemInactive = leverItemInactive;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemActive() {
        return leverItemActive;
    }

    public CasinoGameMode setLeverItemActive(@Nullable ItemStack leverItemActive) {
        this.leverItemActive = leverItemActive;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemRolling() {
        return leverItemRolling;
    }

    public CasinoGameMode setLeverItemRolling(@Nullable ItemStack leverItemRolling) {
        this.leverItemRolling = leverItemRolling;
        return this;
    }


    @Nullable
    public IBoomboxSong getBackgroundMusic() {
        return backgroundMusic;
    }

    public CasinoGameMode setBackgroundMusic(@Nullable IBoomboxSong backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
        return this;
    }


    @Nonnull
    public List<Integer> getMusicButtonSlots() {
        return musicButtonSlots;
    }

    public CasinoGameMode setMusicButtonSlots(@Nonnull List<Integer> musicButtonSlots) {
        if(musicButtonSlots == null) return this;
        this.musicButtonSlots = musicButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getMusicButtonItemInactive() {
        return musicButtonItemInactive;
    }

    public CasinoGameMode setMusicButtonItemInactive(@Nullable ItemStack musicButtonItemInactive) {
        this.musicButtonItemInactive = musicButtonItemInactive;
        return this;
    }


    @Nullable
    public ItemStack getMusicButtonItemActive() {
        return musicButtonItemActive;
    }

    public CasinoGameMode setMusicButtonItemActive(@Nullable ItemStack musicButtonItemActive) {
        this.musicButtonItemActive = musicButtonItemActive;
        return this;
    }


    @Nullable
    public String getMusicButtonItemActiveTitle() {
        return musicButtonItemActiveTitle;
    }

    public CasinoGameMode setMusicButtonItemActiveTitle(@Nullable String musicButtonItemActiveTitle) {
        this.musicButtonItemActiveTitle = musicButtonItemActiveTitle;
        return this;
    }


    @Nonnull
    public List<Integer> getStatsButtonSlots() {
        return statsButtonSlots;
    }

    public CasinoGameMode setStatsButtonSlots(@Nonnull List<Integer> statsButtonSlots) {
        if(statsButtonSlots == null) return this;
        this.statsButtonSlots = statsButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getStatsButtonItem() {
        return statsButtonItem;
    }

    public CasinoGameMode setStatsButtonItem(@Nullable ItemStack statsButtonItem) {
        this.statsButtonItem = statsButtonItem;
        return this;
    }


    @Nonnull
    public List<String> getStatsButtonLore() {
        return statsButtonLore;
    }

    public CasinoGameMode setStatsButtonLore(@Nonnull List<String> statsButtonLore) {
        if(statsButtonSlots == null) return this;
        this.statsButtonLore = statsButtonLore;
        return this;
    }


    @Nonnull
    public Map<Integer, ItemStack> getEmptySlots() {
        return emptySlots;
    }

    public CasinoGameMode setEmptySlots(@Nonnull Map<Integer, ItemStack> emptySlots) {
        if(emptySlots == null) return this;
        this.emptySlots = emptySlots;
        return this;
    }


    @Override
    public String toString() {
        return
                "Mode-name: " + modeName + ";" +
                "GUI-size: " + guiSize + ";" +
                "GUI-title: " + guiTitle + ";" +
                "Permission: " + permission + ";" +
                "GUI-icon-slots: " + slotInGUI.toString() + ";" +
                "GUI-one-game-icon-slots: " + slotInOneGameGUI.toString() + ";" +
                "Icon-item: " + iconItem + ";" +

                "Jackpot-chance: " + jackpotChance + ";" +
                "Jackpot-boost:" + jackpotBoost + ";" +
                "Jackpot-charged-percentage:" + chargedPercentage + ";" +
                "Jackpot-send-message:" + sendJackpotMessage + ";" +
                "Jackpot-send-message-to-all:" + sendJackpotMessageToAll + ";" +
                "Jackpot-send-message-to-discord:" + sendJackpotMessageToDiscord + ";" +
                "Jackpot-only-commands:" + useOnlyJackpotCommands + ";" +
                "Jackpot-commands-list:" + jackpotCommandsToDispatch.toString() + ";" +
                "Jackpot-http-url:" + httpJackpotURL + ";" +
                "Jackpot-http-method:" + httpJackpotMethod + ";" +
                "Jackpot-http-headers:" + httpJackpotHeaders.toString() + ";" +
                "Jackpot-music:" + (jackpotMusic == null ? null : jackpotMusic.getID()) + ";" +

                "Victory-fireworks:" + spawnVictoryFireWorks + ";" +
                "Victory-send-message:" + sendVictoryMessage + ";" +
                "Victory-send-message-to-all:" + sendVictoryMessageToAll + ";" +
                "Victory-send-message-to-discord:" + sendVictoryMessageToDiscord + ";" +
                "Victory-only-commands:" + useOnlyVictoryCommands + ";" +
                "Victory-commands-list:" + victoryCommandsToDispatch.toString() + ";" +
                "Victory-http-url:" + httpVictoryURL + ";" +
                "Victory-http-method:" + httpVictoryMethod + ";" +
                "Victory-http-headers:" + httpVictoryHeaders.toString() + ";" +
                "Victory-music:" + (victoryMusic == null ? null : victoryMusic.getID()) + ";" +

                "Bonus-only-commands:" + useOnlyBonusCommands + ";" +
                "Bonus-commands-list:" + bonusCommandsToDispatch.toString() + ";" +
                "Bonus-http-url:" + httpBonusURL + ";" +
                "Bonus-http-method:" + httpBonusMethod + ";" +
                "Bonus-http-headers:" + httpBonusHeaders.toString() + ";" +
                "Bonus-music:" + (bonusMusic == null ? null : bonusMusic.getID()) + ";" +

                "Defeat-send-message:" + sendDefeatMessage + ";" +
                "Defeat-send-message-to-all:" + sendDefeatMessageToAll + ";" +
                "Defeat-send-message-to-discord:" + sendDefeatMessageToDiscord + ";" +
                "Defeat-commands-list:" + defeatCommandsToDispatch.toString() + ";" +
                "Defeat-http-url:" + httpDefeatURL + ";" +
                "Defeat-http-method:" + httpDefeatMethod + ";" +
                "Defeat-http-headers:" + httpDefeatHeaders.toString() + ";" +
                "Defeat-music:" + (defeatMusic == null ? null : defeatMusic.getID()) + ";" +

                "Bet-min-price:" + minBetPrice + ";" +
                "Bet-min-items-amount:" + minBetPriceInItems + ";" +
                "Bet-max-price:" + maxBetPrice + ";" +
                "Bet-max-items-amount:" + maxBetPriceInItems + ";" +
                "Bet-max-price-difference:" + maxDiffBetweenBets + ";" +

                "Money-bet-slots:" + moneyBetSlots.toString() + ";" +
                "Money-bet-item:" + moneyBetItem + ";" +
                "Money-bet-item-title:" + moneyBetItemTitle + ";" +
                "Money-bet-item-lore:" + moneyBetItemLore.toString() + ";" +
                "Money-bet-default:" + moneyBetDefault + ";" +
                "Money-bet-change-per-click:" + moneyBetChangePerClick + ";" +
                "Money-bet-big-change-per-click:" + moneyBetChangePerClickBig + ";" +

                "Spot-slots:" + spotSlots.toString() + ";" +
                "Spot-item:" + spotItem + ";" +

                "Lever-slots:" + leverSlots.toString() + ";" +
                "Lever-item-inactive:" + leverItemInactive + ";" +
                "Lever-item-active:" + leverItemActive + ";" +
                "Lever-item-rolling:" + leverItemRolling + ";" +

                "Background-music:" + (backgroundMusic == null ? null : backgroundMusic.getID()) + ";" +
                "Background-music-button-slots:" + musicButtonSlots.toString() + ";" +
                "Background-music-button-item-inactive:" + musicButtonInactive + ";" +
                "Background-music-button-item-active:" + musicButtonActive + ";" +
                "Background-music-button-item-active-title:" + musicButtonActiveTitle + ";" +
                "Background-empty-slots:" + emptySlots;
    }
}



