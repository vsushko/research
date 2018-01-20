update exsvc set sum_tax = cost * tax / 100
update exsvc set sum_svc = cost + sum_tax
/
