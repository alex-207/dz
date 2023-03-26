/*===========================================================================================================
ПРОГРАММА СЧИТЫВАЕТ С КЛАВИАТУРЫ ПОЛЬЗОВАТЕЛЬСКИЕ M ЧИСЕЛ И СЧИТАЕТ, СКОЛЬКО ЧИСЕЛ БОЛЬШЕ 0 ВВЁЛ ПОЛЬЗОВАТЕЛЬ
=============================================================================================================*/
#pragma warning disable

void FillArr(int[] array, int size)
{
    for (int i = 0; i < size; i++)
    {
        Console.Write($"Введите число: ");
        int.TryParse(Console.ReadLine(), out array[i]);
    }
}

int Check(int[] array, int size)
{
    int result = 0;
    for (int i = 0; i < size; i++)
    {
        if (array[i] > 0)
        {
            result++;
        }
    }
    return result;
}

void PrintArr(int[] array, int size)
{
    for (int i = 0; i < size; i++)
    {
        Console.Write($"{array[i]} ");
    }
    Console.Write($"-> {Check(array, size)}");
}

int M = 5;
int[] arr = new int[M];
FillArr(arr, M);
PrintArr(arr, M);