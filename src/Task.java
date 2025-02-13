import java.time.LocalDateTime;

public class Task {
    private int id, status; //status 0=todo 1=in-progress 2=done
    private LocalDateTime createdAt, updatedAt;
    private String description;
    private static int nTask = 0;

    public Task(String description, int id){
        this.id = id;
        this.description=description;
        status=0;
        createdAt=LocalDateTime.now().withSecond(0).withNano(0);
        updatedAt=createdAt;
        nTask++;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }
    
    public int getStatus() {
        return status;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static int getnTask() {
        return nTask;
    }

    
}
