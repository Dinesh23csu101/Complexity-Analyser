import java.io.*;

public class Main {
    public static String analyzeComplexity(String code) {
        if (code.contains("for") || code.contains("while")) {
            if (code.contains("for") && code.indexOf("for", code.indexOf("for") + 1) != -1 ||
                    code.contains("while") && code.indexOf("while", code.indexOf("while") + 1) != -1) {

                if (code.contains("i = i * 2")|| code.contains("i *= 2") || code.contains("i = i / 2") ||code.contains("i /= 2") || code.contains("i < n * 2") || code.contains("i < n / 2")) {
                    return "O(log n) due to logarithmic time complexity";
                }
                return "O(n^2) or higher due to nested loops";
            }
            return "O(n) due to a single loop";
        } else if (code.contains("void") && code.contains("(") && code.contains("{") && code.contains("return")) {
            return "O(2^n) or O(n!) due to recursion";
        }
        return "O(1) (constant time complexity)";
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/MainFrame/Desktop/codeexample2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder code = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                code.append(line).append("\n");
            }
            System.out.println("Estimated Time Complexity: " + analyzeComplexity(code.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}