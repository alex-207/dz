import datetime
from datetime import date
import os

os.system('cls')  # очистка консоли

""" 1. Приложение заметки (Python)
Сохранение заметки в формате json или csv (разделение полей через ";")
Заметка должна содержать:
-Идентификатор
-Заголовок
-Тело заметки
-Дату/время создания или последнего изменения 

Заметка должна уметь:
-Сохранять заметки в файл
-Читать заметки из файла
  -Выборка по дате
  -Поиск определенной заметки и ее вывод в консоль
  -Вывод всех заметок
-Редактировать старые заметки
-Удалять заметки """

# ВЫВОД ВСЕХ ЗАМЕТОК
def show_all_notes(file_notes):  # принять файл
    os.system('cls')
    try:
        with open(file_notes, 'r') as current_file:  # открыть файл в режиме чтения + создание псевдонима (не требует закрытия)
            list_notes = current_file.readlines()  # сформировать список заметок
        
            # ПОСТРОЧНЫЙ ВЫВОД КАЖДОЙ ЗАМЕТКИ
            for note in list_notes:
                print(note, end='')
            input("\nНажмите любую клавишу: ")
    
    except FileNotFoundError:
        input("Неудалось открыть файл")
        
# ДОБАВЛЕНИЕ НОВОЙ ЗАМЕТКИ
def add_notes(file_notes):
    os.system('cls')
    try:

        with open(file_notes, 'r+') as current_file:  # открыть файл
            list_note = current_file.readlines()
            
            # УНИКАЛЬНЫЙ id
            list_id = []
            id = 1
            for note in list_note:
                for i in range(1):
                    list_id.append(note[i])
            for i in list_id:
                if str(id) == i:
                    id += 1

            header = ""
            body = ""
            current_date = date.today()
            
            current_date_time = datetime.datetime.now()
            current_time = current_date_time.time()

            header += input("Введите заголовок заметки, на латинице: ").lower()
            body += input("Введите текст заметки, на латинице: ").lower()

            current_file.write(str(id) + '; ')
            current_file.write(header + '; ')
            current_file.write(body + '; ')
            current_file.write(str(current_date) + '; ')
            current_file.write(str(current_time) + '\n')
            
        input("Заметка была успешно добавленна. Нажмите любую клавишу для выхода: ")
    
    except FileNotFoundError:
        with open(file_notes, 'a') as create_file:
            input("Файл отсутствовал, и был создан. Нажмите любую клавишу для создания первой заметки")
            search_notes(file_notes)

# ПОИСК ОПРЕДЕЛЕННОЙ ЗАМЕТКИ ПО КЛЮЧУ
def search_notes(file_notes):
    os.system('cls')
    try:    
        find = input('Введите данные для поиска, на латинице: ').lower()

        with open(file_notes, 'r') as current_file:  # открыть файл в режиме чтения + создание псевдонима (не требует закрытия)
            list_notes = current_file.readlines()  # сформировать список заметок
        
            # ПОСТРОЧНЫЙ ПОИСК ПО КАЖДОЙ ЗАМЕТКИ
            for note in list_notes:
                if find in note:
                    print(note, end='')
        input("Нажмите любую клавишу: ")
    
    except FileNotFoundError:
        input("Неудалось открыть файл")
        
# ВЫБОРКА ПО ДАТЕ
def date_search_notes(file_notes):
    os.system('cls')
    try:    
        find = input('Введите число в формате yyyy-mm-dd: ').lower()

        with open(file_notes, 'r') as current_file:  # открыть файл в режиме чтения + создание псевдонима (не требует закрытия)
            list_notes = current_file.readlines()  # сформировать список заметок
        
            # ПОСТРОЧНЫЙ ПОИСК ПО КАЖДОЙ ЗАМЕТКИ
            for note in list_notes:
                if find in note:
                    print(note, end='')
        input("Нажмите любую клавишу: ")
    
    except FileNotFoundError:
        input("Неудалось открыть файл")

