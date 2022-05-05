package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MannualCaseData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-05T05:59:28.112Z[GMT]")


public class MannualCaseData   {
  @JsonProperty("conceptId")
  private Integer conceptId = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("date")
  private String date = null;

  public MannualCaseData conceptId(Integer conceptId) {
    this.conceptId = conceptId;
    return this;
  }

  /**
   * Get conceptId
   * @return conceptId
   **/
  @Schema(example = "1", description = "")
  
    public Integer getConceptId() {
    return conceptId;
  }

  public void setConceptId(Integer conceptId) {
    this.conceptId = conceptId;
  }

  public MannualCaseData value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(example = "user-entered value", description = "")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public MannualCaseData date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @Schema(example = "2022-03-31", description = "")
  
    public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MannualCaseData mannualCaseData = (MannualCaseData) o;
    return Objects.equals(this.conceptId, mannualCaseData.conceptId) &&
        Objects.equals(this.value, mannualCaseData.value) &&
        Objects.equals(this.date, mannualCaseData.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conceptId, value, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MannualCaseData {\n");
    
    sb.append("    conceptId: ").append(toIndentedString(conceptId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
