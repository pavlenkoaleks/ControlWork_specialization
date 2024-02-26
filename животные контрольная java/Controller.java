
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
  
    public Controller(){};
    public void start(){
    HumanFriend animal1 = new Cat(1,"домашние","кот","Барсик","23 марта 2015","мяу");
    HumanFriend animal2 = new Dog(2,"домашние","собака","Пуся","21 января 2019","гав-гав");
    HumanFriend animal3 = new Horse(3,"вьючные","конь","Гром","6 апреля 2021","и-гог-го");
    HumanFriend animal4 = new Camel(4,"вьючные","верблюд","Тинки","6 апреля 2005","плююсь");
    ArrayList <HumanFriend> animals = new ArrayList<>(List.of(animal1,animal2,animal3,animal4));
    int counter = 5;
    Scanner scan = new Scanner(System.in);
    System.out.println("База данных с животными. 1 - показать всех животных 2 - добавить животное, 3- обучить животное новым способностям 4 - выйти");
    int a = scan.nextInt();
    while(a!=4){
       switch (a) {
        case 1:
        System.out.println(animals);
            break;

       case 2:
        System.out.println("Кого добавить? 1 - кот 2 - собака 3 - лошадь 4 - верблюд");
        int b = scan.nextInt();
        System.out.println("Введите имя и дату рождения");
        scan.nextLine();
        String Animalname =scan.nextLine();
        String Animaldate =scan.nextLine();
        switch (b) {
            case 1:
            HumanFriend cat = new Cat(counter,"домашние","кот",Animalname,Animaldate,"мяу");
            animals.add(cat);
            counter++;
                break;
            case 2:
            HumanFriend dog = new Dog(counter,"домашние","собака",Animalname,Animaldate,"гав-гав");
            animals.add(dog);
            counter++;
                break;
            case 3:
            HumanFriend horse = new Horse(counter,"вьючные","лошадь",Animalname,Animaldate,"и-го-го");
            animals.add(horse);
            counter++;
                break;
            case 4 :
            HumanFriend camel = new Horse(counter,"вьючные","верблюд",Animalname,Animaldate,"плююсь");
            animals.add(camel);
            counter++;
                break;
            default:
                break;
        }


        break;
        case 3:
        System.out.println("Кого будем обучать? Выбери номер");
        System.out.println(animals);
        int c = scan.nextInt(); 
        System.out.println("Чему будем обучать? 1 - принеси тапки 2 - попрыгай 3 - иди погуляй");
        int d = scan.nextInt();
        switch (d) {
            case 1:
            animals.get(c-1).setSkills(", принеск тапки");
                
                break;
            case 2:
            animals.get(c-1).setSkills(", прыгаю");
                    
                break;
            case 3:
            animals.get(c-1).setSkills(", пойду гулять");
                        
                    break;
            default:
                break;
        }


        default:
            break;
       }
       System.out.println("База данных с животными. 1 - показать всех животных 2 - добавить животное, 3- обучить животное новым способностям 4 - выйти");;
        a = scan.nextInt();
        
    }



    }
}