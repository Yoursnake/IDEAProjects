package first.Management;

public class ManageMain {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("sheng");
        employee.setSalary(2000);
        employee.setId(100);
        System.out.println(employee.getName() + " 的薪水为 "
                + employee.getSalary() + "，id 为 " + employee.getId());

        Manager manager = new Manager();
        manager.setName("zhao");
        manager.setSalary(2000);
        manager.setId(101);
        manager.setBonus(500);
        manager.setDuty("cleaner");
        System.out.println(manager.getName() + " 的薪水为 "
                + manager.getSalary() + "，id 为 " + manager.getId()
                + "，职务为 " + manager.getDuty());
    }
}
