use aurora;

drop table predict_record;
drop table model_info;
drop table training_info;


CREATE TABLE IF NOT EXISTS `aurora`.`predict_record` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` BLOB NULL DEFAULT NULL,
  `predict_result` VARCHAR(45) NULL DEFAULT NULL,
  `actual_result` VARCHAR(45) NULL DEFAULT NULL,
  `is_correct` TINYINT(4) NULL DEFAULT NULL,
  `model_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_MODEL_INFO_idx` (`model_id` ASC),
  CONSTRAINT `FK_MODEL_INFO`
    FOREIGN KEY (`model_id`)
    REFERENCES `aurora`.`model_info` (`id`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `aurora`.`model_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `training_date` DATE NULL DEFAULT NULL,
  `model_name` VARCHAR(45) NULL DEFAULT NULL,
  `training_method` VARCHAR(45) NULL DEFAULT NULL,
  `path` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3


CREATE TABLE IF NOT EXISTS `aurora`.`training_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `training_number` INT(11) NULL DEFAULT NULL,
  `test_number` INT(11) NULL DEFAULT NULL,
  `total_number` INT(11) NULL DEFAULT NULL,
  `accuracy` INT(11) NULL DEFAULT NULL,
  `model_id` INT(11) NULL DEFAULT NULL,
  `training_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FP_MODEL_INFO_idx` (`model_id` ASC),
  CONSTRAINT `FP_MODEL_INFO`
    FOREIGN KEY (`model_id`)
    REFERENCES `aurora`.`model_info` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2