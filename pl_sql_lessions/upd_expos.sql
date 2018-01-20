update expos set cost = price * quant
/
update expos set sum_tax = cost * tax / 100
/
update expos set sum_pos = cost + sum_tax
/
