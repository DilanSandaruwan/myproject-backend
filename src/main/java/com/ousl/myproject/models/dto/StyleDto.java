package com.ousl.myproject.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ousl.myproject.models.enumModels.StyleStatus;
import com.ousl.myproject.models.enumModels.StyleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StyleDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private String styleNo;
    private String styleName;
    private Long styleQty;

    @Enumerated(EnumType.STRING)
    private StyleStatus styleStatus;
    @Enumerated(EnumType.STRING)
    private StyleType styleType;

    private String category;
    private String itemCode;
    private Long consumption;





}
