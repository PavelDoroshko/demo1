package com.example.demo.util;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HttpHeadersUtil {
    public static HttpHeaders getAttachHeaders(String name) {
        return getFileHeaders(name, "attachment");
    }

    public static HttpHeaders getInlineHeaders(String name) {
        return getFileHeaders(name, "inline");
    }

    private static HttpHeaders getFileHeaders(String name, String type) {
        HttpHeaders responseHeaders = new HttpHeaders();
        ContentDisposition contentDisposition = ContentDisposition
                .builder(type)
                .filename(name, StandardCharsets.UTF_8)
                .build();
        responseHeaders.setContentDisposition(contentDisposition);
        responseHeaders.add("X-Filename", URLEncoder.encode(name, StandardCharsets.UTF_8));
        return responseHeaders;
    }
}
