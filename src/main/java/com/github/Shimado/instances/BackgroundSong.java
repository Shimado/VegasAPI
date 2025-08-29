package com.github.Shimado.instances;

import com.github.Shimado.interfaces.IBoomboxSong;
import com.github.Shimado.nbs.NbsSong;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a background song that can be used in the casino.
 * Music that will be played during a win/loss/jackpot, as well as background music.
 * Implements the {@link IBoomboxSong} interface and provides details such as
 * identifiers, file data, materials, model data, price, permissions, and
 * NBS/OGG song information.
 */

public class BackgroundSong implements IBoomboxSong {

    private String id;
    private int slot = -1;
    private int page = -1;
    private String filename;
    private String soundName;
    private int soundLength = 0;
    private String name;
    private List<String> description = new ArrayList<>();
    private double price = 0.0;
    private String permission = "";
    private String material;
    private int customModelData = 0;
    private String materialActivated;
    private int customModelDataActivated = 0;
    private NbsSong nbsSong;

    /**
     * Gets the unique identifier of the song.
     * ID of the music in the Vegas plugin config, which is specified in the "Music GUI songs:"
     *
     * @return song ID or {@code null} if not set
     */

    @Override
    @Nullable
    public String getID() {
        return id;
    }

    /**
     * Sets the unique identifier of the song.
     * ID of the music in the Vegas plugin config, which is specified in the "Music GUI songs:"
     *
     * @param id song ID
     */

    @Override
    public void setID(String id) {
        this.id = id;
    }


    /**
     * Gets the slot in the music GUI.
     * If not set, or exceeds the menu size, then the icon of this music will not be in the music menu.
     *
     * @return slot number
     */

    public int getSlot() {
        return slot;
    }

    /**
     * Sets the slot in the music GUI.
     *
     * @param slot slot number
     */

    public void setSlot(int slot) {
        this.slot = slot;
    }


    /**
     * Gets the page number in the music GUI.
     * If not set, or exceeds the page size, then the icon of this music will not be in the music menu.
     *
     * @return page number
     */

    public int getPage() {
        return page;
    }

    /**
     * Sets the page number in the music GUI.
     *
     * @param page page number
     */

    public void setPage(int page) {
        this.page = page;
    }


    /**
     * Gets the filename of the song file, which is located in the folder plugins => Vegas => Music
     * WITHOUT .nbs at the end AND GAPS!!!
     *    Wrong: test1.nbs, test 2, test 3.nbs
     *    Correct: test4
     * Only needed for .nbs files.
     *
     * @return filename or {@code null} if not set
     */

