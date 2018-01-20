create table exsvc
(doc_nd number(6) not null
, doc_dd date not null
, service_n varchar2(60) check(service_n in ('услуги доставки', 'услуги упаковки'))
, cost number (12,2)
, tax number(5,2) check (tax in (10,18))
, sum_tax number(5,2)
, sum_svc number (12, 2)
, constraint pk_exsvc
primary key (doc_nd, doc_dd, service_n)
, constraint fk_exsvc_exdoc
foreign key(doc_nd, doc_dd)
references exdoc (doc_dn, doc_dd)
)
/
