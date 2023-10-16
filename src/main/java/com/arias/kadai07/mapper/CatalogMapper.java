package com.arias.kadai07.mapper;

import com.arias.kadai07.entity.Catalog_List;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CatalogMapper {

    //データベースから全てのデータを取得する
    @Select("SELECT * FROM catalog_list")
    List<Catalog_List> findAll();

    //データベースにデータを登録する
    @Insert({
            "<script>",
            "INSERT INTO catalog_list (productName, productPrice, productStock) VALUES ",
            "<foreach collection='list' item='item' separator=','>",
            "  (#{item.productName}, #{item.productPrice}, #{item.productStock})",
            "</foreach>",
            "</script>"
    })
    int insert(@Param("list") List<Catalog_List> catalogList);

    //データベースのデータを更新する
    @Update({
            "<script>",
            "UPDATE catalog_list SET",
            "<foreach collection='list' item='item' separator=','>",
            "productName = #{item.productName}, productPrice = #{item.productPrice}, productStock = #{item.productStock}",
            "</foreach>",
            "WHERE id IN",
            "<foreach collection='list' item='item' separator=',' open='(' close=')'>",
            "#{item.id}",
            "</foreach>",
            "</script>"
    })
    int update(@Param("list") List<Catalog_List> cataloglist);

    //データベースからデータを削除する
    @Delete("DELETE FROM catalog_list WHERE id = #{id}")
    int delete(int id);

    //データベースから商品名を検索する
    @Select("SELECT * FROM catalog_list WHERE productName LIKE CONCAT('%', #{productName}, '%')")
    List<Catalog_List> search(String productName);

}
