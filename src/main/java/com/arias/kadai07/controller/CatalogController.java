package com.arias.kadai07.controller;

import com.arias.kadai07.entity.Catalog_List;
import com.arias.kadai07.service.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {
    //依存性注入
    private final CatalogServiceImpl catalogServiceImpl;

    //コンストラクタ
    @Autowired
    public CatalogController(CatalogServiceImpl catalogServiceImpl) {
        this.catalogServiceImpl = catalogServiceImpl;
    }

    //データベースから全てのデータを取得する
    public List<Catalog_List> findAll() {
        return catalogServiceImpl.findAll();
    }

    //データベースにデータを登録する
    @PostMapping("/insert")
    public String insert(@RequestBody List<Catalog_List> catalogList) {
        catalogServiceImpl.insert(catalogList);
        return "データベースに登録しました。";
    }

    //データベースのデータを更新する
    @PatchMapping("/update")
    public String update(@RequestBody List<Catalog_List> catalogList) {
        catalogServiceImpl.update(catalogList);
        return "データベースを更新しました。";
    }

    //データベースからデータを削除する
    @DeleteMapping("/delete")
    public String delete(@RequestBody int id) {
        catalogServiceImpl.delete(id);
        return "データベースから削除しました。";
    }
}

