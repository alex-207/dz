/*===========================================================================================================
ПРОГРАММА ИНИЦИАЛИЗИРУЕТ МАССИВ СЛУЧАЙНЫМИ ВЕЩЕСТВЕННЫМИ ЧИСЛАМИ И ИЩЕТ РАЗНИЦУ МЕЖДУ МАКСИМАЛЬНЫМ И МИНИМАЛЬНЫМ ЭЛЕМЕНТАМИ МАССИВА
=============================================================================================================*/
void FillRandomArr(double[] array, int size)
{
    for (int i = 0; i < size; i++)
    {
        array[i] = new Random().Next(100);
    }
}

void PrintArr(double[] array, int size)
{
    for (int i = 0; i < size; i++)
    {
        Console.Write($"{array[i]} ");
    }
    Console.Write("\n");
}

double FindMax(double[] array, int size)
{
    double max = array[0];  // max - это первое число
    for (int i = 0; i < size; i++)
    {
        if (array[i] > max) max = array[i];
    }

    return max;
}

double FindMin(double[] array, int size)
{
    double min = array[0];  // min - это первое число
    for (int i = 0; i < size; i++)
    {
        if (array[i] < min) min = array[i];
    }

    return min;
}

int size = 5;
double[] arr = new double[size];
FillRandomArr(arr, size);
PrintArr(arr, size);
// Console.Write($"{FindMax(arr, size)}\n");
// Console.Write($"{FindMin(arr, size)}");
double result = FindMax(arr, size) - FindMin(arr, size);
Console.Write($"{result}");