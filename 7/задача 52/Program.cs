/*===========================================================================================================
ПРОГРАММА ИЩЕТ СРЕДНЕЕ АРИФМЕТИЧЕСКОЕ ЭЛЕМЕНТОВ, В КАЖДОМ СТОЛБЦЕ ДВУХМЕРНОГО МАССИВА
=============================================================================================================*/
#pragma warning disable

// ИНИЦИАЛИЗАЦИЯ МАССИВА
int[,] InitArray(int[,] arr)
{
    for (int i = 0; i < arr.GetLength(0); i++)
    {
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            arr[i, j] = new Random().Next(10);
        }
    }
    return arr;
}

// ПЕЧАТЬ МАССИВА
int[,] PrintArray(int[,] arr)
{
    for (int i = 0; i < arr.GetLength(0); i++)
    {
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            Console.Write($"{arr[i, j]} ");
        }
        Console.WriteLine();
    }
    return arr;
}

// ПОДСЧЕТ СЕДНЕГО АРИФМЕТИЧЕСКОГО В СТОЛБЦАХ
float CountAvarege(int[,] arr, int indexCol)
{
    float result = 0;

    for (int i = 0; i < arr.GetLength(0); i++)
    {
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            if (j == indexCol) result += arr[i, j];
        }
    }
    result /= arr.GetLength(0);

    return result;
}

int m = 3;
int n = 8;
int[,] array = new int[m, n];
InitArray(array);
PrintArray(array);
Console.WriteLine();

Console.Write($"Среднее арифметическое каждого столбца: ");
int indexColumn = 0;
for (int i = 0; i < array.GetLength(1); i++)
{
    Console.Write($"{Math.Round(CountAvarege(array, indexColumn), 1)}");
    if (indexColumn == array.GetLength(1) - 1) Console.Write($".");
    else Console.Write($"; ");
    indexColumn++;
}