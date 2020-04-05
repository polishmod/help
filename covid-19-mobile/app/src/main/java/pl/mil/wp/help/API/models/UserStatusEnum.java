package pl.mil.wp.help.API.models;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets UserStatusEnum
 */
@JsonAdapter(UserStatusEnum.Adapter.class)
public enum UserStatusEnum {
  
  NONE("none"),
  
  ACTIVE("active"),
  
  INACTIVE("inactive");

  private String value;

  UserStatusEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static UserStatusEnum fromValue(String text) {
    for (UserStatusEnum b : UserStatusEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<UserStatusEnum> {
    @Override
    public void write(final JsonWriter jsonWriter, final UserStatusEnum enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public UserStatusEnum read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return UserStatusEnum.fromValue(String.valueOf(value));
    }
  }
}

