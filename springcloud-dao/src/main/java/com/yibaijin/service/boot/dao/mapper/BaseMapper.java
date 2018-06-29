package com.yibaijin.service.boot.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BaseMapper<MODLE, EXAMPLE> {

    long countByExample(EXAMPLE example);

    int deleteByExample(EXAMPLE example);

    int deleteByPrimaryKey(Long id);

    int insert(MODLE record);

    int insertSelective(MODLE record);

    List<MODLE> selectByExampleWithRowbounds(EXAMPLE example, RowBounds rowBounds);

    List<MODLE> selectByExample(EXAMPLE example);

    MODLE selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MODLE record, @Param("example") EXAMPLE example);

    int updateByExample(@Param("record") MODLE record, @Param("example") EXAMPLE example);

    int updateByPrimaryKeySelective(MODLE record);

    int updateByPrimaryKey(MODLE record);
}
