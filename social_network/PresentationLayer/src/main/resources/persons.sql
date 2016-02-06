INSERT INTO `user` (`email`, `name`, `firstName`, `password`, `enabled`, `birth`, `pays`, `ville`, `gender`, `phoneType`, `phone`, `adress`, `img`) VALUES ('amani@gmail.com', 'Amani', 'LAHBIB', 'amani', '1', '1991-03-27 00:00:00', 'France', 'caen', 'female', 'Mobile', '0754216532', 'rue adresse amani', '1');
INSERT INTO `social_network`.`user_roles` (`user_role_id`, `email`, `role`) VALUES ('1', 'amani@gmail.com', 'ROLE_USER');

INSERT INTO `user` (`email`, `name`, `firstName`, `password`, `enabled`, `birth`, `pays`, `ville`, `gender`, `phoneType`, `phone`, `adress`, `img`) VALUES ('nick@gmail.com', 'Nickita', 'KHARAIM', 'nick', '1', '1989-07-15 00:00:00', 'France', 'caen', 'male', 'Mobile', '0754276537', 'rue adresse nick', '2');
INSERT INTO `social_network`.`user_roles` (`user_role_id`, `email`, `role`) VALUES ('2', 'nick@gmail.com', 'ROLE_USER');

INSERT INTO `user` (`email`, `name`, `firstName`, `password`, `enabled`, `birth`, `pays`, `ville`, `gender`, `phoneType`, `phone`, `adress`, `img`) VALUES ('toto@gmail.com', 'Toto', 'Titi', 'toto', '1', '1989-07-15 00:00:00', 'France', 'caen', 'male', 'Mobile', '0754276537', 'rue adresse nick', '4');
INSERT INTO `social_network`.`user_roles` (`user_role_id`, `email`, `role`) VALUES ('5', 'toto@gmail.com', 'ROLE_USER');

INSERT INTO `user` (`email`, `name`, `firstName`, `password`, `enabled`, `birth`, `pays`, `ville`, `gender`, `phoneType`, `phone`, `adress`, `img`) VALUES ('admin@gmail.com', 'Admin', 'Admin', 'admin', '1', '1980-07-15 00:00:00', 'France', 'Paris', 'male', 'Mobile', '0724576537', 'rue admin', '3');
INSERT INTO `social_network`.`user_roles` (`user_role_id`, `email`, `role`) VALUES ('3', 'admin@gmail.com', 'ROLE_USER');
INSERT INTO `social_network`.`user_roles` (`user_role_id`, `email`, `role`) VALUES ('4', 'admin@gmail.com', 'ROLE_ADMIN');