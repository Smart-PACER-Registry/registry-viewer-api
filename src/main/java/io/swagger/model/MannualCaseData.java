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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-03T18:13:28.024Z[GMT]")


public class MannualCaseData   {
  @JsonProperty("contentId")
  private Integer contentId = null;

  @JsonProperty("question")
  private String question = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("date")
  private String date = null;

  public MannualCaseData contentId(Integer contentId) {
    this.contentId = contentId;
    return this;
  }

  /**
   * Get contentId
   * @return contentId
   **/
  @Schema(example = "1", description = "")
  
    public Integer getContentId() {
    return contentId;
  }

  public void setContentId(Integer contentId) {
    this.contentId = contentId;
  }

  public MannualCaseData question(String question) {
    this.question = question;
    return this;
  }

  /**
   * Get question
   * @return question
   **/
  @Schema(example = "Lab Results", description = "")
  
    public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
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
    return Objects.equals(this.contentId, mannualCaseData.contentId) &&
        Objects.equals(this.question, mannualCaseData.question) &&
        Objects.equals(this.value, mannualCaseData.value) &&
        Objects.equals(this.date, mannualCaseData.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentId, question, value, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MannualCaseData {\n");
    
    sb.append("    contentId: ").append(toIndentedString(contentId)).append("\n");
    sb.append("    question: ").append(toIndentedString(question)).append("\n");
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
