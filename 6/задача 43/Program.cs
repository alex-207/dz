/*===========================================================================================================
ПРОГРАММА ИЩЕТ ТОЧКУ ПЕРЕСЕЧЕНИЯ ДВУХ ПРЯМЫХ, ЗАДАННЫХ УРАВНЕНИЯМИ y = k1 * x + b1, y = k2 * x + b2; ЗНАЧЕНИЯ b1, k1, b2 И k2 ЗАДАЮТСЯ ПОЛЬЗОВАТЕЛЕМ
=============================================================================================================*/
#pragma warning disable

double b1, k1, b2, k2, x, y;

Console.Write($"Введите b1: ");
double.TryParse(Console.ReadLine(), out b1);

Console.Write($"Введите k1: ");
double.TryParse(Console.ReadLine(), out k1);

Console.Write($"Введите b2: ");
double.TryParse(Console.ReadLine(), out b2);

Console.Write($"Введите k2: ");
double.TryParse(Console.ReadLine(), out k2);

x = (b2 - b1) / (k1 - k2);
y = k1 * x + b1;

Console.Write($"b1 = {b1}, k1 = {k1}, b2 = {b2}, k2 = {k2} -> ");
Console.Write($"({Math.Round(x, 2)} {Math.Round(y, 2)})");
