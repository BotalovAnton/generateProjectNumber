import java.util.List;
import java.util.stream.Collectors;

public class ProjectNumberGenerationService {

    public static String generateNum(List<Integer> numbers) {

        if(numbers.isEmpty()) {
            return convertToThreeDigitString(1);
        }

        numbers = numbers.stream().distinct().sorted().collect(Collectors.toList());

        if(numbers.size() == 1) {
            return numbers.get(0) > 1 ? convertToThreeDigitString(1) : convertToThreeDigitString(2);
        }

        else {
            if(numbers.get(0) > 1) {
                return convertToThreeDigitString(1);
            }
            else {
                for(int i = 0; i < numbers.size() - 1; i++) {
                    if ((numbers.get(i + 1) - numbers.get(i)) > 1) {
                        return convertToThreeDigitString(numbers.get(i) + 1);
                    }
                }

                return convertToThreeDigitString(numbers.get(numbers.size() - 1) + 1);
            }
        }

    }

    public static String convertToThreeDigitString(Integer number) {
        return String.format("%03d", number);
    }

}