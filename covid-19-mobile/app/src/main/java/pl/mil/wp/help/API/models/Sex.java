package pl.mil.wp.help.API.models;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets Sex
 */
@JsonAdapter(Sex.Adapter.class)
public enum Sex {
  
  MALE("male"),
  
  FEMALE("female");

  private String value;

  Sex(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static Sex fromValue(String text) {
    for (Sex b : Sex.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<Sex> {
    @Override
    public void write(final JsonWriter jsonWriter, final Sex enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public Sex read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return Sex.fromValue(String.valueOf(value));
    }
  }
}

