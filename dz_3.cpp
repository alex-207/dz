#include <iostream>

using namespace std; // используем пространство имен std во всем файле

enum Week { Mon, Tue, Wed, Thu, Fri, Sat, Sun }; // объявление и инициализация списка "Week" с перечислением констант

int main() {

	Week work_days[4] = { Mon, Wed, Fri, Sat }; // объявление и инициализация одномерного массива "work_days", с 4 константами
	Week holi_days[3] = { Tue, Thu, Sun };      // объявление и инициализация одномерного массива "holi_days", с 3 константами

	cout << "First  work day: " << work_days[0] << endl;  // First  work day: 0
	cout << "First  holi day: " << holi_days[0] << endl;  // First  holi day : 1

	work_days[0] = Sun;
	holi_days[2] = Mon;
	
	cout << "First  work day: " << work_days[0] << endl;  // First  work day: 6
	cout << "First  holi day: " << holi_days[2] << endl;  // First  holi day: 0


	return 0;
}