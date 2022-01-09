delete from message;

insert into message(id, text, tag, user_id) values
(1, 'first', 'my_tag', 1),
(2, 'second', 'my_tag2', 1),
(3, 'third', 'my_tag3', 1),
(4, 'fourth', 'my_tag4', 1);

alter sequence hibernate_sequence restart with 10;
