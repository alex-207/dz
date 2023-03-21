/*===========================================================================================================
ПРОГРАММА ПРИНИМАЕТ НА ВХОД ДВА ЧИСЛА (a И b) И ЦИКЛИЧЕСКИ ВОЗВОДИТ ЧИСЛО a В НАТУРАЛЬНУЮ СТЕПЕНЬ b
=============================================================================================================*/
int CountDegree(int num, int degree)
{
    int result = 1;
    for (int i = 0; i < degree; i++)
    {
        result *= num;
    }
    return result;
}

int a, b;
Console.Write($"Введите число а: ");
int.TryParse(Console.ReadLine(), out a);
Console.Write($"Введите число b: ");
int.TryParse(Console.ReadLine(), out b);

Console.Write($"{a},{b} -> {CountDegree(a, b)}");