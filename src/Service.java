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
}
