#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>

void isSimple(int num) {

	if (num == 1 || num == 0) {  // 0 и 1 - не простые
		printf("The num %d is not simple!", num);
	}

	else if (num == 2 || num == 3) {  // 2 и 3 - простые
		printf("The num %d is simple!", num);
	}

	else if (num % 2 == 0) {  // любое четное - не простое
		printf("The num %d is not simple!", num);
	}

	else {

		// ПРОВЕРЯЕМ ТОЛЬКО НЕЧЕТНЫЕ ОТ 3 ДО ВВЕДЕННОГО ЧИСЛА
		for (int i = 3; i < num; i += 2) {  

			// ЕСЛИ ВВЕДЕННОЕ ЧИСЛО БОЛЬШЕ 3 И ПОДЕЛИТСЯ ХОТЯ БЫ ОДИН РАЗ, БЕЗ ОСТАТКА, НА КАКОЕ-НИБУДЬ ИЗ НЕЧЕТНЫХ ЧИСЕЛ
			if (num % i == 0) {  
				printf("The num %d is not simple!", num);  // значит оно не простое
				break;  // выход из цикла
			}

			else {
				printf("The num %d is simple!", num);
				break;  // выход из цикла
			}
		}
	}
}

int main() {
	int a;
	printf("Enter the number please: ");
	scanf("%d", &a);
	isSimple(a);
	printf("\n");

	return 0;
}