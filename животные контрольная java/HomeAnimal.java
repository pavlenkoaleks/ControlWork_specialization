public class HomeAnimal extends HumanFriend{
    protected  String kindofanimal ;

    public HomeAnimal(int animal_id, String typeofanimal,String kindofanimal){
       
        super(animal_id,typeofanimal);
        this.kindofanimal = kindofanimal;
    }
    public String getkind(){
        return kindofanimal;
    
    }
}
