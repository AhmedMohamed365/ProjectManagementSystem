package ProjectManagementSystem;

public abstract class User  {
    private String name;
    private String Password;
    private String email;
    private String mobileNumber;

    public String getGender() {
        return gender;
    }

    private String gender ;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Task getTasks() {
        return Tasks;
    }

    public void setTasks(Task Tasks) {
        this.Tasks = Tasks;
    }

    public int getTasksCount() {
        return tasksCount;
    }

    public void setTasksCount(int tasksCount) {
        this.tasksCount = tasksCount;
    }
    
      public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    private Task Tasks;

    private int tasksCount;

    public User() {
    }

    public void Display_userInfo() {
    }
}
