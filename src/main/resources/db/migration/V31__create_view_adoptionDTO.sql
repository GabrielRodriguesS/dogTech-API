CREATE VIEW `adoption_dto_view` AS
select `animal`.`id` AS `animalId`,`animal`.`name` AS `animalName`,
`adoption`.`date_interest` AS `dateInterest`,
`adoption`.`date_adoption` AS `dateAdoption`,
`adoption`.`status` AS `status`,`adopter`.`name` AS `adopterName`,
`adopter`.`email` AS `adopterEmail`,`manager`.`name` AS `managerName`
from (((`adoption`
join `animal`on((`adoption`.`animal_id` = `animal`.`id`)))
join `person` `adopter` on((`adoption`.`adopter` = `adopter`.`id`)))
join `person` `manager` on((`adoption`.`adoption_manager` = `manager`.`id`)));