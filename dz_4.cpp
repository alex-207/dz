/* ==========================================================================================================
1.  if/ else - &&
============================================================================================================= */
	
	uint32_t a, b;
	
	cout << "Enter the number:" << endl;
	cin >> a;

	cout << "Enter the unother number:" << endl;
	cin >> b;

	if (a + b > 10 && a + b <= 20)
			cout << "true";  // код если условие (c <= 20) = true
	
	else
			cout << "false";

/* ==========================================================================================================
2. if/ else - && ||
============================================================================================================= */
	
	const int THE_FIRST_CONST = 5;
	const int THE_SECOND_CONST = 6;
	const int SUMM = THE_FIRST_CONST + THE_SECOND_CONST;
	

	if (THE_FIRST_CONST == 10 && THE_SECOND_CONST == 10 || SUMM == 10)
		cout << "true!";
	
	else
		cout << "false";       // 11 → false
	
/* ==========================================================================================================
3. ЦИКЛ for - ВЫВОД НЕЧЕТНЫХ ЧИСЕЛ
============================================================================================================= */

for (size_t i = 1; i <= 50; i += 2)                       // инициализация(с чего начинать цикл): 1 включительно; 
                                                   // условие(последняя итерация при): 50;
                                                   // изменение(на сколько изменять новый цикл): +2
    {
<<<<<<< HEAD
        cout << i << " ";
=======
        if (i % 2 != 0)                            // вывод только тех чисел, когда: число / 2 по модулю ≠ 0
            cout << i << " ";
>>>>>>> 528fc096c22e563fa238f51cb2bdddd0876264f1
    }
	
/* ==========================================================================================================
4*. if/ else С ВЫЗОВОМ ФУНКЦИИ - ПРОГРАММА ПРОВЕРЯЮЩАЯ ПРОСТОЕ ЧИСЛО
============================================================================================================= */
		
string isPrime(unsigned int number)           // вызов функции
{
	bool isPrime = true;
	
	if (number == 1 || number == 0)           
		
	isPrime = false;                         // отметили 1 и 0 как непростые числа (false)

    else if (number == 2)                    
	{
		isPrime = true                       // отметили 2 как простое число (true)
	}
	
	else if (number % 2 == 0)                // если делится на 2 без остатка → четное
	{
		isPrime = false                      // отметили все четные как непростые числа (false)
	}
    
    else
    {
		for (size_t i = 3; i <= round(sqrt(number)); i += 2)  // проверяем нечетные(3 + 2 + 2 + 2..) числа от 3; до квадратного корня из "number";
		{                                                     // round(sqrt(number)) - функция извлечения квадратного корня                             
			if (number % i == 0)                              // если любое из этих нечетных чисел поделится без остатка ↓ 
			{                                                 
				isPrime = false;                              // отметить его как непростое число                     
				break;                                        // и выйти из программы
			}  
		}
	}

    if (isPrime)
	{
		return PRIME;
	}
    else
	{
		return NOT_PRIME;
	}
}

    cout << "13 : " << isPrime(13) << endl;	
	cout << "99 : " << isPrime(99) << endl;
	cout << "26 : " << isPrime(26) << endl;
	
/* ==========================================================================================================
5*. if/ else С ВЫЗОВОМ ФУНКЦИИ - ПРОГРАММА ВВОДА И ОПРЕДЕЛЕНИЯ ВИСОКОСНОГО ГОДА
============================================================================================================= */

string isLeapYear(unsigned int year)       // вызов функции
{
    bool isLeap = false;

    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) //  (год делится на 400) или (делится на 4 и не делится на 100)
    {
	    isLeap = true;   // високосный
    }

    if (isLeap)
    {
	    return LEAP;
    }

    else
<<<<<<< HEAD
    {
	    return NOT_LEAP; // не високосный
    }
}

    cout << "8 : " << isLeapYear(8) << endl;
	cout << "111 : " << isLeapYear(111) << endl;
	cout << "400 : " << isLeapYear(400) << endl;
	cout << "100 : " << isLeapYear(100) << endl;
=======
        cout << "This is a not leap year!" << endl;
>>>>>>> 528fc096c22e563fa238f51cb2bdddd0876264f1
