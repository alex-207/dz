/* 1.
============================================================================================================= */
#include <iostream>

using namespace std;    // разрешаем использовать пространство std во всем файле

int main() {
	
	int a = 2;
	int b = 13;
	int c = 9;
	int d = 7;
	
	float e = static_cast <float> (c) / d;
    float f = b + static_cast <float> (e);
    float g = a * static_cast <float> (f);
	
	cout << "a * (b + (c / d)) = " << g << endl;


return 0;
}



/* 2.
============================================================================================================= */

#include <iostream>

using namespace std;    // разрешаем использовать пространство std во всем файле

int main() {

	unsigned int a = 21, b;
	cin >> b;

	unsigned int mask;

	mask = (b <= a) ? (a - b) : 2 * (b - a);

	cout << mask << endl;

	return 0;
}



/* 3.
============================================================================================================= */

#include <iostream>

using namespace std;    // разрешаем использовать пространство std во всем файле


int main() {

	int arr[3][3][3] = {
	    { { 1, 2, 3 }, { 1, 2, 3 }, { 3, 4, 5 } },
		{ { 1, 2, 3 }, { 1, 11, 3 }, { 3, 4, 5 } },
		{ { 1, 2, 3 }, { 1, 2, 3 }, { 3, 4, 5 } }
	};
	
	int* pArr = nullptr; // объвляем указатель и инициализируем его нулем

	pArr = &arr[1][1][1];  // настраиваем указатель на центральный элемент массива

	*pArr = 20;           // arr[1][1][1] = 20

	cout << pArr << endl;     // !!! подчеркивает cout красным - не знаю в чем дело...

	return 0;
}



/* 4**.
============================================================================================================= */

#include <iostream>

using namespace std;    // разрешаем использовать пространство std во всем файле

extern int a;
extern int b;
extern int c;
extern int d;

int main() {
	
	float e = static_cast <float> (c) / d;
    float f = b + static_cast <float> (e);
    float g = a * static_cast <float> (f);

	cout << g << endl;

	return 0;
}
