package com.github.Shimado.instances;

import com.github.Shimado.interfaces.IBoomboxSong;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasinoGameMode {

    private String modeName;                                                 // Для использования в командах
    private int guiSize = 6;                                                 // Размер инвентаря
    private String guiTitle;                                                 // Заголовок инвентаря
    private String permission = "";                                          // Право доступа, чтобы открыть режим
    private List<Integer> slotInGUI = new ArrayList<>();                     // Какой слот занимает в главном меню
    private List<Integer> slotInOneGameGUI = new ArrayList<>();              // Какой слот занимает в меню под 1 игру
    private ItemStack iconItem;                                              // Сама иконка

    private double jackpotChance = 0.0;                                      // Шанс выбить джекпот при победе
    private double jackpotBoost = 1.0;                                       // Усиление выплаты джекпота
    private double chargedPercentage = 0.0;                                  // Какой процент ставки идет в джекпот
    private boolean sendJackpotMessage = true;                               // Отправляет сообщение о джекпоте игрока
    private boolean sendJackpotMessageToAll = false;                         // Отправляет сообщение о джекпоте игрока всем игрокам
    private boolean sendJackpotMessageToDiscord = false;                     // Отправляет сообщение о джекпоте игрока в дискорд
    private boolean useOnlyJackpotCommands = false;                          // Будут ли выполняться только команды
    private List<String> jackpotCommandsToDispatch = new ArrayList<>();      // Команды, которые выполняются при джекпоте игрока [Placeholders: %player%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpJackpotURL;                                           // Ссылка, которая будет обрабатываться
    private String httpJackpotMethod = "POST";                               // Метод запроса
    private Map<String, Object> httpJackpotHeaders = new HashMap<>();        // Заголовки запроса
    private IBoomboxSong jackpotMusic;                                       // Музыка в формате .nbs с Boombox плагина

    private boolean spawnVictoryFireWorks = false;                           // Спавнит ли салют при победе
    private boolean sendVictoryMessage = false;                              // Отправляет сообщение о победе игроку, кто выйграл
    private boolean sendVictoryMessageToAll = false;                         // Отправляет сообщение о победе игрока всем игрокам
    private boolean sendVictoryMessageToDiscord = false;                     // Отправляет сообщение о победе игрока в дискорд
    private boolean useOnlyVictoryCommands = false;                          // Будут ли выполняться только команды
    private List<String> victoryCommandsToDispatch = new ArrayList<>();      // Команды, которые выполняются при победе игрока [Placeholders: %player%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpVictoryURL;                                           // Ссылка, которая будет обрабатываться
    private String httpVictoryMethod = "POST";                               // Метод запроса
    private Map<String, Object> httpVictoryHeaders = new HashMap<>();        // Заголовки запроса
    private IBoomboxSong victoryMusic;                                       // Музыка в формате .nbs с Boombox плагина

    private boolean useOnlyBonusCommands = false;                            // Будут ли выполняться только команды
    private List<String> bonusCommandsToDispatch = new ArrayList<>();        // Команды, которые выполняются при победе игрока [Placeholders: %player%, %bet_price%, %prize%, %bet_price_rounded%, %prize_rounded%]
    private String httpBonusURL;                                             // Ссылка, которая будет обрабатываться
    private String httpBonusMethod;                                          // Метод запроса
    private Map<String, Object> httpBonusHeaders = new HashMap<>();          // Заголовки запроса
    private IBoomboxSong bonusMusic;                                         // Музыка в формате .nbs с Boombox плагина

    private boolean sendDefeatMessage = false;                               // Отправляет сообщение о проигрыше игроку, кто выйграл
    private boolean sendDefeatMessageToAll = false;                          // Отправляет сообщение о проигрыше игрока всем игрокам
    private boolean sendDefeatMessageToDiscord = false;                      // Отправляет сообщение о проигрыше игрока в дискорд
    private List<String> defeatCommandsToDispatch = new ArrayList<>();       // Команды, которые выполняются при проигрыше игрока [Placeholders: %player%, %bet_price%, %bet_price_rounded%]
    private String httpDefeatURL;                                            // Ссылка, которая будет обрабатываться
    private String httpDefeatMethod;                                         // Метод запроса
    private Map<String, Object> httpDefeatHeaders = new HashMap<>();         // Заголовки запроса
    private IBoomboxSong defeatMusic;                                        // Музыка в формате .nbs с Boombox плагина

    private double minBetPrice = 0.0;                                        // Минимальная ставка в денежном эквиваленте
    private int minBetPriceInItems = 1;                                      // Минимальная количество предметов, которые может поставить игрок
    private double maxBetPrice = 0.0;                                        // Максимальная ставка в денежном эквиваленте
    private int maxBetPriceInItems = 64;                                     // Максимальное количество предметов, которые может поставить игрок
    private double maxDiffBetweenBets = 0.0;                                 // Максимальная разница между ставками, если превышает, то нельзя сделать ставку

    private List<Integer> moneyBetSlots = new ArrayList<>();                 // Слоты под ставку денег
    private ItemStack moneyBetItem;                                          // Кнопка изменения ставки
    private String moneyBetItemTitle;                                        // Заголовок кнопки изменения ставки
    private List<String> moneyBetItemLore = new ArrayList<>();               // Описание кнопки изменения ставки
    private double moneyBetDefault = 1000.0;                                 // Ставка, которая идет по стандарту
    private double moneyBetChangePerClick = 1000.0;                          // На сколько будет изменять ставка за клик
    private double moneyBetChangePerClickBig = 10000.0;                      // На сколько будет изменяться ставка за большой клик

    private List<Integer> spotSlots = new ArrayList<>();                     // Места под ставку
    private ItemStack spotItem;                                              // Иконка места под ставку

    private List<Integer> leverSlots = new ArrayList<>();                    // Слоты под рычаги управления
    private ItemStack leverItemInactive;                                     // Неактивный рычаг, когда еще нет ставки
    private ItemStack leverItemActive;                                       // Активный рычаг, когда игрок сделал ставку
    private ItemStack leverItemRolling;                                      // Прокручивается рычаг, когда игрок сделал ставку и начал игру

    private IBoomboxSong backgroundMusic;                                    // Музыка в формате .nbs с Boombox плагина
    private List<Integer> musicButtonSlots = new ArrayList<>();              // Какой слот занимает кнопка
    private ItemStack musicButtonInactive;                                   // Кнопка фоновой музыка (неактивная)
    private ItemStack musicButtonActive;                                     // Кнопка фоновой музыка (активная)
    private String musicButtonActiveTitle;                                   // Заголовок активной фоновой кнопки
    private Map<Integer, ItemStack> emptySlots = new HashMap<>();            // Фоновые ячейки


    public CasinoGameMode(String modeName){
        this.modeName = modeName;
    }


    @Nullable
    public String getModeName(){
        return this.modeName;
    }

    public CasinoGameMode setModeName(@Nonnull String modeName){
        this.modeName = modeName;
        return this;
    }


    @Nullable
    public String getGuiTitle(){
        return this.guiTitle;
    }

    public CasinoGameMode setGuiTitle(@Nonnull String guiTitle){
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
        this.permission = permission;
        return this;
    }


    @Nonnull
    public List<Integer> getSlotInGUI() {
        return slotInGUI;
    }

    public CasinoGameMode setSlotInGUI(List<Integer> slotInGUI) {
        this.slotInGUI = slotInGUI;
        return this;
    }


    @Nonnull
    public List<Integer> getSlotInOneGameGUI() {
        return slotInOneGameGUI;
    }

    public CasinoGameMode setSlotInOneGameGUI(List<Integer> slotInOneGameGUI) {
        this.slotInOneGameGUI = slotInOneGameGUI;
        return this;
    }


    @Nullable
    public ItemStack getIconItem() {
        return iconItem;
    }

    public CasinoGameMode setIconItem(ItemStack iconItem) {
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

    public CasinoGameMode setJackpotCommandsToDispatch(List<String> jackpotCommandsToDispatch) {
        this.jackpotCommandsToDispatch = jackpotCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpJackpotURL() {
        return httpJackpotURL;
    }

    public CasinoGameMode setHttpJackpotURL(String httpJackpotURL) {
        this.httpJackpotURL = httpJackpotURL;
        return this;
    }


    @Nullable
    public String getHttpJackpotMethod() {
        return httpJackpotMethod;
    }

    public CasinoGameMode setHttpJackpotMethod(String httpJackpotMethod) {
        this.httpJackpotMethod = httpJackpotMethod;
        return this;
    }


    @Nonnull
    public Map<String, Object> getHttpJackpotHeaders() {
        return httpJackpotHeaders;
    }

    public CasinoGameMode setHttpJackpotHeaders(Map<String, Object> httpJackpotHeaders) {
        this.httpJackpotHeaders = httpJackpotHeaders;
        return this;
    }


    @Nullable
    public IBoomboxSong getJackpotMusic() {
        return jackpotMusic;
    }

    public CasinoGameMode setJackpotMusic(IBoomboxSong jackpotMusic) {
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

    public CasinoGameMode setVictoryCommandsToDispatch(List<String> victoryCommandsToDispatch) {
        this.victoryCommandsToDispatch = victoryCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpVictoryURL() {
        return httpVictoryURL;
    }

    public CasinoGameMode setHttpVictoryURL(String httpVictoryURL) {
        this.httpVictoryURL = httpVictoryURL;
        return this;
    }


    @Nullable
    public String getHttpVictoryMethod() {
        return httpVictoryMethod;
    }

    public CasinoGameMode setHttpVictoryMethod(String httpVictoryMethod) {
        this.httpVictoryMethod = httpVictoryMethod;
        return this;
    }


    @Nonnull
    public Map<String, Object> getHttpVictoryHeaders() {
        return httpVictoryHeaders;
    }

    public CasinoGameMode setHttpVictoryHeaders(Map<String, Object> httpVictoryHeaders) {
        this.httpVictoryHeaders = httpVictoryHeaders;
        return this;
    }


    @Nullable
    public IBoomboxSong getVictoryMusic() {
        return victoryMusic;
    }

    public CasinoGameMode setVictoryMusic(IBoomboxSong victoryMusic) {
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

    public CasinoGameMode setBonusCommandsToDispatch(List<String> bonusCommandsToDispatch) {
        this.bonusCommandsToDispatch = bonusCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpBonusURL() {
        return httpBonusURL;
    }

    public CasinoGameMode setHttpBonusURL(String httpBonusURL) {
        this.httpBonusURL = httpBonusURL;
        return this;
    }


    @Nullable
    public String getHttpBonusMethod() {
        return httpBonusMethod;
    }

    public CasinoGameMode setHttpBonusMethod(String httpBonusMethod) {
        this.httpBonusMethod = httpBonusMethod;
        return this;
    }


    @Nonnull
    public Map<String, Object> getHttpBonusHeaders() {
        return httpBonusHeaders;
    }

    public CasinoGameMode setHttpBonusHeaders(Map<String, Object> httpBonusHeaders) {
        this.httpBonusHeaders = httpBonusHeaders;
        return this;
    }


    @Nullable
    public IBoomboxSong getBonusMusic() {
        return bonusMusic;
    }

    public CasinoGameMode setBonusMusic(IBoomboxSong bonusMusic) {
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

    public CasinoGameMode setDefeatCommandsToDispatch(List<String> defeatCommandsToDispatch) {
        this.defeatCommandsToDispatch = defeatCommandsToDispatch;
        return this;
    }


    @Nullable
    public String getHttpDefeatURL() {
        return httpDefeatURL;
    }

    public CasinoGameMode setHttpDefeatURL(String httpDefeatURL) {
        this.httpDefeatURL = httpDefeatURL;
        return this;
    }


    @Nullable
    public String getHttpDefeatMethod() {
        return httpDefeatMethod;
    }

    public CasinoGameMode setHttpDefeatMethod(String httpDefeatMethod) {
        this.httpDefeatMethod = httpDefeatMethod;
        return this;
    }


    @Nonnull
    public Map<String, Object> getHttpDefeatHeaders() {
        return httpDefeatHeaders;
    }

    public CasinoGameMode setHttpDefeatHeaders(Map<String, Object> httpDefeatHeaders) {
        this.httpDefeatHeaders = httpDefeatHeaders;
        return this;
    }


    @Nullable
    public IBoomboxSong getDefeatMusic() {
        return defeatMusic;
    }

    public CasinoGameMode setDefeatMusic(IBoomboxSong defeatMusic) {
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

    public CasinoGameMode setMoneyBetSlots(List<Integer> moneyBetSlots) {
        this.moneyBetSlots = moneyBetSlots;
        return this;
    }


    @Nullable
    public ItemStack getMoneyBetItem() {
        return moneyBetItem;
    }

    public CasinoGameMode setMoneyBetItem(ItemStack moneyBetItem) {
        this.moneyBetItem = moneyBetItem;
        return this;
    }


    @Nullable
    public String getMoneyBetItemTitle() {
        return moneyBetItemTitle;
    }

    public CasinoGameMode setMoneyBetItemTitle(String moneyBetItemTitle) {
        this.moneyBetItemTitle = moneyBetItemTitle;
        return this;
    }


    @Nonnull
    public List<String> getMoneyBetItemLore() {
        return moneyBetItemLore;
    }

    public CasinoGameMode setMoneyBetItemLore(List<String> moneyBetItemLore) {
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

    public CasinoGameMode setSpotSlots(List<Integer> spotSlots) {
        this.spotSlots = spotSlots;
        return this;
    }


    @Nullable
    public ItemStack getSpotItem() {
        return spotItem;
    }

    public CasinoGameMode setSpotItem(ItemStack spotItem) {
        this.spotItem = spotItem;
        return this;
    }


    @Nonnull
    public List<Integer> getLeverSlots() {
        return leverSlots;
    }

    public CasinoGameMode setLeverSlots(List<Integer> leverSlots) {
        this.leverSlots = leverSlots;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemInactive() {
        return leverItemInactive;
    }

    public CasinoGameMode setLeverItemInactive(ItemStack leverItemInactive) {
        this.leverItemInactive = leverItemInactive;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemActive() {
        return leverItemActive;
    }

    public CasinoGameMode setLeverItemActive(ItemStack leverItemActive) {
        this.leverItemActive = leverItemActive;
        return this;
    }


    @Nullable
    public ItemStack getLeverItemRolling() {
        return leverItemRolling;
    }

    public CasinoGameMode setLeverItemRolling(ItemStack leverItemRolling) {
        this.leverItemRolling = leverItemRolling;
        return this;
    }


    @Nonnull
    public IBoomboxSong getBackgroundMusic() {
        return backgroundMusic;
    }

    public CasinoGameMode setBackgroundMusic(IBoomboxSong backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
        return this;
    }


    @Nonnull
    public List<Integer> getMusicButtonSlots() {
        return musicButtonSlots;
    }

    public CasinoGameMode setMusicButtonSlots(List<Integer> musicButtonSlots) {
        this.musicButtonSlots = musicButtonSlots;
        return this;
    }


    @Nullable
    public ItemStack getMusicButtonInactive() {
        return musicButtonInactive;
    }

    public CasinoGameMode setMusicButtonInactive(ItemStack musicButtonInactive) {
        this.musicButtonInactive = musicButtonInactive;
        return this;
    }


    @Nullable
    public ItemStack getMusicButtonActive() {
        return musicButtonActive;
    }

    public CasinoGameMode setMusicButtonActive(ItemStack musicButtonActive) {
        this.musicButtonActive = musicButtonActive;
        return this;
    }


    @Nullable
    public String getMusicButtonActiveTitle() {
        return musicButtonActiveTitle;
    }

    public CasinoGameMode setMusicButtonActiveTitle(String musicButtonActiveTitle) {
        this.musicButtonActiveTitle = musicButtonActiveTitle;
        return this;
    }


    @Nonnull
    public Map<Integer, ItemStack> getEmptySlots() {
        return emptySlots;
    }

    public CasinoGameMode setEmptySlots(Map<Integer, ItemStack> emptySlots) {
        this.emptySlots = emptySlots;
        return this;
    }


}
