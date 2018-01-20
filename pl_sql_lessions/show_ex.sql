set linesize 512

col doc_nd     for 9999
col address    for a36
col customer_n for a16
col pos_no     for 99
col good_n     for a18
col price      for 990.00
col service_n  for a16

break on doc_nd page 1

compute sum of cost on doc_nd
compute sum of sum_tax on doc_nd
compute sum of sum_pos on doc_nd
compute sum of sum_svc on doc_nd

select * from exdoc order by doc_nd;
select * from expos order by doc_nd, pos_no;
select * from exsvc order by doc_nd, service_n;

clear break