package com.ousl.myproject.services;

import com.ousl.myproject.models.dto.StyleDto;
import com.ousl.myproject.models.requestResponse.Response;

public interface StyleService {
    Response getAllStyles();
    Response createStyle(StyleDto[] newStyle);
    Response deleteStyle(StyleDto styleDto);
}
