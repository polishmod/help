package pl.mil.wp.help.room.entities.questionnaire;

import java.util.Date;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Sebastian Paciorek
 */
@Entity
public class Questionnaire {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "firstQuestionAnswer")
    public Integer firstQuestionAnswer;

    @ColumnInfo(name = "secondQuestionAnswer")
    public Integer secondQuestionAnswer;

    @ColumnInfo(name = "thirdQuestionAnswer")
    public Integer thirdQuestionAnswer;

    @ColumnInfo(name = "fourthQuestionAnswer")
    public Integer fourthQuestionAnswer;

    @ColumnInfo(name = "fifthQuestionAnswer")
    public List<Integer> fifthQuestionAnswer;

    @ColumnInfo(name = "sixthQuestionAnswer")
    public Integer sixthQuestionAnswer;

    @ColumnInfo(name = "seventhQuestionAnswer")
    public Integer seventhQuestionAnswer;

    @ColumnInfo(name = "date")
    public String date = (String) android.text.format.DateFormat.format("yyyy-MM-ddTHH:mm:ss", new Date());
}
