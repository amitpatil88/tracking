create database tracking;
use tracking;

CREATE USER 'tracking'@'localhost' IDENTIFIED BY 'tracking';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON tracking.* TO 'tracking'@'localhost';

