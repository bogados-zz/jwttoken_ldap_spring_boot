
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (1, 'lcabello', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin@admin.com', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (2, 'sbogado',  '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',  'enabled@userBean.com', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (3, 'admin',     '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'disabled@userBean.com', 0, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));

INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);


------------------QUERY PARA MYSQL-------------------



--INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, STR_TO_DATE('01-01-2016','%c-%e-%Y'));
--INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (2, 'sbogado', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'userBean', 'userBean', 'enabled@userBean.com', 1, STR_TO_DATE('01-01-2016','%c-%e-%Y'));
--INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'userBean', 'userBean', 'disabled@userBean.com', 0, STR_TO_DATE('01-01-2016','%c-%e-%Y'));

--INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
--INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');

--INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
--INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
--INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
--INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);



insert into respuesta (fecha,respuesta) values ('2016-01-01',true);
insert into respuesta (fecha,respuesta) values ('2016-02-01',true);
insert into respuesta (fecha,respuesta) values ('2016-03-01',true);
insert into respuesta (fecha,respuesta) values ('2016-04-01',true);
insert into respuesta (fecha,respuesta) values ('2016-05-01',true);
insert into respuesta (fecha,respuesta) values ('2016-06-01',true);
insert into respuesta (fecha,respuesta) values ('2016-07-01',true);
insert into respuesta (fecha,respuesta) values ('2016-08-01',true);
insert into respuesta (fecha,respuesta) values ('2016-09-01',true);
insert into respuesta (fecha,respuesta) values ('2016-10-01',true);
insert into respuesta (fecha,respuesta) values ('2016-11-01',true);
insert into respuesta (fecha,respuesta) values ('2016-12-01',true);
insert into respuesta (fecha,respuesta) values ('2016-01-01',true);
insert into respuesta (fecha,respuesta) values ('2016-02-01',true);
insert into respuesta (fecha,respuesta) values ('2016-03-01',true);
insert into respuesta (fecha,respuesta) values ('2016-04-01',true);
insert into respuesta (fecha,respuesta) values ('2016-05-01',true);
insert into respuesta (fecha,respuesta) values ('2016-06-01',true);
insert into respuesta (fecha,respuesta) values ('2016-07-01',true);
insert into respuesta (fecha,respuesta) values ('2016-08-01',true);
insert into respuesta (fecha,respuesta) values ('2016-09-01',true);
insert into respuesta (fecha,respuesta) values ('2016-10-01',true);
insert into respuesta (fecha,respuesta) values ('2016-11-01',true);
insert into respuesta (fecha,respuesta) values ('2016-12-01',true);
insert into respuesta (fecha,respuesta) values ('2016-01-01',true);
insert into respuesta (fecha,respuesta) values ('2016-02-01',true);
insert into respuesta (fecha,respuesta) values ('2016-03-01',true);
insert into respuesta (fecha,respuesta) values ('2016-04-01',true);
insert into respuesta (fecha,respuesta) values ('2016-05-01',true);
insert into respuesta (fecha,respuesta) values ('2016-06-01',true);
insert into respuesta (fecha,respuesta) values ('2016-07-01',true);
insert into respuesta (fecha,respuesta) values ('2016-08-01',true);
insert into respuesta (fecha,respuesta) values ('2016-09-01',true);
insert into respuesta (fecha,respuesta) values ('2016-10-01',true);
insert into respuesta (fecha,respuesta) values ('2016-11-01',true);
insert into respuesta (fecha,respuesta) values ('2016-12-01',true);
insert into respuesta (fecha,respuesta) values ('2016-01-01',true);
insert into respuesta (fecha,respuesta) values ('2016-02-01',true);
insert into respuesta (fecha,respuesta) values ('2016-03-01',true);
insert into respuesta (fecha,respuesta) values ('2016-04-01',true);
insert into respuesta (fecha,respuesta) values ('2016-05-01',true);
insert into respuesta (fecha,respuesta) values ('2016-06-01',true);
insert into respuesta (fecha,respuesta) values ('2016-07-01',true);
insert into respuesta (fecha,respuesta) values ('2016-08-01',true);
insert into respuesta (fecha,respuesta) values ('2016-09-01',true);
insert into respuesta (fecha,respuesta) values ('2016-10-01',true);
insert into respuesta (fecha,respuesta) values ('2016-11-01',true);
insert into respuesta (fecha,respuesta) values ('2016-12-01',true);
insert into respuesta (fecha,respuesta) values ('2016-01-01',true);
insert into respuesta (fecha,respuesta) values ('2016-02-01',true);
insert into respuesta (fecha,respuesta) values ('2016-03-01',true);
insert into respuesta (fecha,respuesta) values ('2016-04-01',true);
insert into respuesta (fecha,respuesta) values ('2016-05-01',true);
insert into respuesta (fecha,respuesta) values ('2016-06-01',true);
insert into respuesta (fecha,respuesta) values ('2016-07-01',true);
insert into respuesta (fecha,respuesta) values ('2016-08-01',true);
insert into respuesta (fecha,respuesta) values ('2016-09-01',true);
insert into respuesta (fecha,respuesta) values ('2016-10-01',true);
insert into respuesta (fecha,respuesta) values ('2016-11-01',true);
insert into respuesta (fecha,respuesta) values ('2016-12-01',true);



