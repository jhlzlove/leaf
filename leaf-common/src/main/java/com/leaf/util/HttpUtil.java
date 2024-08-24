package com.leaf.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/**
 * 基于 JDK 的网络小工具
 *
 * @author jhlz
 * @version 1.0.0
 */
public class HttpUtil {

    public static String get(String url) {
        try {
            return HttpClient.newHttpClient()
                    .send(HttpRequest.newBuilder(URI.create(url)).GET().build(),
                            HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String get(String url, Map<String, String> headers) {
        HttpRequest request = buildGetRequest(url, headers, null);

        try {
            return HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String get(String url, String... headers) {
        HttpRequest request = buildGetRequest(url, null, headers);

        try {
            return HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构建 GET 请求
     *
     * @param url
     * @param headers
     * @param headerStr
     * @return
     */
    private static HttpRequest buildGetRequest(String url,
                                               Map<String, String> headers,
                                               String[] headerStr) {
        Objects.requireNonNull(url, "url must not be null!");
        HttpRequest.Builder builder = HttpRequest.newBuilder().GET();
        if (!Objects.isNull(headers)) headers.forEach(builder::setHeader);
        if (!Objects.isNull(headerStr)) builder.headers(headerStr);
        return builder.build();
    }

    public static String getAsync(String url, Map<String, String> headers) {
        HttpRequest request = buildGetRequest(url, headers, null);
        try {
            return HttpClient.newHttpClient()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .get().body();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAsync(String url, String... headers) {
        HttpRequest request = buildGetRequest(url, null, headers);
        try {
            return HttpClient.newHttpClient()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .get().body();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAsync(String url) {
        HttpRequest request = buildGetRequest(url, null, null);
        try {
            return HttpClient.newHttpClient()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .get().body();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
