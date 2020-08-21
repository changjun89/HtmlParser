package com.wmf.homework.controller;

import com.wmf.homework.domain.ParsingResult;
import com.wmf.homework.dto.ParseRequestDto;
import com.wmf.homework.dto.ParseResponseDto;
import com.wmf.homework.service.HtmlParseService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class HtmlParserController {

    private final HtmlParseService parseService;

    @PostMapping(value = "/api/parse")
    public ResponseEntity<ParseResponseDto> parse(@RequestBody @Valid ParseRequestDto request, Errors errors) throws Exception {
        if(errors.hasErrors()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        ParsingResult parsingResult = parseService.parse(request.getUrl(), request.getType(), request.getUnitCount());
        String remainder = parsingResult.getRemainder();
        String share = parsingResult.getShare();

        ParseResponseDto result = ParseResponseDto.builder()
                .remainder(remainder)
                .share(share)
                .build();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
