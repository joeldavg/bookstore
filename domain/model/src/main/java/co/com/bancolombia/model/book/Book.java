package co.com.bancolombia.model.book;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Book {

    private String title;
    private String subtitle;
    private String authors;
    private String publisher;
    private String id;
    private String pages;
    private String year;
    private String rating;
    private String desc;
    private String price;
    private String image;
    private String url;

}
