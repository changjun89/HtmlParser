package com.wmf.homework.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParseResponseDto {

    private String share;

    private String remainder;
}
