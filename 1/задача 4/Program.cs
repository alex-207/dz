/*===========================================================================================================
ПРОГРАММА ПРИНИМАЕТ НА ВХОД ТРИ ЧИСЛА И ВЫДАЁТ МАКСИМАЛЬНОЕ ИЗ ЭТИХ ЧИСЕЛ
=============================================================================================================*/
bool flag = false;
bool flag2 = false;
bool flag3 = false;
int a = 0;
int b = 0;
int c = 0;

Console.WriteLine($"Enter the first num: ");
flag = int.TryParse(Console.ReadLine(), out a);  // считать строку и попытаться ее переформатировать в число и если удастся -> flag = true и записать это число в а

Console.WriteLine($"Enter the second num: ");
flag2 = int.TryParse(Console.ReadLine(), out b);

Console.WriteLine($"Enter the third num: ");
flag3 = int.TryParse(Console.ReadLine(), out c);

int max = a;

if(flag == true && flag2 == true && flag3 == true) { // если введенные числа - корректны
    if(b > max) max = b;
    if(c > max) max = c;
    Console.Write($"max = {max}");
}
else Console.Write($"Wrong input!");