/* ==========================================================================================================
ВОЗВРАЩАЕТ ПОБЕДУ ПОСЛЕ ПЕРВОГО, ЛЮБОГО ХОДА - НЕ ПОЙМУ В ЧЕМ ДЕЛО...
============================================================================================================= */

#include <iostream>
#include <random>
#include <stdlib.h>
#include <chrono>

using namespace std;

//======================================================================================

enum Tcell : char // СОСТОЯНИЯ ЯЧЕЕК
{
    CROSS = 'X',
	ZERO = '0',
	EMPTY = '_'
};

enum Tproсess // СТАДИИ
{
	IN_PROCESS,
	WON_AI,
	WON_HUMAN,
	DRAW
};

struct TCoord // КООРДИНАТЫ
{
	size_t y{ 0 };
	size_t x{ 0 };
};

struct TGame // ГЛАВНАЯ СТРУКТУРА ИГРЫ
{
	const size_t SIZE{ 4 }; // 
	Tcell** ppFiled{ nullptr }; // состояния ячеек/ указатель на указатель/ ячейка/ занулена
	Tcell ai; // чем играет искуственный интелект
	Tcell human; // чем играет человек
	Tproсess process{ IN_PROCESS }; // стадии/ процесс/ в процессе
	size_t turn{ 0 }; // чей ход/ значение 0
};

//======================================================================================

inline void clearScr() // ОЧИСТКА ЭКРАНА; inline - рекомендация компилятору встроить код функции в место ее вызова(тело функции копируется во все места вызова)
{
	//system("clc");
	cout << "\x1B[2J\x1B[H";
}

int32_t __fastcall getRandomNum(int32_t min, int32_t max) // ГЕНЕРАТОР СЛУЧАЙНЫХ ЧИСЕЛ; __fastcall - быстрый вызов - 2 параметра
{
	const static auto seed = chrono::system_clock::now().time_since_epoch().count(); // испльзует библиотеку chrono
	static mt19937_64 generator(seed); // генератор
	uniform_int_distribution<int32_t> dis(min, max); // распределение
	return dis(generator);
}

//======================================================================================

void __fastcall initGame(TGame& g) // ИНИЦИАЛИЗАЦИЯ ИГРЫ
{   // выделение памяти для матрицы игрового поля g.ppFiled
	g.ppFiled = new Tcell * [g.SIZE]; // главная структура игры/ ячейка/ выделение памяти/ состояния ячеек/ через указатель/ главная структура игры/ 
	for (size_t i = 0; i < g.SIZE; i++) // от 0, до SIZE(3) в структуре g(TGame), +1 c каждой итерацией
	{
		g.ppFiled[i] = new Tcell[g.SIZE]; // динамическое выделение памяти для ячейки игрового поля g.ppFiled
	}

	// инициализация матрицы игрового поля g.ppFiled пустыми значениями
	for (size_t y = 0; y < g.SIZE; y++) // y - внешние переменные
	{
		for (size_t x = 0; x < g.SIZE; x++) // x - внутренние переменные
		{
			g.ppFiled[y][x] = EMPTY; // инициализируем всю матрицу пустыми ячейками
		}
	}
	// условие кто чем играет
	if (getRandomNum(0, 1000) > 500)
	{
		g.human = CROSS;
		g.ai = ZERO;
		g.turn = 0;
	}

	else
	{
		g.human = ZERO;
		g.ai = CROSS;
		g.turn = 1;
	}
}

void __fastcall deInitGame(TGame& g) // ДЕИНИЦИАЛИЗАЦИЯ (ПОСЛЕ ОКОНЧАНИЯ ИГРЫ)
{
	// освобождение памяти для матрицы игрового поля g.ppFiled
	for (size_t i = 0; i < g.SIZE; i++) // от 0, до SIZE(4) в структуре g(TGame), +1 c каждой итерацией
	{
		delete[] g.ppFiled[i];
	}
	delete[] g.ppFiled;
	g.ppFiled = nullptr;
}

void __fastcall printGame(const TGame& g) // ПЕЧАТЬ ИГРЫ
{
	cout << "    ";
	for (size_t x = 0; x < g.SIZE; x++) // внутренние переменные
	{
		cout << x + 1 << "   ";
	}
	cout << endl;
	
	for (size_t y = 0; y < g.SIZE; y++) // внешние переменные
	{
		cout << y + 1 << " | "; 
		for (size_t x = 0; x < g.SIZE; x++) //  внутренние переменные
		{
			cout << g.ppFiled[y][x] << " | ";
		}
		cout << endl;
	}
	cout << endl << " Human: " << g.human << endl << " Computer: " << g.ai << endl;
}

