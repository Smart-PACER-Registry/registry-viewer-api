package io.swagger.dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.model.Coding;
import io.swagger.model.DetailCondition;
import io.swagger.model.DetailMeasurement;
import io.swagger.model.DetailMedication;
import io.swagger.model.DetailNote;
import io.swagger.model.DetailObservation;
import io.swagger.model.OneOfDetailsItems;

public class DetailsRowMapper implements RowMapper<OneOfDetailsItems> {
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
    public OneOfDetailsItems mapRow(ResultSet rs, int rowNum) throws SQLException {
        OneOfDetailsItems retVal = null;

        if ("drug_exposure".equals(entity_type)) {
            DetailMedication detailMed = new DetailMedication();
            Date startDate = rs.getDate("startDate");
            if (startDate != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                String value = dateFormat.format(startDate);
                detailMed.setStartDate(value);
            }

            Date endDate = rs.getDate("endDate");
            if (endDate != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                String value = dateFormat.format(endDate);
                detailMed.setStartDate(value);
            }

            detailMed.setSystem(rs.getString("System"));
            detailMed.setCode(rs.getString("Code"));
            detailMed.setDisplay(rs.getString("Display"));
            detailMed.setRefills(rs.getInt("Refills"));
            detailMed.setQuantity(rs.getInt("Quantity"));
            detailMed.setDaysSupply(rs.getInt("DaysSupply"));
            detailMed.setSig(rs.getString("Sig"));
            detailMed.setRouteSystem(rs.getString("RouteSystem"));
            detailMed.setRouteCode(rs.getString("RouteCode"));
            detailMed.setRouteDisplay(rs.getString("RouteDisplay"));
            detailMed.setLotNumber(rs.getString("LotNumber"));
            detailMed.setTableDisplayText((rs.getString("Display") + " " + 
                rs.getString("Sig")).trim());

            retVal = detailMed;
        } else if ("condition_occurrence".equals(entity_type)) {
            DetailCondition detailCondition = new DetailCondition();
            Date startDate = rs.getDate("startDate");
            if (startDate != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                String value = dateFormat.format(startDate);
                detailCondition.setStartDate(value);
            }

            Date endDate = rs.getDate("endDate");
            if (endDate != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                String value = dateFormat.format(endDate);
                detailCondition.setStartDate(value);
            }

            detailCondition.setSystem(rs.getString("System"));
            detailCondition.setCode(rs.getString("Code"));
            detailCondition.setDisplay(rs.getString("Display"));
            detailCondition.setTableDisplayText(rs.getString("Display"));

            retVal = detailCondition;
        } else if ("observation".equals(entity_type)) {
            DetailObservation detailObservation = new DetailObservation();
            Date date = rs.getDate("Date");
            if (date != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                String value = dateFormat.format(date);
                detailObservation.setDate(value);
            }

            detailObservation.setSystem(rs.getString("System"));
            detailObservation.setCode(rs.getString("Code"));
            detailObservation.setDisplay(rs.getString("Display"));
            
            String valueAsConceptCode = rs.getString("ValueAsConceptCode");
            Double valueAsNumber = rs.getDouble("ValueAsNumber");
            String valueAsString = rs.getString("ValueAsString");
            if (valueAsConceptCode != null && !valueAsConceptCode.isEmpty()) {
                detailObservation.setValue (rs.getString("ValueAsConceptDisplay"));
                detailObservation.setTableDisplayText (
                    rs.getString("Display") + " | " +
                    rs.getString("ValueAsConceptDisplay"));
            } else if (valueAsNumber != null) {
                detailObservation.setValue(String.valueOf(valueAsNumber));
                String tableDispText = rs.getString("Display") + " | " + String.valueOf(valueAsNumber);
                if (rs.getString("Unit") != null) {
                    tableDispText += " " + rs.getString("Unit");
                }
                detailObservation.setTableDisplayText(tableDispText);
            } else if (valueAsString != null && !valueAsString.isEmpty()) {
                detailObservation.setValue(valueAsString);
                detailObservation.setTableDisplayText(rs.getString(("Display") + " | " + valueAsString));
            }

            detailObservation.setUnit(rs.getString("Unit"));

            retVal = detailObservation;
        } else if ("measurement".equals(entity_type)) {
            DetailMeasurement detailMeasurement = new DetailMeasurement();
            Date date = rs.getDate("Date");
            if (date != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                String value = dateFormat.format(date);
                detailMeasurement.setDate(value);
            }

            detailMeasurement.setSystem(rs.getString("System"));
            detailMeasurement.setCode(rs.getString("Code"));
            detailMeasurement.setDisplay(rs.getString("Display"));
            
            String valueAsConceptCode = rs.getString("ValueAsConceptCode");
            Double valueAsNumber = rs.getDouble("ValueAsNumber");
            if (valueAsConceptCode != null && !valueAsConceptCode.isEmpty()) {
                detailMeasurement.setValue(rs.getString("ValueAsConceptDisplay"));
                detailMeasurement.setTableDisplayText(
                    rs.getString("Display") + " | " + rs.getString("ValueAsConceptDisplay"));
            } else if (valueAsNumber != null) {
                detailMeasurement.setValue((rs.getString("Operator") + " " + String.valueOf(valueAsNumber)).trim());
                detailMeasurement.setTableDisplayText(rs.getString("Display") + " | " + String.valueOf(valueAsNumber));
            } 
            detailMeasurement.setUnit(rs.getString("Unit"));

            detailMeasurement.setRangeLow(rs.getInt("RangeLow"));
            detailMeasurement.setRangeHigh(rs.getInt("RangeHigh"));
            retVal = detailMeasurement;
        } else if ("note".equals(entity_type)) {
            DetailNote detailNote = new DetailNote();
            Date date = rs.getDate("Date");
            if (date != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                String value = dateFormat.format(date);
                detailNote.setDate(value);
            }

            detailNote.setSystem(rs.getString("System"));
            detailNote.setCode(rs.getString("Code"));
            detailNote.setDisplay(rs.getString("Display"));
            detailNote.setValue(rs.getString("Value"));

            retVal = detailNote;
        }

        return retVal;
    }
    
}
