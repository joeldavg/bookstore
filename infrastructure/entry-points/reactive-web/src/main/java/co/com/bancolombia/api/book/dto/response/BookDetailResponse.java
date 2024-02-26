package co.com.bancolombia.api.book.dto.response;

public record BookDetailResponse(
        long id,
        String title,
        String subtitle,
        String authors,
        String publisher,
        int pages,
        int year,
        byte rating,
        String desc,
        float price,
        String image,
        String url) {
}
