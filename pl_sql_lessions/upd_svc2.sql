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
                  , '����� ����������', quant * 0.1
                  , '������ ���������', quant * 1.2
                  , '������ �����������', ROUND( quant / 10) * 0.85
                  , '����� ��� ������', quant)
                ) as weight
          from expos
           ) v
)
 where service_n like '%��������%'
/
