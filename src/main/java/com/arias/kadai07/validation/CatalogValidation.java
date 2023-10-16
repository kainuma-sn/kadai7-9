package com.arias.kadai07.validation;

import com.arias.kadai07.Exception.MyCustomDataAccessException;
import com.arias.kadai07.entity.Catalog_List;

import java.util.List;

public class CatalogValidation {

    public void checkNullorEmptyCatalog(List<Catalog_List> catalogList) {
        if (catalogList == null || catalogList.isEmpty()) {
            throw new MyCustomDataAccessException("カタログリストが空です。データを提供してください。");
        }

        for (Catalog_List catalog : catalogList) {
            if (catalog == null || catalog.getProductName() == null || catalog.getProductName().isEmpty()) {
                throw new MyCustomDataAccessException("カタログの名前が空またはnullです。正しいデータを提供してください。");
            }
            // 他のバリデーションルールも追加できます
        }
    }
}
