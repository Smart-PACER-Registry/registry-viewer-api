package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Annotation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-29T13:57:35.834Z[GMT]")


public class Annotation   {
  @JsonProperty("annoation_id")
  private Integer annoationId = null;

  @JsonProperty("userId")
  private Integer userId = null;

  @JsonProperty("date")
  private String date = null;

  @JsonProperty("text")
  private String text = null;

  public Annotation annoationId(Integer annoationId) {
    this.annoationId = annoationId;
    return this;
  }

  /**
   * Get annoationId
   * @return annoationId
   **/
  @Schema(example = "1", description = "")
  
    public Integer getAnnoationId() {
    return annoationId;
  }

  public void setAnnoationId(Integer annoationId) {
    this.annoationId = annoationId;
  }

  public Annotation userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   **/
  @Schema(example = "1", description = "")
  
    public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Annotation date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @Schema(example = "2022-01-14T05:00:00.000Z", description = "")
  
    public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Annotation text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
   **/
  @Schema(example = "annotation text", description = "")
  
    public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Annotation annotation = (Annotation) o;
    return Objects.equals(this.annoationId, annotation.annoationId) &&
        Objects.equals(this.userId, annotation.userId) &&
        Objects.equals(this.date, annotation.date) &&
        Objects.equals(this.text, annotation.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(annoationId, userId, date, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Annotation {\n");
    
    sb.append("    annoationId: ").append(toIndentedString(annoationId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
