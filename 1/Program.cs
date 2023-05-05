/*=========================================
ПРОГРАММА ФОРМИРУЕТ ИЗ ИМЕЮЩЕГОСЯ МАССИВА СТРОК НОВЫЙ МАССИВ ИЗ СТРОК, ДЛИНА КОТОРЫХ МЕНЬШЕ, ЛИБО РАВНА 3 СИМВОЛАМ
===========================================*/
#pragma warning disable

int FindSize2(string[] arr)
{
    int size2 = 0;
    for (int i = 0; i < arr.Length; i++)
    {
        if (arr[i].Length <= 3) size2++;
    }
    return size2;
}

string[] FillArray2(string[] arr, int size2)
{
    string[] array2 = new string[size2];
    int index2 = 0;
    for (int i = 0; i < arr.Length; i++)
    {
        if (arr[i].Length <= 3)
        {
            array2[index2] = arr[i];
            index2++;
        }
    }

    return array2;
}

void PrintArray2(string[] arr2)
{
    for (int i = 0; i < arr2.Length; i++)
    {
        Console.Write($"{arr2[i]}");
        if (i == arr2.Length - 1) Console.Write("");
        else Console.Write($", ");
    }
}

string[] array = new string[] { "134", "15245", "-24", "com24" };
int size2 = FindSize2(array);
PrintArray2(FillArray2(array, size2));