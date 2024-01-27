package ru.odnoklassniki.services;

import ru.odnoklassniki.ApiClient;
import ru.odnoklassniki.common.ApiException;
import ru.odnoklassniki.requests.bookmark.BookmarkAddRequest;
import ru.odnoklassniki.responses.bookmark.BookmarkAddResponse;

/**
 * @author
 * @created
 * Сервис для выполнения методов группы bookmark: https://apiok.ru/dev/methods/rest/bookmark/
 */
public class BookmarkService {
    private ApiClient apiClient;

    BookmarkService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Получение информации о закладке
     */
    public BookmarkAddResponse add(String refID, String bookmarkType) throws ApiException {
        BookmarkAddRequest addRequest = new BookmarkAddRequest();
        return apiClient.executeRequest(addRequest, BookmarkAddResponse.class);
    }
}
