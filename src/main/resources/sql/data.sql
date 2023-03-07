INSERT INTO `k_pac` (`title`, `description`, creation_date) VALUES ('title1', 'description1', '06-03-2023');
INSERT INTO `k_pac` (`title`, `description`, creation_date) VALUES ('title2', 'description2', '06-03-2023');
INSERT INTO `k_pac` (`title`, `description`, creation_date) VALUES ('title3', 'description3', '06-03-2023');
INSERT INTO `k_pac` (`title`, `description`, creation_date) VALUES ('title4', 'description4', '06-03-2023');
INSERT INTO `k_pac` (`title`, `description`, creation_date) VALUES ('title5', 'description5', '06-03-2023');


INSERT INTO `k_pac_set` (`title`) VALUES ('title1');
INSERT INTO `k_pac_set` (`title`) VALUES ('title2');
INSERT INTO `k_pac_set` (`title`) VALUES ('title3');
INSERT INTO `k_pac_set` (`title`) VALUES ('title4');

INSERT INTO `k_pac_k_pac_set` (k_pac_id, k_pac_set_id) VALUES (1, 4);
INSERT INTO `k_pac_k_pac_set` (k_pac_id, k_pac_set_id) VALUES (2, 2);
INSERT INTO `k_pac_k_pac_set` (k_pac_id, k_pac_set_id) VALUES (3, 1);
INSERT INTO `k_pac_k_pac_set` (k_pac_id, k_pac_set_id) VALUES (4, 3);
INSERT INTO `k_pac_k_pac_set` (k_pac_id, k_pac_set_id) VALUES (1, 2);
INSERT INTO `k_pac_k_pac_set` (k_pac_id, k_pac_set_id) VALUES (2, 4);
