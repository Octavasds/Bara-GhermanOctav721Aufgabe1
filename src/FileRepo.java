import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class FileRepo {
    public static ArrayList<Events> readFile() {
        ArrayList<Events> events = new ArrayList<>();
        String filePath = "evenimente.tsv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String aux=br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t" );
                Events event= new Events();
                event.setId(Integer.parseInt(parts[0]));
                event.setMitgliedsName(parts[1]);
                event.setHaus(parts[2]);
                event.setEreignis(parts[3]);
                event.setDatum(parts[4]);
                events.add(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }
}
