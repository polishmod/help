package pl.mil.wp.help.API.models;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets UserHealthStatus
 */
@JsonAdapter(UserHealthStatus.Adapter.class)
public enum UserHealthStatus {
  
  HEALTHY("healthy"),
  
  RECOVERED("recovered"),
  
  QUARANTINE("quarantine"),
  
  DEATH("death");

  private String value;

  UserHealthStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static UserHealthStatus fromValue(String text) {
    for (UserHealthStatus b : UserHealthStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<UserHealthStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final UserHealthStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public UserHealthStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return UserHealthStatus.fromValue(String.valueOf(value));
    }
  }
}

