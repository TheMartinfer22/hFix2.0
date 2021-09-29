package dev.nanosync.hfix.types;

public enum ConfigType {
    WORLD("worldConfigurations"),
    CHUNK("chunkConfigurations"),
    MOB("mobConfigurations"),
    PLAYER("playerConfigurations");

    private final String fileName;

    ConfigType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
