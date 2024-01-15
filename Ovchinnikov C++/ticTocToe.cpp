/* ИГРА "КРЕСТИКИ-НОЛИКИ 3х3"
===========================================*/
#include <iostream>
#include <random>
#include <chrono>
#include <stdlib.h>
using namespace std;

// 1. ПЕРЕЧИСЛЕНИЕ СОСТОЯНИЙ КЛЕТКИ
enum tCell : char {
	CROSS = 'X',
	ZERO = '0',
	EMPTY = '_'
};

// 2. ПЕРЕЧИСЛЕНИЕ ПРОЦЕССА ИГРЫ
enum tProcess {
	WIN_PC,
	WIN_HUMAN,
	DRAW,  // ничья 
	IN_PROCESS  // игра в процессе
};

// 3. СТРУКТУРА ОСЕЙ КООРДИНАТ
struct coordinates {
size_t y = 0;  // строки
size_t x = 0;  // столбцы
};

// 4. СТРУКТУРА ИГРЫ (ГЛАВНАЯ СТРУКТУРА)
struct ticTacToe {
	const size_t SIZE = 3;  // поле 3x3
	tCell** pField{ nullptr };  // указатель на игровое поле
	tCell ai;  // чем играет комп
	tCell human;  // чем играет чел
	tProcess process{ IN_PROCESS };  // текущее состояние игры - в процессе
	int turn = 0;  // чья очередь ходить? четные числа - ход человека
};

// 5. ВСТРОИТЬ КОД ФУНКЦИИ ОЧИСТКИ ЭКРАНА, В МЕСТО ЕЕ ВЫЗОВА (НА ВЫБОР)
inline void clearScreen() {
	//system("cls");  // системная очистка экрана или
	cout << "\x1B[2J\x1B[H";
}

// 6. __fastcall - БЫСТРЫЙ ВЫЗОВ ФУНКЦИИ СЛУЧАЙНЫХ ЧИСЕЛ
int32_t __fastcall getRandomNum(int32_t min, int32_t max) {
	const static auto seed = chrono::system_clock::now().time_since_epoch().count();
	static mt19937_64 generator(seed);
	uniform_int_distribution<int32_t> dis(min, max);

	return dis(generator);
}

// 7. __fastcall - БЫСТРЫЙ ВЫЗОВ ФУНКЦИИ ИНИЦИАЛИЗАЦИИ ИГРЫ
void __fastcall initGame(ticTacToe& g) {  // принять по ссылке НЕконстантную главную структуру ticTacToe

	// 1. ВЫДЕЛЕНИЕ
	g.pField = new (nothrow) tCell * [g.SIZE];  // двп для строк

	for (size_t i = 0; i < g.SIZE; i++) {
		g.pField[i] = new (nothrow) tCell[g.SIZE];  // двп для колонок
	}

	// 2. РАБОТА - ИНИЦИАЛИЗАЦИЯ ПУСТОГО ПОЛЯ 
	for (size_t y = 0; y < g.SIZE; y++) {
		for (size_t x = 0; x < g.SIZE; x++) {
			g.pField[y][x] = EMPTY;
		}
	}

	// РАНДОМ ОПРЕДЕЛЯЕТ КТО ЧЕМ ИГРАЕТ
	if (getRandomNum(0, 1000) > 500) {
		g.human = CROSS;
		g.ai = ZERO;
		g.turn = 0;  // очередь человека
	}

	else {
		g.human = ZERO;
		g.ai = CROSS;
		g.turn = 1;  // очередь компьютера
	}
}

// 8. __fastcall - БЫСТРЫЙ ВЫЗОВ ФУНКЦИИ ОСВОБОЖДЕНИЯ ДИНАМИЧЕСКИ ВЫДЕЛЕННОЙ ПАМЯТИ
void __fastcall deInitGame(ticTacToe& g) {  // принять по ссылке НЕконстантную главную структуру ticTacToe

	// 3. ОСВОБОЖДЕНИЕ
	for (size_t i = 0; i < g.SIZE; i++) {
		delete[] g.pField[i];
	}
	delete[] g.pField;
	g.pField = nullptr;
}

