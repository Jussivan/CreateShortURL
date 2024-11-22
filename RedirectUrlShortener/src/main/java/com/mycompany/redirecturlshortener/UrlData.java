package com.mycompany.redirecturlshortener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UrlData {
    private String originalUrl;
    private long expirationTime;
}