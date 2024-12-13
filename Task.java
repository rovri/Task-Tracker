public class Task {
    private int id, createdAt, updatedAt, status; //status 0=todo 1=in-progress 2=done
    private String description;
    private static int nTask = 0;

    public Task(String description){
        id=nTask+1; //id será a quantidade de tasks + 1
        this.description=description;
        status=0;
        //createdAt=thistime;
        updatedAt=createdAt;
        nTask++;
    }

    
}
