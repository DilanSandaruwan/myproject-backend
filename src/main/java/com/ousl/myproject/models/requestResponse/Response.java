package com.ousl.myproject.models.requestResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Response {
    private ResponseHeader responseHeader;
    private ResponseBody responseBody;


}
