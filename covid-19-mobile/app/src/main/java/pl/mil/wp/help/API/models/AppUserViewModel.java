package pl.mil.wp.help.API.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * AppUserViewModel
 */

public class AppUserViewModel {
  @SerializedName("sex")
  private Sex sex = null;

  @SerializedName("userHealthStatus")
  private UserHealthStatus userHealthStatus = null;

  @SerializedName("city")
  private String city = null;

  @SerializedName("country")
  private String country = null;

  @SerializedName("roles")
  private List<String> roles = null;

  @SerializedName("dateOfBirth")
  private String dateOfBirth = null;

  @SerializedName("age")
  private Integer age = null;

  @SerializedName("doctorId")
  private Long doctorId = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("status")
  private UserStatusEnum status = null;

  @SerializedName("firstName")
  private String firstName = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("phone")
  private String phone = null;

  @SerializedName("optionText")
  private String optionText = null;

  @SerializedName("id")
  private Long id = null;

  @SerializedName("guid")
  private UUID guid = null;

  @SerializedName("uid")
  private String uid;

  @SerializedName("optionId")
  private String optionId = null;

  @SerializedName("isDeleted")
  private Boolean isDeleted = null;

  @SerializedName("optionAdditionalInfo")
  private Map<String, String> optionAdditionalInfo = null;

  public AppUserViewModel sex(Sex sex) {
    this.sex = sex;
    return this;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public AppUserViewModel userHealthStatus(UserHealthStatus userHealthStatus) {
    this.userHealthStatus = userHealthStatus;
    return this;
  }

  public UserHealthStatus getUserHealthStatus() {
    return userHealthStatus;
  }

  public void setUserHealthStatus(UserHealthStatus userHealthStatus) {
    this.userHealthStatus = userHealthStatus;
  }

  public AppUserViewModel city(String city) {
    this.city = city;
    return this;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public AppUserViewModel country(String country) {
    this.country = country;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public AppUserViewModel roles(List<String> roles) {
    this.roles = roles;
    return this;
  }

  public AppUserViewModel addRolesItem(String rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<String>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public AppUserViewModel dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public AppUserViewModel doctorId(Long doctorId) {
    this.doctorId = doctorId;
    return this;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public AppUserViewModel password(String password) {
    this.password = password;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AppUserViewModel status(UserStatusEnum status) {
    this.status = status;
    return this;
  }

  public UserStatusEnum getStatus() {
    return status;
  }

  public void setStatus(UserStatusEnum status) {
    this.status = status;
  }

  public AppUserViewModel firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public AppUserViewModel lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public AppUserViewModel email(String email) {
    this.email = email;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AppUserViewModel phone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getOptionText() {
    return optionText;
  }

  public AppUserViewModel id(Long id) {
    this.id = id;
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public AppUserViewModel guid(UUID guid) {
    this.guid = guid;
    return this;
  }
  public UUID getGuid() {
    return guid;
  }

  public void setGuid(UUID guid) {
    this.guid = guid;
  }


  public String getOptionId() {
    return optionId;
  }

  public AppUserViewModel isDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
    return this;
  }

  public Boolean isIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public Map<String, String> getOptionAdditionalInfo() {
    return optionAdditionalInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppUserViewModel appUserViewModel = (AppUserViewModel) o;
    return Objects.equals(this.sex, appUserViewModel.sex) &&
        Objects.equals(this.userHealthStatus, appUserViewModel.userHealthStatus) &&
        Objects.equals(this.city, appUserViewModel.city) &&
        Objects.equals(this.country, appUserViewModel.country) &&
        Objects.equals(this.roles, appUserViewModel.roles) &&
        Objects.equals(this.dateOfBirth, appUserViewModel.dateOfBirth) &&
        Objects.equals(this.age, appUserViewModel.age) &&
        Objects.equals(this.doctorId, appUserViewModel.doctorId) &&
        Objects.equals(this.password, appUserViewModel.password) &&
        Objects.equals(this.status, appUserViewModel.status) &&
        Objects.equals(this.firstName, appUserViewModel.firstName) &&
        Objects.equals(this.lastName, appUserViewModel.lastName) &&
        Objects.equals(this.email, appUserViewModel.email) &&
        Objects.equals(this.phone, appUserViewModel.phone) &&
        Objects.equals(this.optionText, appUserViewModel.optionText) &&
        Objects.equals(this.id, appUserViewModel.id) &&
        Objects.equals(this.uid, appUserViewModel.uid) &&
        Objects.equals(this.guid, appUserViewModel.guid) &&
        Objects.equals(this.optionId, appUserViewModel.optionId) &&
        Objects.equals(this.isDeleted, appUserViewModel.isDeleted) &&
        Objects.equals(this.optionAdditionalInfo, appUserViewModel.optionAdditionalInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sex, userHealthStatus, city, country, roles, dateOfBirth, age, doctorId, password, status, firstName, lastName, email, phone, optionText, id, uid, guid, optionId, isDeleted, optionAdditionalInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppUserViewModel {\n");
    
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    userHealthStatus: ").append(toIndentedString(userHealthStatus)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    doctorId: ").append(toIndentedString(doctorId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    optionText: ").append(toIndentedString(optionText)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    optionId: ").append(toIndentedString(optionId)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("    optionAdditionalInfo: ").append(toIndentedString(optionAdditionalInfo)).append("\n");
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

