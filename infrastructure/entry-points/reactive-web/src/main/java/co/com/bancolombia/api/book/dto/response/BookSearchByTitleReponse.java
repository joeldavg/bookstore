package co.com.bancolombia.api.book.dto.response;

public record BookSearchByTitleReponse(
        long id,
        String title,
        String subtitle,
        float price,
        String image,
        String url) {
}
