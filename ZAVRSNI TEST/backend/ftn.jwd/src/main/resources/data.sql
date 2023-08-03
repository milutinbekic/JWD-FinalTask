

INSERT INTO user (id, e_mail, user_name, password, name, surname, role)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO user (id, e_mail, user_name, password, name, surname, role)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','USER');
INSERT INTO user (id, e_mail, user_name, password, name, surname, role)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','USER');

              
INSERT INTO festival (id, name) VALUES (1, 'Summer fest');
INSERT INTO festival (id, name) VALUES (2, 'Exit');
INSERT INTO festival (id, name) VALUES (3, 'Beer fest');
INSERT INTO festival (id, name) VALUES (4, 'Arsenal fest');

INSERT INTO artist (id, members, country, name, genre) VALUES (1, 3, 'Serbia', 'A happy Group', 'Zabavna');
INSERT INTO artist (id, members, country, name, genre) VALUES (2, 4, 'BiH', 'Kids From the Hood', 'Rok');
INSERT INTO artist (id, members, country, name, genre) VALUES (3, 1, 'Serbia', 'Majestic', 'Rep');
INSERT INTO artist (id, members, country, name, genre) VALUES (4, 3, 'Makedonija', 'Springers', 'Hip-hop');

INSERT INTO performance (id, festival_id, artist_id) VALUES (1, 1, 2);
INSERT INTO performance (id, festival_id, artist_id) VALUES (2, 2, 2);
INSERT INTO performance (id, festival_id, artist_id) VALUES (3, 3, 3);
INSERT INTO performance (id, festival_id, artist_id) VALUES (4, 4, 4);
INSERT INTO performance (id, festival_id, artist_id) VALUES (5, 2, 1);
INSERT INTO performance (id, festival_id, artist_id) VALUES (6, 1, 3);


