package com.book.bookmanagementt.model;

import com.book.bookmanagementt.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank
    private String bookname;

    @NotNull
    @NotBlank
    private String author;

    @NotNull
    private int price;

    @ManyToOne
    @JoinColumn(name = "Cid")
    private Category category;

}
