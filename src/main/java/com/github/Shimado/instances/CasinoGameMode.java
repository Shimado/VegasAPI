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
    private String httpJackpotURL;                                           // URL to be processed
    private String httpJackpotMethod = "POST";                               // Request method
    private Map<String, Object> httpJackpotHeaders = new HashMap<>();        // Request headers
    private IBoomboxSong jackpotMusic;                                       // Music in .nbs format from Boombox plugin

    private boolean ifWinMultiplierLessThanOneConsiderAsBonus = true;        // If the winning odds are less than 1.0, the bonus scenario will be processed instead of the win scenario. If there is no bonus scenario, the win scenario will be processed.
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
    private String httpVictoryURL;                                           // URL to be processed
    private String httpVictoryMethod = "POST";                               // Request method
    private Map<String, Object> httpVictoryHeaders = new HashMap<>();        // Request headers
    private IBoomboxSong victoryMusic;                                       // Music in .nbs format from Boombox plugin

    private boolean sendBonusTitle = false;                                  // Sends bonus title
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
    private String httpBonusURL;                                             // URL to be processed
    private String httpBonusMethod = "POST";                                 // Request method
    private Map<String, Object> httpBonusHeaders = new HashMap<>();          // Request headers
    private IBoomboxSong bonusMusic;                                         // Music in .nbs format from Boombox plugin

    private boolean sendDefeatTitle = false;                                 // Sends defeat title
    private String defeatTitle;                                              // Title itself [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String defeatSubtitle;                                           // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private boolean sendDefeatTitleToAll = false;                            // Sends defeat title to all players
    private String defeatTitleToAll;                                         // Title itself [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private String defeatSubtitleToAll;                                      // Subtitle itself [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private int defeatTitleFadeIn = 0;                                       // Title fade in time in ticks
    private int defeatTitleStay = 0;                                         // Title stay time in ticks
    private int defeatTitleFadeOut = 0;                                      // Title fade out time in ticks
    private boolean sendDefeatMessage = false;                               // Sends defeat message to the losing player
    private String defeatMessage;                                            // Message itself [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private boolean sendDefeatMessageToAll = false;                          // Sends defeat message to all players
    private String defeatMessageToAll;                                       // Message itself [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private boolean sendDefeatMessageToDiscord = false;                      // Sends defeat message to Discord
    private String defeatMessageToDiscord;                                   // Message itself [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
    private List<String> defeatCommandsToDispatch = new ArrayList<>();       // Commands executed when player loses [Placeholders: %player%, %mode%, %bet_price%, %bet_price_rounded%]
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


    public boolean isIfWinMultiplierLessThanOneConsiderAsBonus() {
        return ifWinMultiplierLessThanOneConsiderAsBonus;
    }

    public CasinoGameMode setIfWinMultiplierLessThanOneConsiderAsBonus(boolean ifWinMultiplierLessThanOneConsiderAsBonus) {
        this.ifWinMultiplierLessThanOneConsiderAsBonus = ifWinMultiplierLessThanOneConsiderAsBonus;
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


    public boolean isSendBonusTitle() {
        return sendBonusTitle;
    }

    public CasinoGameMode setSendBonusTitle(boolean sendBonusTitle) {
        this.sendBonusTitle = sendBonusTitle;
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


    public boolean isSendDefeatTitle() {
        return sendDefeatTitle;
    }

    public CasinoGameMode setSendDefeatTitle(boolean sendDefeatTitle) {
        this.sendDefeatTitle = sendDefeatTitle;
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
                "Jackpot-send-title:" + sendJackpotTitle + ";" +
                "Jackpot-title:" + jackpotTitle + ";" +
                "Jackpot-subtitle:" + jackpotSubtitle + ";" +
                "Jackpot-send-title-to-all:" + sendJackpotTitleToAll + ";" +
                "Jackpot-title-to-all:" + jackpotTitleToAll + ";" +
                "Jackpot-subtitle-to-all:" + jackpotSubtitleToAll + ";" +
                "Jackpot-title-fade-in:" + jackpotTitleFadeIn + ";" +
                "Jackpot-title-stay:" + jackpotTitleStay + ";" +
                "Jackpot-title-fade-out:" + jackpotTitleFadeOut + ";" +
                "Jackpot-send-message:" + sendJackpotMessage + ";" +
                "Jackpot-message:" + jackpotMessage + ";" +
                "Jackpot-send-message-to-all:" + sendJackpotMessageToAll + ";" +
                "Jackpot-message-to-all:" + jackpotMessageToAll + ";" +
                "Jackpot-send-message-to-discord:" + sendJackpotMessageToDiscord + ";" +
                "Jackpot-message-to-discord:" + jackpotMessageToDiscord + ";" +
                "Jackpot-only-commands:" + useOnlyJackpotCommands + ";" +
                "Jackpot-commands-list:" + jackpotCommandsToDispatch.toString() + ";" +
                "Jackpot-http-url:" + httpJackpotURL + ";" +
                "Jackpot-http-method:" + httpJackpotMethod + ";" +
                "Jackpot-http-headers:" + httpJackpotHeaders.toString() + ";" +
                "Jackpot-music:" + (jackpotMusic == null ? null : jackpotMusic.getID()) + ";" +

                "Victory-if-multiplier-less-than-one-consider-as-bonus:" + ifWinMultiplierLessThanOneConsiderAsBonus + ";" +
                "Victory-send-title:" + sendVictoryTitle + ";" +
                "Victory-title:" + victoryTitle + ";" +
                "Victory-subtitle:" + victorySubtitle + ";" +
                "Victory-send-title-to-all:" + sendVictoryTitleToAll + ";" +
                "Victory-title-to-all:" + victoryTitleToAll + ";" +
                "Victory-subtitle-to-all:" + victorySubtitleToAll + ";" +
                "Victory-title-fade-in:" + victoryTitleFadeIn + ";" +
                "Victory-title-stay:" + victoryTitleStay + ";" +
                "Victory-title-fade-out:" + victoryTitleFadeOut + ";" +
                "Victory-fireworks:" + spawnVictoryFireWorks + ";" +
                "Victory-send-message:" + sendVictoryMessage + ";" +
                "Victory-message:" + victoryMessage + ";" +
                "Victory-send-message-to-all:" + sendVictoryMessageToAll + ";" +
                "Victory-message-to-all:" + victoryMessageToAll + ";" +
                "Victory-send-message-to-discord:" + sendVictoryMessageToDiscord + ";" +
                "Victory-message-to-discord:" + victoryMessageToDiscord + ";" +
                "Victory-only-commands:" + useOnlyVictoryCommands + ";" +
                "Victory-commands-list:" + victoryCommandsToDispatch.toString() + ";" +
                "Victory-http-url:" + httpVictoryURL + ";" +
                "Victory-http-method:" + httpVictoryMethod + ";" +
                "Victory-http-headers:" + httpVictoryHeaders.toString() + ";" +
                "Victory-music:" + (victoryMusic == null ? null : victoryMusic.getID()) + ";" +

                "Bonus-send-title:" + sendBonusTitle + ";" +
                "Bonus-title:" + bonusTitle + ";" +
                "Bonus-subtitle:" + bonusSubtitle + ";" +
                "Bonus-send-title-to-all:" + sendBonusTitleToAll + ";" +
                "Bonus-title-to-all:" + bonusTitleToAll + ";" +
                "Bonus-subtitle-to-all:" + bonusSubtitleToAll + ";" +
                "Bonus-title-fade-in:" + bonusTitleFadeIn + ";" +
                "Bonus-title-stay:" + bonusTitleStay + ";" +
                "Bonus-title-fade-out:" + bonusTitleFadeOut + ";" +
                "Bonus-send-message:" + sendBonusMessage + ";" +
                "Bonus-message:" + bonusMessage + ";" +
                "Bonus-send-message-to-all:" + sendBonusMessageToAll + ";" +
                "Bonus-message-to-all:" + bonusMessageToAll + ";" +
                "Bonus-send-message-to-discord:" + sendBonusMessageToDiscord + ";" +
                "Bonus-message-to-discord:" + bonusMessageToDiscord + ";" +
                "Bonus-only-commands:" + useOnlyBonusCommands + ";" +
                "Bonus-commands-list:" + bonusCommandsToDispatch.toString() + ";" +
                "Bonus-http-url:" + httpBonusURL + ";" +
                "Bonus-http-method:" + httpBonusMethod + ";" +
                "Bonus-http-headers:" + httpBonusHeaders.toString() + ";" +
                "Bonus-music:" + (bonusMusic == null ? null : bonusMusic.getID()) + ";" +

                "Defeat-send-title:" + sendDefeatTitle + ";" +
                "Defeat-title:" + defeatTitle + ";" +
                "Defeat-subtitle:" + defeatSubtitle + ";" +
                "Defeat-send-title-to-all:" + sendDefeatTitleToAll + ";" +
                "Defeat-title-to-all:" + defeatTitleToAll + ";" +
                "Defeat-subtitle-to-all:" + defeatSubtitleToAll + ";" +
                "Defeat-title-fade-in:" + defeatTitleFadeIn + ";" +
                "Defeat-title-stay:" + defeatTitleStay + ";" +
                "Defeat-title-fade-out:" + defeatTitleFadeOut + ";" +
                "Defeat-send-message:" + sendDefeatMessage + ";" +
                "Defeat-message:" + defeatMessage + ";" +
                "Defeat-send-message-to-all:" + sendDefeatMessageToAll + ";" +
                "Defeat-message-to-all:" + defeatMessageToAll + ";" +
                "Defeat-send-message-to-discord:" + sendDefeatMessageToDiscord + ";" +
                "Defeat-message-to-discord:" + defeatMessageToDiscord + ";" +
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
                "Background-music-button-item-inactive:" + musicButtonItemInactive + ";" +
                "Background-music-button-item-active:" + musicButtonItemActive + ";" +
                "Background-music-button-item-active-title:" + musicButtonItemActiveTitle + ";" +
                "Background-stats-button-slots:" + statsButtonSlots.toString() + ";" +
                "Background-stats-button-item:" + statsButtonItem + ";" +
                "Background-stats-button-lore:" + statsButtonLore + ";" +
                "Background-empty-slots:" + emptySlots;
    }
}



