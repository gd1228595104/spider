package com.example.sptiledemo.dao;

import com.example.sptiledemo.bean.QCPage;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QcspiterMapper {
    /**
     * 批量插入数据
     * @param list
     * @return
     */
    int save(@Param("list") List<QCPage> list);
    /**
     * 分页查找全部信息
     */
    Page<QCPage> selectAll();
    /**
     * 查找表的记录数
     */
    int selectCount();
}
