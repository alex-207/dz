/* ==========================================================================================================
1. ДИНАМИЧЕСКОЕ ВЫДЕЛЕНИЕ ПАМЯТИ ДЛЯ ОДНОМЕРНОГО МАССИВА, С ВВОДОМ ЕГО РАЗМЕРА И ПЕРЕДАЧА В ФУНКЦИЮ ДЛЯ ИНИЦИАЛИЗАЦИИ И ПЕРЕДАЧА В ФУНКЦИЮ ПЕЧАТИ
============================================================================================================= */
	
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void printArray(const int* array, const size_t arraySize) // 3. - функция печати на экране
{
	cout << "Array: ";
	for (size_t i = 0; i < arraySize; i++)
	{
		cout << array[i] << " "; // Array: 1 2 4 8 16..
	}
	cout << endl;
}

void initArray(int* arr, size_t SIZE) // 2. - функция для инициализации
{
	arr[0] = 1;
	for (size_t i = 1; i < SIZE; i++)
	{
		arr[i] = arr[i - 1] << 1; // побитовый сдвиг влево = * 2 
	}
	printArray(arr, SIZE); // передача массива и его размера, в функцию для печати ↑
}

int main() // 1. - главная функция
{
	int SIZE; // Количество элементов
	cout << "Enter size of your array: ";
	cin >> SIZE;
	int* arr = new (nothrow) int[SIZE]; // 1.1 - выделение памяти для одномерного массива

	if (arr != nullptr) // 1.2 - если память выделилась, то
	{
		initArray(arr, SIZE); // передача массива и его размера, в функцию для инициализации ↑
		delete[] arr;  // 4. - очистить память под массив
	}
	return 0;
}



/* ==========================================================================================================
2. ДИНАМИЧЕСКОЕ ВЫДЕЛЕНИЕ ПАМЯТИ ДВУХМЕРНОГО МАССИВА(МАТРИЦЫ) И ПЕРЕДАЧА ЕГО В ФУНКЦИЮ ДЛЯ РАНДОМНОЙ ИНИЦИАЛИЗАЦИИ И ПЕРЕДАЧА В ФУНКЦИЮ ПЕЧАТИ
============================================================================================================= */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void printMatrix(int** array, const size_t SIZE) // 3. - функция дл печати матрицы
{
	cout << "Matrix: " << endl;

	for (size_t i = 0; i < SIZE; i++)
	{
		for (size_t j = 0; j < SIZE; j++)
		{
			cout << array[i][j] << " ";  // Matrix:
			                             // 55 77 99 14
			                             //	77 89 9 81
			                             //	56 74 25 41
			                             //	36 46 25 1
		}
		cout << endl;
	}
}

void initMatrix(int** pMatrix, const size_t SIZE) // 2. - функция для инициализации матрицы
{
	for (size_t i = 0; i < SIZE; i++)
	{
		for (size_t j = 0; j < SIZE; j++)
		{
			pMatrix[i][j] = rand() % 100; // рандомная инициализации матрицы 0..99
		}
	}
	printMatrix(pMatrix, SIZE);  // передача матрицы и ее размера, в функцию для печати ↑
}

int main() // 1. - главная функция
    {
	srand(time(NULL)); // объявление генератора случ числ
	const size_t SIZE = 4; // размер матрицы: 4х4
	int** pMatrix = new int* [SIZE]; // 1.1 - объявление указателя на указатель матрицы(двухмерный массив) и выделение динамической памяти для указателей
	for (size_t i = 0; i < SIZE; i++) // 1.2 - цикл для выделения памяти для каждой строки матрицы
	{
		pMatrix[i] = new int[SIZE];
	}

	initMatrix(pMatrix, SIZE); // 1.3 - передаем матрицу и ее размер в функцию для инициализации ↑

	for (size_t i = 0; i < SIZE; i++) // 4. - цикл для очистки памяти для каждой строки матрицы
	{
		delete[] pMatrix[i]; 
	}
	delete[] pMatrix; // очистка места для указателей

    return 0;
    }

	
	
