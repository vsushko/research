create table expos
( doc_nd number (6) not null
, doc_dd date 
, pos_no number(5) not null
, good_n varchar(60) not null
, ed varchar2(6) not null
, quant number(9,2) not null
, price number(9,2) not null
, cost number(12,2)
, tax number(12,2) not null
, sum_tax number(12,2)
, sum_pos number(12,2)
)
/
