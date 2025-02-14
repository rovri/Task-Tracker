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
        JSONObject objTemp = new JSONObject();
        for(int i = 0; i<arrayTasks.length(); i++){
            objTemp=arrayTasks.getJSONObject(i);
            if(objTemp.getInt("id") == id){
                objTemp.put("description", description);
                arrayTasks.put(i, objTemp);
                writeFile();
                return 1;
            }
        }
        //JSONObject obj = arrayTasks.getJSONObject(id-1);
        return 0;
    }

    public int delete(int id){ //retorna 1 caso tenha tido sucesso, e 0 caso contrário
        JSONObject objTemp = new JSONObject();
        for(int i = 0; i<arrayTasks.length(); i++){
            objTemp=arrayTasks.getJSONObject(i);
            if(objTemp.getInt("id") == id){
                arrayTasks.remove(i);
                writeFile();
                return 1;
            }
        }
        
        return 0;
    }

    public int markinprogress(int id){
        JSONObject objTemp = new JSONObject();
        for(int i = 0; i<arrayTasks.length(); i++){
            objTemp=arrayTasks.getJSONObject(i);
            if(objTemp.getInt("id") == id){
                objTemp.put("status", 1);
                arrayTasks.put(i, objTemp);   
                writeFile();
                return 1;
            }
        }
        return 0;
    }

    public int markdone(int id){
        JSONObject objTemp = new JSONObject();
        for(int i = 0; i<arrayTasks.length(); i++){
            objTemp=arrayTasks.getJSONObject(i);
            if(objTemp.getInt("id") == id){
                objTemp.put("status", 2);
                arrayTasks.put(i, objTemp);   
                writeFile();
                return 1;
            }
        }
        return 0;
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
