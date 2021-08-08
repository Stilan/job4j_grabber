create table if not exists rabbit (
    id serial primary key,
    created_date bigint
);

select * from rabbit;

drop table rabbit;