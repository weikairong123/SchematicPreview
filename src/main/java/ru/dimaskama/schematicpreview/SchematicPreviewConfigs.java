package ru.dimaskama.schematicpreview;

import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigDouble;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.config.options.ConfigInteger;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;

import java.io.File;

public class SchematicPreviewConfigs implements IConfigHandler {
    public static final String CONFIG_FILE_NAME = "schematicpreview.json";

    public static ConfigBoolean SCHEMATICPREVIEW_ENABLED;
    public static ConfigHotkey CONFIG_MENU_HOTKEY;

    public static ConfigInteger ENTRY_GAP_X;
    public static ConfigInteger ENTRY_GAP_Y;
    public static ConfigInteger PREVIEW_MAX_VOLUME;
    public static ConfigBoolean RENDER_TILE;
    public static ConfigDouble PREVIEW_FOV;
    public static ConfigDouble PREVIEW_ROTATION_Y;
    public static ConfigDouble PREVIEW_ROTATION_X;

    static {
        SCHEMATICPREVIEW_ENABLED = new ConfigBoolean("schematicpreviewEnabled", true,
                "config.comment.schematicpreviewEnabled",
                "config.comment.schematicpreviewEnabled");

        CONFIG_MENU_HOTKEY = new ConfigHotkey("schematicpreviewConfigMenuHotkey", "",
                "config.comment.schematicpreviewConfigMenuHotkey",
                "config.comment.schematicpreviewConfigMenuHotkey");

        ENTRY_GAP_X = new ConfigInteger("schematicpreviewEntryGapX", 2, 0, 200,
                "config.comment.schematicpreviewEntryGapX",
                "config.comment.schematicpreviewEntryGapX");

        ENTRY_GAP_Y = new ConfigInteger("schematicpreviewEntryGapY", 2, 0, 200,
                "config.comment.schematicpreviewEntryGapY",
                "config.comment.schematicpreviewEntryGapY");

        PREVIEW_MAX_VOLUME = new ConfigInteger("schematicpreviewMaxVolume", 100000, 0, Integer.MAX_VALUE,
                "config.comment.schematicpreviewMaxVolume",
                "config.comment.schematicpreviewMaxVolume");

        RENDER_TILE = new ConfigBoolean("schematicpreviewRenderTile", true,
                "config.comment.schematicpreviewRenderTile",
                "config.comment.schematicpreviewRenderTile");

        PREVIEW_FOV = new ConfigDouble("schematicpreviewFov", 70.0D, 10.0D, 170.0D,
                "config.comment.schematicpreviewFov",
                "config.comment.schematicpreviewFov");

        PREVIEW_ROTATION_Y = new ConfigDouble("schematicpreviewRotationY", 45.0D, -180.0D, 180.0D,
                "config.comment.schematicpreviewRotationY",
                "config.comment.schematicpreviewRotationY");

        PREVIEW_ROTATION_X = new ConfigDouble("schematicpreviewRotationX", 30.0D, -90.0D, 90.0D,
                "config.comment.schematicpreviewRotationX",
                "config.comment.schematicpreviewRotationX");
    }

    public static void load() {
        File configFile = FileUtils.getConfigFile(CONFIG_FILE_NAME);
        if (configFile.exists()) {
            fi.dy.masa.malilib.config.ConfigUtils.loadConfig(configFile, SchematicPreviewConfigs.class);
        }
    }

    public static void save() {
        File configFile = FileUtils.getConfigFile(CONFIG_FILE_NAME);
        fi.dy.masa.malilib.config.ConfigUtils.saveConfig(configFile, SchematicPreviewConfigs.class);
    }

    @Override
    public void loadFromFile() {
        load();
    }

    @Override
    public void saveToFile() {
        save();
    }
}