// 9. __fastcall - БЫСТРЫЙ ВЫЗОВ ФУНКЦИИ ПЕЧАТЬ ПОЛЯ
void __fastcall printGame(const ticTacToe& g) {  // принять по ссылке константную главную структуру ticTacToe

	cout << "    "s;  // 4 пробела
	for (size_t x = 0; x < g.SIZE; x++) {
		cout << x + 1 << "   "s;  // 3 пробела
	}
	cout << endl;

	for (size_t y = 0; y < g.SIZE; y++) {
		cout << y + 1 << " | "s;

		for (size_t x = 0; x < g.SIZE; x++) {
			cout << g.pField[y][x] << " | "s;
		}
		cout << endl;
	}
	cout << endl;

	// КТО ЧЕМ ИГРАЕТ
	cout << "Human: "s << g.human << endl;
	cout << "Computer: "s << g.ai << endl;
}

// 11. ВЫИГРАЛ ЛИ КТО-ТО, ИЛИ НАСТУПИЛА НИЧЬЯ
tProcess __fastcall gotWin(const ticTacToe& g) {  // принять по ссылке константную главную структуру ticTacToe

	// ПРОВЕРЯЕМ ЕСТЬ ЛИ ВЫИГРЫШ В СТРОКАХ
	for (size_t y = 0; y < g.SIZE; y++) {
		if (g.pField[y][0] == g.pField[y][1] && g.pField[y][0] == g.pField[y][2]) {  // если заняты все три клеточки
			
			if (g.pField[y][0] == g.human) {  // и из занятых клеток принадлежит человеку
				return WIN_HUMAN;  // выиграл человек
			}

			if (g.pField[y][0] == g.ai) { // и из занятых клеток принадлежит компьютеру
				return WIN_PC;  // выиграл компьютер
			}
		}
	}

	// ПРОВЕРЯЕМ ЕСТЬ ЛИ ВЫИГРЫШ В СТОЛБЦАХ
	for (size_t x = 0; x < g.SIZE; x++) {
		if (g.pField[0][x] == g.pField[1][x] && g.pField[0][x] == g.pField[2][x]) {

			if (g.pField[0][x] == g.human) {
				return WIN_HUMAN;
			}

			if (g.pField[0][x] == g.ai) {
				return WIN_PC;
			}
		}
	}

	// ПРОВЕРЯЕМ ЕСТЬ ЛИ ВЫИГРЫШ ПО ДИАГОНАМЯМ
	if (g.pField[0][0] == g.pField[1][1] && g.pField[0][0] == g.pField[2][2]) {

		if (g.pField[0][0] == g.human) {
			return WIN_HUMAN;
		}

		if (g.pField[0][0] == g.ai) {
			return WIN_PC;
		}
	}

	if (g.pField[2][0] == g.pField[1][1] && g.pField[1][1] == g.pField[0][2]) {

		if (g.pField[1][1] == g.human) {
			return WIN_HUMAN;
		}

		if (g.pField[1][1] == g.ai) {
			return WIN_PC;
		}
	}

	// ПРОВЕРИТЬ НИЧЬЮ
	bool draw = true;

	// ПЕРЕБИРАЕМ ВСЮ МАТРИЦУ
	for (size_t y = 0; y < g.SIZE; y++) {
		for (size_t x = 0; x < g.SIZE; x++) {
			
			if (g.pField[y][x] == EMPTY) {  // если хоть одна клеточка пустая
				draw = false;  // то ничьей нет
				break;  // досрочный выход
			}
		}
		if (draw == false) {
			break;  // досрочный выход
		}
	}

	if (draw == true) {
		return DRAW;
	}

	return IN_PROCESS;  // если выиграша или ничьей нет - продолжить игру
}

 // 12. ПОЛУЧИТЬ КООРДИНАТУ ХОДА ЧЕЛОВЕКА
