package co.com.bancolombia.r2dbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "subtitle", nullable = false)
    private String subtitle;
    @Column(name = "authors", nullable = false)
    private String authors;
    @Column(name = "publisher", nullable = false)
    private String publisher;
    @Column(name = "pages", nullable = false)
    private int pages;
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "rating", nullable = false)
    private byte rating;
    @Column(name = "description", nullable = false)
    private String desc;
    @Column(name = "price", nullable = false)
    private float price;
    @Column(name = "image", nullable = false)
    private String image;
    @Column(name = "url", nullable = false)
    private String url;

}
