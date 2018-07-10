use aurora;

CREATE TABLE `aurora`.`training_info` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `training_number` INT NULL,
  `test_number` INT NULL,
  `total_number` INT NULL,
  `accuracy` INT NULL,
  `model_id` INT NULL,
	`training_info` DATE NULL,
  PRIMARY KEY (`id`));
  

  CREATE TABLE `aurora`.`model_info` (
  `id` INT NOT NULL,
  `training_date` DATE NULL,
  `model_name` VARCHAR(45) NULL,
  `training_method` VARCHAR(45) NULL,
  `path` VARCHAR(200) NULL,
	`training_id` INT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `aurora`.`predict_record` (
  `id` INT NOT NULL,
  `content` BLOB NULL,
  `predict_result` VARCHAR(45) NULL,
  `actual_result` VARCHAR(45) NULL,
  `is_correct` TINYINT NULL,
	`model_id` INT NULL,
  PRIMARY KEY (`id`));


ALTER TABLE `aurora`.`predict_record` 

ADD CONSTRAINT `FK_MODEL_INFO`
  FOREIGN KEY (`model_id`)
  REFERENCES `aurora`.`model_info` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  
ALTER TABLE `aurora`.`model_info` 
ADD INDEX `FK_TRAINING_INFO_idx` (`training_id` ASC);
ALTER TABLE `aurora`.`model_info` 
ADD CONSTRAINT `FK_TRAINING_INFO`
  FOREIGN KEY (`training_id`)
  REFERENCES `aurora`.`training_info` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `aurora`.`training_info` 
ADD INDEX `FP_MODEL_INFO_idx` (`model_id` ASC);
ALTER TABLE `aurora`.`training_info` 
ADD CONSTRAINT `FP_MODEL_INFO`
  FOREIGN KEY (`model_id`)
  REFERENCES `aurora`.`model_info` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;