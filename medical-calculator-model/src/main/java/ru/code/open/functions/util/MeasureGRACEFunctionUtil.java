package ru.code.open.functions.util;

import ru.code.open.exceptions.AlgorithmException;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MeasureGRACEFunctionUtil {

    private static Map<Interval<Integer>, Integer> age = null;
    private static Map<Interval<Integer>, Integer> heartRate = null;
    private static Map<Interval<Integer>, Integer> systolicBloodPressure = null;
    private static Map<Interval<Double>, Integer> serumCreatinine = null;
    private static Map<String, Integer> heartFailureSeverity = null;

    public static Map<Interval<Integer>, Integer> getAge() throws AlgorithmException {
        if (age == null) {
            age = new TreeMap<>();
            age.put(new Interval<>(0, 29), 0);
            age.put(new Interval<>(30, 39), 8);
            age.put(new Interval<>(40, 49), 25);
            age.put(new Interval<>(50, 59), 41);
            age.put(new Interval<>(60, 69), 58);
            age.put(new Interval<>(70, 79), 75);
            age.put(new Interval<>(80, 89), 91);
            age.put(new Interval<>(90, Integer.MAX_VALUE), 100);
        }
        return age;
    }

    public static Map<Interval<Integer>, Integer> getHeartRate() throws AlgorithmException {
        if (heartRate == null) {
            heartRate = new TreeMap<>();
            heartRate.put(new Interval<>(0, 49), 0);
            heartRate.put(new Interval<>(50, 69), 3);
            heartRate.put(new Interval<>(70, 89), 9);
            heartRate.put(new Interval<>(90, 109), 15);
            heartRate.put(new Interval<>(110, 149), 24);
            heartRate.put(new Interval<>(150, 199), 38);
            heartRate.put(new Interval<>(200, Integer.MAX_VALUE), 46);
        }
        return heartRate;
    }

    public static Map<Interval<Integer>, Integer> getSystolicBloodPressure() throws AlgorithmException {
        if (systolicBloodPressure == null) {
            systolicBloodPressure = new TreeMap<>();
            systolicBloodPressure.put(new Interval<>(0, 79), 58);
            systolicBloodPressure.put(new Interval<>(80, 99), 53);
            systolicBloodPressure.put(new Interval<>(100, 119), 43);
            systolicBloodPressure.put(new Interval<>(120, 139), 34);
            systolicBloodPressure.put(new Interval<>(140, 159), 24);
            systolicBloodPressure.put(new Interval<>(160, 199), 10);
            systolicBloodPressure.put(new Interval<>(200, Integer.MAX_VALUE), 0);
        }
        return systolicBloodPressure;
    }

    public static Map<Interval<Double>, Integer> getSerumCreatinine() throws AlgorithmException {
        if (serumCreatinine == null) {
            serumCreatinine = new TreeMap<>();
            serumCreatinine.put(new Interval<>(0d, 35.35), 1);
            serumCreatinine.put(new Interval<>(35.36, 70.71), 4);
            serumCreatinine.put(new Interval<>(70.72, 106.07), 7);
            serumCreatinine.put(new Interval<>(106.08, 141.42), 10);
            serumCreatinine.put(new Interval<>(141.43, 176.7), 13);
            serumCreatinine.put(new Interval<>(176.8, 353d), 21);
            serumCreatinine.put(new Interval<>(354d, Double.MAX_VALUE), 28);
        }
        return serumCreatinine;
    }

    public static Map<String, Integer> getHeartFailureSeverity() {
        if (heartFailureSeverity == null) {
            heartFailureSeverity = new TreeMap<>();
            heartFailureSeverity.put("Кардиогенный шок (IV)", 59);
            heartFailureSeverity.put("Острый отек легких (III)", 39);
            heartFailureSeverity.put("Наличие хрипов в легких и/или повышенного давления в югулярных венах (II)", 20);
            heartFailureSeverity.put("Отсутствие признаков застойной сердечной недостаточности (I)", 0);
        }
        return heartFailureSeverity;
    }

    public static <N extends Number> Interval<N> getInterval(N value, Map<Interval<N>, Integer> map) {
        Set<Interval<N>> intervals = map.keySet();
        for (Interval<N> currentInterval : intervals) {
            if (currentInterval.contains(value)) {
                return currentInterval;
            }
        }
        return null;
    }
}
