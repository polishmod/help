package pl.mil.wp.help.room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import androidx.room.TypeConverter;
import java8.util.stream.StreamSupport;

/**
 * Created by Sebastian Paciorek
 */
public class Converters {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static List<Integer> fromStringToIntegerList(String value) {
        List<Integer> tempList = new ArrayList<>();
        if (value != null && !value.isEmpty()) {
            Collections.addAll(
                    tempList
                    , StreamSupport
                            .stream(Arrays.asList(value.split(";")))
                            .map(Integer::valueOf).toArray(Integer[]::new)
            );
        }
        return tempList;
    }
    @TypeConverter
    public static String fromIntegerToArrayList(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        if (numbers != null) {
            for (Integer n : numbers) {
                stringBuilder.append(n).append(";");
            }
        }
        return stringBuilder.toString();
    }
}
