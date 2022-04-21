package io.swagger.dbo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.model.ViewerData;

public class ViewerDataRowMapper implements RowMapper<ViewerData> {
    private Map<Integer, ViewerData> resultMap;

    public ViewerDataRowMapper() {
        resultMap = new HashMap<Integer, ViewerData>();
    }
    
    public Map<Integer, ViewerData> getResultMap() {
        return this.resultMap;
    }

    @Override
    public ViewerData mapRow(ResultSet rs, int rowNum) throws SQLException {
        ViewerData viewerData = new ViewerData();

        Integer obsKey = rs.getInt("observation_id");

        viewerData.setObservationId(obsKey);
        viewerData.setFlag(rs.getString("flag"));
        viewerData.setAnnotation(rs.getString("annotation"));
        viewerData.setCaseId(rs.getInt("case_id"));

        resultMap.put(obsKey, viewerData);
        
        return viewerData;
    }
    
}
