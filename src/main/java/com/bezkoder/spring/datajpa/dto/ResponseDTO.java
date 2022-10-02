package com.bezkoder.spring.datajpa.dto;

import com.bezkoder.spring.datajpa.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private Integer statusCode;
    private Object content;
}
