#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>

// тсмйжхъ нопедекъчыъъ опнярне вхякн - ъгшй ях
void isSimple(int num) {

	if (num == 1 || num == 0) {  // ВХЯКЮ 1 Х 0 - МЕ ОПНЯРШЕ
		printf("The num %d is not simple!", num);
	}

	else if (num == 2 || num == 3) {  // 2 ХКХ 3 - ОПНЯРНЕ
		printf("The num %d is simple!", num);
	}

	else if (num % 2 == 0) {  // КЧАНЕ ВЕРМНЕ - МЕ ОПНЯРНЕ
		printf("The num %d is not simple!", num);
	}

	else {

		// опнбепъел рнкэйн мевермше нр 3 дн ббедеммнцн вхякю бйкчвхрекэмн
		for (int i = 3; i <= num; i += 2) {  // i = |3|

			// еякх ббедеммне вхякн анкэье 3 ондекхряъ унръ аш ндхм пюг, аег нярюрйю, мю йюйне-мхасдэ хг мевермшу вхяек
			if (num % i == 0) {  // 15 % 3 == 0
				printf("The num %d is not simple!", num);  // ГМЮВХР НМН МЕ ОПНЯРНЕ
				break;  // БШУНД ХГ ЖХЙКЮ
			}

			else {
				printf("The num %d is simple!", num);
				break;  // БШУНД ХГ ЖХЙКЮ
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