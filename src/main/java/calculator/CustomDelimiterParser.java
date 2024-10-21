package calculator;

public class CustomDelimeterParser {
    public class CustomDelimiterParser {
        public String extractDelimiter(String input) {
            if (input.startsWith("//")) {
                int newlineIndex = input.indexOf("\n");
                if (newlineIndex != -1) {
                    return input.substring(2, newlineIndex);
                }
            }
            return null;
        }

        public String extractNumberPart(String input) {
            int newlineIndex = input.indexOf("\n");
            return input.substring(newlineIndex + 1);
        }
    }

}
