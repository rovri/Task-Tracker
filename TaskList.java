import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<String> lista = new ArrayList<>();
    int availableID = 0;
    File arquivo = new File("lista.json");

    public TaskList(){
        initFile();
    }

    public int getAvailableID() {
        if(arquivo.exists()){
            return lista.size()+1;
        }else{
            return 1;
        }
    }

    private void initFile(){
        try{
            arquivo.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader("lista.json"));
            for(String line = reader.readLine(); line!= null; line=reader.readLine()){
                lista.add(line);
            }
            reader.close();
        } catch(IOException e){
            System.out.println("Um erro ocorreu na hora de criar o arquivo.");
            e.printStackTrace();
        }
    }

    public int add(Task task){  //retorna 1 caso tenha adicionado com sucesso, e 0 caso contrário
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("lista.json"));
            for(String l:lista){
                writer.write(l+"\n");
            }
            writer.write(task.getId()+"|"+task.getDescription()+"|"+task.getStatus()+"|"+task.getCreatedAt()+"|"+task.getUpdatedAt());
            writer.close();
            return 1;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }

        
    }

    public int update(int id, String description){ //retorna 1 caso tenha tido sucesso, e 0 caso contrário
        System.out.println("update");
        return 1;
    }

    public int delete(int id){ //retorna 1 caso tenha tido sucesso, e 0 caso contrário
        System.out.println("delete");
        return 1;
    }

    public int markinprogress(int id){
        System.out.println("markinprogress");
        return 1;
    }

    public int markdone(int id){
        System.out.println("markdone");
        return 1;
    }

    public void list(String status){
        switch(status){
            case "all":
                for(String l:lista){
                    String[] parts = l.split("\\|");
                    System.out.println(parts[1]);
                }
                break;
            case "todo":
                for(String l:lista){
                    String[] parts = l.split("\\|");
                    if(parts[2].equals("0")){
                        System.out.println(parts[1]);
                    }
                }
                break;
            case "in-progress":
                for(String l:lista){
                    String[] parts = l.split("\\|");
                    if(parts[2].equals("1")){
                        System.out.println(parts[1]);
                    }
                }
                break; 
            case "done":
                for(String l:lista){
                    String[] parts = l.split("\\|");
                    if(parts[2].equals("2")){
                        System.out.println(parts[1]);
                    }
                }
                break;
        }
    }

}
