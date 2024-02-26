package co.com.bancolombia.model.book;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Book {

    private Long id;
    private String title;
    private String subtitle;
    private String authors;
    private String publisher;
    private int pages;
    private int year;
    private byte rating;
    private String desc;
    private float price;
    private String image;
    private String url;

}
