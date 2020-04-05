package pl.mil.wp.help.API.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AppUserViewModelApiResponse
 */

public class AppUserViewModelApiResponse {
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
  private AppUserViewModel content = null;

  public AppUserViewModelApiResponse success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Get success
   * @return success
  **/
  public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public AppUserViewModelApiResponse message(String message) {
    this.message = message;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public AppUserViewModelApiResponse detail(String detail) {
    this.detail = detail;
    return this;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public AppUserViewModelApiResponse uiConfig(ExceptionUiConfig uiConfig) {
    this.uiConfig = uiConfig;
    return this;
  }

  public ExceptionUiConfig getUiConfig() {
    return uiConfig;
  }

  public void setUiConfig(ExceptionUiConfig uiConfig) {
    this.uiConfig = uiConfig;
  }

  public AppUserViewModelApiResponse errors(List<ValidationError> errors) {
    this.errors = errors;
    return this;
  }

  public AppUserViewModelApiResponse addErrorsItem(ValidationError errorsItem) {
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

  public AppUserViewModelApiResponse content(AppUserViewModel content) {
    this.content = content;
    return this;
  }

  public AppUserViewModel getContent() {
    return content;
  }

  public void setContent(AppUserViewModel content) {
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
    AppUserViewModelApiResponse appUserViewModelApiResponse = (AppUserViewModelApiResponse) o;
    return Objects.equals(this.success, appUserViewModelApiResponse.success) &&
        Objects.equals(this.message, appUserViewModelApiResponse.message) &&
        Objects.equals(this.detail, appUserViewModelApiResponse.detail) &&
        Objects.equals(this.uiConfig, appUserViewModelApiResponse.uiConfig) &&
        Objects.equals(this.errors, appUserViewModelApiResponse.errors) &&
        Objects.equals(this.content, appUserViewModelApiResponse.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, message, detail, uiConfig, errors, content);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppUserViewModelApiResponse {\n");
    
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

