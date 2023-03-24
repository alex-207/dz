/*===========================================================================================================
ПРОГРАММА ИНИЦИАЛИЗИРУЕТ МАССИВ СЛУЧАЙНЫМИ ЧИСЛАМИ И ИЩЕТ СУММУ ЭЛЕМЕНТОВ, СТОЯЩИХ НА НЕЧЁТНЫХ ИНДЕКСАХ МАССИВА
=============================================================================================================*/
void FillRandomArr(int[] array, int size)
{
    for (int i = 0; i < size; i++)
    {
        array[i] = new Random().Next(-100, 101);
    }
}

void PrintArr(int[] array, int size)
{
    for (int i = 0; i < size; i++)
    {
        Console.Write($"{array[i]} ");
    }
    Console.Write("\n");
}

int FindSumm(int[] array, int size)
{
    int summ = 0;
    for (int i = 1; i < size; i += 2)
    {
        summ += array[i];
    }

    return summ;
}

int size = 14;
int[] arr = new int[size];
FillRandomArr(arr, size);
PrintArr(arr, size);
Console.Write($"{FindSumm(arr, size)}");