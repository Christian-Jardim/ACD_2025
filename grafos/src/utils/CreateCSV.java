package utils;
import graphs.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateCSV {
	public static void generateCsv(List<String> csvList) {
        String header = "Algorithm,GraphType,GraphChosen,Repetition,Time(ms)";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("run_times.csv"))) {
            writer.write(header);
            writer.newLine();

            for (String line : csvList) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("\n\n [SUCESSO] Dados de execuçaõ garvados em 'run_times.csv'!");
        } catch (IOException e) {
            System.err.println("\n\n [ERRO] Falha ao escrever o arquivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
