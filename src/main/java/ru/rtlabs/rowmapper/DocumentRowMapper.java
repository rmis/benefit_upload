package ru.rtlabs.rowmapper;

import ru.rtlabs.Entity.Indiv;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by leon4uk on 10.01.17.
 */
public class DocumentRowMapper extends CommonRowMapper<Indiv> {

    @Override
    public Indiv mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Indiv query = new Indiv();
        query.setId(getInteger(rs, "indiv_id"));
        query.setSnils(getString(rs, "number"));
        return query;

    }
}