package pl.mil.wp.help.API.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * BooleanApiResponse
 */

public class BooleanApiResponse {
  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("detail")
  private String detail = null;

  @SerializedName("uiConfig")
  private ExceptionUiConfig uiConfig = null;

  @SerializedName("errors")
  private List<ValidationError> errors = null;

  @SerializedName("content")
  private Boolean content = null;

  public BooleanApiResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public BooleanApiResponse message(String message) {
    this.message = message;
    return this;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public BooleanApiResponse detail(String detail) {
    this.detail = detail;
    return this;
  }


  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public BooleanApiResponse uiConfig(ExceptionUiConfig uiConfig) {
    this.uiConfig = uiConfig;
    return this;
  }


  public ExceptionUiConfig getUiConfig() {
    return uiConfig;
  }

  public void setUiConfig(ExceptionUiConfig uiConfig) {
    this.uiConfig = uiConfig;
  }

  public BooleanApiResponse errors(List<ValidationError> errors) {
    this.errors = errors;
    return this;
  }

  public BooleanApiResponse addErrorsItem(ValidationError errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<ValidationError>();
    }
    this.errors.add(errorsItem);
    return this;
  }


  public List<ValidationError> getErrors() {
    return errors;
  }

  public void setErrors(List<ValidationError> errors) {
    this.errors = errors;
  }

  public BooleanApiResponse content(Boolean content) {
    this.content = content;
    return this;
  }


  public Boolean isContent() {
    return content;
  }

  public void setContent(Boolean content) {
    this.content = content;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BooleanApiResponse booleanApiResponse = (BooleanApiResponse) o;
    return Objects.equals(this.success, booleanApiResponse.success) &&
        Objects.equals(this.message, booleanApiResponse.message) &&
        Objects.equals(this.detail, booleanApiResponse.detail) &&
        Objects.equals(this.uiConfig, booleanApiResponse.uiConfig) &&
        Objects.equals(this.errors, booleanApiResponse.errors) &&
        Objects.equals(this.content, booleanApiResponse.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, message, detail, uiConfig, errors, content);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BooleanApiResponse {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    uiConfig: ").append(toIndentedString(uiConfig)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

