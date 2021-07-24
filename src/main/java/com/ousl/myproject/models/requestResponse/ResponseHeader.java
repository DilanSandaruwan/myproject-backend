package com.ousl.myproject.models.requestResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseHeader {
    private int resultCode;
    private String resultDescription;
}
