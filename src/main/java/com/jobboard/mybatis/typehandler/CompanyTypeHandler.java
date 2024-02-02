package com.jobboard.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.jobboard.dto.enums.CompanyType;

public class CompanyTypeHandler implements TypeHandler<CompanyType>{

    @Override
    public CompanyType getResult(ResultSet rs, String columnName) throws SQLException {
        return getCode(rs.getInt(columnName));
    }

    @Override
    public CompanyType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return getCode(rs.getInt(columnIndex));
    }

    @Override
    public CompanyType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getCode(cs.getInt(columnIndex));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CompanyType parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    private CompanyType getCode(int code) {
        CompanyType[] enums = CompanyType.values();
        for(CompanyType e: enums){
            if(e.getCode() == code){
                return e;
            }
        }
        return null;
    }
    
}
