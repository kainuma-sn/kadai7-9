package com.arias.kadai07.service;

import com.arias.kadai07.entity.Catalog_List;
import com.arias.kadai07.exception.CatalogDataAccessException;
import com.arias.kadai07.exception.CatalogNotFoundException;
import com.arias.kadai07.mapper.CatalogMapper;
import com.arias.kadai07.validation.CatalogValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

//CatalogServiceImpl implements NameServiceを１つのbeanとしてDIコンテナに格納する。格納したクラスはbeanと呼ばれる。
@Service
public class CatalogServiceImpl implements CatalogService {

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
            if (!result.isEmpty()) {
                return result;
            } else {
                throw new CatalogNotFoundException("catalog not found"); //データが見つからないエラーをスローする
            }
        } catch (DataAccessException ex) {
            // データベースアクセスに関連する例外をキャッチする
            logger.error("データベースからデータの取得中にエラーが発生しました", ex);
            throw new CatalogDataAccessException("申し訳ありません、現在サーバーで問題が発生しています。", ex);
        }
    }

    //データベースにデータを登録する
    public void insert(List<Catalog_List> catalogList) {
        try {
            // ユーザーが入力したデータにnull又は空白かどうかバリデーションを実行
            catalogValidation.checkNullorEmptyCatalog(catalogList);
            //データベースにデータを登録
            catalogMapper.insert(catalogList);
        } catch (DataAccessException ex) {
            // データベースアクセスに関連する例外をキャッチする
            logger.error("データベースにデータの登録中にエラーが発生しました", ex);
            throw new CatalogDataAccessException("申し訳ありません、現在サーバーで問題が発生しています。", ex);
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
            throw new CatalogDataAccessException("申し訳ありません、現在サーバーで問題が発生しています。", ex);
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
            throw new CatalogDataAccessException("申し訳ありません、現在サーバーで問題が発生しています。", ex);
        }
    }

    //データベースから商品名を検索する
    public List<Catalog_List> search(String productName) {
        try {
            // データベースから検索したデータを取得
            List<Catalog_List> result = catalogMapper.search(productName);
            if (!result.isEmpty()) {
                return result;
            } else {
                throw new CatalogNotFoundException("catalog not found"); //データが見つからないエラーをスローする
            }
        } catch (DataAccessException ex) {
            // データベースアクセスに関連する例外をキャッチする
            logger.error("データベースからデータの取得中にエラーが発生しました", ex);
            throw new CatalogDataAccessException("申し訳ありません、現在サーバーで問題が発生しています。", ex);
        }
    }
}
