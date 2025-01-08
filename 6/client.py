import socket
import threading
# ИНИЦИАЛИЗАЦИЯ НИКНЕЙМА
nickname = input("Choose your nickname: ")
# ПОДКЛЮЧЕНИЕ К СЕРВЕРУ
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(('45.153.68.12', 55555))  # ipv4-server, port
# МОНИТОРИТЬ СООБЩЕНИЯ И ВЫВОД НИКНЕЙМА
def receive():
    while True:
        try:
            message = client.recv(1024).decode('utf8')  # принять сообщение
            if message == 'NICK':
                client.send(nickname.encode('utf8'))  # отправить клиенту никнейм
            else:
                print(message)  # вывести клиенту сообщение
        except:
            print("An error occured!")
            client.close()  # закрыть сокет при ошибке
            break
# ОТПРАВКА СООБЩЕНИЯ
def write():
    while True:
        message = '{}: {}'.format(nickname, input(''))  # формирование сообщения (никнейм: введенный текст)
        client.send(message.encode('utf8'))  # отправить сообщение
# ЗАПУСТИТЬ МОНИТОРИНГ СООБЩЕНИЙ И ВЫВОДА НИКНЕЙМА
receive_thread = threading.Thread(target=receive)
receive_thread.start()
# ЗАПУСТИТЬ ОТПРАВКУ СООБЩЕНИЯ
write_thread = threading.Thread(target=write)
write_thread.start()