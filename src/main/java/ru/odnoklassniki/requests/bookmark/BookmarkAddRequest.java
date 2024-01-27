package ru.odnoklassniki.requests.bookmark;

import ru.odnoklassniki.common.ApiMethod;
import ru.odnoklassniki.common.BookmarkField;
import ru.odnoklassniki.requests.ApiRequest;
import ru.odnoklassniki.requests.ApiRequestConstants;

/**
 * @author
 * @created
 * Запрос на выполнение метода users.getCurrentUser
 * Документация https://apiok.ru/dev/methods/rest/bookmark/bookmark.add
 */
public class BookmarkAddRequest extends ApiRequest {
    public BookmarkAddRequest() {
        this.setApiMethod(ApiMethod.ADD);
    }

    public BookmarkAddRequest(BookmarkField[] bookmarkFields) {
        this.setApiMethod(ApiMethod.ADD).addParam(ApiRequestConstants.FIELDS_PARAM,bookmarkFields);
    }
}
