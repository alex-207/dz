
/*==================================================================================================================
1.  ОБЪЯВЛЕНИЕ И ИНИЦИАЛИЗАЦИЯ ПЕРЕМЕННЫХ
==================================================================================================================== */

short int rool = - 10;

int a = 30'000;

long long b = 9'223'372'036'854'077;

<<<<<<< HEAD
char c = 'A';
=======
char c = '14';  // ♫
>>>>>>> d89242956c65cec28355f85d11c230b0c12f665f

bool d;
d = true;

float e;
e = -2'147'483'647.9f;

double f;
f =  9 223 372 036 854 775 805.9999999999;




/*==================================================================================================================
2. ОБЪЯВЛЕНИЕ И ИНИЦИАЛИЗАЦИЯ СИМВОЛЬНОГО ПЕРЕЧИСЛЕНИЯ "TicTacToeCell"(КЛЕТКА ДЛЯ ИГРЫ КРЕСТИКИ-НОЛИКИ), ТИПА "enum", С ПЕРЕЧИСЛЕНИЕМ СОСТОЯНИЙ ЯЧЕЙКИ ПОЛЯ
==================================================================================================================== */
 
enum TicTacToeCell : char  {
	 TC_CROSS = 'X',
	 TC_ZERRO = '0',   
	 TC_EMPTY = '_'
	 };
	
	
	
	
/*==================================================================================================================
3. ОБЪЯВЛЕНИЕ И ИНИЦИАЛИЗАЦИЯ ДВУМЕРНОГО МАССИВА "field"(ПОЛЕ), СОДЕРЖАЩИЙ ПЕРЕЧИСЛЕНИЕ "TicTacToeCell"
==================================================================================================================== */

TicTacToeCell field[3][3] { { TC_EMPTY, TC_EMPTY, TC_EMPTY },
		                    { TC_EMPTY, TC_EMPTY, TC_EMPTY },
					        { TC_EMPTY, TC_EMPTY, TC_EMPTY } };

}




/*==================================================================================================================
4*. ОБЪЯВЛЯЕМ СТРУКТУРУ "TicTacToe"(ПОЛЕ ДЛЯ ИГРЫ В КРЕСТИКИ-НОЛИКИ), С ОБЪЯВЛЕНИЕМ ВСЕХ ЕЕ СВОЙСТВ
==================================================================================================================== */

struct TicTacToe {
	const unsigned int nFieldSize = 3;            // константа размера поля 3 х 3
	TicTacToeCell field[3][3]                     // массив поля
	char Player1Name[];                           // символьный массив "имя первого игрока"
	char Player2Name[];                           // символьный массив "имя второго игрока"
	TicTacToeCell ePlayer1, ePlayer2;             // чем играет первый и второй игрок
	bool isGameFinished;                          // логическая переменная "игра закончилась или нет"
	bool isFirstPlayerWon;                        // логическая переменная "победил первый игрок"
	bool isSecondPlayerWon;                       // логическая переменная "победил второй игрок"
	bool draw;                                    // логическая переменная "ничья"
	bool isPlayWithComputer                       // логическая переменная "играть с компьютером"
	unsigned short complexity;                    // положительная, короткая переменная "сложность игры с компьтером"
	unsigned long long Player1ID, Player2ID;      // положительная, очень длинная переменная id игроков 
};




/*==================================================================================================================
5**. ОБЪЯВЛЕНИЕ СТРУКТУРЫ "MyVariant", СОДЕРЖАЩАЯ:
                                     - ПЕРЕМЕННУЮ "MyData", ТИПА "union"
							         - ТРИ БИТОВЫХ ФЛАГА
	 И УКАЗАНИЕ КАКОЙ ТИП ДАННЫХ ИСПОЛЬЗУЕТСЯ В ДАННЫЙ МОМЕНТ 								 
==================================================================================================================== */

union MyData {                                  // объявление универсальной переменной "MyData", типа "union"
	
	int a;
	float b;                                    // перечисление возможных типов беззнаковых переменных, которыми она может быть
    char c;	
};

struct MyVariant {                              // объявление структуры "MyVariant", содержание:
	   MyData data;                             // объявляем новое имя для переменной "MyData", типа "union" = "data"
	   
	   unsigned int isInt : 1;                  // битовый флаг 1
       unsigned int isFloat : 1;                // битовый флаг 2
       unsigned int isChar : 1;                 // битовый флаг 3
};



int main() {
	
	MyVariant var;                              // объявляем новое имя для структуры "MyVariant" = "var"
	
	var.data.b = 333.555f;                     // инициализация переменной "data", находящейся по адресу: структура "var", присваивание ей типа "float" и значения "333.555f"
	var.isFloat = 1;                           // используем "float", остальные = 0
	var.isChar = 0;
	var.isInt = 0;
	
	std::cout << var.data.b << std::endl;
	
	 
	var.data.a = 10;                           // инициализация переменной "data", находящейся по адресу: структура "var", присваивание ей типа "int" и значения "10"
	var.isInt = 1;                             // используем "int", остальные = 0
	var.isFloat = 0;                           
	var.isChar = 0;
	
	std::cout << var.data.a << std::endl;
	
	
	var.data.c = 'G';                          // инициализация переменной "data", находящейся по адресу: структура "var", присваивание ей типа "char" и значения "'G'"
	var.isChar = 1;                            // используем "char", остальные = 0
	var.isInt = 0;                             
	var.isFloat = 0;                           
	
	
	std::cout << var.data.c << std::endl;

    return 0;
}
