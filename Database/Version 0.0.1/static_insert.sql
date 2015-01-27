--- insert into role table

insert into role(role_name,access_level) values ('Administrator','A');

--  insert into rights table
insert into user_right(right_name) values ('RIGHTS_CREATE_USER');
insert into user_right(right_name) values ('RIGHTS_ADD_GPS_DEVICE');
insert into user_right(right_name) values ('RIGHTS_DROP_USER');
insert into user_right(right_name) values ('RIGHTS_CREATE_ROLE');
insert into user_right(right_name) values ('RIGHTS_CREATE_RIGHTS');


--insert into 
insert into role_rights_xref(role_id,right_id) values ((select role_id from role where role_name ='Administrator'),
	(select right_id from user_right where right_name = 'RIGHTS_CREATE_USER'));

insert into role_rights_xref(role_id,right_id) values ((select role_id from role where role_name ='Administrator'),
	(select right_id from user_right where right_name = 'RIGHTS_ADD_GPS_DEVICE'));

insert into role_rights_xref(role_id,right_id) values ((select role_id from role where role_name ='Administrator'),
	(select right_id from user_right where right_name = 'RIGHTS_DROP_USER'));

insert into role_rights_xref(role_id,right_id) values ((select role_id from role where role_name ='Administrator'),
	(select right_id from user_right where right_name = 'RIGHTS_CREATE_ROLE'));
	
insert into role_rights_xref(role_id,right_id) values ((select role_id from role where role_name ='Administrator'),
	(select right_id from user_right where right_name = 'RIGHTS_CREATE_RIGHTS'));
	

-- create user
insert into users(username,password,is_enabled,created_date,invalid_login_attempt) values('admin','=da81be5f13dc8286134953bb09fc88449bc3ce82','Y',sysdate(),0);	

insert into user_profile(user_id,first_name,middle_name,last_name,access_level,email_id,mobile_no) values ((select user_id from users where username ='admin'),'Amit','Vasanta','Patil','A','amitpatil88@gmail.com',342);
