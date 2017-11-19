// Алфавит
var symbols = ['А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', ' ', '.', ',', '—', '!'];

// Смещение
var shift = 10;

// Закодированное сообщение
var encodedMessage = [8, 28, 36, 52, 56, 40, 23, 31, 56, 39, 38, 28, 48, 52, 58, 56, 38, 27, 32, 37, 56, 40, 23, 31, 56, 39, 38, 41, 39, 32, 57];

// Раскодированное сообщение
var decodedMessage = '';

for (var j = 0; j < encodedMessage.length; j++) {
    var index = encodedMessage[j] + shift;
    decodedMessage += symbols[index > symbols.length ? index - symbols.length : index]; 
}

/*

Мяу! Я научился шифровать и мне нужна программа расшифровки.

Есть массив symbols, в котором хранится алфавит (буквы и другие символы).

Есть массив encodedMessage, в котором хранится зашифрованное сообщение. Каждый элемент этого массива — это индекс символа из массива symbols.

Индексы сдвинуты на величину в переменной shift. Пример: элемент из зашифрованного массива равен единице, значит с учётом сдвига десять это символ с индексом одиннадцать в массиве с алфавитом, то есть «К».

Программа дешифровки должна переводить элементы из массива с шифровкой в символы из массива алфавита и склеивать из них расшифрованную строку. Эту строку храним в переменной decodedMessage.

Если индекс со смещением выходит за пределы алфавита, то нужно вычесть из этого индекса длину алфавита (большие индексы шифруют символы в начале алфавита).

*/
