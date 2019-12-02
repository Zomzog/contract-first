package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.Color;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Pony
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-02T22:26:12.093+01:00[Europe/Paris]")

public class Pony   {
  @JsonProperty("Id")
  private String id;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("Color")
  private Color color;

  @JsonProperty("CreatedAt")
  private Long createdAt;

  public Pony id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Pony name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "Big McIntosh", required = true, value = "")
  @NotNull

@Size(min=1,max=100) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Pony color(Color color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Pony createdAt(Long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Timestamp
   * @return createdAt
  */
  @ApiModelProperty(value = "Timestamp")


  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pony pony = (Pony) o;
    return Objects.equals(this.id, pony.id) &&
        Objects.equals(this.name, pony.name) &&
        Objects.equals(this.color, pony.color) &&
        Objects.equals(this.createdAt, pony.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, color, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pony {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

