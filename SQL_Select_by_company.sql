CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);


INSERT INTO company(id, name) values(1,'SumatoSoft');
INSERT INTO company(id, name) values(2,'AgileEngine');
INSERT INTO company(id, name) values(3,'Archer Software');
INSERT INTO company(id, name) values(4,'Artelogic');
INSERT INTO company(id, name) values(5,'The NineHertz');
INSERT INTO company(id, name) values(6,'ZealousWeb');
INSERT INTO company(id, name) values(7,'Simform');
INSERT INTO company(id, name) values(8,'Slingshot');
INSERT INTO company(id, name) values(9,'Technostacks Infotech Pvt. Ltd');

INSERT INTO person(id, name, company_id) values(1, 'Мельникова Ксения Витальевна',2 );
INSERT INTO person(id, name, company_id) values(2, 'Иванова София Ивановна',4 );
INSERT INTO person(id, name, company_id) values(3, 'Буракшаева Юлия Сергеевна',6 );
INSERT INTO person(id, name, company_id) values(4, 'Фурсова Елизавета Владимировна',8 );
INSERT INTO person(id, name, company_id) values(5, 'Сапсай Иван Алексеевич', 1);
INSERT INTO person(id, name, company_id) values(6, 'Богословский Артем Михайлович', 3);
INSERT INTO person(id, name, company_id) values(7, 'Самбикина Юлия Владимировна',5 );
INSERT INTO person(id, name, company_id) values(8, 'Шпак Ангелина Эдуардовна', 7);
INSERT INTO person(id, name, company_id) values(9, 'Пименов Максим Евгеньевич', 9);
INSERT INTO person(id, name, company_id) values(10, 'Сигида Валерия Романовна', 1);
INSERT INTO person(id, name, company_id) values(11, 'Миронова Елизавета Валерьевна', 2);
INSERT INTO person(id, name, company_id) values(12, 'Безуглова Анастасия Александровна', 3);
INSERT INTO person(id, name, company_id) values(13, 'Сергеева Мария Вячеславовна', 4);
INSERT INTO person(id, name, company_id) values(14, 'Перфильева Милена Егоровна', 5);
INSERT INTO person(id, name, company_id) values(15, 'Химич Елена Сергеевна', 6);
INSERT INTO person(id, name, company_id) values(16, 'Бондина Анастасия Борисовна', 7);
INSERT INTO person(id, name, company_id) values(17, 'Лебедева Екатерина Сергеевна', 8);
INSERT INTO person(id, name, company_id) values(18, 'Мощева Алина Георгиевна', 9);
INSERT INTO person(id, name, company_id) values(19, 'Моругина Ирина Николаевна', 2);
INSERT INTO person(id, name, company_id) values(20, 'Прокопенко Алина Дмитривена', 4);
INSERT INTO person(id, name, company_id) values(21, 'Белюга Татьяна Сергеевна', 6);
INSERT INTO person(id, name, company_id) values(22, 'Седенкова Анастасия Максимовна',8 );
INSERT INTO person(id, name, company_id) values(23, 'Храмова Полина Дмитриевна', 9);
INSERT INTO person(id, name, company_id) values(24, 'Бирт Елизавета Александровна', 9);

-- 1. В одном запросе получить
-- - имена всех person, которые не состоят в компании с id = 5;
-- - название компании для каждого человека.
select p.name,c.name from person AS p JOIN company AS c ON p.company_id = c.id and c.id != 5;
-- 2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.
select count(p.company_id),c.name from person AS p JOIN company AS c ON p.company_id = c.id  group by c.name LIMIT 1;

DROP TABLE company;
DROP TABLE person;