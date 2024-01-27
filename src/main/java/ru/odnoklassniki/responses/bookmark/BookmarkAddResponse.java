package ru.odnoklassniki.responses.bookmark;

import ru.odnoklassniki.responses.ApiResponse;

/**
 * @author
 * @created
 * Результат выполнения метода bookmark.add
 * Документация https://apiok.ru/dev/methods/rest/bookmark/bookmark.add
 */
public class BookmarkAddResponse extends ApiResponse {
    private boolean success;

    public boolean getSuccess() {
        return success;
    }
}