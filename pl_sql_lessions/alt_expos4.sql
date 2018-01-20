alter table expos add constraint ck_expos_tax check (tax = 10 OR tax = 18)
/
