insert into LASTING (LASTING)
values (90),
       (120),
       (60);

insert into FILM (TITLE, LASTING_ID)
values ('F1', 1),
        ('F2',2),
        ('F3',3),
        ('F4',3),
        ('F5',2),
        ('F6',1);

insert into PRICE (COST)
values (300),
       (200),
       (100),
       (500),
       (400),
       (250);

# insert into TICKET (SEANCE_ID)
# values (1),
#        (2),
#        (3),
#        (4),
#        (6),
#        (1);


insert into seance  (TIME_START, FILM_ID, AMOUNT_TICKETS, PRICE_ID, DATE)
values ('10:00:00',1, 12, 2, '2022-12-13'),
       ('11:30:00', 2, 34, 4,'2022-12-13'),
       ('13:30:00', 3, 0, 1,'2022-12-12'),
       ('15:00:00', 4, 0, 6,'2022-12-12'),
       ('17:00:00', 5, 21, 5,'2022-11-14'),
       ('19:00:00', 6, 10, 3,'2022-11-14');

insert into seance  (TIME_START, FILM_ID, AMOUNT_TICKETS, PRICE_ID, DATE)
values ('10:00:00',1, 83, 3, '2022-12-13'),
       ('11:30:00', 2, 34, 5,'2022-12-13');

CREATE VIEW ticket_cost AS select
title, amount_tickets, cost FROM seance
JOIN price on seance.price_id = price.id
JOIN film on seance.film_id = film.id  order by FILM_ID;
