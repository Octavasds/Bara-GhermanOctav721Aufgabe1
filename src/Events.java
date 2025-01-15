public class Events {
    int id;
    String MitgliedsName;
    String Haus;
    String Ereignis;
    String Datum;
    public void setId(int id) {
        this.id = id;
    }

    public void setMitgliedsName(String mitgliedsName) {
        MitgliedsName = mitgliedsName;
    }

    public void setHaus(String haus) {
        Haus = haus;
    }

    public void setEreignis(String ereignis) {
        Ereignis = ereignis;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public int getId() {
        return id;
    }

    public String getMitgliedsName() {
        return MitgliedsName;
    }

    public String getHaus() {
        return Haus;
    }

    public String getEreignis() {
        return Ereignis;
    }

    public String getDatum() {
        return Datum;
    }

}
