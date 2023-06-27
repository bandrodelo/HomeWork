package testTask;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Count {
    private static final String TAG_COWS = "cows";
    private static final String TAG_PIGS = "pigs";
    private static final String TAG_CHICKENS = "chickens";
    private static final int LEGS_CHICKEN = 2;
    private static final int LEGS_OTHER_ANIMALS = 4;

    public static long totalLegsAnimals(String fileName) throws IOException, ParseException {
        FileReader fileReader = new FileReader(fileName);
        JSONParser parser = new JSONParser();
        JSONObject read = (JSONObject) parser.parse(fileReader);

        long totalLegAnimals = (long) read.get(TAG_CHICKENS) * LEGS_CHICKEN
                + (long) read.get(TAG_COWS) * LEGS_OTHER_ANIMALS
                + (long) read.get(TAG_PIGS) * LEGS_OTHER_ANIMALS;
        return totalLegAnimals;
    }

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(totalLegsAnimals("animals.json"));
    }
}
