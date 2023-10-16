package com.arias.kadai07.service;

import com.arias.kadai07.Exception.MyCustomDataAccessException;
import com.arias.kadai07.entity.Catalog_List;
import com.arias.kadai07.mapper.CatalogMapper;
import com.arias.kadai07.validation.CatalogValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements NameService {

    //依存性注入
    private final CatalogMapper catalogMapper;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final CatalogValidation catalogValidation = new CatalogValidation();

    //コンストラクタ
    CatalogServiceImpl(CatalogMapper catalogMapper) {
        this.catalogMapper = catalogMapper;
    }

    //データベースから全てのデータを取得する
    public List<Catalog_List> findAll() {
        try {
            // データベースからデータを取得
            List<Catalog_List> result = catalogMapper.findAll();

            //取得したデータを返す
            return result;

        } catch (DataAccessException ex) {
            // データベースアクセスに関連する例外をキャッチする
            logger.error("データベースからデータの取得中にエラーが発生しました", ex);

            // 例外をカスタムのエラーメッセージとともに再スローするか、エラーメッセージをユーザーに提供する
            throw new MyCustomDataAccessException("データベースからデータの取得中にエラーが発生しました。詳細情報を提供しました。", ex);
        }
    }

    //データベースにデータを登録する
    public void insert(List<Catalog_List> catalogList) {
        try {
            // バリデーションを実行
            catalogValidation.checkNullorEmptyCatalog(catalogList);

            //データベースにデータを登録
            catalogMapper.insert(catalogList);

        } catch (DataAccessException ex) {
            // データベースアクセスに関連する例外をキャッチする
            logger.error("データベースにデータの登録中にエラーが発生しました", ex);

            // 例外をカスタムのエラーメッセージとともに再スローするか、エラーメッセージをユーザーに提供する
            throw new MyCustomDataAccessException("データベースにデータの登録中にエラーが発生しました。詳細情報を提供しました。", ex);
        }

    }

    //データベースのデータを更新する
//データベースのデータを更新する
    public void update(List<Catalog_List> catalogList) {
        try {
            // データベースのデータを更新
            catalogMapper.update(catalogList);

        } catch (DataAccessException ex) {
            // データベースアクセスに関連する例外をキャッチする
            logger.error("データベースのデータの更新中にエラーが発生しました", ex);

            // 例外をカスタムのエラーメッセージとともに再スローするか、エラーメッセージをユーザーに提供する
            throw new MyCustomDataAccessException("データベースのデータの更新中にエラーが発生しました。詳細情報を提供しました。", ex);
        }
    }

    //データベースからデータを削除する
    public void delete(int id) {
        try {
            // データベースからデータを削除
            catalogMapper.delete(id);

        } catch (DataAccessException ex) {
            // データベースアクセスに関連する例外をキャッチする
            logger.error("データベースからデータの削除中にエラーが発生しました", ex);

            // 例外をカスタムのエラーメッセージとともに再スローするか、エラーメッセージをユーザーに提供する
            throw new MyCustomDataAccessException("データベースからデータの削除中にエラーが発生しました。詳細情報を提供しました。", ex);
        }
    }

    //データベースから商品名を検索する
    public List<Catalog_List> search(String productName) {
        try {
            // データベースからデータを取得
            List<Catalog_List> result = catalogMapper.search(productName);

            //取得したデータを返す
            return result;
            
        } catch (DataAccessException ex) {
            // データベースアクセスに関連する例外をキャッチする
            logger.error("データベースからデータの取得中にエラーが発生しました", ex);

            // 例外をカスタムのエラーメッセージとともに再スローするか、エラーメッセージをユーザーに提供する
            throw new MyCustomDataAccessException("データベースからデータの取得中にエラーが発生しました。詳細情報を提供しました。", ex);
        }
    }
}
