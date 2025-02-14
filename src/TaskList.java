import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;


public class TaskList {
    //List<String> lista = new ArrayList<>();
    JSONArray arrayTasks = new JSONArray();
    int availableID = 0;
    File arquivo = new File("lista.json");

    public TaskList(){
        initFile();
    }

    public int getAvailableID() {
        if(arquivo.exists()){
            return arrayTasks.length()+1;
            //return lista.size()+1;
        }else{
            return 1;
        }
    }

    private void initFile() {
        try {
            if (arquivo.exists() && arquivo.length() > 0) {
                String conteudo = new String(Files.readAllBytes(Paths.get("lista.json")));
                arrayTasks = new JSONArray(conteudo); // Converte a string JSON para um JSONArray
            } else {
                arquivo.createNewFile(); 
                arrayTasks = new JSONArray(); // Inicializa um JSONArray vazio se o arquivo estiver vazio
            }
        } catch (IOException | JSONException e) {
            System.out.println("Erro ao inicializar o arquivo.");
            e.printStackTrace();
        }
    }

    public int add(Task task){  //retorna 1 caso tenha adicionado com sucesso, e 0 caso contrário
        JSONObject taskNew = new JSONObject();
        taskNew.put("id", task.getId());
        taskNew.put("status", task.getStatus());
        taskNew.put("description", task.getDescription());
        taskNew.put("createdAt", task.getCreatedAt());
        taskNew.put("updatedAt", task.getUpdatedAt());
        arrayTasks.put(taskNew);
        writeFile();
        return 1;  
    }

    private void writeFile(){ //escreve o array JSON no arquivo lista.json
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("lista.json"));
            writer.write(arrayTasks.toString());
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public int update(int id, String description){ //retorna 1 caso tenha tido sucesso, e 0 caso contrário
        JSONObject obj = arrayTasks.getJSONObject(id-1);
        obj.put("description", description);
        arrayTasks.put(id, obj);
        writeFile();
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
                System.out.println(arrayTasks.toString());
            /*
                for(String l:lista){
                    String[] parts = l.split("\\|");
                    System.out.println(parts[1]);
                }
            */
                break;
            case "todo":
                System.out.println("todo");
                //for(String l:lista){
                    //String[] parts = l.split("\\|");
                    //if(parts[2].equals("0")){
                    //    System.out.println(parts[1]);
                    //}
                //}
                break;
            case "in-progress":
                System.out.println("in-progress");
                //for(String l:lista){
                    //String[] parts = l.split("\\|");
                    //if(parts[2].equals("1")){
                    //    System.out.println(parts[1]);
                    //}
                //}
                break; 
            case "done":
                System.out.println("done");
                //for(String l:lista){
                    //String[] parts = l.split("\\|");
                    //if(parts[2].equals("2")){
                    //    System.out.println(parts[1]);
                    //}
                //}
                break;
        }
    }

}
