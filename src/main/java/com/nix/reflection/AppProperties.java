package com.nix.reflection;

import com.nix.reflection.annotation.PropertyKey;

public class AppProperties {
    @PropertyKey("lang")
    public String language;

    @PropertyKey("window.mode")
    public String window_mode;

    @PropertyKey("mouse_sensitivity")
    public int mouse_sensitivity;

    @PropertyKey("screen.width")
    public int screen_width;

    @PropertyKey("screen.height")
    public int screen_height;

    @PropertyKey("graphics.texture")
    public String graphics_texture;

    @PropertyKey("graphics.shadow")
    public String graphics_shadow;

    @PropertyKey("vertical_sync")
    public boolean vertical_sync;

    public boolean testField = true;

    @Override
    public String toString() {
        return "AppProperties{" +
                "language='" + language + '\'' +
                ", window_mode='" + window_mode + '\'' +
                ", mouse_sensitivity=" + mouse_sensitivity +
                ", screen_width=" + screen_width +
                ", screen_height=" + screen_height +
                ", graphics_texture='" + graphics_texture + '\'' +
                ", graphics_shadow='" + graphics_shadow + '\'' +
                ", vertical_sync=" + vertical_sync +
                ", testField=" + testField +
                '}';
    }
}