    @Override
    @Nullable
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the filename of the song file, which is located in the folder plugins => Vegas => Music
     * WITHOUT .nbs at the end AND GAPS!!!
     *    Wrong: test1.nbs, test 2, test 3.nbs
     *    Correct: test4
     * Only needed for .nbs files.
     *
     * @param filename filename
     */

    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }


    /**
     * Gets the button material in string format. Can be material, can be head URL.
     * Needed to display the music icon when it is not selected.
     *
     * @return material or {@code null} if not set
     */

    @Override
    @Nullable
    public String getMaterialUnPurchased() {
        return material;
    }

    /**
     * Sets the button material in string format. Can be material, can be head URL.
     * Needed to display the music icon when it is not selected.
     *
     * @param material material name
     */

    @Override
    public void setMaterialUnPurchased(String material) {
        this.material = material;
    }


    /**
     * Gets the custom model data for the unpurchased state.
     *
     * @return custom model data value
     */

    @Override
    public int getCustomModelDataUnPurchased() {
        return customModelData;
    }

    /**
     * Sets the custom model data for the unpurchased state.
     *
     * @param customModelData custom model data value
     */

    @Override
    public void setCustomModelDataUnPurchased(int customModelData) {
        this.customModelData = customModelData;
    }


    /**
     * Gets the button material in string format. Can be material, can be head URL.
     * Needed to display the music icon when it is selected.
     *
     * @return material or {@code null} if not set
     */

    @Override
    @Nullable
    public String getMaterialPurchased() {
        return materialActivated;
    }

    /**
     * Sets the button material in string format. Can be material, can be head URL.
     * Needed to display the music icon when it is selected.
     *
     * @param materialActivated material name
     */

    @Override
    public void setMaterialPurchased(String materialActivated) {
        this.materialActivated = materialActivated;
    }


    /**
     * Gets the custom model data for the purchased state.
     *
     * @return custom model data value
     */

    @Override
    public int getCustomModelDataPurchased() {
        return customModelDataActivated;
    }

    /**
     * Sets the custom model data for the purchased state.
     *
     * @param customModelDataActivated custom model data value
     */

    @Override
    public void setCustomModelDataPurchased(int customModelDataActivated) {
        this.customModelDataActivated = customModelDataActivated;
    }


    /**
     * Gets the button material in string format. Can be material, can be head URL.
     * Needed to display the music icon when it is selected.
     *
     * @return material or {@code null} if not set
     */

    @Override
    @Nullable
    public String getMaterialPlaylist() {
        return materialActivated;
    }

    /**
     * Sets the button material in string format. Can be material, can be head URL.
     * Needed to display the music icon when it is selected.
     *
     * @param materialActivated material name
     */

    @Override
    public void setMaterialPlaylist(String materialActivated) {
        this.materialActivated = materialActivated;
    }


    /**
     * Gets the custom model data used in playlists.
     *
     * @return custom model data value
     */

    @Override
    public int getCustomModelDataPlaylist() {
        return customModelDataActivated;
    }

    /**
     * Sets the custom model data used in playlists.
     *
     * @param customModelDataActivated custom model data value
     */

    @Override
    public void setCustomModelDataPlaylist(int customModelDataActivated) {
        this.customModelDataActivated = customModelDataActivated;
    }


    /**
     * Gets the display name of the song icon.
     * If not specified, there will be no icon.
     *
     * @return song name or {@code null} if not set
     */

    @Override
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * Sets the display name of the song icon.
     *
     * @param name song name
     */

    @Override
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the lore of the song icon.
     *
     * @return list of description lines, never {@code null}
     */

    @Override
    @Nonnull
    public List<String> getDescription() {
        return description;
    }

    /**
     * Sets the lore of the song icon.
     *
     * @param description list of description lines
     */

    @Override
    public void setDescription(List<String> description) {
        this.description = description;
    }


    /**
     * Gets the price of the song.
     * Not used in the plugin itself.
     *
     * @return song price
     */

    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the song.
     * Not used in the plugin itself.
     *
     * @param price song price
     */

    @Override
    public void setPrice(double price) {
        this.price = price;
    }


    /**
     * Sets the required permission to use the song.
     *
     * @param permission permission string
     */

    @Override
    @Nonnull
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * Gets the required permission to use the song.
     *
     * @return permission string
     */

    @Override
    public String getPermission() {
        return permission;
    }


    @Override
    public int getOwn() {
        return 0;
    }

    @Override
    public void addOwn() {
    }

    @Override
    public void setOwn(int own) {
    }


    @Override
    public int getAuditions() {
        return 0;
    }

    @Override
    public void addAuditions() {
    }

    @Override
    public void setAuditions(int own) {
    }


    /**
     * Gets the {@link NbsSong} data of this background song.
     * Used by the plugin to play .nbs file.
     *
     * @return NbsSong object or {@code null} if not set
     */

    @Override
    @Nullable
    public NbsSong getNbsSong() {
        return nbsSong;
    }


    /**
     * Sets the {@link NbsSong} data of this background song.
     * Used by the plugin to play .nbs file.
     *
     * @param nbsSong NbsSong object
     */

    @Override
    public void setNbsSong(NbsSong nbsSong) {
        this.nbsSong = nbsSong;
    }


    /**
     * Gets the full name of the song that you will need to specify can be found by entering the /playsound <sound name> command.
     * in the game, and you will be given a list of where you need to find this song!
     *
     * @return sound name or {@code null} if not set
     */

    @Override
    @Nullable
    public String getCustomOggSoundName() {
        return soundName;
    }

    /**
     * Sets the full name of the song that you will need to specify can be found by entering the /playsound <sound name> command.
     * in the game, and you will be given a list of where you need to find this song!
     *
     * @param soundName sound name
     */

    @Override
    public void setCustomOggSoundName(String soundName) {
        this.soundName = soundName;
    }


    /**
     * Gets the length of the OGG sound in seconds.
     * Length of .ogg song in seconds. It is necessary to specify, because Minecraft cannot
     * determine the length of the song from the resource pack on its own.
     * WORKS ONLY WITH RESOURCE PACK WITH CUSTOM .OGG SONGS
     *
     * @return sound length
     */

    @Override
    public int getCustomOggSoundLength() {
        return soundLength;
    }

    /**
     * Sets the length of the OGG sound in seconds.
     * Length of .ogg song in seconds. It is necessary to specify, because Minecraft cannot
     * determine the length of the song from the resource pack on its own.
     * WORKS ONLY WITH RESOURCE PACK WITH CUSTOM .OGG SONGS
     *
     * @param soundLength sound length
     */

    @Override
    public void setCustomOggSoundLength(int soundLength) {
        this.soundLength = soundLength;
    }
}
