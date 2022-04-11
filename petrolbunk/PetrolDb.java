package petrolbunk;


import java.sql.*;

public class PetrolDb implements PetrolDbInterface {
    // Database connection
    private Connection connection = null;
    private PreparedStatement preparedQuery = null;
    private ResultSet resultSet = null;
    PetrolMethods callRefill= new PetrolMethods();

    //Database Query
    public PetrolDb() {
        try {
            connection = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            System.out.println("1.unable to establish connection with DB");
            e.printStackTrace();
        }
    }
    PetrolMethods refillObj = new PetrolMethods();


    void setup(PetrolData petrolDataoobj){
        int check =0;
        try{
            preparedQuery = connection.prepareStatement(PetrolDbInterface.setvalues);
            preparedQuery.setDate(1,petrolDataoobj.getDate());
            preparedQuery.setDouble(2,petrolDataoobj.getPetrolQuantity());
            preparedQuery.setDouble(3,petrolDataoobj.getDieselQuantity());
            preparedQuery.setDouble(4,petrolDataoobj.getPetrolRate());
            preparedQuery.setDouble(5,petrolDataoobj.getDieselRate());
            check =preparedQuery.executeUpdate();
            PreparedStatement prestmt = connection.prepareStatement("insert into collection (today) values(?);");
            prestmt.setDate(1,petrolDataoobj.getDate());
            prestmt.executeUpdate();
            if (check>0){
                System.out.println("Today Set up  is finished.......");
            }

        } catch (Exception e1) {
            System.out.println("Insert command Failed");
            e1.printStackTrace();
        } finally {
            try {
                preparedQuery.close();
            } catch (SQLException ex) {
                System.out.println("connection not closed in insert Section....");
                ex.printStackTrace();
            }
        }
    }
    void fillUpDb(PetrolData petrolDataObj){
        try{
         ResultSet rs = null;
        CallableStatement callStatement = connection.prepareCall("{call petrolfunction1(?,?,?,?,?)}");
        callStatement.setInt(1,petrolDataObj.getChoice());
        callStatement.setDouble(2,petrolDataObj.getCapacity());
        callStatement.setDate(3,petrolDataObj.getDate());
        callStatement.registerOutParameter(4,Types.DOUBLE);
        callStatement.registerOutParameter(5,Types.INTEGER);
        callStatement.executeUpdate();
        double bill= callStatement.getDouble(4);
        System.out.println("bill ="+bill);
        int message = callStatement.getInt(5);
        if (message==12){
            refillObj.callRefill(message);
            System.out.println("Diesel not avilable.....");
        }else if(message==11){
            refillObj.callRefill(message);
            System.out.println("Petrol not avilable...");
        }else{
            System.out.println("Refilled successfully....");
        }

        callStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void refillDb(PetrolData obj){
        try {
            preparedQuery = connection.prepareStatement("update petrolstorage set  ? = ? where todaydate = ? ;");
            preparedQuery.setString(1,obj.getRefillColumn());
            preparedQuery.setDouble(2,obj.getRefill());
            preparedQuery.setDate(3,obj.getDate());
            preparedQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
