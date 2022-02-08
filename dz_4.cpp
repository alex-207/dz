/* 
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

/* 
2. if/ else - && ||
============================================================================================================= */
	
	const int THE_FIRST_CONST = 5;
	const int THE_SECOND_CONST = 6;
	const int SUMM = THE_FIRST_CONST + THE_SECOND_CONST;
	

	if (THE_FIRST_CONST == 10 && THE_SECOND_CONST == 10 || SUMM == 10)
		cout << "true!";
	
	else
		cout << "false";       // 11 → false
	
/* 
3. ЦИКЛ for - вывод нечетных чисел
============================================================================================================= */

for (int i = 1; i < 50; i++)                       // инициализация(с чего начинать цикл): 1 включительно; 
                                                   // условие(последняя итерация при): 50;
                                                   // изменение(на сколько изменять новый цикл): +2
    {
        if (i % 2 != 0)                            // вывод только тех чисел, когда: число / 2 по модулю ≠ 0
            cout << i << " ";
    }
	
/* 
4*. if/ else - && - простое число
============================================================================================================= */
        
		// НЕ ПОНИМАЮ ЗАЧЕМ ЗДЕСЬ ЦИКЛ?
		
int a;
cout << "Enter some positive number please: " << endl;    
cin >> a;                                                 // присвоить "number" значение  
	
	if (a % 2 != 0 && a % 1 == 0 && a % a == 0) // делится c остатком на 2 && делится без остатка на 1 && делится без остатка на само себя
        cout << "Your number: " << a << " - is simple!" << endl;

    else
        cout << "Your number: " << a << " - is not simple!" << endl;           
	
/* 
5*.
============================================================================================================= */

int a;
    cout << "Enter some year 1..3 000: " << endl;
    cin >> a;

    if (a % 400 == 0 && a % 100 == 0)
            cout << "This is a not leap year!" << endl;

    else if (a % 4 == 0 || a % 400 == 0)       // делится без остатка на 4 ||(или) делится без остатка на 400
                cout << "This is a leap year! " << endl;
    
    else if (a < 1 || a > 3000)
             cout << "You entered an incorrect year!" << endl;

    else
        cout << "This is a not leap year!" << endl;
