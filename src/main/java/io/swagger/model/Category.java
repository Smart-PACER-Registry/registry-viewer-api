package io.swagger.model;

public class Category {
    private Integer conceptId;
    private String section;
    private String category;

    public Integer getConceptId() {
        return this.conceptId;
    }

    public void setConceptId(Integer conceptId) {
        this.conceptId = conceptId;
    }

    public String getSection(){
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
