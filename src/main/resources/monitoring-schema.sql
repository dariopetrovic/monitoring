CREATE SCHEMA `monitoring` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `monitoring`.`tb_monitoring_results` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `device_type` VARCHAR (45),
  `measurement_value` VARCHAR (45),
  `measurement_date` DATETIME ,
  `measurement_created` DATETIME ,
  PRIMARY KEY (`id`));