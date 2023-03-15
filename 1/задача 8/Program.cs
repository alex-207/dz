/*===========================================================================================================
ПРОГРАММА НА ВХОД ПРИНИМАЕТ ЧИСЛО (N), А НА ВЫХОДЕ ПОКАЗЫВАЕТ ВСЕ ЧЁТНЫЕ ЧИСЛА ОТ 1 ДО N.
=============================================================================================================*/
bool flag = false;
int N;
int count = 2;

Console.WriteLine($"Enter the num please: ");
flag = int.TryParse(Console.ReadLine(), out N);  // считать строку и попытаться ее переформатировать в число и если удастся -> flag = true и записать это число в N

if(flag == true) { // если введенное число - корректно
    
    // ЕСЛИ N - ЧЕТНОЕ, ПОЛОЖИТЕЛЬНОЕ
    if(N >= 0 && N % 2 == 0) {
        while(count <= N) {
            Console.Write($"{count} ");
            count += 2;
        }
    }

    // ЕСЛИ N - НЕЧЕТНОЕ, ПОЛОЖИТЕЛЬНОЕ
    else if(N > 0 && N % 2 != 0) {
        while(count <= N) {
            Console.Write($"{count} ");
            count += 2;
        }
    }

    // ЕСЛИ N - ЧЕТНОЕ, ОТРИЦАТЕЛЬНОЕ
    else if(N < 0 && N % 2 == 0) {
        count = 0;
        while(count >= N) {
            Console.Write($"{count} ");
            count -= 2;
        }
    }

    // ЕСЛИ N - НЕЧЕТНОЕ, ОТРИЦАТЕЛЬНОЕ
    else if(N < 0 && N % 2 != 0) {
        count = 0;
        while(count >= N) {
            Console.Write($"{count} ");
            count -= 2;
        }
    }
}
else Console.Write($"Wrong input!");
