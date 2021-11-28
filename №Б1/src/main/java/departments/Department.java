package departments;

import java.util.List;

public abstract class Department {

    private int serviceTime;
    private List<Department> subDepartments;

    public Department(int serviceTime, List<Department> subDepartments) {
        this.serviceTime = serviceTime;

        if (subDepartments == null) {
            this.subDepartments = List.of();
        } else {
            this.subDepartments = subDepartments;
        }
    }

    private int calculateSubDepartmentsServiceTime() {
        int maxServiceTime = 0;

        for (Department subDepartment : subDepartments) {
            int subDepartmentServiceTime = subDepartment.getServiceTime();
            if (subDepartmentServiceTime > maxServiceTime) {
                maxServiceTime = subDepartmentServiceTime;
            }
        }
        return maxServiceTime;
    }

    public int getServiceTime() {
        return serviceTime + calculateSubDepartmentsServiceTime();
    }

}
