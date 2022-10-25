package com.nhnacademy.sevlet2;

import java.util.Arrays;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
    private CookieUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Cookie getCookie(HttpServletRequest req, String name) {
        return Optional.ofNullable(req.getCookies())
            .flatMap(cookies -> Arrays.stream(cookies)
                .filter(c -> c.getName().equals(name))
                .findFirst())
            .orElse(null);
    }

}
