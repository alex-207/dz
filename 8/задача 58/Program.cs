/*===========================================================================================================
ПРОГРАММА НАХОДИТ ПРОИЗВЕДЕНИЕ ДВУХ МАТРИЦ
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


int[,] FindComposition(int[,] arr, int[,] arr2)
{
    int[,] arr3 = new int[arr.GetLength(0), arr.GetLength(1)];
    for (int i = 0; i < arr3.GetLength(0); i++)
    {
        for (int j = 0; j < arr3.GetLength(1); j++)
        {
            for (int k = 0; k < arr.GetLength(1); k++)
            {
                arr3[i, j] += arr[i, k] * arr2[k, j];
            }
        }
    }
    return arr3;
}

int m = 2;
int n = 2;
int[,] array = new int[m, n];
int[,] array2 = new int[m, n];
InitArray(array);
InitArray(array2);
PrintArray(array);
Console.WriteLine("---");
PrintArray(array2);
PrintArray(FindComposition(array, array2));