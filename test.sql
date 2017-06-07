CREATE TABLE IF NOT EXISTS `latest` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
)ENGINE=MyISAM DEFAULT CHARSET=utf8;
