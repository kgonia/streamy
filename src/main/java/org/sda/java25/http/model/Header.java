package org.sda.java25.http.model;

public class Header {

    public Header(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private String key;

    private String value;

    @Override
    public String toString() {
        return "Header{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