Tproсess __fastcall getWon(const TGame& g) //  ПРОЦЕСС/ ВЫИГРЫШ
{   // проверка есть ли выигрыш в строках?
	for (size_t y = 0; y < g.SIZE; y++) // внешние переменные
	{
		if (g.ppFiled[y][0] == g.ppFiled[y][1] && g.ppFiled[y][0] == g.ppFiled[y][2] && g.ppFiled[y][0] == g.ppFiled[y][3])
		{
			if (g.ppFiled[y][0] == g.human) // если ячейка [у][0] = человеку, то
				return WON_HUMAN; // победил человек

			if (g.ppFiled[y][0] == g.ai) // если ячейка [у][0] = компьютеру, то
				return WON_AI; // победил компьютер
		}
	}

    // проверка есть ли выигрыш в столбцах?
	for (size_t x = 0; x < g.SIZE; x++) // внутренние переменные
	{
		if (g.ppFiled[0][x] == g.ppFiled[1][x] && g.ppFiled[0][x] == g.ppFiled[2][x] && g.ppFiled[0][x] == g.ppFiled[3][x])
		{
			if (g.ppFiled[0][x] == g.human) // если ячейка [0][x] = человеку, то
				return WON_HUMAN; // победил человек

			if (g.ppFiled[0][x] == g.ai) // если ячейка [0][x] = компьютеру, то
				return WON_AI; // победил компьютер
		}
	}

	// проверка есть ли выигрыш по диагонали?
    if (g.ppFiled[0][0] == g.ppFiled[1][1] && g.ppFiled[0][0] == g.ppFiled[2][2] && g.ppFiled[0][0] == g.ppFiled[3][3]) // если ячейки [0][0] = [1][1] = [2][2] = true, то
	{
	    if (g.ppFiled[0][0] == g.human) // если ячейка [0][0] = человеку, то
		return WON_HUMAN; // победил человек

		if (g.ppFiled[0][0] == g.ai) // если ячейка [0][0] = компьютеру, то
		return WON_AI; // победил компьютер
	}

	if (g.ppFiled[3][0] == g.ppFiled[2][1] && g.ppFiled[2][1] == g.ppFiled[1][2] && g.ppFiled[1][2] == g.ppFiled[0][3]) // если ячейки [2][0] = [1][1] = [0][2] = true, то
	{
		if (g.ppFiled[1][1] == g.human) // если ячейка [1][1] = человеку, то
			return WON_HUMAN; // победил человек

		if (g.ppFiled[1][1] == g.ai) // если ячейка [1][1] = компьютеру, то
			return WON_AI; // победил компьютер
	}
	
    // проверка есть ли ничья?
	bool draw{ true };
	for (size_t y = 0; y < g.SIZE; y++) // внешние переменные
	{
		for (size_t x = 0; x < g.SIZE; x++) //  внутренние переменные
		{
			if (g.ppFiled[y][x] == EMPTY) // если есть хоть один EMPTY, то 
			{
				draw = false; // не ничья

				break; // выход из первого условия 
			}
		}
		if (!draw) // еще раз если draw стала false (не ничья), то
			break; // выход из второго условия
	}

	if (draw) // если draw = true
		return DRAW; // ничья

	return IN_PROCESS; 
}

TCoord __fastcall getHumanCoord(const TGame& g) // КООРДИНАТА/ ЧЕЛОВЕК
{
	TCoord c{ 0 };
	do 
	{
		cout << "Enter X (1..4): ";
		cin >> c.x;
		cout << "Enter Y (1..4): ";
		cin >> c.y;

		c.x--;
		c.y--;
	}

	while (c.x > 3 || c.y > 3 || g.ppFiled[c.y][c.x] != EMPTY);

	return c; // ввод координат
}

