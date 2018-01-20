alter table expos
  add constraint fk_expos_exdoc
  foreign key(doc_nd, doc_dd)
  references exdoc( doc_nd, dc_dd)
/
