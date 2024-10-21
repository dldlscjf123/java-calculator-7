package calculator;

public class StringCalculator {
        private static final String DEFAULT_DELIMITERS = "[,:]";

        public int calculate(String input) {
            if (input.isEmpty()) {
                return 0;
            }

            String[] tokens = splitNumbers(input);
            return sumTokens(tokens);
        }

        private String[] splitNumbers(String input) {
            CustomDelimiterParser parser = new CustomDelimiterParser();
            String delimiter = parser.extractDelimiter(input);

            if (delimiter != null) {
                input = parser.extractNumberPart(input);
            } else {
                delimiter = DEFAULT_DELIMITERS;
            }

            return input.split(delimiter);
        }

        private int sumTokens(String[] tokens) {
            int sum = 0;
            for (String token : tokens) {
                sum += parseNumber(token);
            }
            return sum;
        }

        private int parseNumber(String token) {
            try {
                int number = Integer.parseInt(token.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                return number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다: " + token);
            }
        }
    }

