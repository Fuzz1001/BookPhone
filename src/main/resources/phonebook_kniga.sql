CREATE DATABASE phonebook;
use phonebook;
DROP TABLE IF EXISTS kniga;
CREATE TABLE kniga
(
                       `id` int(11) NOT NULL AUTO_INCREMENT,
                       `name` varchar(128) NOT NULL,
                       `email` varchar(128) NOT NULL,
                       `phone` int(11),
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (1, 'Viwdwor', 'vicwdmail.com', 7034);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (2, 'Gerald', 'ger24@gmail.com', 7074714);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (3, 'Ciri', 'ciri53@gmail.com', 7054552);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (4, 'Berthold', 'ber74@gmail.com', 7028562);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (5, 'Ann', 'ann36@gmail.com', 7061854);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (6, 'Rainer', 'rain85@gmail.com', 7049567);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (7, 'Katrine', 'cat53@gmail.com', 7056732);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (8, 'Guts', 'sword99@gmail.com', 7069977);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (9, 'Elena', 'len27@gmail.com', 7037462);
INSERT INTO phonebook.kniga (id, name, email, phone) VALUES (11, 'Vicwdtor', 'vicqd@gmail.com', 70324);