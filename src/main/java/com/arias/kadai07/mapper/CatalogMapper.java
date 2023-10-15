package com.arias.kadai07.mapper;

import com.arias.kadai07.entity.Catalog_List;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CatalogMapper {

    @Select("SELECT * FROM catalog_list")
    List<Catalog_List> findAll();

    @Insert({
            "<script>",
            "INSERT INTO catalog_list (productName, productPrice, productStock) VALUES ",
            "<foreach collection='list' item='item' separator=','>",
            "  (#{item.productName}, #{item.productPrice}, #{item.productStock})",
            "</foreach>",
            "</script>"
    })
    int insert(@Param("list") List<Catalog_List> catalogList);

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
}
