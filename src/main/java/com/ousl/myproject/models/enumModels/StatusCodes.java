package com.ousl.myproject.models.enumModels;


public enum StatusCodes {
    SUCCESS(100),
    NOT_FOUND(404),
    INTERNAL_ERROR(500);

    public int value;

    StatusCodes(int value){
        this.value = value;
    }

}
