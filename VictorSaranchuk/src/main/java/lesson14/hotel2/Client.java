package lesson14.hotel2;

public class Client {
    private String name;

   public Client(String name){
       this.name=name;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name!=null ? name.equals(client.name):client.name==null;
    }

    @Override
    public int hashCode() {

        String c=name.substring(0,1);
        return name!=null ? c.hashCode():0;
    }
}


