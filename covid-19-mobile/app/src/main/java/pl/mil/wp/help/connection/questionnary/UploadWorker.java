package pl.mil.wp.help.connection.questionnary;

import android.content.Context;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import pl.mil.wp.help.R;
import pl.mil.wp.help.connection.RetrofitManager;
import pl.mil.wp.help.room.AppDatabase;
import pl.mil.wp.help.room.entities.questionnaire.Questionnaire;
import pl.mil.wp.help.shared_preferences.SharedPreferencesUtil;
import retrofit2.Response;

public class UploadWorker extends Worker {
    private final static String TAG = UploadWorker.class.getSimpleName();
    private String token;
    private String idUser;

    public UploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        String event = context.getString(R.string.auth_token);
        this.token = SharedPreferencesUtil.getString(context, event, "");
        setIDUser(context);
    }

    @NonNull
    @Override
    public Result doWork() {
        String token = "Bearer " + this.token;
        QuestionnaryService service = RetrofitManager.buildService(QuestionnaryService.class);
        Questionnaire questionnaireData = AppDatabase.getDatabase().questionnaireDAO().getNewestRawQuestionnaireByDate();

        try {
            Response response = service.sendQuestionnaryData(token, QuestionnaryDtoMapper.questionnaryToDto(questionnaireData, getIdUser())).execute();
            return response.isSuccessful() ? Result.success() : Result.retry();
        } catch (IOException e) {
            e.printStackTrace();
            return Result.retry();

        }
    }

    private void setIDUser(Context context){
        idUser = SharedPreferencesUtil.getIDUser(context);
    }

    public String getIdUser() {
        return idUser;
    }
}
