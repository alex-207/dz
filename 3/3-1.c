#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>

// ������� ������������ ������� ����� - ���� ��
void isSimple(int num) {

	if (num == 1 || num == 0) {  // ����� 1 � 0 - �� �������
		printf("The num %d is not simple!", num);
	}

	else if (num == 2 || num == 3) {  // 2 ��� 3 - �������
		printf("The num %d is simple!", num);
	}

	else if (num % 2 == 0) {  // ����� ������ - �� �������
		printf("The num %d is not simple!", num);
	}

	else {

		// ��������� ������ �������� �� 3 �� ���������� ����� ������������
		for (int i = 3; i <= num; i += 2) {  // i = |3|

			// ���� ��������� ����� ������ 3 ��������� ���� �� ���� ���, ��� �������, �� �����-������ �� �������� �����
			if (num % i == 0) {  // 15 % 3 == 0
				printf("The num %d is not simple!", num);  // ������ ��� �� �������
				break;  // ����� �� �����
			}

			else {
				printf("The num %d is simple!", num);
				break;  // ����� �� �����
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