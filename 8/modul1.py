import os

def show_contacts(file):  # вывод данных  
    os.system("cls")
    with open(file, 'r') as contacts:  # открыть файл в режиме чтения, with - создание псевдонима для файла
        data = contacts.readlines()  # сформировать список из файла
        for contact in data:
            print(contact, end='')  # после вывода контакта - не переходить на следующую строчку
    input('\n' + 'Для выхода нажмите любую клавишу:')  # ручная остановка для просмотра результата

def add_contacts(file):  # добавление данных
    os.system("cls")
    with open(file, 'a') as contacts:  # открыть файл в режиме добавления данных, with - создание псевдонима для файла

        # СФОРМИРОВАТЬ СТРОКУ ДЛЯ ОТПРАВКИ ЕЕ НА ЗАПИСЬ В ФАЙЛ
        res = ''  # инициализация пустой строки
        res += input('Введите фамилию контакта: ') + ' '  # + ' ' - разделитель для удобства
        res += input('Введите имя контакта: ') + ' '  
        res += input('Введите номер телефона контакта: ') + ' '  
        contacts.write('\n' + res + '\n')  # отправить данные на запись
    input('\n' + 'Контакт был добавлен. Для выхода нажмите любую клавишу:')  # ручная остановка для просмотра результата

def search_contacts(file):  # поиск данных
    os.system("cls")
    target = input('Поиск: ')  # принять запрос
    
    with open(file, 'r') as contacts:  # открыть файл в режиме чтения, with - создание псевдонима для файла
        file = contacts.readlines()  # сформировать список из файла
        
        for contact in file:
            if target in contact:  # если есть совпаденеи с запросом
                print(contact)  # вывод контакта
                break
        else:
            print('Контакт не найден:(' + '\n')

    input('Для выхода нажмите любую клавишу:')  # ручная остановка для просмотра результата

def edit_contacts(file):  # редактирование данных
    os.system("cls")
    target = input('Ведите данные контакта для редактирования: ')  # принять запрос
    
    with open(file, 'r') as contacts:  # открыть файл в режиме чтения, with - создание псевдонима для файла
        file = contacts.readlines()  # сформировать список из файла

        for contact in file:
            if target in contact:  # если есть совпаденеи с запросом
                print(contact)  # вывод контакта
                changes = input('Ведите новые данные для данного контакта: ')  # принять запрос изменения

                with open('change_file.txt', 'w') as contacts_out:  # открыть файл в режиме перезаписи
                    for line in file:
                        contacts_out.write(line.replace(contact, changes))  # заменить текущего контакта на измененного
                        file = contacts_out  # !!! ПЕРЕЗАПИСЬ В ОСНОВНОЙ ФАЙЛ ПОЧЕМУ-ТО НЕ РАБОТАЕТ
                    break
        else:
            print('Контакт не найден:(' + '\n')
    input('Изменения успешно применены. Для выхода нажмите любую клавишу:')  # ручная остановка для просмотра результата
# !!! НЕ РАБОТАЕТ ПЕРЕЗАПИСЬ В ОСНОВНОЙ ФАЙЛ

def delete_contacts(file):  # удаление данных
    os.system("cls")
    target = input('Ведите данные контакта для удаления: ')  # принять запрос
    
    with open(file, 'r') as contacts:  # открыть файл в режиме чтения, with - создание псевдонима для файла
        file = contacts.readlines()  # сформировать список из файла

        for contact in file:
            if target in contact:  # если есть совпаденеи с запросом
                print(contact)  # вывод контакта
                delete = input('НАЖМИТЕ "Y" ДЛЯ УДАЛЕНИЯ ДАННОГО КОНТАКТА: ')  # принять запрос изменения
                if delete == 'Y':
                     with open('change_file.txt', 'w') as contacts_out:  # открыть файл в режиме перезаписи
                        for line in file:
                            contacts_out.write(line.replace(contact, ''))  # заменить текущего контакта на пустую строку
                            file = contacts_out  # !!! ПЕРЕЗАПИСЬ В ОСНОВНОЙ ФАЙЛ ПОЧЕМУ-ТО НЕ РАБОТАЕТ
                        break
        else:
            print('Контакт не найден:(' + '\n')
    input('Изменения успешно применены. Для выхода нажмите любую клавишу:')  # ручная остановка для просмотра результата
# !!! НЕ РАБОТАЕТ ПЕРЕЗАПИСЬ В ОСНОВНОЙ ФАЙЛ

def drawing():  # отрисовать интерфейс
    print('1 - Показать все контакты')
    print('2 - Добавить контакт')
    print('3 - Поиск контакта')
    print('4 - Редактирование контакта')
    print('5 - Удаление контакта')
    print('6 - Выход')