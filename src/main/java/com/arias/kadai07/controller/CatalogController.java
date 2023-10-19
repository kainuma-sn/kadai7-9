package com.arias.kadai07.controller;

import com.arias.kadai07.entity.Catalog_List;
import com.arias.kadai07.exception.CatalogDataAccessException;
import com.arias.kadai07.exception.CatalogNotFoundException;
import com.arias.kadai07.exception.nullOrEmptyException;
import com.arias.kadai07.service.CatalogServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class CatalogController {
    //依存性注入。beanであるCatalogServiceImplをDIコンテナから取得する。
    private final CatalogServiceImpl catalogServiceImpl;

    //コンストラクタ
    @Autowired //自動でDIコンテナからbeanを取得する
    public CatalogController(CatalogServiceImpl catalogServiceImpl) {
        this.catalogServiceImpl = catalogServiceImpl;
    }

    //カタログリストから全てのデータを取得する
    @GetMapping("/findAll")
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

    //データベースから商品名を検索する
    @GetMapping("/search")
    public List<Catalog_List> search(@RequestParam String productName) {
        return catalogServiceImpl.search(productName);
    }

    //データベース処理中に問題が検出された場合、エラーメッセージを返す
    @ExceptionHandler(value = CatalogDataAccessException.class)
    public ResponseEntity<Map<String, String>> handleCatalogDataAccessException(CatalogDataAccessException ex, HttpServletRequest request) {
        // エラーメッセージを作成
        Map<String, String> errorMap = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), // 404
                "error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "message", ex.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //検索結果が該当しない場合にエラーメッセージを返す
    @ExceptionHandler(value = CatalogNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCatalogNotFoundException(CatalogNotFoundException ex, HttpServletRequest request) {
        // エラーメッセージを作成
        Map<String, String> errorMap = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()), // 404
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", ex.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }

    // 空白又はnullの場合にエラーメッセージを返す
    @ExceptionHandler(value = nullOrEmptyException.class)
    public ResponseEntity<Map<String, String>> handleNullOrEmptyDataAccessException(nullOrEmptyException ex, HttpServletRequest request) {
        // エラーメッセージを作成
        Map<String, String> errorMap = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()), // 400
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", ex.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}

