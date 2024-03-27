package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class Dictionary implements Serializable {
    @Serial
    private static final long serialVersionUID = 123456789L; // Custom serial version UID
    private String uuid;
    private String word;
    private String description;

    public Dictionary() {
    }

    public Dictionary(String uuid, String word, String description) {
        this.uuid = uuid;
        this.word = word;
        this.description = description;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "uuid='" + uuid + '\'' +
                ", word='" + word + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

