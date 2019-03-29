����������
create table cart
(id SERIAL,
login_id int not null,
quality int not null,
item_id int not null
);

�����ڍ�
create table m_buy_detail
(id SERIAL,
history_id int not null,
quality int not null,
create_date datetime not null
);

�w������
create table m_buy_history
(id SERIAL,
user_id int not null,
total_price int not null,
pay_method_id int not null,
delivery_method_id int not null,
create_date datetime not null
);


�x�������@
create table m_pay_method
(id SERIAL, 
name VARCHAR(256) not null);


�z�����@
create table m_delivery_method
(id SERIAL, 
name VARCHAR(256) not null,
price int not null);

���i
create table m_item
(id SERIAL, 
name VARCHAR(256) not null,
detail text not null,
price int not null,
file_name VARCHAR(256) not null);

���[�U�[���
create table t_user 
(id SERIAL,
login_id VARCHAR(20) NOT NULL, 
name VARCHAR(136) not null,
mail VARCHAR(256) not null,
phone VARCHAR(11) not null,
address VARCHAR(256) not null,
login_password VARCHAR(20) not null,
create_date date not null )


