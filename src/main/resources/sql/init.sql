create table contacts
(
    id   bigserial not null
        constraint contacts_pk
            primary key,
    name varchar   not null
);

alter table contacts
    owner to postgres;

create unique index contacts_id_uindex
    on contacts (id);

INSERT INTO contacts(id, name) values (1, 'Albert');
INSERT INTO contacts(id, name) values (2, 'Kate');
INSERT INTO contacts(id, name) values (3, 'Jenifer');
INSERT INTO contacts(id, name) values (4, 'Emily');
INSERT INTO contacts(id, name) values (5, 'Jack');
INSERT INTO contacts(id, name) values (6, 'Michael');
INSERT INTO contacts(id, name) values (7, 'Reece');
INSERT INTO contacts(id, name) values (8, 'Lily');