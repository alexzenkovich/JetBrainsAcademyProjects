import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word);
        }
        return builder.toString().toCharArray();
        // implement the method
    }

    public static void dgh() {
        File sampleFile = new File("sample.txt");
        String content = "I don't think that";

        try (FileWriter writer = new FileWriter(sampleFile)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}