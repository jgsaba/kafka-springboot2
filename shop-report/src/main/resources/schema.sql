
create schema if not exists report;

create table report.shop_report (
      id bigserial primary key auto_increment,
      status varchar(100) not null,
      quantity int not null);