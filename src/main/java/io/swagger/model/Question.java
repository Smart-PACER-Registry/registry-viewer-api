package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Question
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-05T05:59:28.112Z[GMT]")


public class Question   {
  @JsonProperty("conceptId")
  private Integer conceptId = null;

  @JsonProperty("section")
  private String section = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("question")
  private String question = null;

  public Question conceptId(Integer conceptId) {
    this.conceptId = conceptId;
    return this;
  }

  /**
   * Get conceptId
   * @return conceptId
   **/
  @Schema(example = "12345", description = "")
  
    public Integer getConceptId() {
    return conceptId;
  }

  public void setConceptId(Integer conceptId) {
    this.conceptId = conceptId;
  }

  public Question section(String section) {
    this.section = section;
    return this;
  }

  /**
   * Get section
   * @return section
   **/
  @Schema(example = "Lab Results", description = "")
  
    public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public Question category(String category) {
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

  public Question question(String question) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question = (Question) o;
    return Objects.equals(this.conceptId, question.conceptId) &&
        Objects.equals(this.section, question.section) &&
        Objects.equals(this.category, question.category) &&
        Objects.equals(this.question, question.question);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conceptId, section, category, question);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Question {\n");
    
    sb.append("    conceptId: ").append(toIndentedString(conceptId)).append("\n");
    sb.append("    section: ").append(toIndentedString(section)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    question: ").append(toIndentedString(question)).append("\n");
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
