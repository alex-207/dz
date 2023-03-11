/*===========================================================================================================
ПРОГРАММА НА ВХОД ПРИНИМАЕТ ЧИСЛО (N), А НА ВЫХОДЕ ПОКАЗЫВАЕТ ВСЕ ЧЁТНЫЕ ЧИСЛА ОТ 1 ДО N.
=============================================================================================================*/
bool flag = false;
int N;
int count = 1;

Console.WriteLine($"Enter the num please: ");
flag = int.TryParse(Console.ReadLine(), out N);  // считать строку и попытаться ее переформатировать в число и если удастся -> flag = true и записать это число в N

if(flag == true) { // если введенное число - корректно
    if(N >= 1) {
        while(count <= N) {
            Console.Write($"{count} ");
            count++;
        }
    }

    else if(N < 1) {
        while (count >= N) {
            Console.Write($"{count} ");
            count--;
        }
    }
}
else Console.Write($"Wrong input!");