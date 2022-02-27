/* ==========================================================================================================
1. ПОДКЛЮЧЕНИЕ ФУНКЦИЙ ИЗ ДРУГОЙ CPP, И ИХ ПРОТОТИПОВ ИЗ З.Ф. ПОДСЧЕТ ПОЛОЖИТЕЛЬНЫХ И ОТРИЦАТЕЛЬНЫХ ЭЛЕМЕНТОВ
============================================================================================================= */

mylib.cpp

#include <iostream>

using namespace std;

namespace MyLib // 1. - заключаем реализацию функции в отдельную область
{
	float* createAndInitArr(const size_t size) // Реализация функции (создание и инициализация массива)
	{
		float* pArr = new (nothrow) float[size];
		if (pArr != nullptr)
		{
			for (size_t i = 0; i < size; i++)
			{
				pArr[i] = (rand() % 100) - 50.0f; // -50..50
			}
		}

		return pArr; // возвращаем указатель 
	}

	void printArray(const float* arr, const size_t size) // печать массива
	{
		for (size_t i = 0; i < size; i++)
		{
			cout << arr[i] << " ";
		}
		cout << endl;
	}

	void sumElement(const float* arr, const size_t size) // Реализация функции (подсчет и вывод на экран положительных и отрицательных элементов)
	{
		size_t pos = 0U, neg = 0U;

		for (size_t i = 0U; i < size; i++) // пробегаемся по массиву
		{
			if (arr[i] > 0.0f) // подсчитываем количество положительных элементов 
			{
				pos++;
			}

			else if (arr[i] < 0.0f) // подсчитываем количество отрицательных элементов 
			{
				neg++;
			}
		}

		cout << "Positive: " << pos << endl << "Negative: " << neg << endl; // вывод результатов
	}
}



=========================================================================================
mylyb.h

#pragma once

namespace MyLib // 1. - заключаем реализацию функции в отдельную область namespace MyLib
{

    float* createAndInitArr(const size_t size); // прототипы функций

    void printArray(const float* arr, const size_t size);

    void sumElement(const float* arr, const size_t size);
}



=========================================================================================
main.cpp

#include <iostream>
#include <fstream>

#include "mylib.h" // 2. - подключаем з.ф foo.h, в котором хранится прототип printArray

using namespace std;

int main()
{
	const short size = 10;
	const float* arr = MyLib::createAndInitArr(size); // вызов функции создания и инициализации массива через namespace MyLib, передаем size

	if (arr != nullptr)
	{
		MyLib::printArray(arr, size); // вызов функции печати массива через namespace MyLib, передаем массив arr и size
		MyLib::sumElement(arr, size); // вызов функции подсчета положительных и отрицательных чисел массива через namespace MyLib, передаем массив arr и size

		delete[] arr;
	}
}
    


/* ==========================================================================================================
2. define, ПРОВЕРЯЮЩИЙ ДИАПАЗОН ЧИСЛА ОТ 0 ДО y, МАКРО-ФУНКЦИЯ ДЛЯ ПЕЧАТИ true ИЛИ false
============================================================================================================= */

#include <iostream>
#define IN_RANGE(x, y) ((x >= 0 && x < y) ? "true" : "false") // макро-функция для печати true или false
                                                              // условие для x: от 0 до y → если входит в этот диапазон выведет true, если нет, то false
using namespace std;

inline int task() // т.к. функция маленькая и нет цикла, используется inline
{
	int num;
	cout << "Enter the number: " << endl;
	cin >> num;
	cout << IN_RANGE(num, 10) << endl;
}



/* ==========================================================================================================
3. ПУЗЫРЬКОВАЯ СОРТИРОВКА, define ЗАДАЕТ РАЗМЕР МААСИВА, ИНИЦИАЛИЗАЦИЯ МАССИВА С КЛАВИАТУРЫ, ЗАМЕНА ЭЛЕМЕНТОВ ЧЕРЕЗ МАКРОС-ФУНКЦИИ
============================================================================================================= */

mylib.cpp

#include <iostream>

using namespace std;

namespace MyLib // 1. - заключаем реализацию функции в отдельную область
{
	void printArr(const int* arr, const size_t size) // Реализация функции (вывод массива на экран)
	{
		cout << arr[0];
		for (size_t i = 1; i < size; i++)
		{
			cout << " " << arr[i];
		}
		cout << endl;
	}


#define SWAP_INT(x, y) int temp = x; x = y; y = temp; // перестановка элементов через макро-функцию; temp - временный элемент

