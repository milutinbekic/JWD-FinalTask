

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

              
INSERT INTO festival (id, naziv) VALUES (1, 'Letnji festival');
INSERT INTO festival (id, naziv) VALUES (2, 'Exit');
INSERT INTO festival (id, naziv) VALUES (3, 'Beer fest');
INSERT INTO festival (id, naziv) VALUES (4, 'Arsenal fest');

INSERT INTO izvodjac (id, broj_clanova, drzava_porekla, ime, zanr) VALUES (1, 3, 'Srbija', 'Vesela druzina', 'Zabavna');
INSERT INTO izvodjac (id, broj_clanova, drzava_porekla, ime, zanr) VALUES (2, 4, 'BiH', 'Bend iz kraja', 'Rok');
INSERT INTO izvodjac (id, broj_clanova, drzava_porekla, ime, zanr) VALUES (3, 1, 'Srbija', 'Majestic', 'Rep');
INSERT INTO izvodjac (id, broj_clanova, drzava_porekla, ime, zanr) VALUES (4, 3, 'Makedonija', 'nePoznati klinci', 'Hip-hop');

INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (1, 1, 2);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (2, 2, 2);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (3, 3, 3);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (4, 4, 4);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (5, 2, 1);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUES (6, 1, 3);


