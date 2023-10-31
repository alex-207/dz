import os

def print_data():
    # os.system('cls')  # очистка консоли
    with open('phone_book.txt', 'a', encoding='utf-8'):  # создание файла без дальнейшей работы с ним
        pass
    with open('phone_book.txt', 'r', encoding='utf-8') as file:
        phone_book_str = file.read()
    print(phone_book_str)
    # print()
    input('Нажмите Enter для выхода в меню: ')

def input_name():
    return input('Введите имя контакта: ').title()
    
def input_surname():
    return input('Введите фамилию: ').title()
    
def input_patronymic():
    return input('Введите отчество: ').title()

def input_phone():
    return input('Введите телефон: ')

def input_address():
    return input('Введите адрес: ').title()
    
def input_data():

    with open('phone_book.txt', 'r+') as file:  # открыть файл дозапись + чтение
            list_contacts = file.readlines()

    # УНИКАЛЬНЫЙ id
    list_id = []
    id = 1
    for contact in list_contacts:
        for i in range(1):
            list_id.append(contact[i])
    for i in list_id:
        if str(id) == i:
            id += 1

    surname = input_surname()
    name = input_name()
    patronymic = input_patronymic()
    phone = input_phone()
    address = input_address()
    my_sep = ' '
    return f'{id}.{my_sep}{surname}{my_sep}{name}{my_sep}{patronymic}{my_sep}{phone};{my_sep}Адрес:{my_sep}{address}\n\n'

def add_contact():
    new_contact_str = input_data()
    with open('phone_book.txt', 'a', encoding='utf-8') as file:
        file.write(new_contact_str)
    os.system('cls')  # очистка консоли

def search_contact():
    print('Виды поиска: \n'
        '1. По id\n'
        '2. По фамилии\n'
        '3. По имени\n'
        '4. По отчеству\n'
        '5. По телефону\n'
        '6. По адресу\n')
    command = input('Введите вид поиска 1..6: ')

    while command not in ('1', '2', '3', '4', '5', '6'):
        print('Некорректный ввод')
        command = input('Введите вид поиска 1..6: ')
    
    i_search = int(command) - 1

    search = input('Введите данные для поиска контакта: ').lower()
    print()

    with open('phone_book.txt', 'r', encoding='utf-8') as file:
        list_contacts = file.read().rstrip().split('\n\n')
        # print(list_contacts[0])

    flag = False
    for contact in list_contacts:
        contacts_list = contact.lower().replace('\n', ' ').split()
        # print(contacts_list[i_search + 1])
        if command == 6 and search in (contacts_list[i_search:]):
                flag = True
                os.system('cls')  # очистка консоли
                return contact
        elif command != 6 and search in (contacts_list[i_search]):
            flag = True
            os.system('cls')  # очистка консоли
            return contact
            
    if flag == False:
        return f'Контакт не найден'

def copy_contact():
    try:
        search = input('Введите id контакта для копирования: ')
        print()
        with open('phone_book.txt', 'r', encoding='utf-8') as file:
            list_file = file.read().rstrip().split('\n\n')

            for contact in list_file:
                if str(search) == contact[0]:
                    print(contact)
                    print()
                    confirm = input('НАЖМИТЕ "Y" ДЛЯ ПОДТВЕРЖДЕНИЯ КОПИРОВАНИЯ КОНТАКТА: ').lower()  # принять запрос изменения
                    if confirm == 'y' or confirm == 'н':
                        with open('phone_book_copy.txt', 'a', encoding='utf-8') as copy_file:
                            copy_file.write(f'{contact}\n\n')
                    else:
                        return
                    
    except Exception:
        print("Файл пустой и нечего тут копировать))")

