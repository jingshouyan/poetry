package com.github.jingshouyan.peotry.dto;

import lombok.Data;

import java.util.List;

/**
 * @author jingshouyan
 * #date 2019/2/15 21:05
 */

@Data
public class PoetDTO {
    private String author;
    private String title;
    private List<String> paragraphs;
    private List<String> strains;
}
