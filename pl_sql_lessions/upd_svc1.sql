update exsvc
    set cost =
(
  select SUM(DECODE( good_n
             , '����� ����������', quant
             , '������ ���������', quant * 1.7
             , '������ �����������', round( quant / 10) * 1.5))
    from expos
)
 where service_n like '%��������%'
/
