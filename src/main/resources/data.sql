SET FOREIGN_KEY_CHECKS=0; -- to disable them

	delete from bill;
	delete from rule;

SET FOREIGN_KEY_CHECKS=1; -- to re-enable them

insert into rule(id,name,number_customer,payment_limit,promotion_code,discount_percent_flg,discount_total,discount_percent,discount_group_flg,discount_group,total) values
(1,'1. Discount 10% when customer present coupon code "DIS10" or price is more/equal than 2000 baht',0,2000 ,'DIS10',true,0,10,false,0,0);

insert into rule(id,name,number_customer,payment_limit,promotion_code,discount_percent_flg,discount_total,discount_percent,discount_group_flg,discount_group,total) values
(2,'2. Discount 30% when customer present coupon code "STARCARD" for 2 customers',2,0 ,'STARCARD',true,0,30,false,0,0);

insert into rule(id,name,number_customer,payment_limit,promotion_code,discount_percent_flg,discount_total,discount_percent,discount_group_flg,discount_group,total) values
(3,'3. Come 4 pay 3 when customer present coupon code "STARCARD" ',4,0,'STARCARD',false,0,0,true,3,0);

insert into rule(id,name,number_customer,payment_limit,promotion_code,discount_percent_flg,discount_total,discount_percent,discount_group_flg,discount_group,total) values
(4,'4. Discount 25% when price more/equal that 2500 baht.',0,2500 ,null,true,0,25,false,0,0);


