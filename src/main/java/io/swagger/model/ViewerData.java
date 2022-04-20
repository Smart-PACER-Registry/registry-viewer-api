package io.swagger.model;

public class ViewerData {
    private Integer viewerDataId;
    private Integer observationId;
    private Integer caseId;
    private Integer personId;
    private String flag;
    private String annotation;

    public ViewerData() {

    }

    public void setViewerDataId(Integer viewerDataId) {
        this.viewerDataId = viewerDataId;
    }

    public Integer getViewerDataId() {
        return this.viewerDataId;
    }

    public void setObservationId(Integer observationId) {
        this.observationId = observationId;
    }

    public Integer getObservationId() {
        return this.observationId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getCaseId() {
        return this.caseId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonId() {
        return this.personId;
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
}
