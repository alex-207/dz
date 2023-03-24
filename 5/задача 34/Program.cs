/*===========================================================================================================
ПРОГРАММА ИНИЦИАЛИЗИРУЕТ МАССИВ СЛУЧАЙНЫМИ, ТРЕХЗНАЧНЫМИ, ПОЛОЖИТЕЛЬНЫМИ ЧИСЛАМИ И ПОКАЗЫВАЕТ КОЛИЧЕСТВО ЧЕТНЫХ ЧИСЕЛ В ЭТОМ МАССИВЕ
=============================================================================================================*/
void FillRandomArr(int[] array, int size)
{
    for (int i = 0; i < size; i++)
    {
        array[i] = new Random().Next(100, 1000);
    }
}

void PrintArr(int[] array, int size)
{
    for (int i = 0; i < size; i++)
    {
        Console.Write($"{array[i]} ");
    }
}

int FindNun(int[] array, int size)
{
    int count = 0;
    for (int i = 0; i < size; i++)
    {
        if (array[i] % 2 == 0) count++;
    }

    return count;
}

int size = 4;
int[] arr = new int[size];
FillRandomArr(arr, size);
PrintArr(arr, size);
Console.Write($"{FindNun(arr, size)}");