coordinates __fastcall getCoordHum(const ticTacToe& g) {  // принять по ссылке константную главную структуру ticTacToe
	coordinates c{ 0 };
	do {
		cout << "Enter X (1..3): "s;
		cin >> c.x;
		cout << "Enter Y (1..3): "s;
		cin >> c.y;

		// Т.К. ДЛЯ ЧЕЛОВЕКА ДИАПАЗОН 1..3, ТО ДЛЯ КОМПЬЮТЕРА ДИАПАЗОН БУДЕТ 0..2 -> ПОЭТОМУ УМЕНЬШАЕМ x и у на 1:
		c.x--;
		c.y--;
	} while (c.x > 2 || c.y > 2 || g.pField[c.y][c.x] != EMPTY);  // если координаты больше 2 или клеточка не пустая (занята) -> повторить ввод координат

	return c;
}

 // 13. ПОЛУЧИТЬ КООРДИНАТУ ХОДА КОМПЬТЕРА (ИСКУСТВЕННЫЙ ИНТЕЛЕКТ)
coordinates __fastcall getCoordComp(ticTacToe& g) {  // принять по ссылке НЕконстантную главную структуру ticTacToe

	// 1. АЛГОРИТМ ПОЗВОЛЯЕТ СДЕЛАТЬ НУЖНЫЙ ХОД КОМПЬЮТЕРУ, ЕСЛИ ДЛЯ ПОБЕДЫ КОМПЬЮТЕРА ОСТАЛСЯ ОДИН ХОД
	for (size_t y = 0; y < g.SIZE; y++) {
		for (size_t x = 0; x < g.SIZE; x++) {

			if (g.pField[y][x] == EMPTY) {  // если хоть одна клеточка пустая
				g.pField[y][x] = g.ai;  // сделать в нее гепотетический ход 
				
				if (gotWin(g) == WIN_PC) {  // и если при этом текущий статус игры быдет ==  WIN_PC
					g.pField[y][x] = EMPTY;  // сделать эту клетку опять пустой

					return { y,x };  // вернуть ход по этим координатам
				}

				else {  // если выиграть не получилось
					g.pField[y][x] = EMPTY;  // сделать эту клетку пустой
				}
			}
		}
	}

	// 2. АЛГОРИТМ МЕШАЕТ ПОБЕДИТЬ ЧЕЛОВЕКУ, ЕСЛИ ЧЕЛОВЕКУ ОСТАЛСЯ ОДИН ХОД ДО ПОБЕДЫ
	for (size_t y = 0; y < g.SIZE; y++) {
		for (size_t x = 0; x < g.SIZE; x++) {

			if (g.pField[y][x] == EMPTY) {  // если хоть одна клеточка пустая
				g.pField[y][x] = g.human;  // сделать в нее гепотетический ход от лица человека

				if (gotWin(g) == WIN_HUMAN) {  // и если при этом текущий статус игры быдет ==  WIN_HUMAN
					g.pField[y][x] = EMPTY;  // сделать эту клетку опять пустой

					return { y,x };  // вернуть ход по этим координатам - помешать человеку выиграть
				}

				else {  // если помешать выиграть не получилось
					g.pField[y][x] = EMPTY;  // сделать эту клетку пустой
				}
			}
		}
	}

	// ПРИОРИТЕТНЫЕ ХОДЫ:
	// 3. ПОПЫТКА ПОХОДИТЬ В ЦЕНТР
	if (g.pField[1][1] == EMPTY) {  // если центр свободен
		return { 1,1 };
	}

	// 4. ПОПЫТКА ПОХОДИТЬ В УГОЛ
	coordinates buf[4];  
	size_t num = 0;  // переменная для хранения количества свободных углов, куда можно будет походить
	
	// ПРОВЕРКА ВСЕХ УГЛОВ
	if (g.pField[0][0] == EMPTY) {  // если угол свободен
		buf[num] = { 0,0 };  // сохранить его в буфер для последующего выбора угла
		num++;  // увеличить значение количества свободных углов
	}

	if (g.pField[2][2] == EMPTY) {
		buf[num] = { 2,2 };
		num++;
	}

	if (g.pField[2][0] == EMPTY) {
		buf[num] = { 2,0 };
		num++;
	}

	if (g.pField[0][2] == EMPTY) {
		buf[num] = { 0,2 };
		num++;
	}

	// РАНДОМНО ВЫБРАТЬ УГОЛ ДЛЯ ХОДА
	if (num > 0) {
		const size_t index = getRandomNum(0, 1000) % num;  // index = 0..num
		return buf[index];  // случайный угол из пустых
	}

	// 5. ПОПЫТКА ПОХОДИТЬ В НЕ УГОЛ
	// ПРОВЕРКА ВСЕХ НЕ УГЛОВ
	num = 0;  // переменная для хранения количества свободных не углов, куда можно будет походить
	if (g.pField[0][1] == EMPTY) {  // если не угол свободен
		buf[num] = { 0,1 };  // сохранить его в буфер для последующего выбора не угла
		num++;  // увеличить значение количества свободных не углов
	}

	if (g.pField[1][0] == EMPTY) {
		buf[num] = { 1,0 };
		num++;
	}

	if (g.pField[1][2] == EMPTY) {
		buf[num] = { 1,2 };
		num++;
	}

	if (g.pField[2][1] == EMPTY) {
		buf[num] = { 2,1 };
		num++;
	}

	// РАНДОМНО ВЫБРАТЬ НЕ УГОЛ ДЛЯ ХОДА
	if (num > 0) {
		const size_t index = getRandomNum(0, 1000) % num;  // index = 0..num
		return buf[index];  // случайный не угол из пустых
	}
} 

