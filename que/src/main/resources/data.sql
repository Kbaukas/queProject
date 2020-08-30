INSERT INTO `tickets`
(`id`,
`specialist_id`,
`serial_number`,
`start_time`,
`end_time`,
`state`)
VALUES
(1, 1, '1111', '2020-09-30 2:09:30.915555', '2020-08-29 22:09:30.915555','WAITING'),
(2, 1, '1011','2020-09-30 2:19:30.915555','2020-08-29 22:09:30.915555','WAITING'),
(3, 2, '3005','2020-09-30 1:19:30.915555','2020-08-29 22:09:30.915555','WAITING'),
(4, 3, '4112','2020-09-30 1:39:30.915555','2020-08-29 22:09:30.915555','WAITING');

INSERT INTO `specialists`
(`id`,
`user_name`,
`speciality`,
`first_name`,
`last_name`,
`password`)
VALUES
(1, 'manageris5', 'MANAGER', 'Inga', 'Super', 'asdasdasdasda'),
(2, 'adminas2','ADMIN', 'Onute', 'Gera', 'asdasdasdasda'),
(3, 'supportas5','SUPPORT', 'Jonas', 'Nebicas', 'asdasdasdasda'),
(4, 'buhalteris1','ACCOUNTANT', 'Petras', 'Bicas', 'asdasdasdasda');




