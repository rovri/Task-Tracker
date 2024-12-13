public class List {
    public int add(Task task){  //retorna 1 caso tenha adicionado com sucesso, e 0 caso contrário
        //addnojson
        System.out.println("add");
        return 1;
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
    public int list(){
        System.out.println("list");
        return 1;
    }

}
