package pl.mil.wp.help.API.models;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets ExceptionUiType
 */
@JsonAdapter(ExceptionUiType.Adapter.class)
public enum ExceptionUiType {
  
  NOTIFICATION("notification"),
  
  DIALOG("dialog");

  private String value;

  ExceptionUiType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ExceptionUiType fromValue(String text) {
    for (ExceptionUiType b : ExceptionUiType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<ExceptionUiType> {
    @Override
    public void write(final JsonWriter jsonWriter, final ExceptionUiType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ExceptionUiType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ExceptionUiType.fromValue(String.valueOf(value));
    }
  }
}

