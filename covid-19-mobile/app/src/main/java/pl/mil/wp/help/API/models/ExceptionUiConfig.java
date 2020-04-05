package pl.mil.wp.help.API.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


/**
 * ExceptionUiConfig
 */

public class ExceptionUiConfig {
  @SerializedName("timeout")
  private Integer timeout = null;

  @SerializedName("type")
  private ExceptionUiType type = null;

  public ExceptionUiConfig timeout(Integer timeout) {
    this.timeout = timeout;
    return this;
  }

  public Integer getTimeout() {
    return timeout;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }

  public ExceptionUiConfig type(ExceptionUiType type) {
    this.type = type;
    return this;
  }

  public ExceptionUiType getType() {
    return type;
  }

  public void setType(ExceptionUiType type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExceptionUiConfig exceptionUiConfig = (ExceptionUiConfig) o;
    return Objects.equals(this.timeout, exceptionUiConfig.timeout) &&
        Objects.equals(this.type, exceptionUiConfig.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeout, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExceptionUiConfig {\n");
    
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

