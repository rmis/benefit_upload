
package ru.rtlabs.rowmapper;

import ru.rtlabs.Entity.Indiv;
        import java.sql.ResultSet;
        import java.sql.SQLException;

public class PatientRowMapper extends CommonRowMapper<Indiv> {

    @Override
    public Indiv mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Indiv query = new Indiv();
        query.setId(getInteger(rs, "id"));
        query.setNote(getString(rs, "note"));
        return query;

    }
}