/* ==========================================================================================================
3. ПРОГРАММА СОЗДАНИЯ ДВУХ ТЕКСТОВЫХ ФАЙЛОВ, С ЗАПРОСОМ ИХ НАЗВАНИЯ У ПОЛЬЗОВАТЕЛЯ
============================================================================================================= */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void WriteToFile(const string& fn, const string& str) // функция записи содержимого в файл принимет по ссылке названия и содержимое файлов 
{                                                     // т.к. названия и содержимое не будут меняться, делаем их константными
	ofstream fout;
	fout.open(fn);  // открываем файл
	if (fout.is_open())  // если он открыт
	{
		fout << str; // записывае  внего строку
		fout.close(); // закрываем поток
	}
}

int main()
{
	cout << "Enter file name 1 for output: ";
	string fn1, fn2;
	cin >> fn1;
	cout << "Enter file name 2 for output: ";
	cin >> fn2;

	const string str1 = "When consuming writespace-delimited input";
	WriteToFile(fn1, str1); // передаем в функцию записи название и содержимое файла 1

	const string str2 = "Null-terminated strings are array of characters that are terminated by a special null character";
	WriteToFile(fn2, str2); // передаем в функцию записи название и содержимое файла 2
	
	return 0;
}

	
	
/* ==========================================================================================================
4*.  ФУНКЦИЯ, «СКЛЕИВАЮЩАЯ» ДВА ФАЙЛА В ТРЕТИЙ ТЕКСТОВЫЙ ФАЙЛ (ИМЯ ФАЙЛОВ СПРОСИТЬ У ПОЛЬЗОВАТЕЛЯ)
============================================================================================================= */	

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void CopyFile(ifstream& fin, ofstream& fout) // принимаем по ссылке два входных потока и выходной поток
{
	string str;
	while (!fin.eof()) // цикл для записи строк во выходной поток по одной, пробегаем до конца файла
	{
		getline(fin, str); // читаем строку из входного потока
		fout << str << endl; // записываем строку в выходной поток 
	}
}

int main()
{
	cout << "Enter file name 1 for input: ";
	string fn1, fn2, outFN;
	cin >> fn1;
	cout << "Enter file name 2 for input: ";
	cin >> fn2;
	cout << "Enter merged file name: ";
	cin >> outFN;

	ifstream fin1(fn1); // открытие 1 входного потока
	ifstream fin2(fn2); // открытие 2 входного потока
	ofstream fout(outFN); // открытие выходного потока

	if (fin1.is_open() && fin2.is_open() && fout.is_open())
	{
		CopyFile(fin1, fout);  // передача по ссылке в функцию CopyFile - 1 входной и выходной поток
		fin1.close();

		CopyFile(fin2, fout); // передача по ссылке в функцию CopyFile - 2 входной и выходной поток
		fin2.close();

		fout.close(); // закрываем поток всех трех файлов
	}
	
	return 0;
}


	
/* ==========================================================================================================
5**. ПРОГРАММА ПОИСКА ИСКОМОГО СЛОВА, ВВЕДЕННОГО ПОЛЬЗОВАТЕЛЕМ В ФАЙЛЕ ТОЖЕ УКАЗАННЫМ ПОЛЬЗОВАТЕЛЕМ
============================================================================================================= */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

bool check(const string& fileName, const string& word) // принимаем имя файла для поиска слова и само слово
{
	ifstream file(fileName);

	if (file.is_open()) // если файл удалось открыть для чтения
	{
		string line;

		while (!file.eof()) // цикл для проверки всего файла на наличие искомого слова
		{
			getline(file, line); // прочитать строку
			if (line.find(word) != string::npos) // поиск слова в данной строке и так до конца файла
			{
				file.close(); // закрыть файл
				return true; // если нашли искомое слово, то возвращаем true
			}
		}
	}

	else // если файл не удалось открыть, возращает false
	{
		cout << "Error! Can not open file: " << fileName << endl;
	}

	file.close();
	return false;
}

int main()
{
	string fileName, checkWord;

	cout << "Enter file name for search key word: ";
	cin >> fileName; // ввод файла, в котором будем искать слово

	cout << "Enter search word: ";
	cin >> checkWord;  // ввод искомого слова

	if (check(fileName, checkWord)) // если слово найденно 
	{
		cout << "Word " + checkWord + " was found in the file " + fileName;
	}

	else // если слово не найденно 
	{
		cout << "Word " + checkWord + "was NOT found in the file " + fileName << endl;
	}
	
	return 0;
}

