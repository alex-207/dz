/*===========================================================================================================
ПРОГРАММА ПРИНИМАЕТ ПОЗИЦИИ ЭЛЕМЕНТА В ДВУМЕРНОМ МАССИВЕ, И ВОЗВРАЩАЕТ ЗНАЧЕНИЕ ЭТОГО ЭЛЕМЕНТА ИЛИ ЖЕ УКАЗАНИЕ, ЧТО ТАКОГО ЭЛЕМЕНТА НЕТ
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

// СЧИТАТЬ КООРДИНАТЫ
int[] ReadCoord(int m, int n)
{
    Console.Write($"Введите две координаты элемента от 0..{m - 1}, и от 0..{n - 1}: \n");
    string inputString = Console.ReadLine();  // считать числа и записать их в строку
    string[] coordString = inputString.Split('.', ',', ' ', ';');  // очистить строку от лишних знаков и записать только числа в массив строк
    int[] coordInt = new int[coordString.Length];  // массив для конвертиции массива строк в данный массив чисел

    // ЗАПОЛНИТЬ МАССИВ КООРДИНАТ - ЧИСЛАМИ
    for (int i = 0; i < coordInt.Length; i++)
    {
        int.TryParse(coordString[i], out coordInt[i]);
    }
    return coordInt;
}

// ПОИСК ЭЛЕМЕНТА
void SearchElement(int[,] arr, int[] coord)
{
    int result = 0;
    for (int i = 0; i < arr.GetLength(0); i++)
    {
        for (int j = 0; j < arr.GetLength(1); j++)
        {
            if (arr.GetLength(0) > coord[0] && arr.GetLength(1) > coord[1])
            {
                Console.Write($"{arr[coord[0], coord[1]]}");
                break;
            }
            else
                Console.Write($"такого числа в массиве нет");
            break;
        }
        break;
    }
}

int m = 3;
int n = 4;
int[,] array = new int[m, n];
InitArray(array);
PrintArray(array);
int[] _coordInt = ReadCoord(m, n);
if (_coordInt.Length == 2) SearchElement(array, _coordInt);  // передаем двухмерный и одномерный массивы
else Console.Write($"Некорректный ввод!\n");