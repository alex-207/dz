/*===========================================================================================================
ПРОГРАММА ПРИНИМАЕТ НА ВХОД КООРДИНАТЫ ДВУХ ТОЧЕК И НАХОДИТ РАССТОЯНИЕ МЕЖДУ НИМИ В 3d ПРОСТРАНСТВЕ
=============================================================================================================*/
#pragma warning disable  // чтобы не выскакивали предупреждения

int aX;
int aY;
int aZ;

int bX;
int bY;
int bZ;

double result = 0;

Console.WriteLine("Enter the aX: ");
int.TryParse(Console.ReadLine(), out aX);

Console.WriteLine("Enter the aY: ");
int.TryParse(Console.ReadLine(), out aY);

Console.WriteLine("Enter the aZ: ");
int.TryParse(Console.ReadLine(), out aZ);

Console.WriteLine("Enter the bX: ");
int.TryParse(Console.ReadLine(), out bX);

Console.WriteLine("Enter the bY: ");
int.TryParse(Console.ReadLine(), out bY);

Console.WriteLine("Enter the bZ: ");
int.TryParse(Console.ReadLine(), out bZ);

result = Math.Sqrt((bX - aX) * (bX - aX) + (bY - aY) * (bY - aY) + (bZ - aZ) * (bZ - aZ));  // вычисление расстояния между двумя точками в пространстве через квадратный корень
result = Math.Round(result, 2);  // округлить до двух знаков после запятой

Console.WriteLine($"distance = {result}");