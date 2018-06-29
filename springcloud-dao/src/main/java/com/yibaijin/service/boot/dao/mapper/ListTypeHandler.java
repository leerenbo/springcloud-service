package com.yibaijin.service.boot.dao.mapper;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import javax.sql.rowset.serial.SerialArray;
import java.sql.*;
import java.util.List;

public class ListTypeHandler extends BaseTypeHandler<List> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List parameter, JdbcType jdbcType) throws SQLException {
        Array array = ps.getConnection().createArrayOf("NUMERIC", parameter.toArray());
        ps.setArray(i, array);
    }

    @Override
    public List getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public List getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public List getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
