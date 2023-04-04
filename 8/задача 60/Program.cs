/*===========================================================================================================
ПРОГРАММА ПОСТРОЧНО ВЫВОДИТ ТРЕХМЕРНЫЙ МАССИВ, ДОБАВЛЯЯ ИНДЕКСЫ КАЖДОГО ЭЛЕМЕНТА
=============================================================================================================*/
#pragma warning disable

// ИНИЦИАЛИЗАЦИЯ МАССИВА
int[,,] InitArray(int[,,] arr)
{
    int num = 10;
    for (int i = 0; i < arr.GetLength(0); i++)
    {
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            for (int k = 0; k < arr.GetLength(2); k++)
            {
                arr[i, j, k] = num;
                num++;
            }
        }
    }
    return arr;
}

// ПЕЧАТЬ МАССИВА
int[,,] PrintArray(int[,,] arr)
{
    for (int i = 0; i < arr.GetLength(0); i++)
    {
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            for (int k = 0; k < arr.GetLength(2); k++)
            {
                Console.Write($"{arr[i, j, k]} ({i},{j},{k}) ");
            }
            Console.WriteLine();
        }
        Console.WriteLine();
    }
    return arr;
}


int n = 2;
int m = 2;
int o = 2;
int[,,] arr3 = new int[n, m, o];  // объявление трехмерного массива
InitArray(arr3);
PrintArray(arr3);