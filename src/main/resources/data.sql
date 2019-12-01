insert into CARD_TYPE (CARD_ID,CARD_TYPE,MULTIPLYING_FACTOR)
values (1,'Regular',1),
       (2,'Student',0.85),
       (3,'Senior Citizen',0.75);

insert into USER(RFID, NAME, CARD_ID, PASSWORD, CURRENT_BALANCE)
values (501,'Lokesh',1,'Lokesh123', 1000),
       (502,'Umesh',3,'Umesh123', 500),
       (503,'Sandeep',2,'Sandeep123', 0),
       (504,'Prashant',1,'Prashant123', 1600),
       (505,'Avinash',2,'Avinash123', 700);

insert into RECHARGE(RECEIPT_NO,PAY_MODE,RECHARGE_AMOUNT,RECHARGE_POINT,USER_ID,RECHARGE_TIMESTAMP)
values (1001,'Cash',1000.00,'Domlur',501,'2019-09-16 16:06:02'),
       (1002,'Net Banking',1500.00,'Online',504,'2018-11-12 18:10:13'),
       (1003,'Debit Card',100.00,'Online',504,'2018-11-02 20:12:53'),
       (1004,'Credit Card',500.00,'Online',502,'2019-03-24 04:43:25'),
       (1005,'UPI',700.00,'Online',505,'2019-12-14 10:15:43');

insert into ROUTE(ROUTE_ID,SOURCE_STATION,DESTINATION_STATION)
values ('MR1','Mysore Road','Magadird Rd'),
       ('MR2','City Rly Stad','Vidhansudha'),
       ('MR3','Cubbon Park','Indiranagar'),
       ('MR4','Nagasandra','Goraguntela'),
       ('BR1','K R Market','Malayya Hospital'),
       ('BR2','Marathalli','Varthur Rd'),
       ('BR3','Whitefield Club','Hoodi'),
       ('BR4','Kodihalli','Malayya Hospital');

insert into ROUTE_PATH(ROUTE_ID,STATION_NUMBER,STATION_NAME,ACCUMULATIVE_DISTANCE)
values ('MR1',0,'Mysore Road',0),
       ('MR1',1,'Deepanjali Nagar',4),
       ('MR1',2,'Athiguppe',6),
       ('MR1',3,'Vijay Nagar',8),
       ('MR1',4,'Magadird Rd',26),

       ('MR2',0,'City Rly Stad',0),
       ('MR2',1,'Majestic',2),
       ('MR2',2,'Sir M V Statue Rd',4),
       ('MR2',3,'Vidhansudha',6),

       ('MR3',0,'Cubbon Park',0),
       ('MR3',1,'M G Road',2),
       ('MR3',2,'Trinity',6),
       ('MR3',3,'halasuru',10),
       ('MR3',4,'Indiranagar',12),


       ('MR4',0,'Nagasandra',0),
       ('MR4',1,'Dasarahalli',2),
       ('MR4',2,'Jalahalli',7),
       ('MR4',3,'Peenya Industry',11),
       ('MR4',4,'Peenya',13),
       ('MR4',5,'Goraguntela',16),

       ('BR1',0,'K R Market',0),
       ('BR1',1,'Town Hall',3),
       ('BR1',2,'Corporation',5),
       ('BR1',3,'Kautirava Stadium',6),
       ('BR1',4,'Malayya Hospital',18),

       ('BR2',0,'Marathalli',0),
       ('BR2',1,'Munnekolalu',6),
       ('BR2',2,'Kundahalli Gate',10),
       ('BR2',3,'Tubarahali',13),
       ('BR2',4,'Siddarura',18),
       ('BR2',5,'Varthur Rd',22),

       ('BR3',0,'Whitefield Club',0),
       ('BR3',1,'Ambedkar Nagar',2),
       ('BR3',2,'ITPL',5),
       ('BR3',3,'Hoodi',8),

       ('BR4',0,'Kodihalli',0),
       ('BR4',1,'Domlur',2),
       ('BR4',2,'Commando Hospital',4),
       ('BR4',3,'Trinity Circle',8),
       ('BR4',4,'M G Road',10),
       ('BR4',5,'Mayo hall',11),
       ('BR4',6,'Brigade Road Junction',13),
       ('BR4',7,'Richmond Circle',14),
       ('BR4',8,'Malayya Hospital',17);


insert into TRANSPORTATION_MODE(TRANSPORT_ID,TRANSPORT_TYPE,RATE)
values (1,'Bus',5),
       (2,'Metro',3);

insert into TRANSPORT(TRANSPORT_ID,TRANSPORT_MODE_ID,ROUTE_ID)
values (1001,1,'BR1'),
       (1002,2,'MR1'),
       (1003,1,'BR1'),
       (1004,2,'MR2'),
       (1005,1,'BR2'),
       (1006,2,'MR3'),
       (1007,1,'BR3'),
       (1008,1,'BR4'),
       (1009,2,'MR4'),
       (1010,1,'BR3'),
       (1011,2,'MR2'),
       (1012,1,'BR3');