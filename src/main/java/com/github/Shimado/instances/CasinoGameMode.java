package com.github.Shimado.instances;

import com.github.Shimado.interfaces.BoomboxSong;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    private List<Integer> slotsInGUI = new ArrayList<>();                    // Slots occupied by the icon in the main GUI
    private List<Integer> slotsInOneGameGUI = new ArrayList<>();             // Slots occupied by an icon in the main GUI for one game
    private ItemStack iconItem;                                              // The icon in the main GUI

    private double jackpotChance = 0.0;                                      // Chance to hit the jackpot if you win
    private double jackpotBoost = 1.0;                                       // Defeat Payout Boost
    private double chargedPercentage = 0.0;                                  // Percentage of the bet that goes to the jackpot
    private BarColor jackpotBossBarColor = BarColor.GREEN;                   // Bar color
    private BarStyle jackpotBossBarStyle = BarStyle.SOLID;                   // Bar style
    private int jackpotBossBarDuration = 0;                                  // Duration in ticks
    private boolean sendJackpotBossBar = false;                              // Sends bossbar title to player
    private String jackpotBossBarTitle;                                      // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendJackpotBossBarToAll = false;                         // Sends bossbar title to all players
    private String jackpotBossBarTitleToAll;                                 // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendJackpotTitle = false;                                // Sends jackpot title
    private String jackpotTitle;                                             // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String jackpotSubtitle;                                          // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendJackpotTitleToAll = false;                           // Sends jackpot title to all players
    private String jackpotTitleToAll;                                        // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String jackpotSubtitleToAll;                                     // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private int jackpotTitleFadeIn = 0;                                      // Title fade in time in ticks
    private int jackpotTitleStay = 0;                                        // Title stay time in ticks
    private int jackpotTitleFadeOut = 0;                                     // Title fade out time in ticks
    private boolean sendJackpotMessage = true;                               // Sends jackpot message to the player
    private String jackpotMessage;                                           // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendJackpotMessageToAll = false;                         // Sends jackpot message to all players
    private String jackpotMessageToAll;                                      // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendJackpotMessageToDiscord = false;                     // Sends jackpot message to Discord
    private String jackpotMessageToDiscord;                                  // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean useOnlyJackpotCommands = false;                          // Whether only commands will be executed
    private List<String> jackpotCommandsToDispatch = new ArrayList<>();      // Commands executed when player hits jackpot [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpJackpotURL;                                           // URL to be processed [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpJackpotMethod = "POST";                               // Request method
    private Map<String, Object> httpJackpotHeaders = new HashMap<>();        // Request headers
    private BoomboxSong jackpotMusic;                                        // Music in .nbs format from Boombox plugin

    private boolean ifWinMultiplierLessThanOneConsiderAsBonus = true;        // If the winning odds are less than 1.0, the bonus scenario will be processed instead of the win scenario. If there is no bonus scenario, the win scenario will be processed.
    private BarColor victoryBossBarColor = BarColor.GREEN;                   // Bar color
    private BarStyle victoryBossBarStyle = BarStyle.SOLID;                   // Bar style
    private int victoryBossBarDuration = 0;                                  // Duration in ticks
    private boolean sendVictoryBossBar = false;                              // Sends bossbar title to player
    private String victoryBossBarTitle;                                      // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryBossBarToAll = false;                         // Sends bossbar title to all players
    private String victoryBossBarTitleToAll;                                 // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryTitle = false;                                // Sends victory title
    private String victoryTitle;                                             // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String victorySubtitle;                                          // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryTitleToAll = false;                           // Sends victory title to all players
    private String victoryTitleToAll;                                        // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String victorySubtitleToAll;                                     // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private int victoryTitleFadeIn = 0;                                      // Title fade in time in ticks
    private int victoryTitleStay = 0;                                        // Title stay time in ticks
    private int victoryTitleFadeOut = 0;                                     // Title fade out time in ticks
    private boolean spawnVictoryFireWorks = false;                           // Whether to spawn fireworks on victory
    private boolean sendVictoryMessage = false;                              // Sends victory message to the winning player
    private String victoryMessage;                                           // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryMessageToAll = false;                         // Sends victory message to all players
    private String victoryMessageToAll;                                      // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendVictoryMessageToDiscord = false;                     // Sends victory message to Discord
    private String victoryMessageToDiscord;                                  // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean useOnlyVictoryCommands = false;                          // Whether only commands will be executed
    private List<String> victoryCommandsToDispatch = new ArrayList<>();      // Commands executed when player wins [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpVictoryURL;                                           // URL to be processed [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpVictoryMethod = "POST";                               // Request method
    private Map<String, Object> httpVictoryHeaders = new HashMap<>();        // Request headers
    private BoomboxSong victoryMusic;                                        // Music in .nbs format from Boombox plugin

    private boolean sendBonusTitle = false;                                  // Sends bonus title
    private BarColor bonusBossBarColor = BarColor.GREEN;                     // Bar color
    private BarStyle bonusBossBarStyle = BarStyle.SOLID;                     // Bar style
    private int bonusBossBarDuration = 0;                                    // Duration in ticks
    private boolean sendBonusBossBar = false;                                // Sends bossbar title to player
    private String bonusBossBarTitle;                                        // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendBonusBossBarToAll = false;                           // Sends bossbar title to all players
    private String bonusBossBarTitleToAll;                                   // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String bonusTitle;                                               // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String bonusSubtitle;                                            // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendBonusTitleToAll = false;                             // Sends bonus title to all players
    private String bonusTitleToAll;                                          // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String bonusSubtitleToAll;                                       // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private int bonusTitleFadeIn = 0;                                        // Title fade in time in ticks
    private int bonusTitleStay = 0;                                          // Title stay time in ticks
    private int bonusTitleFadeOut = 0;                                       // Title fade out time in ticks
    private boolean sendBonusMessage = false;                                // Sends bonus message to the losing player
    private String bonusMessage;                                             // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendBonusMessageToAll = false;                           // Sends bonus message to all players
    private String bonusMessageToAll;                                        // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendBonusMessageToDiscord = false;                       // Sends bonus message to Discord
    private String bonusMessageToDiscord;                                    // Message itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean useOnlyBonusCommands = false;                            // Whether only commands will be executed
    private List<String> bonusCommandsToDispatch = new ArrayList<>();        // Commands executed when player wins [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpBonusURL;                                             // URL to be processed [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpBonusMethod = "POST";                                 // Request method
    private Map<String, Object> httpBonusHeaders = new HashMap<>();          // Request headers
    private BoomboxSong bonusMusic;                                          // Music in .nbs format from Boombox plugin

    private boolean sendDefeatTitle = false;                                 // Sends defeat title
    private BarColor defeatBossBarColor = BarColor.GREEN;                    // Bar color
    private BarStyle defeatBossBarStyle = BarStyle.SOLID;                    // Bar style
    private int defeatBossBarDuration = 0;                                   // Duration in ticks
    private boolean sendDefeatBossBar = false;                               // Sends bossbar title to player
    private String defeatBossBarTitle;                                       // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendDefeatBossBarToAll = false;                          // Sends bossbar title to all players
    private String defeatBossBarTitleToAll;                                  // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String defeatTitle;                                              // Title itself [Placeholders: %player%, %mode%, %bet_price%]
    private String defeatSubtitle;                                           // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDefeatTitleToAll = false;                            // Sends defeat title to all players
    private String defeatTitleToAll;                                         // Title itself [Placeholders: %player%, %mode%, %bet_price%]
    private String defeatSubtitleToAll;                                      // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%]
    private int defeatTitleFadeIn = 0;                                       // Title fade in time in ticks
    private int defeatTitleStay = 0;                                         // Title stay time in ticks
    private int defeatTitleFadeOut = 0;                                      // Title fade out time in ticks
    private boolean sendDefeatMessage = false;                               // Sends defeat message to the losing player
    private String defeatMessage;                                            // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDefeatMessageToAll = false;                          // Sends defeat message to all players
    private String defeatMessageToAll;                                       // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDefeatMessageToDiscord = false;                      // Sends defeat message to Discord
    private String defeatMessageToDiscord;                                   // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean useOnlyDefeatCommands = false;                           // Whether only commands will be executed
    private List<String> defeatCommandsToDispatch = new ArrayList<>();       // Commands executed when player loses [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String httpDefeatURL;                                            // URL to be processed [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String httpDefeatMethod = "POST";                                // Request method
    private Map<String, Object> httpDefeatHeaders = new HashMap<>();         // Request headers
    private BoomboxSong defeatMusic;                                         // Music in .nbs format from Boombox plugin

    private boolean sendDrawTitle = false;                                   // Sends draw title
    private BarColor drawBossBarColor = BarColor.GREEN;                      // Bar color
    private BarStyle drawBossBarStyle = BarStyle.SOLID;                      // Bar style
    private int drawBossBarDuration = 0;                                     // Duration in ticks
    private boolean sendDrawBossBar = false;                                 // Sends bossbar title to player
    private String drawBossBarTitle;                                         // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private boolean sendDrawBossBarToAll = false;                            // Sends bossbar title to all players
    private String drawBossBarTitleToAll;                                    // Title itself [Placeholders: %player%, %mode%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String drawTitle;                                                // Title itself [Placeholders: %player%, %mode%, %bet_price%]
    private String drawSubtitle;                                             // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDrawTitleToAll = false;                              // Sends draw title to all players
    private String drawTitleToAll;                                           // Title itself [Placeholders: %player%, %mode%, %bet_price%]
    private String drawSubtitleToAll;                                        // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%]
    private int drawTitleFadeIn = 0;                                         // Title fade in time in ticks
    private int drawTitleStay = 0;                                           // Title stay time in ticks
    private int drawTitleFadeOut = 0;                                        // Title fade out time in ticks
    private boolean sendDrawMessage = false;                                 // Sends draw message to the losing player
    private String drawMessage;                                              // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDrawMessageToAll = false;                            // Sends draw message to all players
    private String drawMessageToAll;                                         // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean sendDrawMessageToDiscord = false;                        // Sends draw message to Discord
    private String drawMessageToDiscord;                                     // Message itself [Placeholders: %player%, %mode%, %bet_price%]
    private boolean useOnlyDrawCommands = false;                             // Whether only commands will be executed
    private List<String> drawCommandsToDispatch = new ArrayList<>();         // Commands executed when player loses [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String httpDrawURL;                                              // URL to be processed [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String httpDrawMethod = "POST";                                  // Request method
    private Map<String, Object> httpDrawHeaders = new HashMap<>();           // Request headers
    private BoomboxSong drawMusic;                                           // Music in .nbs format from Boombox plugin

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
    private String spotItemTitle;                                            // Betting spot title
    private List<String> spotItemLore = new ArrayList<>();                   // Betting spot lore

    private List<Integer> leverSlots = new ArrayList<>();                    // Control lever slots
    private ItemStack leverItemInactive;                                     // Inactive lever (when no bet is placed)
    private String leverItemInactiveTitle;                                   // Inactive lever title
    private List<String> leverItemInactiveLore = new ArrayList<>();          // Inactive lever lore
    private ItemStack leverItemActive;                                       // Active lever (when player has placed a bet)
    private String leverItemActiveTitle;                                     // Active lever title
    private List<String> leverItemActiveLore = new ArrayList<>();            // Active lever lore
    private ItemStack leverItemRolling;                                      // Rolling lever (when player has placed a bet and started the game)
    private String leverItemRollingTitle;                                    // Rolling lever title
    private List<String> leverItemRollingLore = new ArrayList<>();           // Rolling lever lore
    private ItemStack leverItemEnd;                                          // Finished lever (when the game is over)
    private String leverItemEndTitle;                                        // Finished lever title
    private List<String> leverItemEndLore = new ArrayList<>();               // Finished lever lore

    private BoomboxSong backgroundMusic;                                     // Background music in .nbs format from Boombox plugin
    private List<Integer> musicButtonSlots = new ArrayList<>();              // Slot occupied by the button
    private ItemStack musicButtonItemInactive;                               // Background music button (inactive)
    private String musicButtonItemInactiveTitle;                             // Active background button title
    private List<String> musicButtonItemInactiveLore = new ArrayList<>();    // Active background button lore
    private ItemStack musicButtonItemActive;                                 // Background music button (active)
    private String musicButtonItemActiveTitle;                               // Active background button title
    private List<String> musicButtonItemActiveLore = new ArrayList<>();      // Active background button lore
    private List<Integer> statsButtonSlots = new ArrayList<>();              // This game mode statistics slots
    private ItemStack statsButtonItem;                                       // This game mode statistics item
    private List<String> statsButtonLore = new ArrayList<>();                // This game mode statistics item lore with all placeholders
    private Map<Integer, ItemStack> emptySlots = new HashMap<>();            // Background slot items

    private int gameOnline = 0;                                              // This is how many players are currently playing this mode


    public CasinoGameMode(@NotNull String modeName){
        this.modeName = modeName;
    }


    @NotNull
    public String getModeName(){
        return modeName;
    }


    @Nullable
    public String getGuiTitle(){
        return guiTitle;
    }

    public CasinoGameMode setGuiTitle(@NotNull String guiTitle){
        if(guiTitle == null) return this;
        this.guiTitle = guiTitle;
        return this;
    }


    public int getGuiSize(){
        return guiSize;
    }

    public CasinoGameMode setGuiSize(int guiSize){
        this.guiSize = guiSize;
        return this;
    }


    @Nullable
    public String getPermission(){
        return permission;
    }

    public CasinoGameMode setPermission(@NotNull String permission){
        if(permission == null) return this;
        this.permission = permission;
        return this;
    }


    @NotNull
    public List<Integer> getSlotsInGUI() {
        return slotsInGUI;
    }

    public CasinoGameMode setSlotsInGUI(@NotNull List<Integer> slotsInGUI) {
        if(slotsInGUI == null) return this;
        this.slotsInGUI = slotsInGUI;
        return this;
    }


    @NotNull
    public List<Integer> getSlotsInOneGameGUI() {
        return slotsInOneGameGUI;
    }

    public CasinoGameMode setSlotsInOneGameGUI(@NotNull List<Integer> slotsInOneGameGUI) {
        if(slotsInOneGameGUI == null) return this;
        this.slotsInOneGameGUI = slotsInOneGameGUI;
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


    @Nullable
    public BarColor getJackpotBossBarColor() {
        return jackpotBossBarColor;
    }

    public CasinoGameMode setJackpotBossBarColor(@Nullable BarColor jackpotBossBarColor) {
        this.jackpotBossBarColor = jackpotBossBarColor;
        return this;
    }


    @Nullable
    public BarStyle getJackpotBossBarStyle() {
        return jackpotBossBarStyle;
    }

    public CasinoGameMode setJackpotBossBarStyle(@Nullable BarStyle jackpotBossBarStyle) {
        this.jackpotBossBarStyle = jackpotBossBarStyle;
        return this;
    }


    public int getJackpotBossBarDuration() {
        return jackpotBossBarDuration;
    }

    public CasinoGameMode setJackpotBossBarDuration(int jackpotBossBarDuration) {
        this.jackpotBossBarDuration = jackpotBossBarDuration;
        return this;
    }


    public boolean isSendJackpotBossBar() {
        return sendJackpotBossBar;
    }

    public CasinoGameMode setSendJackpotBossBar(boolean sendJackpotBossBar) {
        this.sendJackpotBossBar = sendJackpotBossBar;
        return this;
    }


    @Nullable
    public String getJackpotBossBarTitle() {
        return jackpotBossBarTitle;
    }

    public CasinoGameMode setJackpotBossBarTitle(@Nullable String jackpotBossBarTitle) {
        this.jackpotBossBarTitle = jackpotBossBarTitle;
        return this;
    }


    public boolean isSendJackpotBossBarToAll() {
        return sendJackpotBossBarToAll;
    }

    public CasinoGameMode setSendJackpotBossBarToAll(boolean sendJackpotBossBarToAll) {
        this.sendJackpotBossBarToAll = sendJackpotBossBarToAll;
        return this;
    }


    @Nullable
    public String getJackpotBossBarTitleToAll() {
        return jackpotBossBarTitleToAll;
    }

    public CasinoGameMode setJackpotBossBarTitleToAll(@Nullable String jackpotBossBarTitleToAll) {
        this.jackpotBossBarTitleToAll = jackpotBossBarTitleToAll;
        return this;
    }


    public boolean isSendJackpotTitle() {
        return sendJackpotTitle;
    }

    public CasinoGameMode setSendJackpotTitle(boolean sendJackpotTitle) {
        this.sendJackpotTitle = sendJackpotTitle;
        return this;
    }


    @Nullable
    public String getJackpotTitle() {
        return jackpotTitle;
    }

    public CasinoGameMode setJackpotTitle(@Nullable String jackpotTitle) {
        this.jackpotTitle = jackpotTitle;
        return this;
    }


    @Nullable
    public String getJackpotSubtitle() {
        return jackpotSubtitle;
    }

    public CasinoGameMode setJackpotSubtitle(@Nullable String jackpotSubtitle) {
        this.jackpotSubtitle = jackpotSubtitle;
        return this;
    }


    public boolean isSendJackpotTitleToAll() {
        return sendJackpotTitleToAll;
    }

    public CasinoGameMode setSendJackpotTitleToAll(boolean sendJackpotTitleToAll) {
        this.sendJackpotTitleToAll = sendJackpotTitleToAll;
        return this;
    }


    @Nullable
    public String getJackpotTitleToAll() {
        return jackpotTitleToAll;
    }

    public CasinoGameMode setJackpotTitleToAll(@Nullable String jackpotTitleToAll) {
        this.jackpotTitleToAll = jackpotTitleToAll;
        return this;
    }


    @Nullable
    public String getJackpotSubtitleToAll() {
        return jackpotSubtitleToAll;
    }

    public CasinoGameMode setJackpotSubtitleToAll(@Nullable String jackpotSubtitleToAll) {
        this.jackpotSubtitleToAll = jackpotSubtitleToAll;
        return this;
    }


    public int getJackpotTitleFadeIn() {
        return jackpotTitleFadeIn;
    }

    public CasinoGameMode setJackpotTitleFadeIn(int jackpotTitleFadeIn) {
        this.jackpotTitleFadeIn = jackpotTitleFadeIn;
        return this;
    }


    public int getJackpotTitleStay() {
        return jackpotTitleStay;
    }

    public CasinoGameMode setJackpotTitleStay(int jackpotTitleStay) {
        this.jackpotTitleStay = jackpotTitleStay;
        return this;
    }


    public int getJackpotTitleFadeOut() {
        return jackpotTitleFadeOut;
    }

    public CasinoGameMode setJackpotTitleFadeOut(int jackpotTitleFadeOut) {
        this.jackpotTitleFadeOut = jackpotTitleFadeOut;
        return this;
    }


    public boolean isSendJackpotMessage() {
        return sendJackpotMessage;
    }

    public CasinoGameMode setSendJackpotMessage(boolean sendJackpotMessage) {
        this.sendJackpotMessage = sendJackpotMessage;
        return this;
    }


    @Nullable
    public String getJackpotMessage() {
        return jackpotMessage;
    }

    public CasinoGameMode setJackpotMessage(@Nullable String jackpotMessage) {
        this.jackpotMessage = jackpotMessage;
        return this;
    }


    public boolean isSendJackpotMessageToAll() {
        return sendJackpotMessageToAll;
    }

    public CasinoGameMode setSendJackpotMessageToAll(boolean sendJackpotMessageToAll) {
        this.sendJackpotMessageToAll = sendJackpotMessageToAll;
        return this;
    }


    @Nullable
    public String getJackpotMessageToAll() {
        return jackpotMessageToAll;
    }

    public CasinoGameMode setJackpotMessageToAll(@Nullable String jackpotMessageToAll) {
        this.jackpotMessageToAll = jackpotMessageToAll;
        return this;
    }


    public boolean isSendJackpotMessageToDiscord() {
        return sendJackpotMessageToDiscord;
    }

    public CasinoGameMode setSendJackpotMessageToDiscord(boolean sendJackpotMessageToDiscord) {
        this.sendJackpotMessageToDiscord = sendJackpotMessageToDiscord;
        return this;
    }


    @Nullable
    public String getJackpotMessageToDiscord() {
        return jackpotMessageToDiscord;
    }

    public CasinoGameMode setJackpotMessageToDiscord(@Nullable String jackpotMessageToDiscord) {
        this.jackpotMessageToDiscord = jackpotMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyJackpotCommands(){
        return useOnlyJackpotCommands;
    }

    public CasinoGameMode setUseOnlyJackpotCommands(boolean useOnlyJackpotCommands){
        this.useOnlyJackpotCommands = useOnlyJackpotCommands;
        return this;
    }


    @NotNull
    public List<String> getJackpotCommandsToDispatch() {
        return jackpotCommandsToDispatch;
    }

    public CasinoGameMode setJackpotCommandsToDispatch(@NotNull List<String> jackpotCommandsToDispatch) {
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


    @NotNull
    public Map<String, Object> getHttpJackpotHeaders() {
        return httpJackpotHeaders;
    }

    public CasinoGameMode setHttpJackpotHeaders(@NotNull Map<String, Object> httpJackpotHeaders) {
        if(httpJackpotHeaders == null) return this;
        this.httpJackpotHeaders = httpJackpotHeaders;
        return this;
    }


    @Nullable
    public BoomboxSong getJackpotMusic() {
        return jackpotMusic;
    }

    public CasinoGameMode setJackpotMusic(@Nullable BoomboxSong jackpotMusic) {
        this.jackpotMusic = jackpotMusic;
        return this;
    }


    public boolean isIfWinMultiplierLessThanOneConsiderAsBonus() {
        return ifWinMultiplierLessThanOneConsiderAsBonus;
    }

    public CasinoGameMode setIfWinMultiplierLessThanOneConsiderAsBonus(boolean ifWinMultiplierLessThanOneConsiderAsBonus) {
        this.ifWinMultiplierLessThanOneConsiderAsBonus = ifWinMultiplierLessThanOneConsiderAsBonus;
        return this;
    }


    @Nullable
    public BarColor getVictoryBossBarColor() {
        return victoryBossBarColor;
    }

    public CasinoGameMode setVictoryBossBarColor(@Nullable BarColor victoryBossBarColor) {
        this.victoryBossBarColor = victoryBossBarColor;
        return this;
    }


    @Nullable
    public BarStyle getVictoryBossBarStyle() {
        return victoryBossBarStyle;
    }

    public CasinoGameMode setVictoryBossBarStyle(@Nullable BarStyle victoryBossBarStyle) {
        this.victoryBossBarStyle = victoryBossBarStyle;
        return this;
    }


    public int getVictoryBossBarDuration() {
        return victoryBossBarDuration;
    }

    public CasinoGameMode setVictoryBossBarDuration(int victoryBossBarDuration) {
        this.victoryBossBarDuration = victoryBossBarDuration;
        return this;
    }


    public boolean isSendVictoryBossBar() {
        return sendVictoryBossBar;
    }

    public CasinoGameMode setSendVictoryBossBar(boolean sendVictoryBossBar) {
        this.sendVictoryBossBar = sendVictoryBossBar;
        return this;
    }


    @Nullable
    public String getVictoryBossBarTitle() {
        return victoryBossBarTitle;
    }

    public CasinoGameMode setVictoryBossBarTitle(@Nullable String victoryBossBarTitle) {
        this.victoryBossBarTitle = victoryBossBarTitle;
        return this;
    }


    public boolean isSendVictoryBossBarToAll() {
        return sendVictoryBossBarToAll;
    }

    public CasinoGameMode setSendVictoryBossBarToAll(boolean sendVictoryBossBarToAll) {
        this.sendVictoryBossBarToAll = sendVictoryBossBarToAll;
        return this;
    }


    @Nullable
    public String getVictoryBossBarTitleToAll() {
        return victoryBossBarTitleToAll;
    }

    public CasinoGameMode setVictoryBossBarTitleToAll(@Nullable String victoryBossBarTitleToAll) {
        this.victoryBossBarTitleToAll = victoryBossBarTitleToAll;
        return this;
    }


    public boolean isSendVictoryTitle() {
        return sendVictoryTitle;
    }

    public CasinoGameMode setSendVictoryTitle(boolean sendVictoryTitle) {
        this.sendVictoryTitle = sendVictoryTitle;
        return this;
    }


    @Nullable
    public String getVictoryTitle() {
        return victoryTitle;
    }

    public CasinoGameMode setVictoryTitle(@Nullable String victoryTitle) {
        this.victoryTitle = victoryTitle;
        return this;
    }


    @Nullable
    public String getVictorySubtitle() {
        return victorySubtitle;
    }

    public CasinoGameMode setVictorySubtitle(@Nullable String victorySubtitle) {
        this.victorySubtitle = victorySubtitle;
        return this;
    }


    public boolean isSendVictoryTitleToAll() {
        return sendVictoryTitleToAll;
    }

    public CasinoGameMode setSendVictoryTitleToAll(boolean sendVictoryTitleToAll) {
        this.sendVictoryTitleToAll = sendVictoryTitleToAll;
        return this;
    }


    @Nullable
    public String getVictoryTitleToAll() {
        return victoryTitleToAll;
    }

    public CasinoGameMode setVictoryTitleToAll(@Nullable String victoryTitleToAll) {
        this.victoryTitleToAll = victoryTitleToAll;
        return this;
    }


    @Nullable
    public String getVictorySubtitleToAll() {
        return victorySubtitleToAll;
    }

    public CasinoGameMode setVictorySubtitleToAll(@Nullable String victorySubtitleToAll) {
        this.victorySubtitleToAll = victorySubtitleToAll;
        return this;
    }


    public int getVictoryTitleFadeIn() {
        return victoryTitleFadeIn;
    }

    public CasinoGameMode setVictoryTitleFadeIn(int victoryTitleFadeIn) {
        this.victoryTitleFadeIn = victoryTitleFadeIn;
        return this;
    }


    public int getVictoryTitleStay() {
        return victoryTitleStay;
    }

    public CasinoGameMode setVictoryTitleStay(int victoryTitleStay) {
        this.victoryTitleStay = victoryTitleStay;
        return this;
    }


    public int getVictoryTitleFadeOut() {
        return victoryTitleFadeOut;
    }

    public CasinoGameMode setVictoryTitleFadeOut(int victoryTitleFadeOut) {
        this.victoryTitleFadeOut = victoryTitleFadeOut;
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


    @Nullable
    public String getVictoryMessage() {
        return victoryMessage;
    }

    public CasinoGameMode setVictoryMessage(@Nullable String victoryMessage) {
        this.victoryMessage = victoryMessage;
        return this;
    }


    public boolean isSendVictoryMessageToAll() {
        return sendVictoryMessageToAll;
    }

    public CasinoGameMode setSendVictoryMessageToAll(boolean sendVictoryMessageToAll) {
        this.sendVictoryMessageToAll = sendVictoryMessageToAll;
        return this;
    }


    @Nullable
    public String getVictoryMessageToAll() {
        return victoryMessageToAll;
    }

    public CasinoGameMode setVictoryMessageToAll(@Nullable String victoryMessageToAll) {
        this.victoryMessageToAll = victoryMessageToAll;
        return this;
    }


    public boolean isSendVictoryMessageToDiscord() {
        return sendVictoryMessageToDiscord;
    }

    public CasinoGameMode setSendVictoryMessageToDiscord(boolean sendVictoryMessageToDiscord) {
        this.sendVictoryMessageToDiscord = sendVictoryMessageToDiscord;
        return this;
    }


    @Nullable
    public String getVictoryMessageToDiscord() {
        return victoryMessageToDiscord;
    }

    public CasinoGameMode setVictoryMessageToDiscord(@Nullable String victoryMessageToDiscord) {
        this.victoryMessageToDiscord = victoryMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyVictoryCommands(){
        return useOnlyVictoryCommands;
    }

    public CasinoGameMode setUseOnlyVictoryCommands(boolean useOnlyVictoryCommands){
        this.useOnlyVictoryCommands = useOnlyVictoryCommands;
        return this;
    }


    @NotNull
    public List<String> getVictoryCommandsToDispatch() {
        return victoryCommandsToDispatch;
    }

    public CasinoGameMode setVictoryCommandsToDispatch(@NotNull List<String> victoryCommandsToDispatch) {
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


    @NotNull
    public Map<String, Object> getHttpVictoryHeaders() {
        return httpVictoryHeaders;
    }

    public CasinoGameMode setHttpVictoryHeaders(@NotNull Map<String, Object> httpVictoryHeaders) {
        if(httpVictoryHeaders == null) return this;
        this.httpVictoryHeaders = httpVictoryHeaders;
        return this;
    }


    @Nullable
    public BoomboxSong getVictoryMusic() {
        return victoryMusic;
    }

    public CasinoGameMode setVictoryMusic(@Nullable BoomboxSong victoryMusic) {
        this.victoryMusic = victoryMusic;
        return this;
    }


    public boolean isSendBonusTitle() {
        return sendBonusTitle;
    }

    public CasinoGameMode setSendBonusTitle(boolean sendBonusTitle) {
        this.sendBonusTitle = sendBonusTitle;
        return this;
    }


    @Nullable
    public BarColor getBonusBossBarColor() {
        return bonusBossBarColor;
    }

    public CasinoGameMode setBonusBossBarColor(@Nullable BarColor bonusBossBarColor) {
        this.bonusBossBarColor = bonusBossBarColor;
        return this;
    }


    @Nullable
    public BarStyle getBonusBossBarStyle() {
        return bonusBossBarStyle;
    }

    public CasinoGameMode setBonusBossBarStyle(@Nullable BarStyle bonusBossBarStyle) {
        this.bonusBossBarStyle = bonusBossBarStyle;
        return this;
    }


    public int getBonusBossBarDuration() {
        return bonusBossBarDuration;
    }

    public CasinoGameMode setBonusBossBarDuration(int bonusBossBarDuration) {
        this.bonusBossBarDuration = bonusBossBarDuration;
        return this;
    }


    public boolean isSendBonusBossBar() {
        return sendBonusBossBar;
    }

    public CasinoGameMode setSendBonusBossBar(boolean sendBonusBossBar) {
        this.sendBonusBossBar = sendBonusBossBar;
        return this;
    }


    @Nullable
    public String getBonusBossBarTitle() {
        return bonusBossBarTitle;
    }

    public CasinoGameMode setBonusBossBarTitle(@Nullable String bonusBossBarTitle) {
        this.bonusBossBarTitle = bonusBossBarTitle;
        return this;
    }


    public boolean isSendBonusBossBarToAll() {
        return sendBonusBossBarToAll;
    }

    public CasinoGameMode setSendBonusBossBarToAll(boolean sendBonusBossBarToAll) {
        this.sendBonusBossBarToAll = sendBonusBossBarToAll;
        return this;
    }


    @Nullable
    public String getBonusBossBarTitleToAll() {
        return bonusBossBarTitleToAll;
    }

    public CasinoGameMode setBonusBossBarTitleToAll(@Nullable String bonusBossBarTitleToAll) {
        this.bonusBossBarTitleToAll = bonusBossBarTitleToAll;
        return this;
    }


    @Nullable
    public String getBonusTitle() {
        return bonusTitle;
    }

    public CasinoGameMode setBonusTitle(@Nullable String bonusTitle) {
        this.bonusTitle = bonusTitle;
        return this;
    }


    @Nullable
    public String getBonusSubtitle() {
        return bonusSubtitle;
    }

    public CasinoGameMode setBonusSubtitle(@Nullable String bonusSubtitle) {
        this.bonusSubtitle = bonusSubtitle;
        return this;
    }


    public boolean isSendBonusTitleToAll() {
        return sendBonusTitleToAll;
    }

    public CasinoGameMode setSendBonusTitleToAll(boolean sendBonusTitleToAll) {
        this.sendBonusTitleToAll = sendBonusTitleToAll;
        return this;
    }


    @Nullable
    public String getBonusTitleToAll() {
        return bonusTitleToAll;
    }

    public CasinoGameMode setBonusTitleToAll(@Nullable String bonusTitleToAll) {
        this.bonusTitleToAll = bonusTitleToAll;
        return this;
    }


    @Nullable
    public String getBonusSubtitleToAll() {
        return bonusSubtitleToAll;
    }

    public CasinoGameMode setBonusSubtitleToAll(@Nullable String bonusSubtitleToAll) {
        this.bonusSubtitleToAll = bonusSubtitleToAll;
        return this;
    }


    public int getBonusTitleFadeIn() {
        return bonusTitleFadeIn;
    }

    public CasinoGameMode setBonusTitleFadeIn(int bonusTitleFadeIn) {
        this.bonusTitleFadeIn = bonusTitleFadeIn;
        return this;
    }


    public int getBonusTitleStay() {
        return bonusTitleStay;
    }

    public CasinoGameMode setBonusTitleStay(int bonusTitleStay) {
        this.bonusTitleStay = bonusTitleStay;
        return this;
    }


    public int getBonusTitleFadeOut() {
        return bonusTitleFadeOut;
    }

    public CasinoGameMode setBonusTitleFadeOut(int bonusTitleFadeOut) {
        this.bonusTitleFadeOut = bonusTitleFadeOut;
        return this;
    }


    public boolean isSendBonusMessage() {
        return sendBonusMessage;
    }

    public CasinoGameMode setSendBonusMessage(boolean sendBonusMessage) {
        this.sendBonusMessage = sendBonusMessage;
        return this;
    }


    @Nullable
    public String getBonusMessage() {
        return bonusMessage;
    }

    public CasinoGameMode setBonusMessage(@Nullable String bonusMessage) {
        this.bonusMessage = bonusMessage;
        return this;
    }


    public boolean isSendBonusMessageToAll() {
        return sendBonusMessageToAll;
    }

    public CasinoGameMode setSendBonusMessageToAll(boolean sendBonusMessageToAll) {
        this.sendBonusMessageToAll = sendBonusMessageToAll;
        return this;
    }


    @Nullable
    public String getBonusMessageToAll() {
        return bonusMessageToAll;
    }

    public CasinoGameMode setBonusMessageToAll(@Nullable String bonusMessageToAll) {
        this.bonusMessageToAll = bonusMessageToAll;
        return this;
    }


    public boolean isSendBonusMessageToDiscord() {
        return sendBonusMessageToDiscord;
    }

    public CasinoGameMode setSendBonusMessageToDiscord(boolean sendBonusMessageToDiscord) {
        this.sendBonusMessageToDiscord = sendBonusMessageToDiscord;
        return this;
    }


    @Nullable
    public String getBonusMessageToDiscord() {
        return bonusMessageToDiscord;
    }

    public CasinoGameMode setBonusMessageToDiscord(@Nullable String bonusMessageToDiscord) {
        this.bonusMessageToDiscord = bonusMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyBonusCommands(){
        return useOnlyBonusCommands;
    }

    public CasinoGameMode setUseOnlyBonusCommands(boolean useOnlyBonusCommands){
        this.useOnlyBonusCommands = useOnlyBonusCommands;
        return this;
    }


    @NotNull
    public List<String> getBonusCommandsToDispatch() {
        return bonusCommandsToDispatch;
    }

    public CasinoGameMode setBonusCommandsToDispatch(@NotNull List<String> bonusCommandsToDispatch) {
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


    @NotNull
    public Map<String, Object> getHttpBonusHeaders() {
        return httpBonusHeaders;
    }

    public CasinoGameMode setHttpBonusHeaders(@NotNull Map<String, Object> httpBonusHeaders) {
        if(httpBonusHeaders == null) return this;
        this.httpBonusHeaders = httpBonusHeaders;
        return this;
    }


    @Nullable
    public BoomboxSong getBonusMusic() {
        return bonusMusic;
    }

    public CasinoGameMode setBonusMusic(@Nullable BoomboxSong bonusMusic) {
        this.bonusMusic = bonusMusic;
        return this;
    }


    public boolean isSendDefeatTitle() {
        return sendDefeatTitle;
    }

    public CasinoGameMode setSendDefeatTitle(boolean sendDefeatTitle) {
        this.sendDefeatTitle = sendDefeatTitle;
        return this;
    }


    @Nullable
    public BarColor getDefeatBossBarColor() {
        return defeatBossBarColor;
    }

    public CasinoGameMode setDefeatBossBarColor(@Nullable BarColor defeatBossBarColor) {
        this.defeatBossBarColor = defeatBossBarColor;
        return this;
    }


    @Nullable
    public BarStyle getDefeatBossBarStyle() {
        return defeatBossBarStyle;
    }

    public CasinoGameMode setDefeatBossBarStyle(@Nullable BarStyle defeatBossBarStyle) {
        this.defeatBossBarStyle = defeatBossBarStyle;
        return this;
    }


    public int getDefeatBossBarDuration() {
        return defeatBossBarDuration;
    }

    public CasinoGameMode setDefeatBossBarDuration(int defeatBossBarDuration) {
        this.defeatBossBarDuration = defeatBossBarDuration;
        return this;
    }


    public boolean isSendDefeatBossBar() {
        return sendDefeatBossBar;
    }

    public CasinoGameMode setSendDefeatBossBar(boolean sendDefeatBossBar) {
        this.sendDefeatBossBar = sendDefeatBossBar;
        return this;
    }


    @Nullable
    public String getDefeatBossBarTitle() {
        return defeatBossBarTitle;
    }

    public CasinoGameMode setDefeatBossBarTitle(@Nullable String defeatBossBarTitle) {
        this.defeatBossBarTitle = defeatBossBarTitle;
        return this;
    }


    public boolean isSendDefeatBossBarToAll() {
        return sendDefeatBossBarToAll;
    }

    public CasinoGameMode setSendDefeatBossBarToAll(boolean sendDefeatBossBarToAll) {
        this.sendDefeatBossBarToAll = sendDefeatBossBarToAll;
        return this;
    }


    @Nullable
    public String getDefeatBossBarTitleToAll() {
        return defeatBossBarTitleToAll;
    }

    public CasinoGameMode setDefeatBossBarTitleToAll(@Nullable String defeatBossBarTitleToAll) {
        this.defeatBossBarTitleToAll = defeatBossBarTitleToAll;
        return this;
    }


    @Nullable
    public String getDefeatTitle() {
        return defeatTitle;
    }

    public CasinoGameMode setDefeatTitle(@Nullable String defeatTitle) {
        this.defeatTitle = defeatTitle;

        return this;
    }


    @Nullable
    public String getDefeatSubtitle() {
        return defeatSubtitle;
    }

    public CasinoGameMode setDefeatSubtitle(@Nullable String defeatSubtitle) {
        this.defeatSubtitle = defeatSubtitle;
        return this;
    }


    public boolean isSendDefeatTitleToAll() {
        return sendDefeatTitleToAll;
    }

    public CasinoGameMode setSendDefeatTitleToAll(boolean sendDefeatTitleToAll) {
        this.sendDefeatTitleToAll = sendDefeatTitleToAll;
        return this;
    }


    @Nullable
    public String getDefeatTitleToAll() {
        return defeatTitleToAll;
    }

    public CasinoGameMode setDefeatTitleToAll(@Nullable String defeatTitleToAll) {
        this.defeatTitleToAll = defeatTitleToAll;
        return this;
    }


    @Nullable
    public String getDefeatSubtitleToAll() {
        return defeatSubtitleToAll;
    }

    public CasinoGameMode setDefeatSubtitleToAll(@Nullable String defeatSubtitleToAll) {
        this.defeatSubtitleToAll = defeatSubtitleToAll;
        return this;
    }


    public int getDefeatTitleFadeIn() {
        return defeatTitleFadeIn;
    }

    public CasinoGameMode setDefeatTitleFadeIn(int defeatTitleFadeIn) {
        this.defeatTitleFadeIn = defeatTitleFadeIn;
        return this;
    }


    public int getDefeatTitleStay() {
        return defeatTitleStay;
    }

    public CasinoGameMode setDefeatTitleStay(int defeatTitleStay) {
        this.defeatTitleStay = defeatTitleStay;
        return this;
    }


    public int getDefeatTitleFadeOut() {
        return defeatTitleFadeOut;
    }

    public CasinoGameMode setDefeatTitleFadeOut(int defeatTitleFadeOut) {
        this.defeatTitleFadeOut = defeatTitleFadeOut;
        return this;
    }


    public boolean isSendDefeatMessage() {
        return sendDefeatMessage;
    }

    public CasinoGameMode setSendDefeatMessage(boolean sendDefeatMessage) {
        this.sendDefeatMessage = sendDefeatMessage;
        return this;
    }


    @Nullable
    public String getDefeatMessage() {
        return defeatMessage;
    }

    public CasinoGameMode setDefeatMessage(@Nullable String defeatMessage) {
        this.defeatMessage = defeatMessage;
        return this;
    }


    public boolean isSendDefeatMessageToAll() {
        return sendDefeatMessageToAll;
    }

    public CasinoGameMode setSendDefeatMessageToAll(boolean sendDefeatMessageToAll) {
        this.sendDefeatMessageToAll = sendDefeatMessageToAll;
        return this;
    }


    @Nullable
    public String getDefeatMessageToAll() {
        return defeatMessageToAll;
    }

    public CasinoGameMode setDefeatMessageToAll(@Nullable String defeatMessageToAll) {
        this.defeatMessageToAll = defeatMessageToAll;
        return this;
    }


    public boolean isSendDefeatMessageToDiscord() {
        return sendDefeatMessageToDiscord;
    }

    public CasinoGameMode setSendDefeatMessageToDiscord(boolean sendDefeatMessageToDiscord) {
        this.sendDefeatMessageToDiscord = sendDefeatMessageToDiscord;
        return this;
    }


    @Nullable
    public String getDefeatMessageToDiscord() {
        return defeatMessageToDiscord;
    }

    public CasinoGameMode setDefeatMessageToDiscord(@Nullable String defeatMessageToDiscord) {
        this.defeatMessageToDiscord = defeatMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyDefeatCommands(){
        return useOnlyDefeatCommands;
    }

    public CasinoGameMode setUseOnlyDefeatCommands(boolean useOnlyDefeatCommands){
        this.useOnlyDefeatCommands = useOnlyDefeatCommands;
        return this;
    }


    @NotNull
    public List<String> getDefeatCommandsToDispatch() {
        return defeatCommandsToDispatch;
    }

    public CasinoGameMode setDefeatCommandsToDispatch(@NotNull List<String> defeatCommandsToDispatch) {
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


    @NotNull
    public Map<String, Object> getHttpDefeatHeaders() {
        return httpDefeatHeaders;
    }

    public CasinoGameMode setHttpDefeatHeaders(@NotNull Map<String, Object> httpDefeatHeaders) {
        if(httpDefeatHeaders == null) return this;
        this.httpDefeatHeaders = httpDefeatHeaders;
        return this;
    }


    @Nullable
    public BoomboxSong getDefeatMusic() {
        return defeatMusic;
    }

    public CasinoGameMode setDefeatMusic(@Nullable BoomboxSong defeatMusic) {
        this.defeatMusic = defeatMusic;
        return this;
    }


    @Nullable
    public BarColor getDrawBossBarColor() {
        return drawBossBarColor;
    }

    public CasinoGameMode setDrawBossBarColor(@Nullable BarColor drawBossBarColor) {
        this.drawBossBarColor = drawBossBarColor;
        return this;
    }


    @Nullable
    public BarStyle getDrawBossBarStyle() {
        return drawBossBarStyle;
    }

    public CasinoGameMode setDrawBossBarStyle(@Nullable BarStyle drawBossBarStyle) {
        this.drawBossBarStyle = drawBossBarStyle;
        return this;
    }


    public int getDrawBossBarDuration() {
        return drawBossBarDuration;
    }

    public CasinoGameMode setDrawBossBarDuration(int drawBossBarDuration) {
        this.drawBossBarDuration = drawBossBarDuration;
        return this;
    }


    public boolean isSendDrawBossBar() {
        return sendDrawBossBar;
    }

    public CasinoGameMode setSendDrawBossBar(boolean sendDrawBossBar) {
        this.sendDrawBossBar = sendDrawBossBar;
        return this;
    }


    @Nullable
    public String getDrawBossBarTitle() {
        return drawBossBarTitle;
    }

    public CasinoGameMode setDrawBossBarTitle(@Nullable String drawBossBarTitle) {
        this.drawBossBarTitle = drawBossBarTitle;
        return this;
    }


    public boolean isSendDrawBossBarToAll() {
        return sendDrawBossBarToAll;
    }

    public CasinoGameMode setSendDrawBossBarToAll(boolean sendDrawBossBarToAll) {
        this.sendDrawBossBarToAll = sendDrawBossBarToAll;
        return this;
    }


    @Nullable
    public String getDrawBossBarTitleToAll() {
        return drawBossBarTitleToAll;
    }

    public CasinoGameMode setDrawBossBarTitleToAll(@Nullable String drawBossBarTitleToAll) {
        this.drawBossBarTitleToAll = drawBossBarTitleToAll;
        return this;
    }


    public boolean isSendDrawTitle() {
        return sendDrawTitle;
    }

    public CasinoGameMode setSendDrawTitle(boolean sendDrawTitle) {
        this.sendDrawTitle = sendDrawTitle;
        return this;
    }


    @Nullable
    public String getDrawTitle() {
        return drawTitle;
    }

    public CasinoGameMode setDrawTitle(@Nullable String drawTitle) {
        this.drawTitle = drawTitle;

        return this;
    }


    @Nullable
    public String getDrawSubtitle() {
        return drawSubtitle;
    }

    public CasinoGameMode setDrawSubtitle(@Nullable String drawSubtitle) {
        this.drawSubtitle = drawSubtitle;
        return this;
    }


    public boolean isSendDrawTitleToAll() {
        return sendDrawTitleToAll;
    }

    public CasinoGameMode setSendDrawTitleToAll(boolean sendDrawTitleToAll) {
        this.sendDrawTitleToAll = sendDrawTitleToAll;
        return this;
    }


    @Nullable
    public String getDrawTitleToAll() {
        return drawTitleToAll;
    }

    public CasinoGameMode setDrawTitleToAll(@Nullable String drawTitleToAll) {
        this.drawTitleToAll = drawTitleToAll;
        return this;
    }


    @Nullable
    public String getDrawSubtitleToAll() {
        return drawSubtitleToAll;
    }

    public CasinoGameMode setDrawSubtitleToAll(@Nullable String drawSubtitleToAll) {
        this.drawSubtitleToAll = drawSubtitleToAll;
        return this;
    }


    public int getDrawTitleFadeIn() {
        return drawTitleFadeIn;
    }

    public CasinoGameMode setDrawTitleFadeIn(int drawTitleFadeIn) {
        this.drawTitleFadeIn = drawTitleFadeIn;
        return this;
    }


    public int getDrawTitleStay() {
        return drawTitleStay;
    }

    public CasinoGameMode setDrawTitleStay(int drawTitleStay) {
        this.drawTitleStay = drawTitleStay;
        return this;
    }


    public int getDrawTitleFadeOut() {
        return drawTitleFadeOut;
    }

    public CasinoGameMode setDrawTitleFadeOut(int drawTitleFadeOut) {
        this.drawTitleFadeOut = drawTitleFadeOut;
        return this;
    }


    public boolean isSendDrawMessage() {
        return sendDrawMessage;
    }

    public CasinoGameMode setSendDrawMessage(boolean sendDrawMessage) {
        this.sendDrawMessage = sendDrawMessage;
        return this;
    }


    @Nullable
    public String getDrawMessage() {
        return drawMessage;
    }

    public CasinoGameMode setDrawMessage(@Nullable String drawMessage) {
        this.drawMessage = drawMessage;
        return this;
    }


    public boolean isSendDrawMessageToAll() {
        return sendDrawMessageToAll;
    }

    public CasinoGameMode setSendDrawMessageToAll(boolean sendDrawMessageToAll) {
        this.sendDrawMessageToAll = sendDrawMessageToAll;
        return this;
    }


    @Nullable
    public String getDrawMessageToAll() {
        return drawMessageToAll;
    }

    public CasinoGameMode setDrawMessageToAll(@Nullable String drawMessageToAll) {
        this.drawMessageToAll = drawMessageToAll;
        return this;
    }


    public boolean isSendDrawMessageToDiscord() {
        return sendDrawMessageToDiscord;
    }

    public CasinoGameMode setSendDrawMessageToDiscord(boolean sendDrawMessageToDiscord) {
        this.sendDrawMessageToDiscord = sendDrawMessageToDiscord;
        return this;
    }


    @Nullable
    public String getDrawMessageToDiscord() {
        return drawMessageToDiscord;
    }

    public CasinoGameMode setDrawMessageToDiscord(@Nullable String drawMessageToDiscord) {
        this.drawMessageToDiscord = drawMessageToDiscord;
        return this;
    }


    public boolean isUseOnlyDrawCommands(){
        return useOnlyDrawCommands;
    }

    public CasinoGameMode setUseOnlyDrawCommands(boolean useOnlyDrawCommands){
        this.useOnlyDrawCommands = useOnlyDrawCommands;
        return this;
    }


    @NotNull
    public List<String> getDrawCommandsToDispatch() {
        return drawCommandsToDispatch;
    }

    public CasinoGameMode setDrawCommandsToDispatch(@NotNull List<String> drawCommandsToDispatch) {
        if(drawCommandsToDispatch == null) return this;
        this.drawCommandsToDispatch = drawCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpDrawURL() {
        return httpDrawURL;
    }

    public CasinoGameMode setHttpDrawURL(@Nullable String httpDrawURL) {
        this.httpDrawURL = httpDrawURL;
        return this;
    }


    @Nullable
    public String getHttpDrawMethod() {
        return httpDrawMethod;
    }

    public CasinoGameMode setHttpDrawMethod(@Nullable String httpDrawMethod) {
        this.httpDrawMethod = httpDrawMethod;
        return this;
    }


    @NotNull
    public Map<String, Object> getHttpDrawHeaders() {
        return httpDrawHeaders;
    }

    public CasinoGameMode setHttpDrawHeaders(@NotNull Map<String, Object> httpDrawHeaders) {
        if(httpDrawHeaders == null) return this;
        this.httpDrawHeaders = httpDrawHeaders;
        return this;
    }


    @Nullable
    public BoomboxSong getDrawMusic() {
        return drawMusic;
    }

    public CasinoGameMode setDrawMusic(@Nullable BoomboxSong drawMusic) {
        this.drawMusic = drawMusic;
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


    @NotNull
    public List<Integer> getMoneyBetSlots() {
        return moneyBetSlots;
    }

    public CasinoGameMode setMoneyBetSlots(@NotNull List<Integer> moneyBetSlots) {
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


    @NotNull
    public List<String> getMoneyBetItemLore() {
        return moneyBetItemLore;
    }

    public CasinoGameMode setMoneyBetItemLore(@NotNull List<String> moneyBetItemLore) {
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


    @NotNull
    public List<Integer> getSpotSlots() {
        return spotSlots;
    }

    public CasinoGameMode setSpotSlots(@NotNull List<Integer> spotSlots) {
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


    @Nullable
    public String getSpotItemTitle() {
        return spotItemTitle;
    }

    public CasinoGameMode setSpotItemTitle(@Nullable String spotItemTitle) {
        this.spotItemTitle = spotItemTitle;
        return this;
    }



    @NotNull
    public List<String> getSpotItemLore() {
        return spotItemLore;
    }

    public CasinoGameMode setSpotItemLore(@NotNull List<String> spotItemLore) {
        if(spotItemLore == null) return this;
        this.spotItemLore = spotItemLore;
        return this;
    }


    @NotNull
    public List<Integer> getLeverSlots() {
        return leverSlots;
    }

    public CasinoGameMode setLeverSlots(@NotNull List<Integer> leverSlots) {
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
    public String getLeverItemInactiveTitle() {
        return leverItemInactiveTitle;
    }

    public CasinoGameMode setLeverItemInactiveTitle(@Nullable String leverItemInactiveTitle) {
        this.leverItemInactiveTitle = leverItemInactiveTitle;
        return this;
    }


    @NotNull
    public List<String> getLeverItemInactiveLore() {
        return leverItemInactiveLore;
    }

    public CasinoGameMode setLeverItemInactiveLore(@NotNull List<String> leverItemInactiveLore) {
        if(leverItemInactiveLore == null) return this;
        this.leverItemInactiveLore = leverItemInactiveLore;
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
    public String getLeverItemActiveTitle() {
        return leverItemActiveTitle;
    }

    public CasinoGameMode setLeverItemActiveTitle(@Nullable String leverItemActiveTitle) {
        this.leverItemActiveTitle = leverItemActiveTitle;
        return this;
    }


    @NotNull
    public List<String> getLeverItemActiveLore() {
        return leverItemActiveLore;
    }

    public CasinoGameMode setLeverItemActiveLore(@NotNull List<String> leverItemActiveLore) {
        if(leverItemActiveLore == null) return this;
        this.leverItemActiveLore = leverItemActiveLore;
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
    public String getLeverItemRollingTitle() {
        return leverItemRollingTitle;
    }

    public CasinoGameMode setLeverItemRollingTitle(@Nullable String leverItemRollingTitle) {
        this.leverItemRollingTitle = leverItemRollingTitle;
        return this;
    }


    @NotNull
    public List<String> getLeverItemRollingLore() {
        return leverItemRollingLore;
    }

    public CasinoGameMode setLeverItemRollingLore(@NotNull List<String> leverItemRollingLore) {
        if(leverItemRollingLore == null) return this;
        this.leverItemRollingLore = leverItemRollingLore;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemEnd() {
        return leverItemEnd;
    }

    public CasinoGameMode setLeverItemEnd(@Nullable ItemStack leverItemEnd) {
        this.leverItemEnd = leverItemEnd;
        return this;
    }


    @Nullable
    public String getLeverItemEndTitle() {
        return leverItemEndTitle;
    }

    public CasinoGameMode setLeverItemEndTitle(@Nullable String leverItemEndTitle) {
        this.leverItemEndTitle = leverItemEndTitle;
        return this;
    }


    @NotNull
    public List<String> getLeverItemEndLore() {
        return leverItemEndLore;
    }

    public CasinoGameMode setLeverItemEndLore(@NotNull List<String> leverItemEndLore) {
        if(leverItemEndLore == null) return this;
        this.leverItemEndLore = leverItemEndLore;
        return this;
    }


    @Nullable
    public BoomboxSong getBackgroundMusic() {
        return backgroundMusic;
    }

    public CasinoGameMode setBackgroundMusic(@Nullable BoomboxSong backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
        return this;
    }


    @NotNull
    public List<Integer> getMusicButtonSlots() {
        return musicButtonSlots;
    }

    public CasinoGameMode setMusicButtonSlots(@NotNull List<Integer> musicButtonSlots) {
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
    public String getMusicButtonItemInactiveTitle() {
        return musicButtonItemInactiveTitle;
    }

    public CasinoGameMode setMusicButtonItemInactiveTitle(@Nullable String musicButtonItemInactiveTitle) {
        this.musicButtonItemInactiveTitle = musicButtonItemInactiveTitle;
        return this;
    }


    @NotNull
    public List<String> getMusicButtonItemInactiveLore() {
        return musicButtonItemInactiveLore;
    }

    public CasinoGameMode setMusicButtonItemInactiveLore(@NotNull List<String> musicButtonItemInactiveLore) {
        if(musicButtonItemInactiveLore == null) return this;
        this.musicButtonItemInactiveLore = musicButtonItemInactiveLore;
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


    @NotNull
    public List<String> getMusicButtonItemActiveLore() {
        return musicButtonItemActiveLore;
    }

    public CasinoGameMode setMusicButtonItemActiveLore(@NotNull List<String> musicButtonItemActiveLore) {
        if(musicButtonItemActiveLore == null) return this;
        this.musicButtonItemActiveLore = musicButtonItemActiveLore;
        return this;
    }


    @NotNull
    public List<Integer> getStatsButtonSlots() {
        return statsButtonSlots;
    }

    public CasinoGameMode setStatsButtonSlots(@NotNull List<Integer> statsButtonSlots) {
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


    @NotNull
    public List<String> getStatsButtonLore() {
        return statsButtonLore;
    }

    public CasinoGameMode setStatsButtonLore(@NotNull List<String> statsButtonLore) {
        if(statsButtonLore == null) return this;
        this.statsButtonLore = statsButtonLore;
        return this;
    }


    @NotNull
    public Map<Integer, ItemStack> getEmptySlots() {
        return emptySlots;
    }

    public CasinoGameMode setEmptySlots(@NotNull Map<Integer, ItemStack> emptySlots) {
        if(emptySlots == null) return this;
        this.emptySlots = emptySlots;
        return this;
    }


    public int getGameOnline(){
        return gameOnline;
    }

    public void setGameOnline(int gameOnline){
        this.gameOnline = gameOnline;
    }

    public void addGameOnline(){
        gameOnline++;
    }

    public void removeGameOnline(){
        gameOnline = Math.max(0, gameOnline - 1);
    }

}



