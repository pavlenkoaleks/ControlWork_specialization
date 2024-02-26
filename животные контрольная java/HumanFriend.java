public class HumanFriend {
    protected int animal_id;
    protected String typeofanimal;



    public HumanFriend(int animal_id, String typeofanimal) {
        this.animal_id= animal_id;
        this.typeofanimal = typeofanimal;
    }

    public int getid(){
        return animal_id;
    }

    public String gettype(){
        return typeofanimal;
    
    }

    public void setSkills(String newskill){
    }
}
