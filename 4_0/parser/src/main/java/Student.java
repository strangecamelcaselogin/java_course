public class Student {
    private int departament_id;
    private int group_id;
    private int student_id;
    private String surname;
    private String firstname;
    private int mark;


    public int getDepartamentId() {
        return departament_id;
    }
    public void setDepartamentId(int id) {
        this.departament_id = id;
    }
    public int getGroupId() {
        return group_id;
    }
    public void setGroupId(int id) {
        this.group_id = id;
    }
    public int getStudentId() {
        return student_id;
    }
    public void setStudentId(int id) {
        this.student_id = id;
    }


    public String getSurname() {
        return surname;
    }
    public void setSurname(String name) {
        this.surname = name;
    }



    @Override
    public String toString() {
        return "Employee:: ";
    }

}
