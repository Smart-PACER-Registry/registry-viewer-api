package io.swagger.dbo;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.model.Category;
import io.swagger.model.Coding;
import io.swagger.model.Content;
import io.swagger.model.Value;

public class CaseDataRowMapper implements RowMapper<Content> {
    private Integer caseId;
    private Integer personId;
    private Map<Integer, Category> categoryConceptMap;

    public CaseDataRowMapper() {
    }
    
    public CaseDataRowMapper(Map<Integer, Category> categoryConceptMap) {
        this.categoryConceptMap = categoryConceptMap;
    }

    public Integer getCaseId() {
        return this.caseId;
    }

    public Integer getPersonId() {
        return this.personId;
    }

    public void setCategoryConceptMap(Map<Integer, Category> categoryConceptMap) {
        this.categoryConceptMap = categoryConceptMap;
    }

    private Value constructValue(String[] derivedValues) {
        Value value = new Value();
        if (derivedValues.length == 3) {
            Coding coding = new Coding();
            coding.setSystem(derivedValues[0]);
            coding.setCode(derivedValues[1]);
            coding.setDisplay(derivedValues[2]);
            value.setCoding(coding);
        } else if (derivedValues.length > 3) {
            Coding coding = new Coding();
            coding.setSystem(derivedValues[1]);
            coding.setCode(derivedValues[2]);
            coding.setDisplay(derivedValues[3]);
            value.setCoding(coding);
        } else {
            value.setValue(derivedValues[0]);
        }

        if (derivedValues.length == 5) {
            value.setValue(derivedValues[3]);
            value.setUnit(derivedValues[4]);
        }

        return value;
    }

    @Override
    public Content mapRow(ResultSet rs, int rowNum) throws SQLException {
        Content content = new Content();

        content.setContentId(rs.getInt("ObservationId"));
        content.setQuestion(rs.getString("ObservationConceptName"));

        Date date = rs.getDate("Date");
        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat(StdDateFormat.DATE_FORMAT_STR_ISO8601);
            String value = dateFormat.format(date);

            content.setDate(value);
        }

        // get derived value. Format defined in
        // https://github.gatech.edu/HDAP/SmartPacer-RC-API-FORMS/wiki/RC-API-Client 
        String obsValue = rs.getString("DerivedValue");
        String[] derivedValues = obsValue.split("\\^");
        if (derivedValues.length > 3) {
            // first one is timestamp. Override the date in the observation.date.
            content.setDate(derivedValues[0]);
        }

        Value value = constructValue(derivedValues);
        content.setDerivedValue(value);

        obsValue = rs.getString("SourceValue");
        derivedValues = obsValue.split("\\^");
        value = constructValue(derivedValues);
        content.setSourceValue(value);

        // Get section and category from conceptId
        Category category = categoryConceptMap.get(rs.getInt("ObservationConceptId"));
        content.setSection(category.getSection());
        content.setCategory(category.getCategory());

        return content;
    }
    
}