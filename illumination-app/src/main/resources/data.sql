-- address_data
INSERT INTO mtmucha.address_data (address_data_description, address_data_name, city, country, latitude, longitude, street)
        VALUES ('Adres, który jest dary', 'DaryAdres', 'Kraków', 'PL', 50.066666, 19.921411, 'Czarnowiejska');
INSERT INTO mtmucha.address_data (address_data_description, address_data_name, city, country, latitude, longitude, street)
        VALUES ('Adres, który jest dary', 'DaryAdres', 'Kraków', 'PL', 50.066475, 19.921902, 'Czarnowiejska');
INSERT INTO mtmucha.address_data (address_data_description, address_data_name, city, country, latitude, longitude, street)
        VALUES ('Adres, który jest dary', 'DaryAdres', 'Kraków', 'PL', 50.066720, 19.921030, 'Czarnowiejska');
INSERT INTO mtmucha.address_data (address_data_description, address_data_name, city, country, latitude, longitude, street)
        VALUES ('Adres, który jest dary', 'DaryAdres', 'Kraków', 'PL', 50.066912, 19.920290, 'Czarnowiejska');
INSERT INTO mtmucha.address_data (address_data_description, address_data_name, city, country, latitude, longitude, street)
        VALUES ('Adres, który jest dary', 'DaryAdres', 'Kraków', 'PL', 50.067078, 19.919668, 'Czarnowiejska');
INSERT INTO mtmucha.address_data (address_data_description, address_data_name, city, country, latitude, longitude, street)
        VALUES ('Adres tii', 'IksdeAdres', 'Kraków', 'PL', 50.064075, 19.922811, 'Reymonta');
INSERT INTO mtmucha.address_data (address_data_description, address_data_name, city, country, latitude, longitude, street)
        VALUES ('Adres tii', 'IksdeAdres', 'Kraków', 'PL', 50.064330, 19.921202, 'Reymonta');
INSERT INTO mtmucha.address_data (address_data_description, address_data_name, city, country, latitude, longitude, street)
        VALUES ('Adres tii', 'IksdeAdres', 'Kraków', 'PL', 50.064536, 19.919743, 'Reymonta');

-- cron_simply_times

-- lamp_module_data
INSERT INTO mtmucha.lamp_module_data (lamp_module_description, lamp_module_name, ip_address, port)
        VALUES ('Dary moduł', 'DareModule', '127.0.0.1', 8081);
INSERT INTO mtmucha.lamp_module_data (lamp_module_description, lamp_module_name, ip_address, port)
        VALUES ('Moduł Reymonta', 'ReymontaModule', '127.0.0.1', 8081);

-- light_lamp_data
INSERT INTO mtmucha.light_lamp_data (light_lamp_description, light_lamp_name, status, address_data_id, lamp_module_number, light_lamp_module_id)
        VALUES ('Dara lampa', 'LampaDare1', 'W', 1, 1, 1);
INSERT INTO mtmucha.light_lamp_data (light_lamp_description, light_lamp_name, status, address_data_id, lamp_module_number, light_lamp_module_id)
        VALUES ('Dara lampa', 'LampaDare2', 'B', 2, 2, 1);
INSERT INTO mtmucha.light_lamp_data (light_lamp_description, light_lamp_name, status, address_data_id, lamp_module_number, light_lamp_module_id)
        VALUES ('Dara lampa', 'LampaDare3', 'W', 3, 3, 1);
INSERT INTO mtmucha.light_lamp_data (light_lamp_description, light_lamp_name, status, address_data_id, lamp_module_number, light_lamp_module_id)
        VALUES ('Dara lampa', 'LampaDare4', 'N', 4, 4, 1);
INSERT INTO mtmucha.light_lamp_data (light_lamp_description, light_lamp_name, status, address_data_id, lamp_module_number, light_lamp_module_id)
        VALUES ('Dara lampa', 'LampaDare5', 'W', 5, 5, 1);
INSERT INTO mtmucha.light_lamp_data (light_lamp_description, light_lamp_name, status, address_data_id, lamp_module_number, light_lamp_module_id)
        VALUES ('Lampa na Reymonta', 'LampaReymonta1', 'W', 6, 1, 2);
INSERT INTO mtmucha.light_lamp_data (light_lamp_description, light_lamp_name, status, address_data_id, lamp_module_number, light_lamp_module_id)
        VALUES ('Lampa na Reymonta', 'LampaReymonta2', 'W', 7, 2 ,2);
INSERT INTO mtmucha.light_lamp_data (light_lamp_description, light_lamp_name, status, address_data_id, lamp_module_number, light_lamp_module_id)
        VALUES ('Lampa na Reymonta', 'LampaReymonta3', 'N', 8, 3, 2);

-- role
INSERT INTO mtmucha.role (role_name) VALUES ('USER');
INSERT INTO mtmucha.role (role_name) VALUES ('ADMIN');

-- user
INSERT INTO mtmucha.user (usr_login, usr_password)
        VALUES ('mucha', '$2a$10$WhUzDjDaDe56BPsS/3u5vujHfwe/fv5nz0aWQkNTFMeH.ej619j5i');
INSERT INTO mtmucha.user (usr_login, usr_password)
        VALUES ('dare', '$2a$10$7POeuP.9YOJcUq1yCIkpmONEmaS3o/T841fjiaVBXPIZmkmciS12C');

-- user_role
INSERT INTO mtmucha.user_role (ur_usr_id, ur_role_id) VALUES (1, 2);
INSERT INTO mtmucha.user_role (ur_usr_id, ur_role_id) VALUES (1, 1);
INSERT INTO mtmucha.user_role (ur_usr_id, ur_role_id) VALUES (2, 1);
INSERT INTO mtmucha.user_role (ur_usr_id, ur_role_id) VALUES (2, 2);