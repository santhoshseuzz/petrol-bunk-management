package petrolbunk;

import java.sql.Date;

public class PetrolData {
    private double petrolQuantity;
    private double dieselQuantity;
    private double petrolRate;
    private double dieselRate;
    private int choice;
    private double capacity;
    private Date date;
    private double refill;
    private String refillColumn;

    public String getRefillColumn() {
        return refillColumn;
    }

    public void setRefillColumn(String refillColumn) {
        this.refillColumn = refillColumn;
    }

    public double getRefill() {
        return refill;
    }

    public void setRefill(double refill) {
        this.refill = refill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPetrolQuantity() {
        return petrolQuantity;
    }

    public void setPetrolQuantity(double petrolQuantity) {
        this.petrolQuantity = petrolQuantity;
    }

    public double getDieselQuantity() {
        return dieselQuantity;
    }

    public void setDieselQuantity(double dieselQuantity) {
        this.dieselQuantity = dieselQuantity;
    }

    public double getPetrolRate() {
        return petrolRate;
    }

    public void setPetrolRate(double petrolRate) {
        this.petrolRate = petrolRate;
    }

    public double getDieselRate() {
        return dieselRate;
    }

    public void setDieselRate(double dieselRate) {
        this.dieselRate = dieselRate;
    }

    private double Rate;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }
}
