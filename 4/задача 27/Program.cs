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
{
    int sum = 0;
    for (int i = 0; i < lot; i++)
    {
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