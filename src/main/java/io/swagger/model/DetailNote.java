package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DetailNote
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-28T01:04:53.602Z[GMT]")


public class DetailNote  implements OneOfDetailsItems {
  @JsonProperty("date")
  private String date = null;

  @JsonProperty("system")
  private String system = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("display")
  private String display = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("tableDisplayText")
  private String tableDisplayText = null;

  public DetailNote date(String date) {
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

  public DetailNote system(String system) {
    this.system = system;
    return this;
  }

  /**
   * Get system
   * @return system
   **/
  @Schema(example = "LOINC", description = "")
  
    public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public DetailNote code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   **/
  @Schema(example = "20507-0", description = "")
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public DetailNote display(String display) {
    this.display = display;
    return this;
  }

  /**
   * Get display
   * @return display
   **/
  @Schema(example = "Note Type", description = "")
  
    public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  public DetailNote value(String value) {
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

  public DetailNote tableDisplayText(String tableDisplayText) {
    this.tableDisplayText = tableDisplayText;
    return this;
  }

  /**
   * Get tableDisplayText
   * @return tableDisplayText
   **/
  @Schema(description = "")
  
    public String getTableDisplayText() {
    return tableDisplayText;
  }

  public void setTableDisplayText(String tableDisplayText) {
    this.tableDisplayText = tableDisplayText;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailNote detailNote = (DetailNote) o;
    return Objects.equals(this.date, detailNote.date) &&
        Objects.equals(this.system, detailNote.system) &&
        Objects.equals(this.code, detailNote.code) &&
        Objects.equals(this.display, detailNote.display) &&
        Objects.equals(this.value, detailNote.value) &&
        Objects.equals(this.tableDisplayText, detailNote.tableDisplayText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, system, code, display, value, tableDisplayText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailNote {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    system: ").append(toIndentedString(system)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    tableDisplayText: ").append(toIndentedString(tableDisplayText)).append("\n");
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
