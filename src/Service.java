import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Service {
    ArrayList<Events> events = FileRepo.readFile();
    public void start_with(){
        ArrayList<Events> uniqueNames = new ArrayList<>();
        ArrayList<Events> events= new ArrayList<>();
        events= FileRepo.readFile();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.length()>1)
            return;
        else
            for(Events ev: events){
                if(ev.getMitgliedsName().startsWith(input))
                    if(!uniqueNames.contains(ev))
                        uniqueNames.add(ev);
            }
        for(Events ev: uniqueNames)
            System.out.println(ev.MitgliedsName);
    }
    public void sortedHouseStark(){
        ArrayList<Events> events = new ArrayList<>();
        ArrayList<Events> starkHouse = new ArrayList<>();
        events= FileRepo.readFile();
        for(Events ev: events)
            if(ev.Haus.equals("Stark"))
                starkHouse.add(ev);
        starkHouse.sort(Comparator.comparing(event->event.Datum));
        for(Events ev: starkHouse)
            System.out.println(ev.Datum+" "+ev.MitgliedsName);
    }
    public void anzahl_Ereignise(){
        String[] houses = { "Stark", "Lannister", "Targaryen", "Greyjoy", "Baratheon" };
        ArrayList<Events> events= new ArrayList<>();
        events= FileRepo.readFile();
        int[] points=new int[6];
        String filePath = "ergebnis.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(Events ev: events)
                if(ev.getHaus().equals(houses[0]))
                    points[0]+=1;
                else
                if(ev.getHaus().equals(houses[1]))
                    points[1]+=1;
                else
                if(ev.getHaus().equals(houses[2]))
                    points[2]+=1;
                else
                if(ev.getHaus().equals(houses[3]))
                    points[3]+=1;
                else
                    if(ev.getHaus().equals(houses[4]))
                        points[4]+=1;
            String aux;
            int hpr;
            for (int i = 0; i < houses.length; i++)
                for(int j=i+1;j<houses.length;j++)
                    if(points[i]<points[j]){
                        hpr=points[i];
                        points[i]=points[j];
                        points[j]=hpr;
                        aux=houses[i];
                        houses[i]=houses[j];
                        houses[j]=aux;
                    }
            for (int i = 0; i < houses.length; i++)
                for(int j=i+1;j<houses.length;j++)
                    if(points[i]==points[j] && houses[i].charAt(0)>houses[j].charAt(0)){
                        hpr=points[i];
                        points[i]=points[j];
                        points[j]=hpr;
                        aux=houses[i];
                        houses[i]=houses[j];
                        houses[j]=aux;
                    }
            for(int i=0;i<houses.length;i++)
            {
                String line = houses[i] + "#" + points[i];
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
