package pl.mil.wp.help.connection.questionnary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymptomsSickPropabilityCalculator {

    public Map<Integer, Double> normRelMap = new HashMap<>();

    public SymptomsSickPropabilityCalculator() {
        this.normRelMap.put(1, 0.3487);
        this.normRelMap.put(2, 0.0336);
        this.normRelMap.put(3, 0.0168);
        this.normRelMap.put(4, 0.3445);
        this.normRelMap.put(5, 0.0210);
        this.normRelMap.put(6, 0.0210);
    }

    public double calculateProbability(List<Integer> symptoms) {
        double sum = 0;
        for (int i : symptoms) {
            sum += normRelMap.get(i);
        }
        return sum;
    }


}
