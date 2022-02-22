/* ==========================================================================================================
1. ПОДКЛЮЧЕНИЕ ФУНКЦИЙ ИЗ ДРУГОЙ CPP, И ИХ ПРОТОТИПОВ ИЗ З.Ф.
============================================================================================================= */

mylib.cpp

#include <iostream>

using namespace std;

namespace MyLib // 1. - заключаем реализацию функции в отдельную область
{

void initArray(float *arr, const int size) // Реализация функции (инициализация массива)
{
    arr[0] = -1.23f;
    for (float i = -1.23f; i < size; i++);
    printArray(arr, size); // передача массива и его размера, в функцию для печати 
}

void printArray(float *arr, const int size) // Реализация функции (вывод массива на экран)
{
    for (float i = -1.23f; i < size; i++)
    {
        cout << i << " ";
    }
        
}

void sumElement(float *arr, const int size) // ДАЛЬШЕ НЕ ЗНАЮ КАК ПРАВИЛЬНО...
{
    for (float i = -1.23f; i < size; i++)
    {
        cout << arr[i > 0] << " ";
    }
    cout << endl;
    for (float i = -1.23f; i < size; i++)
    {
        cout << arr[i < 0] << " ";
    }
}
}



=========================================================================================
mylyb.h

#pragma once

namespace MyLib // 1. - заключаем реализацию функции в отдельную область
{

void printArray(float* arr, const int size);
void initArray(float* arr, const int size);
void sumElement(float* arr, const int size);

}



=========================================================================================
main.cpp

#include <iostream>
#include "mylib.h" // 2. - подключаем з.ф foo.h, в котором хранится прототип printArray

using namespace std;

int main(int argc, char* argv[])
{
    cout << "Invoke printArray fun" << endl;
    const int size = 6;
    float arr[size];
    MyLib::printArray(arr, size); // 3. - Вызываем функцию, реализация которой в другой cpp
    MyLib::initArray(arr, size);
    cout << endl;
    cout << endl;
    cout << "Invoke sumElement fun" << endl;
    MyLib::sumElement(arr, size);

    return 0;
}



/* ==========================================================================================================
2. define, ПРОВЕРЯЮЩИЙ ДИАПАЗОН ЧИСЛА
============================================================================================================= */

#include <iostream>
#define PRINT 

using namespace std;

int main()
{
	int n;
	cout << "Enter the number: " << endl;
	cin >> n;

	int m;
	cout << "Enter the second number: " << endl;
	cin >> m;

	if (n > 0 && n < m)
	{
        #ifdef PRINT
		cout << "true" << endl;
        #endif
	}

	else
		cout << "false" << endl;

	return 0;
}



/* ==========================================================================================================
3. define ЗАДАЕТ РАЗМЕР МААСИВА, ИНИЦИАЛИЗАЦИЯ МАССИВА С КЛАВИАТУРЫ, ФУНКЦИЯ СОРТИРОВКИ ПУЗЫРЬКОМ, ЗАМЕНА ЭЛЕМЕНТОВ ЧЕРЕЗ МАКРОС-ФУНКЦИИ
============================================================================================================= */

#include <iostream>
#define size 4
#define SwapINT(arr[0], arr[1], arr[2], arr[3]) (arr[3], arr[2], arr[1], arr[0])  // ТРЕБУЕТ КРУГЛУЮ СКОБКУ, НЕ ЗНАЮ КАК ИСПРАВИТЬ

using namespace std;

void sortArray(int *arr, int size) // функция сортировки пузырьком
{
	setlocale(LC_ALL, "ru");
	
	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size - 1; j++)
		{
			if (arr[j] > arr[j + 1])
			{
				int b = arr[j]; // создали дополнительную переменную
				arr[j] = arr[j + 1]; // меняем местами
				arr[j + 1] = b; // значения элементов
			}
		}
	}
	cout << "Массив в отсортированном виде: ";

	for (int i = 0; i < size; i++) {
		cout << arr[i] << " "; // выводим элементы массива
	}
	int cout = SwapINT(arr[0], arr[1], arr[2], arr[3]);
}

int main()
{
	int arr[size];

	cout << "Initial the array: " << endl;
	for (int i = 0; i < size; i++) {
		cin >> arr[i];
	}
	sortArray(arr, size);

	return 0;
}



/* ==========================================================================================================
4. ВЫРАВНИВАНИЕ СТРУКТУРЫ pragma pack, ВЫДЕЛЕНИЕ ДИНАМИЧЕСКОЙ ПАМЯТИ ДЛЯ ПЕРЕМЕННОЙ СТРУКТУРЫ, ИНИЦИАЛИЗАЦИЯ СРУКТУРЫ, ВЫВОД НА ЭКРАН СТРУКТУРЫ И ЕЕ РАЗМЕРА
============================================================================================================= */

#include <iostream>

using namespace std;

#pragma pack(push, 1) // push, 1 - сохранить предыдущие настройки
struct Employee  // Новый тип данных Сотрудник
{
    long id; // ID сотрудника
    unsigned short age; // его возраст
    double salary; // его зарплата
};
#pragma pack(pop) // pop - восстановить настройки

int main()
{
    Employee* pEmployee = new Employee;
    pEmployee->id = 14340000;
    pEmployee->age = 34;
    pEmployee->salary = 60.000'00;
    delete pEmployee;

    cout << sizeof(Employee);

	return 0;
}