def edit_contact():
    print('НАЙДИТЕ КОНТАКТ ДЛЯ РЕДАКТИРОВАНИЯ')
    contact = search_contact()
    if contact != 'Контакт не найден':
        print(contact)
        print()
        confirm = input('НАЖМИТЕ "Y" ДЛЯ ПОДТВЕРЖДЕНИЯ РЕДАКТИРОВАНИЯ КОНТАКТА: ').lower()  # принять запрос изменения
        if confirm == 'y' or confirm == 'н':
            print()
            command = input('Что именно вы хотите отредактировать?:\n'
            '1. Фамилию\n'
            '2. Имя\n'
            '3. Отчество\n'
            '4. Телефон\n'
            '5. Адрес\n')

            while command not in ('1', '2', '3', '4', '5'):
                print('Некорректный ввод')
                command = input('Что именно вы хотите отредактировать?:\n')
            print()
            i_search = int(command)
            contact_str = contact.split()

            if command == '1':
                new_surname = input_surname()
                contact_str[i_search] = new_surname
            elif command == '2':
                new_name = input_name()
                contact_str[i_search] = new_name
            elif command == '3':
                new_patronymic = input_patronymic()
                contact_str[i_search] = new_patronymic
            elif command == '4':
                new_phone = input_phone()
                contact_str[i_search] = new_phone
            elif command == '5':
                new_adress = input_address()
                contact_str[i_search] = new_adress

        else:
            print()
            return
        
        print()
        contact = ' '.join(contact_str)

        # ФАЙЛ ТОЛЬКО С ОДНИМ НОВЫМ КОНТАКТОМ
        with open('phone_book_only_one.txt', 'w', encoding='utf-8') as file_only_one:
            file_only_one.write((f'{contact}\n\n'))

        # СПИСОК ТОЛЬКО С ОДНИМ НОВЫМ КОНТАКТОМ
        with open('phone_book_only_one.txt', 'r', encoding='utf-8') as file_only_one:
            list_only_one = file_only_one.readlines()

        # ФАЙЛ СО ВСЕМИ КОНТАКТАМИ, КРОМЕ РЕДАКТИРУЕМОГО
        with open('phone_book.txt', 'r', encoding='utf-8') as file:  # открыть основной файл контактов, для выборки всех контактов, кроме редактироемого
            with open('phone_book_only_another.txt', 'w', encoding='utf-8') as file_only_another: # создать (при открытии, в режиме 'w') промежуточный файл, в который будут записаны все контакты кроме редактируемого
                for line in file:  # пройтись по основному файлу
                    if contact[0] != line[0]:  #  если id редактируемого контакта, которое всегда стоит на первом месте != id текущего контакта из основного списка
                        file_only_another.write(line)  # записывать его в промежуточный файл
        
        # СПИСОК СО ВСЕМИ КОНТАКТАМИ, КРОМЕ РЕДАКТИРУЕМОГО
        with open('phone_book_only_another.txt', 'r', encoding='utf-8') as file_only_another:
            list_only_another = file_only_another.readlines()

        # ПЕРЕЗАПИСЬ В ИТОГОВЫЙ ФАЙЛ ВСЕХ ЗАМЕТОК ОБОИХ СПИСКОВ
        with open('phone_book.txt', 'w', encoding='utf-8') as file:
            file.writelines(list_only_one)

        with open('phone_book.txt', 'a', encoding='utf-8') as file:
            file.writelines(list_only_another)

    else:
        print('Контакт не найден')
        print()


def interface():
    os.system('cls')  # очистка консоли
    with open('phone_book.txt', 'a', encoding='utf-8'):  # создание файла без дальнейшей работы с ним
        pass
    command = ''
    while command != '7':
        print('Меню: \n'
            '1. Вывод контактов\n'
            '2. Добавить контакт\n'
            '3. Поиск контакта\n'
            '4. Скопировать контакт\n'
            '5. Редактировать контакт\n'
            '6. Удалить контакт\n'
            '7. Выход\n')
        command = input('Введите пункт 1..7: ')

        while command not in ('1', '2', '3', '4', '5', '6', '7'):
            print('Некорректный ввод')
            command = input('Введите пункт 1..7: ')

        if command == '1':
            os.system('cls')  # очистка консоли
            print_data()
        elif command == '2':
            os.system('cls')  # очистка консоли
            add_contact()
        elif command == '3':
            os.system('cls')  # очистка консоли
            print(search_contact())
            print()
        elif command == '4':
            os.system('cls')  # очистка консоли
            copy_contact()
            print()
        elif command == '5':
            os.system('cls')  # очистка консоли
            edit_contact()
        elif command == '6':
            os.system('cls')  # очистка консоли
            delete_contact()
        elif command == '7':
            print('До свидания')
