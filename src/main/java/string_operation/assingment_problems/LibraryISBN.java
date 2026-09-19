public class LibraryISBN {

    static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String publisher =
            code.substring(0, 3).toUpperCase();

        String remaining =
            code.substring(3);

        return publisher + remaining;
    }


    static String validateAndFormat(String code) {

        // Step 1: Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Step 2: Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Step 3: Check remaining characters are digits
        for (int i = 3; i < code.length(); i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract year
        String year = code.substring(3, 7);

        // Extract catalog number
        String catalog = code.substring(7);

        // Build output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(code.substring(0, 3));
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }


    public static void main(String[] args) {

        String raw = " pen2026004251 ";

        String normalized =
            normalizeCode(raw);

        System.out.println(
            validateAndFormat(normalized)
        );


        String raw2 = "12N2026004251";

        String normalized2 =
            normalizeCode(raw2);

        System.out.println(
            validateAndFormat(normalized2)
        );
    }
}