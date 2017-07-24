package com.adelmo.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by znb on 17-7-24.
 */

@Repository
public class ContractRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ContractRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Contract> findAll() {
        String sql = "select id,firstName,lastName,phoneName,emailAddress from contacts order by lastName";
        return jdbcTemplate.query(sql, new RowMapper<Contract>() {
            @Override
            public Contract mapRow(ResultSet resultSet, int i) throws SQLException {
                Contract contract = new Contract();
                contract.setId(resultSet.getLong(1));
                contract.setFirstName(resultSet.getString(2));
                contract.setLastName(resultSet.getString(3));
                contract.setPhoneName(resultSet.getString(4));
                contract.setEmailAddress(resultSet.getString(5));
                return contract;
            }
        });
    }
}
