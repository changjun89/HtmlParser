package com.wmf.homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmf.homework.domain.HtmlType;
import com.wmf.homework.domain.ParsingResult;
import com.wmf.homework.dto.ParseRequestDto;
import com.wmf.homework.service.HtmlParseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HtmlParserController.class)
class HtmlParserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HtmlParseService parseService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void requestWithValidData() throws Exception {
        ParseRequestDto request = ParseRequestDto.builder()
                .url("http://wemakeprice.co.kr")
                .type(HtmlType.FULL_HTML)
                .unitCount(5)
                .build();

        ParsingResult result = new ParsingResult("abc","123").divideCharacter(5);

        given(parseService.parse(any(),any(),any())).willReturn(result);

        mockMvc.perform(post("/api/parse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void requestWithInValidData() throws Exception {
        ParseRequestDto request = ParseRequestDto.builder()
                .url("")
                .type(HtmlType.FULL_HTML)
                .unitCount(0)
                .build();

        mockMvc.perform(post("/api/parse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}