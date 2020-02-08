package org.sda.java25.http.model;

import java.util.List;
import java.util.stream.Collectors;

public class Request {

    public Request(int size, String path, String payload, String type, List<Header> headers) {
        this.size = size;
        this.path = path;
        this.payload = payload;
        this.type = type;
        this.headers = headers;
    }

    private int size;

    private String path;

    private String payload;

    private List<Header> headers;

    private String type;

    public int getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public String getPayload() {
        return payload;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Request{" +
                "size=" + size +
                ", path='" + path + '\'' +
                ", payload='" + payload + '\'' +
                ", headers=" + (headers != null ? headers.stream().map(Header::toString).collect(Collectors.joining()) : headers) + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
