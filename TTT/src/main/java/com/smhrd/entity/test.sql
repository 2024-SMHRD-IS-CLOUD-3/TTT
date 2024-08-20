
select * from tb_user; 
delete from tb_user;

select * from tb_trainer;
delete from tb_trainer;


select * from tb_schedule;
delete from tb_schedule
where sche_idx = 6;
drop table tb_schedule

desc tb_schedule;

--INSERT INTO tb_schedule (tr_id, sche_content, st_dt, st_tm, ed_dt, ed_tm, sche_color, sche_status, usr_id)
--VALUES 
--('test', 'Morning Yoga Session', '2024-08-14', '07:00:00', '2024-08-14', '08:00:00', '#FF5733', 'confirmed', 'TTT-2024-0164561924'),
--('test', 'Cardio Training', '2024-08-15', '09:30:00', '2024-08-15', '10:30:00', '#33FF57', 'pending', 'TTT-2024-0164561924'),
--('test', 'Strength Training', '2024-08-16', '11:00:00', '2024-08-16', '12:30:00', '#3357FF', 'confirmed', 'TTT-2024-0164561924'),
--('test', 'Evening Pilates', '2024-08-17', '18:00:00', '2024-08-17', '19:00:00', '#FF33A6', 'cancelled', 'TTT-2024-0164561926'),
--('test2', 'HIIT Session', '2024-08-18', '17:00:00', '2024-08-18', '18:00:00', '#A633FF', 'confirmed', 'TTT-2024-0164561926');


INSERT INTO tb_schedule (tr_id, sche_content, st_dt, st_tm, ed_dt, ed_tm, sche_color, sche_status, usr_id)
VALUES 
('test', 'Morning Yoga Session', '2024-08-14', '2024-08-14 07:00:00', '2024-08-14', '2024-08-14 08:00:00', '#FF5733', 'confirmed', 'TTT-2024-0164561924'),
('test', 'Cardio Training', '2024-08-15', '2024-08-15 09:30:00', '2024-08-15', '2024-08-15 10:30:00', '#33FF57', 'pending', 'TTT-2024-0164561924'),
('test', 'Strength Training', '2024-08-16', '2024-08-16 11:00:00', '2024-08-16', '2024-08-16 12:30:00', '#3357FF', 'confirmed', 'TTT-2024-0164561924'),
('test', 'Evening Pilates', '2024-08-17', '2024-08-17 18:00:00', '2024-08-17', '2024-08-17 19:00:00', '#FF33A6', 'cancelled', 'TTT-2024-0164561926'),
('test2', 'HIIT Session', '2024-08-18', '2024-08-18 17:00:00', '2024-08-18', '2024-08-18 18:00:00', '#A633FF', 'confirmed', 'TTT-2024-0164561926');