// 14. ПОЗДРАВЛЕНИЕ
void __fastcall congrats(const ticTacToe& g) {
	if (g.process == WIN_HUMAN) {
		cout << "You are won!  =)"s << endl;
	}

	else if (g.process == WIN_PC) {
		cout << "Computer is won!  :("s << endl;
	}

	else if (g.process == DRAW) {
		cout << "It is draw!  :/"s << endl;
	}
}

int main() {
	
	ticTacToe g;  // переменная типа главной структуры игры
	
	initGame(g);  // функция инициализации игры - передаем главную структуру
	
	clearScreen();  // очистить экран
	
	printGame(g);  // печать поля

	// 10. ЦИКЛ ОТРИСОВКИ ПОЛЯ ПОСЛЕ КАЖДОГО ХОДА
	do {
		if (g.turn % 2 == 0) {  // ход человека
			
			// ПОЛУЧАЕМ КООРДИНАТУ, ПО КОТОРОЙ ХОЧЕТ СХОДИТЬ ЧЕЛОВЕК
			coordinates c = getCoordHum(g);  
			g.pField[c.y][c.x] = g.human;
		}

		else {  // ход компьютера
			coordinates c = getCoordComp(g);
			g.pField[c.y][c.x] = g.ai;
		}
		g.turn++;  // увелеичивать переменную очередности для поочередных ходов (четное - нечетное)
		
		// КАЖДЫЙ ЦИКЛ ОЧИСТИТЬ ПОЛЕ И ОТРИСОВАТЬ ЗАНОВО
		clearScreen();  // очистить экран
		printGame(g);  // печать поля

		// КАЖДЫЙ ЦИКЛ ПРОВЕРКА - НЕ ВЫИГРАЛ ЛИ КТО-ТО, ИЛИ НАСТУПИЛА НИЧЬЯ
		g.process = gotWin(g);  // передаем главную структуру
	} 
	while (g.process == IN_PROCESS);  // повтрять цикл - пока игра в процессе

	congrats(g);  // поздравление в случае выигрыша кого-либо

	deInitGame(g);  // функция деинициализации игры

	return 0;
}