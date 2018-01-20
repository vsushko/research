update exsvc
    set cost =
(
  select SUM(DECODE( good_n
             , 'Банки стеклянные', quant
             , 'Горшки цветочные', quant * 1.7
             , 'Пробка медицинская', round( quant / 10) * 1.5))
    from expos
)
 where service_n like '%упаковки%'
/
