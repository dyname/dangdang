
select * from d_user ;

select * from(select d_product.id ,d_product.product_name,d_product.fixed_price,d_product.dang_price ,d_product.product_pic, d_book.author,d_book.publishing,d_book.publish_time,d_book.catalogue from d_product join  d_book  where d_product.id=d_book.id ) M where id in (select product_id from d_category_product where cat_id = 9) limit 5,5;

insert into d_item
values(select 1 as order_id,id ,product_name,dang_price,1 as dang_price,0 as product_number,1 as status from d_product where id=1)

update d_item set amount=amount+1 where product_id=2

delete from d_item

select * from d_item

;;;
SELECT * from d_category JOIN d_category_product WHERE d_category.id=d_category_product.cat_id

SELECT id,en_name,name,description,parent_id,count(*) as total
FROM (SELECT d_category.id,d_category.en_name,d_category.name,d_category.description,d_category.parent_id,
		d_category_product.product_id from d_category JOIN d_category_product 
WHERE d_category.id=d_category_product.cat_id) M
GROUP BY id 

select * from(
	(select * from d_category where parent_id=2) M
	join d_category_product where mid=id)


select count(*) as total from d_category_product where cat_id=11

select parent_id from d_category where id=9 


DROP TABLE IF EXISTS d_product;
CREATE TABLE d_product (
  id int(12) NOT NULL auto_increment,
  product_name varchar(100) NOT NULL,
  description varchar(100) default NULL,
  add_time bigint(20) default NULL,
  fixed_price double NOT NULL,
  dang_price double NOT NULL,
  keywords varchar(200) default NULL,
  has_deleted int(1) NOT NULL default '0',
  product_pic varchar(200) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO d_product VALUES (1,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'16.jpg');
INSERT INTO d_product VALUES (2,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'17.jpg');
INSERT INTO d_product VALUES (3,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'18.jpg');
INSERT INTO d_product VALUES (4,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'19.jpg');
INSERT INTO d_product VALUES (5,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'20.jpg');
INSERT INTO d_product VALUES (6,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'21.jpg');
INSERT INTO d_product VALUES (7,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'22.jpg');
INSERT INTO d_product VALUES (8,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'23.jpg');
INSERT INTO d_product VALUES (9,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'24.jpg');
INSERT INTO d_product VALUES (10,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'2.jpg');
INSERT INTO d_product VALUES (11,'�Ͽ�ͷ�۵Ĺ���','�Ͽ�ͷ�۵Ĺ���',1237873000234,200,180,'key',0,'3.jpg');
INSERT INTO d_product VALUES (12,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'4.jpg');
INSERT INTO d_product VALUES (13,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'5.jpg');
INSERT INTO d_product VALUES (14,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'6.jpg');
INSERT INTO d_product VALUES (15,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'7.jpg');
INSERT INTO d_product VALUES (16,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'8.jpg');
INSERT INTO d_product VALUES (17,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'9.jpg');
INSERT INTO d_product VALUES (18,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'10.jpg');
INSERT INTO d_product VALUES (19,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'11.jpg');
INSERT INTO d_product VALUES (20,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'12.jpg');
INSERT INTO d_product VALUES (21,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'13.jpg');
INSERT INTO d_product VALUES (22,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'14.jpg');
INSERT INTO d_product VALUES (23,'�Ͽ�˯���Ĺ���','�Ͽ�˯���Ĺ���',1237873000234,200,180,'key',0,'15.jpg');



DROP TABLE IF EXISTS d_book;
CREATE TABLE d_book (
  id int(12) NOT NULL,
  author varchar(200) NOT NULL,
  publishing varchar(200) NOT NULL,
  publish_time bigint(20) NOT NULL,
  word_number varchar(15) default NULL,
  which_edtion varchar(15) default NULL,
  total_page varchar(15) default NULL,
  print_time bigint(20) default NULL,
  print_number varchar(15) default NULL,
  isbn varchar(25) default NULL,
  author_summary text NOT NULL,
  catalogue text NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO d_book VALUES (1,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (2,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (3,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (4,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (5,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (6,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (7,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (8,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (9,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (10,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (11,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (12,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (13,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (14,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (15,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (16,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (17,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (18,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (19,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (20,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (21,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (22,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (23,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');
INSERT INTO d_book VALUES (24,'��д��','���������',1237873000234,'1��','1','100',1,NULL,'12345678','�����Ǻ���','������һ�����鰡');


DROP TABLE IF EXISTS d_category;
CREATE TABLE d_category (
  id int(12) NOT NULL auto_increment,
  turn int(10) NOT NULL,
  en_name varchar(200) NOT NULL,
  name varchar(200) NOT NULL,
  description varchar(200),
  parent_id int(10),
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO d_category VALUES (1,1,'Book','ͼ��',NULL,0);
INSERT INTO d_category VALUES (2,1,'Novel','С˵',NULL,1);
INSERT INTO d_category VALUES (3,2,'Youth','�ഺ',NULL,1);
INSERT INTO d_category VALUES (4,3,'Humanity And Social Science','�������',NULL,1);
INSERT INTO d_category VALUES (5,4,'Management','����',NULL,1);
INSERT INTO d_category VALUES (6,5,'Children','�ٶ�',NULL,1);
INSERT INTO d_category VALUES (7,6,'Foreign Language','����',NULL,1);
INSERT INTO d_category VALUES (8,7,'Computer','�����',NULL,1);
INSERT INTO d_category VALUES (9,1,'Chinese Contemporary Novel','����С˵',NULL,2);
INSERT INTO d_category VALUES (10,2,'Chinese Modern Novel','���ִ�С˵',NULL,2);
INSERT INTO d_category VALUES (11,3,'Chinese Classical  Novel','�ŵ�С˵',NULL,2);
INSERT INTO d_category VALUES (12,4,'Four Classic Novels','�Ĵ�����',NULL,2);
INSERT INTO d_category VALUES (13,5,'Translated Works','��������',NULL,2);
INSERT INTO d_category VALUES (14,1,'School','У԰',NULL,3);
INSERT INTO d_category VALUES (15,2,'Love','����/���',NULL,3);
INSERT INTO d_category VALUES (16,3,'Grow Up','����/�ɳ�',NULL,3);
INSERT INTO d_category VALUES (17,4,'Fantasy','����',NULL,3);
INSERT INTO d_category VALUES (18,5,'Original','ԭ��',NULL,3);
INSERT INTO d_category VALUES (19,1,'Political','����',NULL,4);
INSERT INTO d_category VALUES (20,2,'Economic','����',NULL,4);
INSERT INTO d_category VALUES (21,3,'Law','����',NULL,4);
INSERT INTO d_category VALUES (22,4,'Philosophy','��ѧ',NULL,4);
INSERT INTO d_category VALUES (23,5,'History','��ʷ',NULL,4);
INSERT INTO d_category VALUES (24,1,'Commen Management','����ѧ',NULL,5);
INSERT INTO d_category VALUES (25,2,'Strategic Management','ս�Թ���',NULL,5);
INSERT INTO d_category VALUES (26,3,'Marketing','�г�Ӫ��',NULL,5);
INSERT INTO d_category VALUES (27,4,'Business History','��ҵʷ��',NULL,5);
INSERT INTO d_category VALUES (28,5,'E-Business','��������',NULL,5);
INSERT INTO d_category VALUES (29,1,'0-2','0-2��',NULL,6);
INSERT INTO d_category VALUES (30,2,'3-6','3-6��',NULL,6);
INSERT INTO d_category VALUES (31,3,'7-10','7-10��',NULL,6);
INSERT INTO d_category VALUES (32,4,'11-14','11-14��',NULL,6);
INSERT INTO d_category VALUES (33,5,'Child Literature','��ͯ��ѧ',NULL,6);
INSERT INTO d_category VALUES (34,1,'English','Ӣ��',NULL,7);
INSERT INTO d_category VALUES (35,2,'Japanese','����',NULL,7);
INSERT INTO d_category VALUES (36,3,'Korean','����',NULL,7);
INSERT INTO d_category VALUES (37,4,'Russian','����',NULL,7);
INSERT INTO d_category VALUES (38,5,'German','����',NULL,7);
INSERT INTO d_category VALUES (39,1,'Computer Theory','���������',NULL,8);
INSERT INTO d_category VALUES (40,2,'Database','���ݿ�',NULL,8);
INSERT INTO d_category VALUES (41,3,'Programming','�������',NULL,8);
INSERT INTO d_category VALUES (42,4,'Artificial Intelligence','�˹�����',NULL,8);
INSERT INTO d_category VALUES (43,5,'Computer Examination','���������',NULL,8);



DROP TABLE IF EXISTS d_category_product;
CREATE TABLE d_category_product (
  id int(12) NOT NULL auto_increment,
  product_id int(10) NOT NULL,
  cat_id int(10) NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO d_category_product VALUES (1,1,9);
INSERT INTO d_category_product VALUES (2,2,9);
INSERT INTO d_category_product VALUES (3,3,9);
INSERT INTO d_category_product VALUES (4,4,9);
INSERT INTO d_category_product VALUES (5,5,9);
INSERT INTO d_category_product VALUES (6,6,9);
INSERT INTO d_category_product VALUES (7,7,9);
INSERT INTO d_category_product VALUES (8,8,9);
INSERT INTO d_category_product VALUES (9,9,9);
INSERT INTO d_category_product VALUES (10,10,9);
INSERT INTO d_category_product VALUES (11,11,10);
INSERT INTO d_category_product VALUES (12,12,10);
INSERT INTO d_category_product VALUES (13,13,10);
INSERT INTO d_category_product VALUES (14,14,10);
INSERT INTO d_category_product VALUES (15,15,10);
INSERT INTO d_category_product VALUES (16,16,10);
INSERT INTO d_category_product VALUES (17,17,10);
INSERT INTO d_category_product VALUES (18,18,10);
INSERT INTO d_category_product VALUES (19,19,10);
INSERT INTO d_category_product VALUES (20,20,10);
INSERT INTO d_category_product VALUES (21,21,10);
INSERT INTO d_category_product VALUES (22,22,10);
INSERT INTO d_category_product VALUES (23,23,10);
INSERT INTO d_category_product VALUES (24,24,10);

INSERT INTO d_category_product VALUES (25,1,2);
INSERT INTO d_category_product VALUES (26,2,2);
INSERT INTO d_category_product VALUES (27,3,2);
INSERT INTO d_category_product VALUES (28,4,2);
INSERT INTO d_category_product VALUES (29,5,2);
INSERT INTO d_category_product VALUES (30,6,2);
INSERT INTO d_category_product VALUES (31,7,2);
INSERT INTO d_category_product VALUES (32,8,2);
INSERT INTO d_category_product VALUES (33,9,2);
INSERT INTO d_category_product VALUES (34,10,2);
INSERT INTO d_category_product VALUES (35,11,2);
INSERT INTO d_category_product VALUES (36,12,2);
INSERT INTO d_category_product VALUES (37,13,2);
INSERT INTO d_category_product VALUES (38,14,2);
INSERT INTO d_category_product VALUES (39,15,2);
INSERT INTO d_category_product VALUES (40,16,2);
INSERT INTO d_category_product VALUES (41,17,2);
INSERT INTO d_category_product VALUES (42,18,2);
INSERT INTO d_category_product VALUES (43,19,2);
INSERT INTO d_category_product VALUES (44,20,2);
INSERT INTO d_category_product VALUES (45,21,2);
INSERT INTO d_category_product VALUES (46,22,2);
INSERT INTO d_category_product VALUES (47,23,2);
INSERT INTO d_category_product VALUES (48,24,2);

INSERT INTO d_category_product VALUES (49,1,1);
INSERT INTO d_category_product VALUES (50,2,1);
INSERT INTO d_category_product VALUES (51,3,1);
INSERT INTO d_category_product VALUES (52,4,1);
INSERT INTO d_category_product VALUES (53,5,1);
INSERT INTO d_category_product VALUES (54,6,1);
INSERT INTO d_category_product VALUES (55,7,1);
INSERT INTO d_category_product VALUES (56,8,1);
INSERT INTO d_category_product VALUES (57,9,1);
INSERT INTO d_category_product VALUES (58,10,1);
INSERT INTO d_category_product VALUES (59,11,1);
INSERT INTO d_category_product VALUES (60,12,1);
INSERT INTO d_category_product VALUES (61,13,1);
INSERT INTO d_category_product VALUES (62,14,1);
INSERT INTO d_category_product VALUES (63,15,1);
INSERT INTO d_category_product VALUES (64,16,1);
INSERT INTO d_category_product VALUES (65,17,1);
INSERT INTO d_category_product VALUES (66,18,1);
INSERT INTO d_category_product VALUES (67,19,1);
INSERT INTO d_category_product VALUES (68,20,1);
INSERT INTO d_category_product VALUES (69,21,1);
INSERT INTO d_category_product VALUES (70,22,1);
INSERT INTO d_category_product VALUES (71,23,1);
INSERT INTO d_category_product VALUES (72,24,1);

DROP TABLE IF EXISTS d_item;
CREATE TABLE d_item (
  id int(12) NOT NULL auto_increment,
  order_id int(10) NOT NULL,
  product_id int(10) NOT NULL,
  product_name varchar(100) NOT NULL,
  dang_price double NOT NULL,
  product_num int(10) NOT NULL,
  amount double NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS d_order;
CREATE TABLE d_order (
  id int(10) NOT NULL auto_increment,
  user_id int(10) NOT NULL,
  status int(10) NOT NULL,
  order_time bigint(20) NOT NULL,
  order_desc varchar(100) default NULL,
  total_price double NOT NULL,
 
  receive_name varchar(100) default NULL,
  full_address varchar(200) default NULL,
  postal_code varchar(8) default NULL,
  mobile varchar(20) default NULL,
  phone varchar(20) default NULL,
  
  PRIMARY KEY  (id)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS d_receive_address;
CREATE TABLE d_receive_address (
  id int(12) NOT NULL auto_increment,
  user_id int(11) NOT NULL,
  receive_name varchar(20) NOT NULL,
  full_address varchar(200) NOT NULL,
  postal_code varchar(8) NOT NULL,
  mobile varchar(15) default NULL,
  phone varchar(20) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB;

insert into d_receive_address values(1, 6,'Java','sun.cn','10000800','12345','67890');
insert into d_receive_address values(2, 6,'JavaJavaJava','ibm.cn','10000600','12345','67890');



DROP TABLE IF EXISTS d_user;
CREATE TABLE d_user (
  id int(12) NOT NULL auto_increment,
  email varchar(50) NOT NULL,
  nickname varchar(50) default NULL,
  password varchar(50) NOT NULL,
  user_integral int(12) NOT NULL default '0',
  is_email_verify char(3),
  email_verify_code varchar(50) default NULL,
  last_login_time bigint default NULL,
  last_login_ip varchar(15) default NULL,
  PRIMARY KEY  (id),
  UNIQUE KEY email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

