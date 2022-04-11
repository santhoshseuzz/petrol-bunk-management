package petrolbunk;

public interface PetrolDbInterface {
    public static final String url = "jdbc:mysql://localhost:3306/petrolbulk";
    public static final String user = "root";
    public static final String pass = "seuzz";
    String setvalues = "insert into petrolstorage values(?,?,?,?,?); ";
    String refill = "update petrolstorage set  (?) = (?) where todaydate = (?) ";
}
