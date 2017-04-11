package ru.rtlabs.rowmapper;

import ru.rtlabs.Entity.Indiv;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndivRowMapper extends CommonRowMapper<Indiv> {

    @Override
    public Indiv mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Indiv query = new Indiv();
        query.setId(getInteger(rs, "id"));
        query.setSurname(getString(rs, "surname"));
        query.setName(getString(rs, "name"));
        query.setPatrName(getString(rs, "patr_name"));
        query.setbDate(getDate(rs, "birth_dt"));
        return query;

    }
}
