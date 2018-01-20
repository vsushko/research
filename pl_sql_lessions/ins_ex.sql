begin
 insert into exdoc
 ( doc_nd
 , dc_dd
 , customer_n
 , address
 , total_cost
 , total_tax
 , total_doc)
 values
 ( 137
 , '12-09-2003'
 , 'Морейс А. Н.'
 , 'ул. Рабочая канавка'
 , 5391.60
 , 959.52
 , 6351.12);
 
insert into expos
( doc_nd
, doc_dd
, pos_no
, good_n
, ed
, quant
, price
, cost
, tax
, sum_tax
, sum_pos)
values
( 137
, '12-09-2003'
, 1
, 'Банки стеклянные'
, 'шт'
, 7
, 3.25
, 22.75
, 20
, 4.10
, 26.85);


insert into expos
( doc_nd
, doc_dd
, pos_no
, good_n
, ed
, quant
, price
, cost
, tax
, sum_tax
, sum_pos)
values
( 137
, '12-09-2003'
, 1
, 'Банки стеклянные'
, 'шт'
, 7
, 3.25
, 22.75
, 18
, 4.10
, 26.85);

insert into expos
( doc_nd
, doc_dd
, pos_no
, good_n
, ed
, quant
, price
, tax)
values
( 137
, '12-09-2003'
, 3
, 'Грунт для цветов'
, 'кг'
, 160
, 32.4
, 18);

insert into expos
( doc_nd
, doc_dd
, pos_no
, good_n
, ed
, quant
, price
, tax)
values
( 137
, '12-09-2003'
, 4
, 'Пробка медицинская'
, 'шт'
, 45
, 3.05
, 10);

update expos set cost = price * quant;
update expos set sum_tax = cost * tax / 100;
update expos set sum_pos = cost + sum_tax;

update exdoc set (total_cost, total_tax, total_doc) =
(select sum(cost), sum(sum_tax), sum(sum_pos) from expos);


insert into exsvc
( exsvc_c
, doc_nd
, doc_dd
, service_n
, tax
)
values
( seq_exsvc.NEXTVAL
, 137
, '12-09-2003'
, 'услуги упаковки'
, 18);

insert into exsvc
( exsvc_c
, doc_nd
, doc_dd
, service_n
, tax
)
values
( seq_exsvc.NEXTVAL
, 137
, '12-09-2003'
, 'услуги упаковки'
, 18);


update exsvc
    set cost =
(
  select SUM(DECODE( good_n
             , 'Банки стеклянные', quant
             , 'Горшки цветочные', quant * 1.7
             , 'Пробка медицинская', round( quant / 10) * 1.5))
    from expos
)
 where service_n like '%упаковки%';
 
 update exsvc
   set cost =
(
    select case
           when   0 <= v.weight and v.weight < 100 then 1.8
           when 100 <= v.weight and v.weight < 200 then 4.7
           when 200 <= v.weight then 6
           else 0
           end as cost
      from (
        select sum( DECODE( good_n
                  , 'Банки стеклянные', quant * 0.1
                  , 'Горшки цветочные', quant * 1.2
                  , 'Пробка медицинская', ROUND( quant / 10) * 0.85
                  , 'Грунт для цветов', quant)
                ) as weight
          from expos
           ) v
)
 where service_n like '%доставки%';
 
update exsvc set sum_tax = cost * tax / 100;
update exsvc set sum_svc = cost + sum_tax;

update exdoc set (total_cost, total_tax, total_doc) =
(select sum(cost), sum(sum_tax), sum(sum_pos) from expos);

update exdoc
   set (total_cost, total_tax, total_doc) =
          (
            select total_cost + sum( cost)
                 , total_tax  + sum( sum_tax)
                 , total_doc  + sum( sum_svc)
              from exsvc
          );

end;
