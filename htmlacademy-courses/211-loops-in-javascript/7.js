var mode = 'pageCopy'; // Режим работы драйвера печати
var pageNumber = 5;    // Номер копируемой страницы
var count = 7;         // Количество копий

if (mode === 'pageCopy') {
  for (var i = 0; i < count; i++) {
    keks.print(pageNumber);
  }
}
