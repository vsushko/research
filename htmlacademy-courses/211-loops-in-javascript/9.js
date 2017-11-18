var mode = 'document'; // Режим работы драйвера печати
var pageNumber = 5;    // Номер копируемой страницы
var count = 7;         // Количество копий
var totalPages = 6;    // Всего страниц в документе

if (mode === 'pageCopy') {
  for (var i = 0; i < count; i++) {
    keks.print(pageNumber);
  }
}

if (mode === 'document') {
  for (var page = 1; page <= totalPages; page++) {
    keks.print(page);
  }
}
