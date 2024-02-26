package co.com.bancolombia.r2dbc.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "books")
public class BookEntity {

    @Id
    @Column(value = "id")
    private Long id;
    @Column(value = "title")
    private String title;
    @Column(value = "subtitle")
    private String subtitle;
    @Column(value = "authors")
    private String authors;
    @Column(value = "publisher")
    private String publisher;
    @Column(value = "pages")
    private int pages;
    @Column(value = "year")
    private int year;
    @Column(value = "rating")
    private byte rating;
    @Column(value = "description")
    private String desc;
    @Column(value = "price")
    private float price;
    @Column(value = "image")
    private String image;
    @Column(value = "url")
    private String url;

}
