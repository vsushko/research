update exdoc set (total_cost, total_tax, total_doc) =
(select sum(cost), sum(sum_tax), sum(sum_pos) from expos)
/
