package net.minecraftforge.gradle.common.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RunConfig {
    private String main;
    private Map<String, String> env = new HashMap<>();
    private Map<String, String> props = new HashMap<>();

    public void setEnvironment(Map<String, Object> map) {
        map.forEach((k,v) -> env.put(k, v instanceof File ? ((File)v).getAbsolutePath() : (String)v));
    }
    public void environment(String key, String value) {
        env.put(key, value);
    }
    public void environment(String key, File value) {
        env.put(key, value.getAbsolutePath());
    }
    public Map<String, String> getEnvironment() {
        return env;
    }

    public void setMain(String value) {
        this.main = value;
    }
    public String getMain() {
        return this.main;
    }

    public void setProperties(Map<String, Object> map) {
        map.forEach((k,v) -> props.put(k, v instanceof File ? ((File)v).getAbsolutePath() : (String)v));
    }
    public void property(String key, String value) {
        props.put(key, value);
    }
    public void property(String key, File value) {
        props.put(key, value.getAbsolutePath());
    }
    public Map<String, String> getProperties() {
        return props;
    }
}