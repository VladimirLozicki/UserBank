create table account
(
    accountId integer,
    account   integer,
    userId    integer
);

alter table account
    owner to postgres;

INSERT INTO public.account (accountid, account, userid) VALUES (1, 100, 1);
INSERT INTO public.account (accountid, account, userid) VALUES (2, 200, 2);
INSERT INTO public.account (accountid, account, userid) VALUES (3, 300, 3);
INSERT INTO public.account (accountid, account, userid) VALUES (4, 400, 4);
INSERT INTO public.account (accountid, account, userid) VALUES (5, 500, 5);
INSERT INTO public.account (accountid, account, userid) VALUES (6, 600, 6);
INSERT INTO public.account (accountid, account, userid) VALUES (7, 700, 7);
INSERT INTO public.account (accountid, account, userid) VALUES (8, 800, 8);
INSERT INTO public.account (accountid, account, userid) VALUES (9, 900, 9);
INSERT INTO public.account (accountid, account, userid) VALUES (10, 1000, 10);