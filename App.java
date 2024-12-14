public class App{
    public static void main(String[] args){
        String comando = " ";
        comando = args[0];
        TaskList lista = new TaskList();
        String desc = "";
        int id = 0;

        
        switch(comando){
            case "add":
                desc = args[1];
                for(int i = 2; i<args.length; i++){ //Dessa forma adiciona todo o texto restante do arg na String desc
                    desc = desc + " " + args[i];
                }
                Task tempT = new Task(desc, lista.getAvailableID());
                lista.add(tempT);
                break;
            case "update":
                id = getId(args);
                desc = args[2];
                for(int i = 3; i<args.length; i++){
                    desc = desc + " " + args[i];
                }
                lista.update(id, desc);
                break;
            case "delete":
                id = getId(args);
                lista.delete(id);
                break;
            case "mark-in-progress":
                id = getId(args);
                lista.markinprogress(id);
                break;
            case "mark-done":
                id = getId(args);
                lista.markdone(id);
                break;
            case "list":
                if(args.length>1){
                    desc = args[1];
                    if(desc.equals("done")){
                        //Implementar done
                    }
                    if(desc.equals("todo")){
                        //Implementar todo
                    }
                    if(desc.equals("in-progress")){
                        //Implementar in-progress
                    }
                }else{
                    lista.list();
                }
                break;
            default:
                System.out.println("Insira um comando válido: add, update, delete, list mark-in-progress, list mark-done, list");
                break;
        }

    }

    public static int getId(String[] args){
        int id=0;
        try{
            id = Integer.parseInt(args[1]);
        } catch(NumberFormatException e) {
            System.out.println("Invalid ID: ID is not a number");
        }
        return id;
    }
}