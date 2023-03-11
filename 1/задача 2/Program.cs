/*===========================================================================================================
ПРОГРАММА, КОТОРАЯ НА ВХОД ПРИНИМАЕТ ДВА ЧИСЛА И ВЫДАЁТ, КАКОЕ ЧИСЛО БОЛЬШЕЕ, А КАКОЕ МЕНЬШЕЕ
=============================================================================================================*/
bool flag = false;
int a = 0;
int b = 0;
Console.WriteLine($"Enter the first num: ");
flag = int.TryParse(Console.ReadLine(), out a);  // считать строку (0) и попытаться ее переформатировать в число и если удастся -> flag = true и записать это число в а

Console.WriteLine($"Enter the second num: ");
flag = int.TryParse(Console.ReadLine(), out b);

if(flag == true) { // если введенные числа - корректны
    if(a > b) Console.WriteLine($"{a} > {b}");
    else if(a < b) Console.WriteLine($"{a} < {b}");
    else Console.WriteLine($"{a} = {b}");
}
else Console.Write($"Wrong input!");