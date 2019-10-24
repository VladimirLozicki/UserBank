create table users
(
    userId   integer,
    name     varchar(45),
    sureName varchar(45)
);

alter table users
    owner to postgres;

INSERT INTO public.users (userid, name, surename) VALUES (1, 'yan', 'lans');
INSERT INTO public.users (userid, name, surename) VALUES (2, 'gleb', 'van');
INSERT INTO public.users (userid, name, surename) VALUES (3, 'vlad', 'pol');
INSERT INTO public.users (userid, name, surename) VALUES (4, 'slava', 'may');
INSERT INTO public.users (userid, name, surename) VALUES (5, 'vladimir', 'qwerty');
INSERT INTO public.users (userid, name, surename) VALUES (6, 'petya', 'novik');
INSERT INTO public.users (userid, name, surename) VALUES (7, 'aleksandr', 'kozhanovskiy');
INSERT INTO public.users (userid, name, surename) VALUES (8, 'maksim', 'maksimuk');
INSERT INTO public.users (userid, name, surename) VALUES (9, 'aleksei', 'gorlach');
INSERT INTO public.users (userid, name, surename) VALUES (10, 'matvei', 'pom');