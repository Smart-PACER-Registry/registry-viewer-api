package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Contents;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Categories
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-12T00:57:17.762Z[GMT]")


public class Categories   {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("contents")
  @Valid
  private List<Contents> contents = null;

  public Categories count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
   **/
  @Schema(example = "1", description = "")
  
    public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Categories contents(List<Contents> contents) {
    this.contents = contents;
    return this;
  }

  public Categories addContentsItem(Contents contentsItem) {
    if (this.contents == null) {
      this.contents = new ArrayList<Contents>();
    }
    this.contents.add(contentsItem);
    return this;
  }

  /**
   * Get contents
   * @return contents
   **/
  @Schema(description = "")
      @Valid
    public List<Contents> getContents() {
    return contents;
  }

  public void setContents(List<Contents> contents) {
    this.contents = contents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Categories categories = (Categories) o;
    return Objects.equals(this.count, categories.count) &&
        Objects.equals(this.contents, categories.contents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, contents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Categories {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    contents: ").append(toIndentedString(contents)).append("\n");
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