TCoord __fastcall getCompCoord(TGame& g) // КООРДИНАТА/ ПОЛУЧИТЬ КООРДИНАТУ ДЛЯ ХОДА КОМПЬТЕРА
{   
	// PRE WIN SITUATION // поиск предвыигрышных ситуаций → чтобы стремиться выиграть
	for (size_t y = 0; y < g.SIZE; y++) // внешние переменные
	{
		for (size_t x = 0; x < g.SIZE; x++) //  внутренние переменные
		{
			if (g.ppFiled[y][x] == EMPTY) // если есть хоть один EMPTY, то 
			{   // гепотетический ход
				g.ppFiled[y][x] = g.ai; // ячейка с координатами [y][x] = ход компьютера
				if (getWon(g) == WON_AI) // если процесс/ выигрыш = стадия игры/ победил компьютер
				{
					g.ppFiled[y][x] = EMPTY; // восстанавливаем состояние поля, если выиграет
					return { y, x };
				}
				g.ppFiled[y][x] = EMPTY; // тоже восстанавливаем состояние поля, если не выиграет
			}
		}
	}

	// PRE FAIL SITUATION // поиск предпроигрышных ситуаций → чтобы помешать человеку выиграть
	for (size_t y = 0; y < g.SIZE; y++) // внешние переменные
	{
		for (size_t x = 0; x < g.SIZE; x++) //  внутренние переменные
		{
			if (g.ppFiled[y][x] == EMPTY) // если есть хоть один EMPTY, то 
			{   // гепотетический ход от лица человека
				g.ppFiled[y][x] = g.human; // ячейка с гепотетическими координатами [y][x] = ход от лица человека
				if (getWon(g) == WON_HUMAN) // если прицесс/ выигрыш = стадия игры/ победил человек
				{
					g.ppFiled[y][x] = EMPTY; // восстанавливаем состояние поля
					return { y, x }; // ходим по этим координатам - мешает выиграть человеку
				}
				g.ppFiled[y][x] = EMPTY; // восстанавливаем состояние поля
			}
		}
	}

	// ход по приоритетам + рандом
	if (g.ppFiled[1][1] == EMPTY) // первым делом проверяем: если ячейка с координатами [1][1](центральная) пустая, то
	{
		return { 1, 1 }; // ходим в нее
	}
    
	// затем углы
	TCoord buf[4]; // массив для координат 4-х углов
	size_t num = 0;
	if (g.ppFiled[0][0] == EMPTY) // если угол c координатами [0][0] = EMPTY
	{
		buf[num] = { 0, 0 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (g.ppFiled[3][3] == EMPTY) 
	{
		buf[num] = { 3, 3 }; // сохранить его для дальнейшего рандомного выбора 
		num++;
	}

	if (g.ppFiled[0][3] == EMPTY) 
	{
		buf[num] = { 0, 3 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (g.ppFiled[3][0] == EMPTY) 
	{
		buf[num] = { 3, 0 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (num > 0)
	{
		const size_t index = getRandomNum(0, 1000) % num; // бросаем кубик ранд 0..num
		return buf[index]; // возвращаем(записываем) случайный угол из сохраненных выше
	}

	// затем не углы
	num = 0;
	if (g.ppFiled[0][1] == EMPTY) 
	{
		buf[num] = { 0, 1 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (g.ppFiled[0][2] == EMPTY) 
	{
		buf[num] = { 0, 2 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (g.ppFiled[3][1] == EMPTY) 
	{
		buf[num] = { 3, 1 }; // сохранить его для дальнейшего рандомного выбора 
		num++;
	}

	if (g.ppFiled[3][2] == EMPTY) 
	{
		buf[num] = { 3, 2 }; // сохранить его для дальнейшего рандомного выбора 
		num++;
	}

	if (g.ppFiled[1][0] == EMPTY) 
	{
		buf[num] = { 1, 0 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (g.ppFiled[2][0] == EMPTY) 
	{
		buf[num] = { 2, 0 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (g.ppFiled[1][3] == EMPTY) // если не угол c координатами [2][0] = EMPTY
	{
		buf[num] = { 1, 3 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (g.ppFiled[2][3] == EMPTY) // если не угол c координатами [2][0] = EMPTY
	{
		buf[num] = { 2, 3 }; // сохранить его для дальнейшего рандомного выбора
		num++;
	}

	if (num > 0)
	{
		const size_t index = getRandomNum(0, 1000) % num; // бросаем кубик ранд 0..num
		return buf[index]; // возвращаем(записываем) случайный не угол из сохраненных выше
	}

}

void congrats(const TGame& g) // ПОЗДРАВЛЕНИЕ
{
	if (g.process == WON_HUMAN)
	{
		cout << "You win! =)" << endl;
	}

	else if (g.process == WON_AI)
	{
		cout << "Computer is win! =/" << endl;
	}

	else if (g.process == DRAW)
	{
		cout << "It is draw! =(" << endl;
	}
}

//====================================================================================== 
 
int main() // ГЛАВНЫЙ АЛГОРИТМ ИГРЫ
{
	TGame g; // ГЛАВНАЯ СТРУКТУРА ИГРЫ/ = g
	initGame(g); // ВЫЗОВ ИНИЦИАЛИЗАЦИИ
	clearScr(); // ОЧИСТКА ЭКРАНА
	printGame(g); // ПЕЧАТЬ ИГРЫ

	do // ОЧЕРЕДНОСТЬ ХОДА
	{ // переменная g.turn четная или нечетная
		if (g.turn % 2 == 0) // если четная, то
		{ // ход человека
			TCoord c = getHumanCoord(g); // переменная с, для получения координаты, по которой хочет сходить человек
			g.ppFiled[c.y][c.x] = g.human;
		}

		else
		{ // ход компьютера
			TCoord c = getCompCoord(g); // переменная с, для получения координаты, по которой хочет сходить компьютер
			g.ppFiled[c.y][c.x] = g.ai;
		}

		g.turn++; // увеличиваем на 1 с каждым ходом, чтобы была очередность
		clearScr(); // ОЧИСТКА ЭКРАНА
		printGame(g); // ЗАНОВО ПЕЧАТЬ ИГРЫ
		g.process = getWon(g); // СТАДИЯ = КТО-ТО ВЫИГРАЛ/ НИЧЬЯ; если true, то выйти из цикла и вызов след функции congrats(g)
	}

	while (g.process == IN_PROCESS); // СТАДИЯ = Tproсess process{ IN_PROCESS }; если true, повторение цикла: TGame g → initGame(g) → clearScr() → printGame(g) → do = while

	congrats(g); // ПОЗДРАВЛЕНИЯ ПОБЕДИТЕЛЯ
	
	deInitGame(g); // ДЕИНИЦИАЛИЗАЦИЯ ИГРЫ ПОСЛЕ ЕЕ ПРЕКРАЩЕНИЯ

	return 0;
}   