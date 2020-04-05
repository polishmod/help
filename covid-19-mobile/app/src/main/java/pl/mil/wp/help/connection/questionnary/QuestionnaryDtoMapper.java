package pl.mil.wp.help.connection.questionnary;

import java.util.ArrayList;
import java.util.List;

import pl.mil.wp.help.room.entities.questionnaire.Questionnaire;

public class QuestionnaryDtoMapper {

    public static QuestionnaryDto questionnaryToDto(Questionnaire questionnaire, String idUser) {
        QuestionnaryDto dto = new QuestionnaryDto();
        //TODO Zastąpić
        dto.setUserId(Long.parseLong(idUser));
        dto.setDate(questionnaire.date);
        dto.setReturnedFromAbroad(stringForPeriodValue(questionnaire.firstQuestionAnswer));
        dto.setHadCloseContactToDiagnosed(stringForPeriodValue(questionnaire.secondQuestionAnswer));
        dto.setReturnedFromAbroad(stringForPeriodValue(questionnaire.thirdQuestionAnswer));
        dto.setHadCloseContactDuringTravel(stringForHygiene(questionnaire.fourthQuestionAnswer));
        dto.setSymptoms(stringListForSymptomsValues(questionnaire.fifthQuestionAnswer));
        dto.setHadYouExpriencedLackOfTasteOrSmell(questionnaire.seventhQuestionAnswer != 0);
        double temperature = questionnaire.sixthQuestionAnswer / 10.0;
        dto.setTemperature(temperature);
        return dto;
    }


    private static String stringForPeriodValue(int value) {
        switch (value) {
            case 1:
                return "oneThreeDaysAgo";
            case 2:
                return "fourSixDaysAgo";
            case 3:
                return "sevenTenDaysAgo";
            case 4:
                return "tenFourteenDaysAgo";
            default:
                return "no";
        }
    }

    private static String stringForHygiene(int value) {
        switch (value) {
            case 2:
                return "sometimes";
            case 3:
                return "mostly";
            case 4:
                return "almostever";
            case 5:
                return "ever";
            default:
                return "no";
        }
    }

    private static List<String> stringListForSymptomsValues(List<Integer> values) {
        List<String> valuesStrings = new ArrayList<>();
        for (int value : values) {
            valuesStrings.add(stringForSymptom(value));
        }
        return valuesStrings;
    }

    private static String stringForSymptom(int value) {
        switch (value) {
            case 1:
                return "fever";
            case 2:
                return "headache";
            case 3:
                return "runny_nose";
            case 4:
                return "cough";
            case 5:
                return "sore_throat";
            case 6:
                return "red_eyes";
            default:
                return "";
        }
    }
}
