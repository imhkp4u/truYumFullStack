/* Menu Item Table details */
use mydb;
INSERT INTO `mydb`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99.00', '1', '2019-04-23', 'Main Course', '1');
INSERT INTO `mydb`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129.00', '1', '2019-12-23', 'Main Course', '0');
INSERT INTO `mydb`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149.00', '1', '2019-01-10', 'Main Course', '0');
INSERT INTO `mydb`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57.000', '0', '2019-01-01', 'Starters', '1');
INSERT INTO `mydb`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32.00', '1', '2019-01-04', 'Dessert', '1');



/* User Table Details */

insert into `mydb`.`user`(us_id, us_name) values(1, 'Shiva');
insert into `mydb`.`user`(us_id, us_name) values(2, 'Ajay');



/* Cart Table Details */

insert into `mydb`.`cart`(ct_us_id,ct_me_id) values (1,1);
insert into `mydb`.`cart`(ct_us_id,ct_me_id) values (1,3);
insert into `mydb`.`cart`(ct_us_id,ct_me_id) values (1,5);




-- 1.	View Menu Item List Admin (TYUC001)  
select * from mydb.menu_item;



-- 2.	View Menu Item List Customer (TYUC002)
select * from mydb.menu_item where me_active = '1' and me_date_of_launch > (select CURDATE());



-- 3.	Edit Menu Item (TYUC003)
select * from mydb.menu_item where me_id = '1';

update mydb.menu_item
set me_name = 'Biriyani', me_price = 130.00, me_active = 1, me_date_of_launch = '2020-01-01', me_category = 'Dinner', me_free_delivery = 0
where me_id = 4;



-- 4.	Add to Cart (TYUC004)
insert into `mydb`.`user`(us_id, us_name) values(1, 'Shiva');
insert into `mydb`.`user`(us_id, us_name) values(2, 'Ajay');

insert into `mydb`.`cart`(ct_us_id,ct_me_id) values (1,1);
insert into `mydb`.`cart`(ct_us_id,ct_me_id) values (1,3);
insert into `mydb`.`cart`(ct_us_id,ct_me_id) values (1,5);


-- 5.	View Cart (TYUC005) get all menu items in a particular user’s cart
select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from mydb.menu_item
inner join cart on
ct_me_id = me_id
where ct_us_id = 1;


-- View Cart (TYUC005) get the total price of all menu items in a particular user’s cart
select sum(me_price) as Total_Price from mydb.menu_item
inner join cart on
ct_me_id = me_id
where ct_us_id = 1;


-- 6.	Remove Item from Cart (TYUC006)
delete from mydb.cart
where ct_us_id = 1 and  ct_me_id = 1;

select * from cart;

