/*===========================================================================================================
ПРОГРАММА ИЩЕТ СТРОКУ С НАИМЕНЬШЕЙ СУММОЙ ЭЛЕМЕНТОВ ДВУМЕРНОГО МАССИВА
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

// ПОДСЧЕТ СУММЫ В СТРОКЕ
int Sum(int[,] arr, int indexCol)
{
    int result = 0;
    int i = indexCol;
    for (int j = 0; j < arr.GetLength(1); j++)
    {
        result += arr[i, j];
    }
    //Console.Write($"{result} ");
    return result;
}

int m = 5;
int n = 3;
int[,] array = new int[m, n];
InitArray(array);
PrintArray(array);

int indexCurrentString = 0;
int[] arr = new int[array.GetLength(0)];  // одномерный массив, для записи сумм всех строк
for (int i = 0; i < array.GetLength(0); i++)
{
    arr[i] = Sum(array, indexCurrentString);
    indexCurrentString++;
}

// ОТВЕТ = ИНДЕКСУ + 1 МИНИМАЛЬНОГО ЧИСЛА МАССИВА
int index = 0;
int minElement = arr[index];
int numElemrnt = 1;
while (index < arr.Length)
{
    if (arr[index] < minElement)
    {
        numElemrnt = index;
    }
    index++;
}
Console.Write($"Номер строки с наименьшей суммой элементов:\n{numElemrnt + 1}");