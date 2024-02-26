
public class Horse extends PackAnimal{
    private String name;
    private String dateofbirth;
    private String skills;


    public Horse(int animal_id, String typeofanimal,String kindofanimal,String name,String dateofbirth,String skills){
        super(animal_id,typeofanimal, kindofanimal);
        this.name=name;
        this.dateofbirth=dateofbirth;
        this.skills=skills;

        
    }

    public String getname(){
        return name;
    }

    public String getskills(){
        return skills;
    }

    public String getbirth(){
        return dateofbirth;
    }
    @Override
    public void setSkills(String newskill){
        skills = skills+ newskill;
    }

  
    @Override
    public String toString() {
        return  "(" + animal_id + ", " +
                typeofanimal + ", " +
                kindofanimal + ", "+
                name + ", "+
                dateofbirth + ", умения:" +
                skills +")";
    }
}
