create table student
(
	studentid varchar(12) not null,
	name varchar(30) not null,
	place varchar(30) not null,
	primary key(studentid)
);

create table shipment
(
	batchid int not null auto_increment,
	shipmentDate TIMESTAMP not null, 
	renewalDate TIMESTAMP not null,
	quantity int not null,
	status int not null,
	primary key(batchid)
);

create table inventory
(
	serialno int not null auto_increment,
	itemid	varchar(30) not null,
	batchId int not null,
	availableqty int not null,
	primary key(serialno)
);

create table shopitem
(
	itemid varchar(30) not null,
	itemname varchar(30) not null,
	price double not null,
	primary key(itemid)
)


