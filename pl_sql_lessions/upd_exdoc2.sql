update exdoc
   set (total_cost, total_tax, total_doc) =
          (
            select total_cost + sum( cost)
                 , total_tax  + sum( sum_tax)
                 , total_doc  + sum( sum_svc)
              from exsvc
          )
/
