CREATE TABLE IF NOT EXISTS bank.`users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint default 1,
  `isLoggedIn` tinyint default 0,
  PRIMARY KEY (`idusers`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT IGNORE INTO bank.users (
`username`,
`password`,
`enabled`,
`isLoggedIn`) values ('user','easypassword',1,0);


INSERT IGNORE INTO bank.users (
`username`,
`password`,
`enabled`,
`isLoggedIn`) values ('admin','toughpassword',1,0);

CREATE TABLE IF NOT EXISTS bank.`authorities` (
  `idroles` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`idroles`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT IGNORE INTO bank.authorities (username,authority) values ('user','USER');


INSERT IGNORE INTO bank.authorities (username,authority)  values ('admin','ADMIN');