package first.Management;

public class Manager extends Employee {
    private double bonus;
    private String duty;

    public double getSalary() {
        return bonus + super.getSalary();
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}