	void sortArr(int* arr, const size_t size)
	{
		for (size_t i = 0; i < size - 1; i++)
		{                                             // пузырьковая сортировка - два вложенных цикла и условие if 
			for (size_t j = 0; j < size - i - 1; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					SWAP_INT(arr[j], arr[j + 1]); // вызываем макро-функцию для перестановки, которая меняет местами [j] и [j + 1]
				}
			}
		}
	}

}



=========================================================================================
mylyb.h

#pragma once

namespace MyLib // 1. - заключаем реализацию функции в отдельную область
{
	void printArr(const int* arr, const size_t size);

	void sortArr(int* arr, const size_t size); // прототип функции сортировки пузырьком 
}  



=========================================================================================
main.cpp

#include <iostream>
#include <fstream>

#include "foo.h" // 2. - подключаем з.ф foo.h, в котором хранится прототип printArray

#define ARR_SIZE 10

using namespace std;

int main()
{
	int* arr = new (nothrow) int[ARR_SIZE]; // динамическое выделение памяти для массива

	if (arr != nullptr)
	{
		cout << "Enter " << ARR_SIZE << " numbers: " << endl;
		for (size_t i = 0; i < ARR_SIZE; i++)
		{
			cin >> arr[i]; // инициализация элемента массива с клавиатуры
		}

		MyLib::sortArr(arr, ARR_SIZE); // сортировка массива
		MyLib::printArr(arr, ARR_SIZE); // печать массива

		delete[] arr; // освобождаем память
	}
}
    


/* ==========================================================================================================
4. ПОБАЙТОВОЕ ВЫРАВНИВАНИЕ СТРУКТУРЫ pragma pack, ВЫДЕЛЕНИЕ ДИНАМИЧЕСКОЙ ПАМЯТИ ДЛЯ ПЕРЕМЕННОЙ СТРУКТУРЫ, ИНИЦИАЛИЗАЦИЯ СРУКТУРЫ, ВЫВОД НА ЭКРАН СТРУКТУРЫ И ЕЕ РАЗМЕРА, СОХРАНЕНИЕ ФАЙЛА В txt
============================================================================================================= */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

#pragma pack(push, 1) // push, 1 - выравнивание 1 байт
struct Employee  // структура с побайтовым выравниванием
{
	unsigned long long id = 0; // ID сотрудника
	char fName[255], lName[255];
	size_t age = 0; // его возраст
	float salary = 0; // его зарплата
	short experience = 0;
};
#pragma pack(pop) // pop - восстановить настройки

void printEmployee(const Employee* emp)
{
	if (emp != nullptr)
	{   // вывод структуры
		cout << "ID: " << emp->id << endl;
		cout << emp->lName << " " << emp->fName;
		cout << "age: " << emp->age << " " << endl;
		cout << "Salary: $" << emp->salary << "/month" << endl;
		cout << "Experience: " << emp->experience << " year(s)" << endl;
        // вывод размера структуры
		cout << "Size: " << sizeof(Employee) << " bytes" << endl;
	}
}

void saveEmployeeToFile(const string& FName, const Employee* emp)
{
	if (emp == nullptr)
		return;

	ofstream fout(FName); // создаем файл для записи данных

	if (fout.is_open()) // открытие сохраненного в txt файла 
	{   // запись полей
		fout << "Employee:{id:" << emp->id << ";fName:" << emp->fName << ";lName:";
		fout << ";age:" << emp->age << ";salary:" << emp->salary;
		fout << ";experience:" << emp->experience << ";}," << endl;

		fout.close // закрытие файла
	}

	else
	{
		cout << "Can't open file" << endl;
	}
}

int main()
{
	Employee* emp = new (nothrow) Employee; // выделение динамической памяти для структуры

	if (emp != nullptr)
	{  // инициализация структуры
		emp->id = 1;
		strcpy_s(emp->fName, "Ivan");
		strcpy_s(emp->lName, "Pushkin");
		emp->age = 24;
		emp->salary = 100'000.00;
		emp->experience = 3;

		printEmployee(emp); // вызов функции печати
		
		saveEmployeeToFile("employee.txt", emp); // сохранить в файл txt 

		delete emp; // очищаем память
	}
}