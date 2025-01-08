import socket
import threading
# ДАННЫЕ ДЛЯ ПОДКЛЮЧЕНИЯ
host = '45.153.68.12'  # ipv4-server
port = 55555
# СОЗДАТЬ СОКЕТ
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # AF_INET - для ipv4; SOCK_STREAM - для tcp
server.bind((host, port))  # добавить в сокет данные
server.listen()  # открыть сокет
# СПИСКИ ДЛЯ КЛИЕНТОВ (СОКЕТОВ) И ИХ НИКНЕЙМОВ
clients = []
nicknames = []

# ОТПРАВКА СООБЩЕНИЯ ВСЕМ КЛИЕНТАМ
def broadcast(message):
    for client in clients:
        client.send(message)
# ОБРАБОТКА СООБЩЕНИЙ ОТДЕЛЬНОГО КЛИЕНТА
def handle(client):
    while True:
        try:
            # РАЗОСЛАТЬ ВСЕМ СООБЩЕНИЕ
            message = client.recv(1024)  # ожидать сообщение
            broadcast(message)  # разослать сообщение
        except:
            # ЕСЛИ ОШИБКА
            index = clients.index(client)  # узнать индекс клиента из списка, на котором произошла ошибка
            clients.remove(client)  # удалить его сокет из списка
            client.close()  # закрыть его сессию
            nickname = nicknames[index]  # узнать никнейм клиента из списка по индексу, на котором произошла ошибка
            broadcast('{} left!'.format(nickname).encode('utf8'))  # разослать сообщение о покидании чата клиента, на котором произошла ошибка
            nicknames.remove(nickname)  # удалить его никнейм из списка
            break  # завершить функцию
# ГЛАВНАЯ ФУНКЦИЯ МОНИТОРЯЩАЯ СООБЩЕНИЯ
def receive():
    while True:
        # УСТАНОВКА НОВОГО ПОДКЛЮЧЕНИЯ
        client, address = server.accept()  # ожидание нового подключения (создание уникального сокета)
        print("Connected with {}".format(str(address)))  # показать клиенту сообщение о настройках его подключения
        # ФОРМИРОВАНИЕ НИКНЕЙМА
        client.send('NICK'.encode('utf8'))  # передать клиенту информацию о его никнейме
        nickname = client.recv(1024).decode('utf8')  # проинициализированть никнейм
        nicknames.append(nickname)  # добавляем никнейм в список
        clients.append(client)  # добавляем клиента в список
        # ВЫВОД НИКНЕЙМА НА ЭКРАН И РАССЫЛКА ИНФОРМАЦИИ О ЕГО ПОДКЛЮЧЕНИИ К ЧАТУ
        print("Nickname is {}".format(nickname))  # показать клиенту его никнейм
        broadcast("{} joined!".format(nickname).encode('utf8'))  # рассылка всем пользователям информации о подключении нового никнейма (клиента) к чату
        client.send('Connected to server!'.encode('utf8'))  # передать клиенту информацию о его подключении к чату
        # ОБРАБОТКА СООБЩЕНИЙ КАЖДОГО КЛИЕНТА
        thread = threading.Thread(target=handle, args=(client,))  # вызов отдельной функции обработки сообщений для каждого клиента
        thread.start()
print("Server if listening...")
receive()