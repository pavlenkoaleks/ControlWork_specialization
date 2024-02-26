DROP DATABASE if EXISTS controlwork;
create DATABASE if not exists controlwork;
use controlwork;

-- создание иерархии таблиц

DROP TABLE IF EXISTS humans_friends;
CREATE TABLE humans_friends (
id INT AUTO_INCREMENT PRIMARY KEY,
typeofanimal VARCHAR(50)
);
INSERT INTO humans_friends(typeofanimal)
VALUES
('домашние'),
('вьючные');

DROP TABLE IF EXISTS Vid;
CREATE TABLE Vid (
id INT AUTO_INCREMENT PRIMARY KEY,
VidofAnimal VARCHAR(50),
type_id int,
FOREIGN KEY (type_id) REFERENCES humans_friends(id)
);
INSERT INTO Vid(VidofAnimal,type_id)
VALUES
('собака',1),
('кошка',1),
('хомяк',1),
('лошадь',2),
('верблюд',2),
('осел',2)
;
Select* from Vid;
Select* from humans_friends,Vid;
Select humans_friends.typeofanimal, Vid.VidofAnimal from humans_friends,Vid
Where humans_friends.id = Vid.type_id;


DROP TABLE IF EXISTS Animals;
CREATE TABLE Animals (
id INT AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(50),
type_id int,
dateofbirth date,
skils varchar(50),
FOREIGN KEY (type_id) REFERENCES Vid(id)
);
INSERT INTO Animals(firstname,type_id,dateofbirth,skils)
VALUES
('Дружок',1,'2020-01-02','гав'),
('Хатико',1,'2022-01-03','гав'),
('Мелисса',2,'2023-01-17','мяу'),
('Булка',2,'2024-01-05','мяу'),
('Элвин',3,'2022-01-06','хрум-хрум'),
('Батон',3,'2022-01-07','хрум-хрум'),
('Сара',4,'2022-01-08','игого'),
('Конь',4,'2018-01-09','игого'),
('Андрей',5,'2022-01-12','плююсь'),
('Динки',5,'2022-02-06','плююсь'),
('Фикси',6,'2022-01-02','Уже приехали?'),
('Маша',6,'2019-01-03','Уже приехали?');


Select Vid.VidofAnimal,Animals.firstname,Animals.dateofbirth,Animals.skils from Vid,Animals
Where Vid.id = Animals.type_id;

-- удаление верблюдов

DELETE FROM Animals WHERE type_id = 5;

create table young_animals as
Select * from Animals 
Where dateofbirth BETWEEN '2021-02-21' and '2023-02-21';

-- создание "молодых животных"

Select * from young_animals;
ALTER Table young_animals ADD AGE INT ;
UPDATE young_animals
SET AGE = (YEAR(current_date()) - YEAR(dateofbirth)) * 12 + (MONTH(current_date()) - MONTH(dateofbirth));

-- объединение таблиц
create table union_animals as
SELECT Vid.type_id,Vid.VidofAnimal,Animals.firstname,Animals.dateofbirth,Animals.skils 
      FROM  Animals INNER JOIN Vid  
	     ON Vid.id = Animals.type_id;
         
  create table union_animalsALL as 
  SELECT humans_friends.typeofanimal,union_animals.VidofAnimal,union_animals.firstname, union_animals.dateofbirth,union_animals.skils
  From union_animals INNER JOIN  humans_friends
	     ON humans_friends.id = union_animals.type_id;

Select * from union_animalsALL ;


