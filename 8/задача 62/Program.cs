/*===========================================================================================================
ПРОГРАММА ЗАПОЛНЯЕТ СПИРАЛЬНО МАССИВ 4 НА 4
=============================================================================================================*/
#pragma warning disable

// ИНИЦИАЛИЗАЦИЯ МАССИВА
int[,] InitArray(int[,] arr)
{
    int i = 1;
    for (int j = 0; j < arr.GetLength(1); j++)
    {
        arr[0, j] = i;
        i++;
    }

    for (int j = 1; j < arr.GetLength(1); j++)
    {
        arr[j, arr.GetLength(1) - 1] = i;
        i++;
    }

    for (int j = arr.GetLength(1) - 2; j >= 0; j--)
    {
        arr[arr.GetLength(0) - 1, j] = i;
        i++;
    }

    for (int j = arr.GetLength(0) - 2; j > 0; j--)
    {
        arr[j, 0] = i;
        i++;
    }

    //

    for (int j = 0; j < arr.GetLength(1) - 2; j++)
    {
        arr[arr.GetLength(1) - 3, j + 1] = i;
        i++;
    }

    for (int j = 0; j < arr.GetLength(1) - 3; j++)
    {
        arr[arr.GetLength(1) - 2, j + 2] = i;
        i++;
    }

    for (int j = arr.GetLength(1) - 3; j >= 0; j--)
    {
        arr[arr.GetLength(0) - 2, j] = i;
        i++;
    }

    return arr;
}

// ПЕЧАТЬ МАССИВА
void PrintArray(int[,] arr)
{
    for (int i = 0; i < arr.GetLength(0); i++)
    {
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            Console.Write($"{arr[i, j]:d2} ");
        }
        Console.WriteLine();
    }
}

int n = 4;
int m = 4;
int[,] arr = new int[n, m];  // объявление трехмерного массива
InitArray(arr);
PrintArray(arr);