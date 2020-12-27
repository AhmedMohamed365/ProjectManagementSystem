package ProjectManagementSystem;

public abstract class User  {

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


    private String name;

    private String Password;
    private String email;

  
    private Task Tasks;

    private int tasksCount;

    public User() {
    }

    public void Display_userInfo() {
    }
}
