package com.wmf.homework.dto;

import com.wmf.homework.domain.HtmlType;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParseRequestDto {

    @NotBlank(message = "url은 필수 값입니다.")
    private String url;

    @NotNull(message = "Type 값은 필수입니다.")
    private HtmlType type;

    @Min(value = 1, message = "출력묶음단위(자연수) 를 입력해주세요.")
    private Integer unitCount;
}
