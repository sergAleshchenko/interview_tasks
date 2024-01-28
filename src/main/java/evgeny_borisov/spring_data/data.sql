CREATE TABLE Speaker
(
    id SERIAL PRIMARY KEY,
    speakerName TEXT
);

select * from speaker;
select * from talk;
select * from speaker join Talk T on Speaker.id = T.speaker_id;

select speakerName from speaker join Talk T on Speaker.id = T.speaker_id where talkTitle like '%Spring%';

insert into speaker(speakerName) values ('Evgeni Borisov');
insert into speaker(speakerName) values ('Ivan Ivanov');
insert into speaker(speakerName) values ('Petr Sergeev');
insert into speaker(speakerName) values ('Sergei Aleshchenko');


CREATE TABLE Talk
(
    talkId SERIAL PRIMARY KEY,
    speaker_id INT NOT NULL,
    talkDate date NOT NULL,
    talkTitle varchar(100) DEFAULT NULL,
    CONSTRAINT fk_speaker FOREIGN KEY (speaker_id) REFERENCES Speaker(id)
);

insert into Talk(speaker_id, talkDate, talkTitle) values (1, '2022-03-14', 'Spring title');
insert into Talk(speaker_id, talkDate, talkTitle) values (2, '2022-03-14', 'Hibernate title');
insert into Talk(speaker_id, talkDate, talkTitle) values (3, '2022-03-14', 'Java title');
insert into Talk(speaker_id, talkDate, talkTitle) values (4, '2022-03-14', 'Spring Data');
insert into Talk(speaker_id, talkDate, talkTitle) values (1, '2022-03-14', 'Title 1');
insert into Talk(speaker_id, talkDate, talkTitle) values (3, '2022-03-14', 'Title 2');
insert into Talk(speaker_id, talkDate, talkTitle) values (3, '2022-03-14', 'Title 3');
insert into Talk(speaker_id, talkDate, talkTitle) values (4, '2022-03-14', 'Title 4');