insert into respuesta (fecha,respuesta) values ('2016-01-01',false);
insert into respuesta (fecha,respuesta) values ('2016-02-01',false);
insert into respuesta (fecha,respuesta) values ('2016-03-01',false);
insert into respuesta (fecha,respuesta) values ('2016-04-01',false);
insert into respuesta (fecha,respuesta) values ('2016-05-01',false);
insert into respuesta (fecha,respuesta) values ('2016-06-01',false);
insert into respuesta (fecha,respuesta) values ('2016-07-01',false);
insert into respuesta (fecha,respuesta) values ('2016-08-01',false);
insert into respuesta (fecha,respuesta) values ('2016-09-01',false);
insert into respuesta (fecha,respuesta) values ('2016-10-01',false);
insert into respuesta (fecha,respuesta) values ('2016-11-01',false);
insert into respuesta (fecha,respuesta) values ('2016-12-01',false);

insert into respuesta (fecha,respuesta) values ('2016-01-01',false);
insert into respuesta (fecha,respuesta) values ('2016-02-01',false);
insert into respuesta (fecha,respuesta) values ('2016-03-01',false);
insert into respuesta (fecha,respuesta) values ('2016-04-01',false);
insert into respuesta (fecha,respuesta) values ('2016-05-01',false);
insert into respuesta (fecha,respuesta) values ('2016-06-01',false);
insert into respuesta (fecha,respuesta) values ('2016-07-01',false);
insert into respuesta (fecha,respuesta) values ('2016-08-01',false);
insert into respuesta (fecha,respuesta) values ('2016-09-01',false);
insert into respuesta (fecha,respuesta) values ('2016-10-01',false);
insert into respuesta (fecha,respuesta) values ('2016-11-01',false);
insert into respuesta (fecha,respuesta) values ('2016-12-01',false);

insert into respuesta (fecha,respuesta) values ('2016-01-01',false);
insert into respuesta (fecha,respuesta) values ('2016-02-01',false);
insert into respuesta (fecha,respuesta) values ('2016-03-01',false);
insert into respuesta (fecha,respuesta) values ('2016-04-01',false);
insert into respuesta (fecha,respuesta) values ('2016-05-01',false);
insert into respuesta (fecha,respuesta) values ('2016-06-01',false);
insert into respuesta (fecha,respuesta) values ('2016-07-01',false);
insert into respuesta (fecha,respuesta) values ('2016-08-01',false);
insert into respuesta (fecha,respuesta) values ('2016-09-01',false);
insert into respuesta (fecha,respuesta) values ('2016-10-01',false);
insert into respuesta (fecha,respuesta) values ('2016-11-01',false);
insert into respuesta (fecha,respuesta) values ('2016-12-01',false);