﻿/*===========================================================================================================
ПРОГРАММА ПРИНИМАЕТ НА ВХОД ЦИФРУ, ОБОЗНАЧАЮЩУЮ ДЕНЬ НЕДЕЛИ, И ПРОВЕРЯЕТ, ЯВЛЯЕТСЯ ЛИ ЭТОТ ДЕНЬ ВЫХОДНЫМ
=============================================================================================================*/
int a = new Random().Next(1, 8);  // 1..7
Console.WriteLine($"{a}");
if(a >= 1 && a < 6){  // 1..5
    Console.WriteLine("идти на работу!");
}
else
    Console.WriteLine("сегодня выходной!");