package com.arias.kadai07.validation;

import com.arias.kadai07.entity.Catalog_List;
import com.arias.kadai07.exception.nullOrEmptyException;

import java.util.List;

public class CatalogValidation {

    public void checkNullorEmptyCatalog(List<Catalog_List> catalogList) {
        // カタログリストがnull又は空の場合、例外をスローする
        if (catalogList == null || catalogList.isEmpty()) {
            throw new nullOrEmptyException("カタログリストが空です。データを提供してください。");
        }

        // カタログリストの中身がnull又は空の場合、例外をスローする
        for (Catalog_List catalog : catalogList) {
            if (catalog == null || catalog.getProductName() == null || catalog.getProductName().isEmpty()) {
                throw new nullOrEmptyException("カタログの名前が空またはnullです。正しいデータを提供してください。");
            }
        }
    }
}
