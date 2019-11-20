package database;

import employee.Employee;

public class EmployeeTable extends MySQLAccess {


    /**
     * Say hello to magic.
     */
    private static final int IN_THREE = 3;
    private static final int IN_FOUR = 4;
    private static final int IN_FIVE = 3;

     /*
     * inserts employee object to Employee table.
     *
     */
    public boolean insertEmployee(final Employee employee) {
        if (employee != null) {
            try {
                super.connect("Hotel");
                ps = conn.prepareStatement("INSERT INTO Employee "
                 + "(id, firstName, lastName, profile, salary) "
                 + "VALUES (? ? ? ? ?)");

                ps.setShort(1, employee.getId());
                ps.setString(2, employee.getFirstName());
                ps.setString(IN_THREE, employee.getLastName());
                ps.setString(IN_FOUR, employee.getProfile());
                ps.setInt(IN_FIVE, employee.getSalary());
                ps.executeUpdate();

                super.disconnect();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

}
