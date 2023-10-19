package com.arias.kadai07.service;

import com.arias.kadai07.entity.Catalog_List;

import java.util.List;

public interface CatalogService {
    //データベースから全てのデータを取得する
    public List<Catalog_List> findAll();

    //データベースにデータを登録する
    public void insert(List<Catalog_List> catalogList);

    //データベースのデータを更新する
    public void update(List<Catalog_List> catalogList);

    //データベースからデータを削除する
    public void delete(int id);

    //データベースから商品名を検索する
    public List<Catalog_List> search(String productName);
}
