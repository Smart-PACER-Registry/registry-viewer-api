package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Details
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-12T00:57:17.762Z[GMT]")


public class Details   {
  @JsonProperty("date")
  private String date = null;

  @JsonProperty("coding")
  private Coding coding = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("unit")
  private String unit = null;

  @JsonProperty("etc")
  private String etc = null;

  public Details date(String date) {
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

  public Details coding(Coding coding) {
    this.coding = coding;
    return this;
  }

  /**
   * Get coding
   * @return coding
   **/
  @Schema(description = "")
  
    @Valid
    public Coding getCoding() {
    return coding;
  }

  public void setCoding(Coding coding) {
    this.coding = coding;
  }

  public Details value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(example = "Reactive", description = "")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Details unit(String unit) {
    this.unit = unit;
    return this;
  }

  /**
   * Get unit
   * @return unit
   **/
  @Schema(description = "")
  
    public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Details etc(String etc) {
    this.etc = etc;
    return this;
  }

  /**
   * Get etc
   * @return etc
   **/
  @Schema(example = "other stuff to include", description = "")
  
    public String getEtc() {
    return etc;
  }

  public void setEtc(String etc) {
    this.etc = etc;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Details details = (Details) o;
    return Objects.equals(this.date, details.date) &&
        Objects.equals(this.coding, details.coding) &&
        Objects.equals(this.value, details.value) &&
        Objects.equals(this.unit, details.unit) &&
        Objects.equals(this.etc, details.etc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, coding, value, unit, etc);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Details {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    coding: ").append(toIndentedString(coding)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    etc: ").append(toIndentedString(etc)).append("\n");
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