# РЕДАКТИРОВАНИЕ
def edit_note(file_notes):
    try:
        os.system("cls")
        current_date = date.today()
        current_date_time = datetime.datetime.now()
        current_time = current_date_time.time() 
        find_id = input('Ведите id заметки - для редактирования: ')  # принять запрос
        with open(file_notes, 'r') as file:
            list_file = file.readlines()
                
            # ПОСТРОЧНЫЙ ПОИСК ПО СПИСКУ
            for note in list_file:
                if str(find_id) == note[0]:
                    print(note, end='')
                    confirm = input('НАЖМИТЕ "Y" ДЛЯ ПОДТВЕРЖДЕНИЯ РЕДАКТИРОВАНИЯ ЗАМЕТКИ: ').lower()  # принять запрос изменения
                    if confirm == 'y' or confirm == 'н':

                        # СОБРАТЬ НОВУЮ ЗАМЕТКУ - id ОСТАВИТЬ ПРЕЖНИЙ
                        my_note = note.split(';')
                        my_note[1] = input("Введите новый заголовок заметки, на латинице: ").lower()
                        my_note[2] = input("Введите новый текст заметки, на латинице: ").lower()
                        my_note[3] = str(current_date)
                        my_note[4] = str(current_time) + ' - reduct'
                        new_note = "; ".join(my_note)
                        # print(new_note)
                        # input()

        # ФАЙЛ С НОВОЙ ЗАМЕТКОЙ
        with open('change_file.json', 'w') as only_new_note:
            only_new_note.write(new_note)

        # СПИСОК С НОВОЙ ЗАМЕТКОЙ
        with open('change_file.json', 'r') as create_edit_list2:
            list_edit_2 = create_edit_list2.readlines()


        # ФАЙЛ СО ВСЕМИ ЗАМЕТКАМИ, КРОМЕ РЕДАКТИРУЕМОЙ
        with open('change_file2.json', 'w') as all_notes_but_one:
            for line in list_file:
                if line[0] != str(find_id):
                    all_notes_but_one.write(line)

        # СПИСОК СО ВСЕМИ ЗАМЕТКАМИ, КРОМЕ РЕДАКТИРУЕМОЙ
        with open('change_file2.json', 'r') as create_edit_list:
            list_edit_1 = create_edit_list.readlines()
        
        # ПЕРЕЗАПИСЬ В ИТОГОВЫЙ ФАЙЛ ВСЕХ ЗАМЕТОК ОБОИХ СПИСКОВ
        first_half = file_notes
        file_notes = open(first_half, 'w')
        file_notes.writelines(list_edit_1)
        # file_notes.close

        file_notes = open(first_half, 'a')
        file_notes.writelines(list_edit_2)
        file_notes.close

    except FileNotFoundError:
        print("Неудалось открыть файл")

    except Exception:
        input("Некорректный ввод. Для выхода нажмите любую клавишу: ")

# УДАЛЕНИЕ
def delete_notes(file_notes):
    os.system("cls")
    try:
        find_id = input('Ведите id заметки - для удаления: ')  # принять запрос
        with open(file_notes, 'r') as file:
            list_file = file.readlines()
            # print(len(list_file))
                
            # ПОСТРОЧНЫЙ ПОИСК ПО СПИСКУ
            for note in list_file:
                if str(find_id) == note[0]:
                    print(note, end='\n')
                    delete = input('НАЖМИТЕ "Y" ДЛЯ УДАЛЕНИЯ ЗАМЕТКИ: ').lower()  # принять запрос изменения
                    if delete == 'y' or delete == 'н':
                        # list_del = []
                        with open('change_file.json', 'w+') as del_note:
                            for line in list_file:
                                if line != note:
                                    del_note.write(line)
                                    
        with open('change_file.json', 'r') as create_del_list:
            list_del = create_del_list.readlines()

        result = file_notes
        file_notes = open(result, 'w')
        file_notes.writelines(list_del)
        file_notes.close

    except FileNotFoundError:
        input("Не удалось открыть файл. Для выхода нажмите любую клавишу: ")

    except Exception:
        input("Некорректный ввод. Для выхода нажмите любую клавишу: ")
        
# ОТРИСОВКА МЕНЮ
def drawing():
    print('1 - Добавить новую заметку')
    print('2 - Показать все заметки')
    print('3 - Поиск заметки')
    print('4 - Выборка заметок по дате')
    print('5 - Редактировать заметку через id')
    print('6 - Удалить заметку')
    print('7 - Выход')


def main(my_notes):
    try:
        while(True):
            os.system('cls')
            drawing()
            choise = int(input("Выберите действие 1-7: "))
            if choise == 1:
                add_notes(my_notes)
            elif choise == 2:
                show_all_notes(my_notes)
            elif choise == 3:
                search_notes(my_notes)
            elif choise == 4:
                date_search_notes(my_notes)
            elif choise == 5:
                edit_note(my_notes)
            elif choise == 6:
                delete_notes(my_notes)
            elif choise == 7:
                print("До свидания!")
                return
            
    except Exception:
        main("my_notes.json")

main("my_notes.json")