CREATE TABLE `customer`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR (255) DEFAULT NULL ,
  `contact` VARCHAR (255) DEFAULT NULL ,
  `telephone` VARCHAR (255) DEFAULT NULL ,
  `email` VARCHAR (255) DEFAULT NULL ,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `customer` VALUES ('1', 'customer1', 'Jack', '13456420984', 'jack@gmail.com', null);
INSERT INTO `customer` VALUES ('2', 'customer2', 'Rose', '13645410239', 'rose@gmail.com', null);
