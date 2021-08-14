create table if not exists post (
    id serial primary key,
    namePost text ,
    textPost text,
    link text unique,
    created bigint
);

select * from post;