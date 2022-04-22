package io.swagger.dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.model.Coding;
import io.swagger.model.Detail;

public class DetailsRowMapper implements RowMapper<Detail> {
    private String entity_type;

    public DetailsRowMapper(Integer domainId) {
        if (domainId == 13L) {
            entity_type = "drug_exposure";
        } else if (domainId == 19L) {
            entity_type = "condition_occurrence";
        } else if (domainId == 27L) {
            entity_type = "observation";
        } else if (domainId == 21L) {
            entity_type = "measurement";
        } else if (domainId == 5085L) {
            entity_type = "note";
        } else {
            entity_type = null;
        }
    }

    @Override
    public Detail mapRow(ResultSet rs, int rowNum) throws SQLException {
        Detail detail = new Detail();
        Date startDate = rs.getDate("Date");
        if (startDate != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            String value = dateFormat.format(startDate);

            detail.setDate(value);
        }

        Coding coding = new Coding();
        coding.setSystem(rs.getString("System"));
        coding.setCode(rs.getString("Code"));
        coding.setDisplay(rs.getString("Display"));
        detail.setCoding(coding);

        String value = rs.getString("Value");
        String unit = rs.getString("Unit");
        String etc = rs.getString("Etc");

        if (value != null && (value.trim() == "" || value.trim().isEmpty())) {
            detail.setValue(null);
        } else {
            detail.setValue(value);
        }

        if (unit != null && (unit.trim() == "" || unit.trim().isEmpty())) {
            detail.setUnit(null);
        } else {
            detail.setUnit(unit);
        }

        if (etc != null && (etc.trim() == "" || etc.trim().isEmpty())) {
            detail.setEtc(null);
        } else {
            detail.setEtc(etc);
        }

        return detail;
    }
    
}
