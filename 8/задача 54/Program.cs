/*===========================================================================================================
ПРОГРАММА УПОРЯДОЧИВАЕТ ПО УБЫВАНИЮ ЭЛЕМЕНТЫ КАЖДОЙ СТРОКИ ДВУМЕРНОГО МАССИВА
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

// ПЕРЕПИСАТЬ ДВУХМЕРНЫЙ МАССИВ В ОДНОМЕРНЫЕ
void SortString(int[,] arr, int indexString)
{
    int[] arrOne = new int[arr.GetLength(1)];
    int i = indexString;

    for (int j = 0; j < arr.GetLength(1); j++)
    {
        arrOne[j] = arr[i, j];
    }
    Array.Sort(arrOne, (x, y) => y.CompareTo(x));

    Console.WriteLine(String.Join(" ", arrOne));
}

int m = 3;
int n = 4;
int[,] array = new int[m, n];
InitArray(array);
PrintArray(array);
Console.WriteLine();

int indexString = 0;
for (int i = 0; i < array.GetLength(0); i++)
{
    SortString(array, indexString);
    indexString++;
}