package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.FlagAnnotationAnnotation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FlagAnnotation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-29T13:57:35.834Z[GMT]")


public class FlagAnnotation   {
  @JsonProperty("flag")
  private String flag = null;

  @JsonProperty("annotation")
  private FlagAnnotationAnnotation annotation = null;

  public FlagAnnotation flag(String flag) {
    this.flag = flag;
    return this;
  }

  /**
   * Get flag
   * @return flag
   **/
  @Schema(example = "flag1", description = "")
  
    public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public FlagAnnotation annotation(FlagAnnotationAnnotation annotation) {
    this.annotation = annotation;
    return this;
  }

  /**
   * Get annotation
   * @return annotation
   **/
  @Schema(description = "")
  
    @Valid
    public FlagAnnotationAnnotation getAnnotation() {
    return annotation;
  }

  public void setAnnotation(FlagAnnotationAnnotation annotation) {
    this.annotation = annotation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlagAnnotation flagAnnotation = (FlagAnnotation) o;
    return Objects.equals(this.flag, flagAnnotation.flag) &&
        Objects.equals(this.annotation, flagAnnotation.annotation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flag, annotation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlagAnnotation {\n");
    
    sb.append("    flag: ").append(toIndentedString(flag)).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
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
