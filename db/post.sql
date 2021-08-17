create table if not exists post (
    id serial primary key,
    namePost text unique,
    textPost text,
    link text,
    created timestamp
);

select * from post;

