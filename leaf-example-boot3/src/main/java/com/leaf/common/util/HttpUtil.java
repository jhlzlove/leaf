package com.leaf.common.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

/**
 * @author: jhlz
 * @since: 2022/12/14 19:59:03
 */
public class HttpUtil {

    public static String get(String url) {
        return get(url, null);
    }

    public static String get(String url, Map<String, String> headers) {
        HttpRequest request = buildGetRequest(url, headers);

        try {
            return HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAsync(String url) {
        return getAsync(url, null);
    }

    public static String getAsync(String url, Map<String, String> headers) {
        HttpRequest request = buildGetRequest(url, headers);
        try {
            return HttpClient.newHttpClient()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .get().body();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static String post(String url, Map<String, String> headers) {
        HttpRequest request = buildPostRequest(url, headers);

        try {
            return HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构建 get 请求
     *
     * @param url     url 字符串
     * @param headers 请求头信息
     * @return
     */
    private static HttpRequest buildGetRequest(String url, Map<String, String> headers) {
        Objects.requireNonNull(url, "url 不能为 null！");
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        // 设置请求头
        Optional.ofNullable(headers).ifPresent((h) -> {
            for (Map.Entry<String, String> header : h.entrySet()) {
                builder.setHeader(header.getKey(), header.getValue());
            }
        });
        // 构建请求
        return builder
                .uri(URI.create(url)).GET()
                .build();
    }

    private static HttpRequest buildGetRequest(String url, String... headers) {
        Objects.requireNonNull(url, "url 不能为 null！");
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        // 设置请求头
        Optional.ofNullable(headers).ifPresent((h) -> {
            builder.headers(h);
        });
        // 构建请求
        return builder
                .uri(URI.create(url)).GET()
                .build();
    }

    /**
     * 构建 post 请求
     *
     * @param url     url 字符串
     * @param headers 请求头信息
     * @return
     */
    private static HttpRequest buildPostRequest(String url, Map<String, String> headers) {
        Objects.requireNonNull(url, "url 不能为 null！");
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        // 设置请求头
        Optional.ofNullable(headers).ifPresent((h) -> {
            for (Map.Entry<String, String> header : h.entrySet()) {
                builder.setHeader(header.getKey(), header.getValue());
            }
        });

        // 构建请求
        return builder.uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
    }

    private static HttpRequest buildPostRequest(String url, String... headers) {
        Objects.requireNonNull(url, "url 不能为 null！");
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        // 设置请求头
        Optional.ofNullable(headers).ifPresent((h) -> {
            builder.headers(h);
        });
        // 构建请求
        return builder.uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
    }
}
