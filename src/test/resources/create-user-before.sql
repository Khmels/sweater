delete from user_role;
delete from usr;

insert into usr (id, active, password, username) values
(1,true, '$2a$08$2W0.DTFZ9Y6jYCSH..SI4eevA9NcP2.pebbJbPvix9HglC8ne9zA2', 'testUser'),
(2,true,'$2a$08$NIb.1NfsKDPWG11AbBhsdu0FdpUM/Rqq24c8mGglhXFhGo8/n5gGm', 'user2');

insert into user_role(user_id, roles) values
(1,'USER'),(1,'ADMIN'),
(2,'USER');

