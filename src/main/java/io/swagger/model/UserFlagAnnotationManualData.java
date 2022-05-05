package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Annotation;
import io.swagger.model.MannualCaseData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserFlagAnnotationManualData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-05T05:59:28.112Z[GMT]")


public class UserFlagAnnotationManualData   {
  @JsonProperty("flag")
  private String flag = "Unknown";

  @JsonProperty("annotations")
  @Valid
  private List<Annotation> annotations = null;

  @JsonProperty("mannualCaseData")
  @Valid
  private List<MannualCaseData> mannualCaseData = null;

  public UserFlagAnnotationManualData flag(String flag) {
    this.flag = flag;
    return this;
  }

  /**
   * Get flag
   * @return flag
   **/
  @Schema(example = "Invalid Entry", description = "")
  
    public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public UserFlagAnnotationManualData annotations(List<Annotation> annotations) {
    this.annotations = annotations;
    return this;
  }

  public UserFlagAnnotationManualData addAnnotationsItem(Annotation annotationsItem) {
    if (this.annotations == null) {
      this.annotations = new ArrayList<Annotation>();
    }
    this.annotations.add(annotationsItem);
    return this;
  }

  /**
   * Get annotations
   * @return annotations
   **/
  @Schema(description = "")
      @Valid
    public List<Annotation> getAnnotations() {
    return annotations;
  }

  public void setAnnotations(List<Annotation> annotations) {
    this.annotations = annotations;
  }

  public UserFlagAnnotationManualData mannualCaseData(List<MannualCaseData> mannualCaseData) {
    this.mannualCaseData = mannualCaseData;
    return this;
  }

  public UserFlagAnnotationManualData addMannualCaseDataItem(MannualCaseData mannualCaseDataItem) {
    if (this.mannualCaseData == null) {
      this.mannualCaseData = new ArrayList<MannualCaseData>();
    }
    this.mannualCaseData.add(mannualCaseDataItem);
    return this;
  }

  /**
   * Get mannualCaseData
   * @return mannualCaseData
   **/
  @Schema(description = "")
      @Valid
    public List<MannualCaseData> getMannualCaseData() {
    return mannualCaseData;
  }

  public void setMannualCaseData(List<MannualCaseData> mannualCaseData) {
    this.mannualCaseData = mannualCaseData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserFlagAnnotationManualData userFlagAnnotationManualData = (UserFlagAnnotationManualData) o;
    return Objects.equals(this.flag, userFlagAnnotationManualData.flag) &&
        Objects.equals(this.annotations, userFlagAnnotationManualData.annotations) &&
        Objects.equals(this.mannualCaseData, userFlagAnnotationManualData.mannualCaseData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flag, annotations, mannualCaseData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserFlagAnnotationManualData {\n");
    
    sb.append("    flag: ").append(toIndentedString(flag)).append("\n");
    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
    sb.append("    mannualCaseData: ").append(toIndentedString(mannualCaseData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
