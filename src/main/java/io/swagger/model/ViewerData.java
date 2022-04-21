package io.swagger.model;

public class ViewerData {
    private Integer observationId;
    private String flag;
    private String annotation;
    private Integer caseId;

    public ViewerData() {

    }

    public void setObservationId(Integer observationId) {
        this.observationId = observationId;
    }

    public Integer getObservationId() {
        return this.observationId;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAnnotation() {
        return this.annotation;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getCaseId() {
        return this.caseId;
    }
}
