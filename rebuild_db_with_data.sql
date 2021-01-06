drop schema if exists public cascade;

drop table if exists public.questions cascade;
drop table if exists public.person_reward cascade;
drop table if exists public.scores cascade;
drop table if exists public.showcases cascade;
drop table if exists public.users cascade;

create schema public;

CREATE TABLE public.users (
	user_id serial NOT NULL,
	"password" varchar(255) NOT NULL,
	username varchar(255) NOT NULL,
	CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

CREATE TABLE public.showcases (
	showcase_id serial NOT NULL,
	people1 int4 NULL,
	people2 int4 NULL,
	people3 int4 NULL,
	people4 int4 NULL,create schema public;
	user_id int4 NOT NULL,
	CONSTRAINT showcases_pkey PRIMARY KEY (showcase_id),
	CONSTRAINT uk_t2kmw8wonvw26jgkgnpesyngp UNIQUE (user_id)
);
ALTER TABLE public.showcases ADD CONSTRAINT fkhky67bwxrare2j4u24vh0imd3 FOREIGN KEY (user_id) REFERENCES users(user_id);

CREATE TABLE public.scores (
	score_id serial NOT NULL,
	generation date NOT NULL,
	score int4 NOT NULL,
	scoreuser_id int4 NOT NULL,
	CONSTRAINT scores_pkey PRIMARY KEY (score_id)
);
ALTER TABLE public.scores ADD CONSTRAINT fka2tqkk4a18pv00vke4w0bl02o FOREIGN KEY (scoreuser_id) REFERENCES users(user_id);

CREATE TABLE public.person_reward (
	person_reward_id serial NOT NULL,
	personid int4 NOT NULL,
	user_id int4 NOT NULL,
	CONSTRAINT person_reward_pkey PRIMARY KEY (person_reward_id)
);
ALTER TABLE public.person_reward ADD CONSTRAINT fkjg7mevce77dwo43704f4f8h3i FOREIGN KEY (user_id) REFERENCES users(user_id);

CREATE TABLE public.questions (
	question_id serial NOT NULL,
	question varchar(255) NOT NULL,
	CONSTRAINT questions_pkey PRIMARY KEY (question_id),
	CONSTRAINT uk_nv168ew28d2nc8efey0cs2613 UNIQUE (question)
);

--populate the questions table
--people questions
insert into questions (question) values ('''s height measurement is? (***)');
insert into questions (question) values ('''s mass measurement is? (**)');
insert into questions (question) values ('''s hair is which shade?');
insert into questions (question) values ('''s skin is what tone?');
insert into questions (question) values ('''s eyes are what kind of color?');
insert into questions (question) values ('''s birth year happened when? (**BBY)');
insert into questions (question) values ('''s gender is? (male/female or n/a)');
--planet questions
insert into questions (question) values (' takes how long to rotate on it''s axis? (**)');
insert into questions (question) values (' takes how long to orbit it''s star? (***)');
insert into questions (question) values ('''s diameter measurement is? (*****)');
insert into questions (question) values ('''s climate descriptor would be?');
insert into questions (question) values ('''s gravity standard is? (* standard)');
insert into questions (question) values ('''s surface water measurement is? (**)');
insert into questions (question) values ('''s population is?');
--film questions
insert into questions (question) values ('''s episode number is?');
insert into questions (question) values ('''s director is? (***** ****)' );
insert into questions (question) values ('''s release date is? (****-**-**)');
--starship questions
insert into questions (question) values ('''s length measurement is?');
insert into questions (question) values ('''s crew member count is?');
insert into questions (question) values ('''s holds how many passengers');
insert into questions (question) values (' has a cargo capacity of? (******)');
insert into questions (question) values (' has a hyper drive rating of? (*.*)');
insert into questions (question) values ('''s starship class is?');

--populate the users table
insert into public.users (password, username) values ('qDTu5IuSTljghgwtmDtPaw==:iNuaPdwkWS8Ex1byh290fQ==', 'bntufte');
insert into public.users (password, username) values ('zI65ooR0huRHJ8B3zNwYZg==:iPjxlulVhaG7N4M3PmlqtQ==', 'logriffith');
insert into public.users (password, username) values ('9q/ioIRybrrTS97u2tboTA==:KES0j91xwPok/1TSn8XhTg==', 'jlrjr98');
insert into public.users (password, username) values ('b2h90q1Neakp844k0ULI4w==:+VeXMjqZMoAeH+vp/4ZMbA==', 'skytsar');
insert into public.users (password, username) values ('SikUesM+9dGJg3goYRKlKg==:KDVw2KPS4d44XsMmNrAtdw==', 'gvogeller4');
insert into public.users (password, username) values ('3p1S3aqiSOIIuIEMl1MElQ==:EuS3/YdtuKK+vsIP306KYg==', 'mherrero5');
insert into public.users (password, username) values ('RvFPxdSOEVbFd+MmCOxAZA==:J5GWU1d9ydgb7jyL27awAg==', 'owheelwright6');
insert into public.users (password, username) values ('MvE/goImUu5EM+n94gWyHw==:9jSIpG6N6DalgJSnIVteCA==', 'abemrose7');
insert into public.users (password, username) values ('w2TCVm89rZM53GEBxPA/WQ==:EHA3O1tVJkln+x6VkE7Wjw==', 'fesome8');
insert into public.users (password, username) values ('15gX88ijKLocejapJU3mFQ==:oJ+ozvZLQGzrCvUzlOz+qQ==', 'mdumigan9');
insert into public.users (password, username) values ('pgvJtkkL+O0aKcAvzSk91Q==:0M3zAMeq3k09Q3Ym7IedRA==', 'imaccarlicha');
insert into public.users (password, username) values ('s/L7jjhLeYqp5Nr0tNiIEw==:lEC6Lk0nF5iw48LoC86mgQ==', 'ageorgiadesb');
insert into public.users (password, username) values ('pa5V5AU5baFBJtfqalDYDg==:UlyMeQViNLes4SIxN/hVPg==', 'dbonefantc');
insert into public.users (password, username) values ('UBjuD08w4uOB4KVAQjxw+Q==:FizjMM7RFOYlIoh+epN3pQ==', 'cwhitesond');
insert into public.users (password, username) values ('rwAkcf/d7RWK0IhJIQY+hw==:0IFDGA79jNjmyPafNirPsQ==', 'achastane');
insert into public.users (password, username) values ('bS4EjtfTVsQVGTx3WFdlfg==:G7aJrMNqAJ9I3xeTyzgUiA==', 'tpanimanf');
insert into public.users (password, username) values ('4X+EwxxPaXukfrjQZQVs/g==:srBGpxSVUYtfrFpQ5sHk/A==', 'mmacrinng');
insert into public.users (password, username) values ('YXIdythJOweBVah3j6j7KA==:iEuU9Adfp9QAJg0si7rqCA==', 'ahutchingsh');
insert into public.users (password, username) values ('t9jSW7frxiUTj3U06pw0rA==:MU7xcnLa1cy4F1g129sWRA==', 'rcolliholei');
insert into public.users (password, username) values ('fec3D1OgtJF1vdQkB0HPhQ==:amyAOAfMZy9Zi41zxtpM2w==', 'jaickinj');
insert into public.users (password, username) values ('rmMf+zX0jxz0i87JsI1t9w==:Z9bSVn465Q+MK1rUGigMAg==', 'ahulksk');
insert into public.users (password, username) values ('7XHWSR+UbK9wEm6Y2QT4ww==:nr6Cg7U/4nL0OoeNSPl2Mg==', 'ksyrettl');
insert into public.users (password, username) values ('fUtk2YFSRDJysSxh1T8CVQ==:2Cw+1dHtjVF69hMqDjea+w==', 'elochheadm');
insert into public.users (password, username) values ('bsha41HTeRLB6GRZ0Am9mQ==:5ZLHvIfr7DKKUwnb+ZbVEQ==', 'jhattoen');
insert into public.users (password, username) values ('qs0qROhMp+sU8NPZnmVXYw==:R38TAtWgan/6ROrh7VCueg==', 'gstuero');

--populate the showcase table
insert into showcases (people1, people2, people3, people4, user_id) values (18, 1, 8, 35, 1);
insert into showcases (people1, people2, people3, people4, user_id) values (8, 24, 5, 31, 2);
insert into showcases (people1, people2, people3, people4, user_id) values (47, 58, 40, 70, 3);
insert into showcases (people1, people2, people3, people4, user_id) values (70, 37, 76, 19, 4);
insert into showcases (people1, people2, people3, people4, user_id) values (4, 67, 22, 69, 5);
insert into showcases (people1, people2, people3, people4, user_id) values (54, 13, 35, 40, 6);
insert into showcases (people1, people2, people3, people4, user_id) values (59, 72, 74, 80, 7);
insert into showcases (people1, people2, people3, people4, user_id) values (44, 68, 74, 47, 8);
insert into showcases (people1, people2, people3, people4, user_id) values (1, 49, 18, 17, 9);
insert into showcases (people1, people2, people3, people4, user_id) values (2, 43, 41, 47, 10);
insert into showcases (people1, people2, people3, people4, user_id) values (29, 63, 56, 31, 11);
insert into showcases (people1, people2, people3, people4, user_id) values (59, 58, 12, 73, 12);
insert into showcases (people1, people2, people3, people4, user_id) values (3, 53, 72, 41, 13);
insert into showcases (people1, people2, people3, people4, user_id) values (39, 2, 59, 24, 14);
insert into showcases (people1, people2, people3, people4, user_id) values (63, 26, 11, 36, 15);
insert into showcases (people1, people2, people3, people4, user_id) values (42, 51, 53, 57, 16);
insert into showcases (people1, people2, people3, people4, user_id) values (76, 74, 69, 75, 17);
insert into showcases (people1, people2, people3, people4, user_id) values (40, 17, 4, 27, 18);
insert into showcases (people1, people2, people3, people4, user_id) values (35, 50, 78, 26, 19);
insert into showcases (people1, people2, people3, people4, user_id) values (42, 46, 79, 71, 20);
insert into showcases (people1, people2, people3, people4, user_id) values (21, 59, 62, 25, 21);
insert into showcases (people1, people2, people3, people4, user_id) values (5, 70, 40, 80, 22);
insert into showcases (people1, people2, people3, people4, user_id) values (42, 59, 77, 45, 23);
insert into showcases (people1, people2, people3, people4, user_id) values (80, 19, 11, 47, 24);
insert into showcases (people1, people2, people3, people4, user_id) values (20, 14, 24, 30, 25);

--populate the scores table
insert into scores (generation, score, scoreuser_id) values ('07/25/2020', 7, 2);
insert into scores (generation, score, scoreuser_id) values ('06/08/2020', 4, 22);
insert into scores (generation, score, scoreuser_id) values ('06/01/2020', 31, 8);
insert into scores (generation, score, scoreuser_id) values ('05/11/2020', 36, 11);
insert into scores (generation, score, scoreuser_id) values ('02/03/2020', 37, 22);
insert into scores (generation, score, scoreuser_id) values ('10/15/2020', 33, 3);
insert into scores (generation, score, scoreuser_id) values ('07/18/2020', 31, 19);
insert into scores (generation, score, scoreuser_id) values ('01/12/2020', 32, 1);
insert into scores (generation, score, scoreuser_id) values ('01/09/2020', 17, 12);
insert into scores (generation, score, scoreuser_id) values ('02/04/2020', 18, 22);
insert into scores (generation, score, scoreuser_id) values ('08/21/2020', 9, 11);
insert into scores (generation, score, scoreuser_id) values ('10/01/2020', 28, 10);
insert into scores (generation, score, scoreuser_id) values ('01/10/2020', 16, 24);
insert into scores (generation, score, scoreuser_id) values ('03/08/2020', 21, 8);
insert into scores (generation, score, scoreuser_id) values ('03/27/2020', 26, 21);
insert into scores (generation, score, scoreuser_id) values ('04/01/2020', 37, 23);
insert into scores (generation, score, scoreuser_id) values ('12/12/2020', 20, 20);
insert into scores (generation, score, scoreuser_id) values ('12/06/2020', 32, 12);
insert into scores (generation, score, scoreuser_id) values ('02/26/2020', 39, 9);
insert into scores (generation, score, scoreuser_id) values ('02/02/2020', 7, 8);
insert into scores (generation, score, scoreuser_id) values ('03/29/2020', 26, 23);
insert into scores (generation, score, scoreuser_id) values ('04/18/2020', 22, 20);
insert into scores (generation, score, scoreuser_id) values ('11/17/2020', 30, 22);
insert into scores (generation, score, scoreuser_id) values ('06/17/2020', 37, 17);
insert into scores (generation, score, scoreuser_id) values ('06/06/2020', 16, 25);
insert into scores (generation, score, scoreuser_id) values ('12/09/2020', 35, 2);
insert into scores (generation, score, scoreuser_id) values ('05/21/2020', 5, 8);
insert into scores (generation, score, scoreuser_id) values ('12/28/2020', 22, 16);
insert into scores (generation, score, scoreuser_id) values ('04/17/2020', 4, 4);
insert into scores (generation, score, scoreuser_id) values ('03/02/2020', 20, 15);
insert into scores (generation, score, scoreuser_id) values ('03/04/2020', 14, 18);
insert into scores (generation, score, scoreuser_id) values ('01/24/2020', 16, 17);
insert into scores (generation, score, scoreuser_id) values ('05/20/2020', 17, 6);
insert into scores (generation, score, scoreuser_id) values ('01/22/2020', 26, 18);
insert into scores (generation, score, scoreuser_id) values ('09/14/2020', 24, 5);
insert into scores (generation, score, scoreuser_id) values ('12/22/2020', 12, 8);
insert into scores (generation, score, scoreuser_id) values ('12/28/2020', 14, 7);
insert into scores (generation, score, scoreuser_id) values ('04/30/2020', 5, 15);
insert into scores (generation, score, scoreuser_id) values ('06/05/2020', 29, 5);
insert into scores (generation, score, scoreuser_id) values ('12/07/2020', 17, 14);
insert into scores (generation, score, scoreuser_id) values ('07/12/2020', 26, 3);
insert into scores (generation, score, scoreuser_id) values ('10/17/2020', 33, 6);
insert into scores (generation, score, scoreuser_id) values ('04/26/2020', 8, 9);
insert into scores (generation, score, scoreuser_id) values ('05/31/2020', 9, 12);
insert into scores (generation, score, scoreuser_id) values ('06/19/2020', 32, 13);
insert into scores (generation, score, scoreuser_id) values ('08/27/2020', 39, 1);
insert into scores (generation, score, scoreuser_id) values ('11/21/2020', 11, 24);
insert into scores (generation, score, scoreuser_id) values ('02/15/2020', 15, 23);
insert into scores (generation, score, scoreuser_id) values ('07/03/2020', 35, 10);
insert into scores (generation, score, scoreuser_id) values ('02/09/2020', 40, 25);

--populate the reward table
insert into person_reward (personid, user_id) values (57, 11);
insert into person_reward (personid, user_id) values (22, 12);
insert into person_reward (personid, user_id) values (37, 9);
insert into person_reward (personid, user_id) values (25, 18);
insert into person_reward (personid, user_id) values (66, 1);
insert into person_reward (personid, user_id) values (31, 1);
insert into person_reward (personid, user_id) values (64, 8);
insert into person_reward (personid, user_id) values (59, 5);
insert into person_reward (personid, user_id) values (45, 22);
insert into person_reward (personid, user_id) values (71, 8);
insert into person_reward (personid, user_id) values (46, 6);
insert into person_reward (personid, user_id) values (19, 6);
insert into person_reward (personid, user_id) values (53, 14);
insert into person_reward (personid, user_id) values (42, 7);
insert into person_reward (personid, user_id) values (56, 4);
insert into person_reward (personid, user_id) values (41, 11);
insert into person_reward (personid, user_id) values (72, 1);
insert into person_reward (personid, user_id) values (27, 11);
insert into person_reward (personid, user_id) values (64, 19);
insert into person_reward (personid, user_id) values (21, 20);
insert into person_reward (personid, user_id) values (79, 22);
insert into person_reward (personid, user_id) values (68, 16);
insert into person_reward (personid, user_id) values (56, 12);
insert into person_reward (personid, user_id) values (19, 21);
insert into person_reward (personid, user_id) values (65, 20);
insert into person_reward (personid, user_id) values (55, 8);
insert into person_reward (personid, user_id) values (12, 18);
insert into person_reward (personid, user_id) values (12, 25);
insert into person_reward (personid, user_id) values (20, 9);
insert into person_reward (personid, user_id) values (21, 22);
insert into person_reward (personid, user_id) values (4, 20);
insert into person_reward (personid, user_id) values (15, 19);
insert into person_reward (personid, user_id) values (43, 23);
insert into person_reward (personid, user_id) values (7, 5);
insert into person_reward (personid, user_id) values (23, 25);
insert into person_reward (personid, user_id) values (52, 11);
insert into person_reward (personid, user_id) values (82, 7);
insert into person_reward (personid, user_id) values (8, 10);
insert into person_reward (personid, user_id) values (44, 23);
insert into person_reward (personid, user_id) values (2, 20);
insert into person_reward (personid, user_id) values (71, 25);
insert into person_reward (personid, user_id) values (44, 20);
insert into person_reward (personid, user_id) values (73, 20);
insert into person_reward (personid, user_id) values (27, 8);
insert into person_reward (personid, user_id) values (42, 24);
insert into person_reward (personid, user_id) values (30, 4);
insert into person_reward (personid, user_id) values (14, 12);
insert into person_reward (personid, user_id) values (75, 8);
insert into person_reward (personid, user_id) values (55, 6);
insert into person_reward (personid, user_id) values (36, 6);
insert into person_reward (personid, user_id) values (79, 4);
insert into person_reward (personid, user_id) values (78, 9);
insert into person_reward (personid, user_id) values (82, 5);
insert into person_reward (personid, user_id) values (80, 15);
insert into person_reward (personid, user_id) values (3, 16);
insert into person_reward (personid, user_id) values (16, 23);
insert into person_reward (personid, user_id) values (58, 24);
insert into person_reward (personid, user_id) values (6, 16);
insert into person_reward (personid, user_id) values (33, 13);
insert into person_reward (personid, user_id) values (38, 21);
insert into person_reward (personid, user_id) values (68, 18);
insert into person_reward (personid, user_id) values (8, 17);
insert into person_reward (personid, user_id) values (81, 12);
insert into person_reward (personid, user_id) values (45, 23);
insert into person_reward (personid, user_id) values (53, 6);
insert into person_reward (personid, user_id) values (82, 4);
insert into person_reward (personid, user_id) values (50, 22);
insert into person_reward (personid, user_id) values (3, 4);
insert into person_reward (personid, user_id) values (37, 3);
insert into person_reward (personid, user_id) values (13, 5);
insert into person_reward (personid, user_id) values (32, 7);
insert into person_reward (personid, user_id) values (75, 5);
insert into person_reward (personid, user_id) values (18, 18);
insert into person_reward (personid, user_id) values (14, 20);
insert into person_reward (personid, user_id) values (28, 7);
insert into person_reward (personid, user_id) values (5, 13);
insert into person_reward (personid, user_id) values (11, 17);
insert into person_reward (personid, user_id) values (52, 12);
insert into person_reward (personid, user_id) values (5, 8);
insert into person_reward (personid, user_id) values (1, 3);
insert into person_reward (personid, user_id) values (3, 13);
insert into person_reward (personid, user_id) values (70, 10);
insert into person_reward (personid, user_id) values (44, 18);
insert into person_reward (personid, user_id) values (15, 8);
insert into person_reward (personid, user_id) values (22, 22);
insert into person_reward (personid, user_id) values (33, 11);
insert into person_reward (personid, user_id) values (54, 17);
insert into person_reward (personid, user_id) values (34, 23);
insert into person_reward (personid, user_id) values (63, 4);
insert into person_reward (personid, user_id) values (72, 2);
insert into person_reward (personid, user_id) values (71, 16);
insert into person_reward (personid, user_id) values (77, 24);
insert into person_reward (personid, user_id) values (28, 15);
insert into person_reward (personid, user_id) values (42, 5);
insert into person_reward (personid, user_id) values (18, 19);
insert into person_reward (personid, user_id) values (26, 2);
insert into person_reward (personid, user_id) values (71, 19);
insert into person_reward (personid, user_id) values (45, 12);
insert into person_reward (personid, user_id) values (45, 3);
insert into person_reward (personid, user_id) values (4, 24);
