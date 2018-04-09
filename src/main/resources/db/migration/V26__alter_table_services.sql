ALTER TABLE `dogTech`.`services` 
ADD COLUMN `photo_id` BIGINT(20) NOT NULL AFTER `value`, 
ADD CONSTRAINT `FK_PHOTO_ID` FOREIGN KEY (`photo_id`) 
REFERENCES `dogTech`.`photo`(`id`);