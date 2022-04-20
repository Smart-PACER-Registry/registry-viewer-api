package io.swagger.dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.model.Category;

public class CategoryConceptCodeRowMapper implements RowMapper<Category> {
    private Map<Integer, Category> categoryConceptMap = new HashMap<Integer, Category> ();
    
    public Map<Integer, Category> getCategoryConceptMap() {
        return this.categoryConceptMap;
    }

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setConceptId(rs.getInt("ConceptId"));
        category.setSection(rs.getString("Section"));
        category.setCategory(rs.getString("Category"));

        categoryConceptMap.put(rs.getInt("ConceptId"), category);

        return category;
    }

}
