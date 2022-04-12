package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Details;
import io.swagger.model.Value;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Contents
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-12T00:57:17.762Z[GMT]")


public class Contents   {
  @JsonProperty("section")
  private String section = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("date")
  private String date = null;

  @JsonProperty("derived-value")
  private Value derivedValue = null;

  @JsonProperty("source-value")
  private Value sourceValue = null;

  @JsonProperty("details")
  private Details details = null;

  public Contents section(String section) {
    this.section = section;
    return this;
  }

  /**
   * Get section
   * @return section
   **/
  @Schema(example = "LabResults", description = "")
  
    public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public Contents category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @Schema(example = "Syphilis", description = "")
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Contents date(String date) {
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

  public Contents derivedValue(Value derivedValue) {
    this.derivedValue = derivedValue;
    return this;
  }

  /**
   * Get derivedValue
   * @return derivedValue
   **/
  @Schema(description = "")
  
    @Valid
    public Value getDerivedValue() {
    return derivedValue;
  }

  public void setDerivedValue(Value derivedValue) {
    this.derivedValue = derivedValue;
  }

  public Contents sourceValue(Value sourceValue) {
    this.sourceValue = sourceValue;
    return this;
  }

  /**
   * Get sourceValue
   * @return sourceValue
   **/
  @Schema(description = "")
  
    @Valid
    public Value getSourceValue() {
    return sourceValue;
  }

  public void setSourceValue(Value sourceValue) {
    this.sourceValue = sourceValue;
  }

  public Contents details(Details details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
   **/
  @Schema(description = "")
  
    @Valid
    public Details getDetails() {
    return details;
  }

  public void setDetails(Details details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contents contents = (Contents) o;
    return Objects.equals(this.section, contents.section) &&
        Objects.equals(this.category, contents.category) &&
        Objects.equals(this.date, contents.date) &&
        Objects.equals(this.derivedValue, contents.derivedValue) &&
        Objects.equals(this.sourceValue, contents.sourceValue) &&
        Objects.equals(this.details, contents.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(section, category, date, derivedValue, sourceValue, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contents {\n");
    
    sb.append("    section: ").append(toIndentedString(section)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    derivedValue: ").append(toIndentedString(derivedValue)).append("\n");
    sb.append("    sourceValue: ").append(toIndentedString(sourceValue)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
