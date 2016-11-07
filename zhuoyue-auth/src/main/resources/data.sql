INSERT INTO `users` VALUES ('admin', 'admin', '1');
INSERT INTO `users` VALUES ('user', 'user', '1');

INSERT INTO `authorities` VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('admin', 'ROLE_USER');
INSERT INTO `authorities` VALUES ('user', 'ROLE_USER');

INSERT INTO `groups` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `groups` VALUES ('2', 'ROLE_USER');

INSERT INTO `group_authorities` VALUES ('1', 'PERM_ACCESS_ADMIN');
INSERT INTO `group_authorities` VALUES ('1', 'PERM_ACCESS_USER');
INSERT INTO `group_authorities` VALUES ('2', 'PERM_ACCESS_USER');

INSERT INTO `group_members` VALUES ('1', 'admin', '1');
INSERT INTO `group_members` VALUES ('2', 'user', '2');
