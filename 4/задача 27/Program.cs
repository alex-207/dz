/*===========================================================================================================
ПРОГРАММА ПРИНИМАЕТ НА ВХОД ЧИСЛО И ВЫДАЁТ СУММУ ЦИФР В ЧИСЛЕ
=============================================================================================================*/
int CountLot(int a)
{
    int lot = 1;
    while (a > 9)
    {
        a /= 10;
        lot++;
    }
    return lot;
}

int CountSum(int a, int lot)
{                                // a   = 123
    int sum = 0;                 // lot =   3
    for (int i = 0; i < lot; i++)//   i =   0 1
    {                            // sum =   0 3
        sum += a % 10;
        a /= 10;
    }
    return sum;
}

int a;
Console.Write($"Введите число: ");
int.TryParse(Console.ReadLine(), out a);

Console.Write($"lot = {CountLot(a)}\n");
Console.Write($"{a} -> {CountSum(a, CountLot(a))}");