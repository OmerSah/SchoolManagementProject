CREATE TABLE `sys`.`student` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `parentName` VARCHAR(45) NULL,
  `guideTeacher` VARCHAR(45) NULL,
  `takenCourses` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `sys`.`teacher` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `givenCourses` VARCHAR(45) NULL,
  `guidedStudents` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `sys`.`principal` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `sys`.`theoretical_course` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `credits` VARCHAR(45) NULL,
  `instructor` VARCHAR(45) NULL,
  `midtermPercentage` VARCHAR(45) NULL,
  `finalPercentage` VARCHAR(45) NULL,
  `sourcebook` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));



CREATE TABLE `sys`.`applied_course` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `credits` VARCHAR(45)  NULL,
  `instructor` VARCHAR(45) NULL,
  `midtermPercentage` VARCHAR(45) NULL,
  `finalPercentage` VARCHAR(45) NULL,
  `projectPercentage` VARCHAR(45) NULL,
  `labPercentage` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
