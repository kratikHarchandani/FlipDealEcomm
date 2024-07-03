package com.flipdeal_ecommerce.flipdeal_ecomm.utils;


import okhttp3.OkHttpClient;


import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import okhttp3.Headers;

import okhttp3.Request;
import okhttp3.Request.Builder;


public class HttpCaller {
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();


    private static String makeHttpCall(Request request) throws IOException {
        return HTTP_CLIENT
                .newCall(request)
                .execute()
                .body()
                .string();
    }

    private static Request.Builder makeBuilderWith(String url, Map<String, String> headers) {
        Builder builder = new Builder().url(url);
        Optional.ofNullable(headers).ifPresent(v -> builder.headers(Headers.of(headers)));
        return builder;
    }

    public static String get(String url, Map<String, String> headers) throws IOException {
        Request request = makeBuilderWith(url, headers)
                .get()
                .build();
        return makeHttpCall(request);
    }
}
