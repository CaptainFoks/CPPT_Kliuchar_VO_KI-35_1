import datetime
import os
from Screen import Screen
from Sound import Sound
from RemoteControl import RemoteControl

class Television:
    """
    Базовий клас телевізора, що включає екран, звук, дистанційний пульт і логування.
    """

    def __init__(self, brand, size):
        """
        Ініціалізує телевізор з екраном, звуком, пультом і веденням логів.

        :param brand: Бренд телевізора.
        :param size: Розмір телевізора в дюймах.
        """
        self.__brand = brand
        self.__size = size
        self.screen = Screen()  # Додаємо екран
        self.sound = Sound()  # Додаємо звук
        self.remoteControl = RemoteControl()  # Додаємо пульт
        self.isOn = False  # Стан телевізора
        self.currentChannel = 1  # Поточний канал

        # Логування
        timestamp = datetime.datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
        file_name = f"tv_log_{timestamp}.txt"
        self.log_file_path = os.path.join(os.getcwd(), file_name)
        self.log_buffer = open(self.log_file_path, 'w')
        self.log_message(f"Телевізор {self.__brand} ({self.__size} дюймів) ініціалізовано.")

    def log_message(self, message):
        """
        Записує повідомлення в лог-файл.

        :param message: Текст повідомлення.
        """
        self.log_buffer.write(message + '\n')
        self.log_buffer.flush()
        print(f"LOG: {message}")

    def power(self):
        """
        Вмикає або вимикає телевізор.
        """
        self.isOn = not self.isOn
        state = "увімкнений" if self.isOn else "вимкнений"
        self.log_message(f"Телевізор {self.__brand} {state}.")
        print(f"Телевізор {self.__brand} ({self.__size} дюймів) {state}.")
    
    def change_channel(self, channel):
        """
        Змінює канал на телевізорі.

        :param channel: Канал для перемикання.
        """
        if self.isOn:
            self.currentChannel = channel
            self.log_message(f"Канал змінено на {self.currentChannel}.")
            print(f"Канал змінено на {self.currentChannel}.")
        else:
            print("Телевізор вимкнений. Спочатку увімкніть його.")
    
    def close_log(self):
        """
        Закриває лог-файл при завершенні роботи.
        """
        self.log_message("Завершення роботи телевізора.")
        self.log_buffer.close()

    # Додаткові функції для телевізора
    def switch_to_next_channel(self):
        """
        Перемикає на наступний канал.
        """
        if self.isOn:
            self.currentChannel += 1
            self.change_channel(self.currentChannel)
        else:
            print("Телевізор вимкнений. Спочатку увімкніть його.")
    
    def switch_to_previous_channel(self):
        """
        Перемикає на попередній канал.
        """
        if self.isOn and self.currentChannel > 1:
            self.currentChannel -= 1
            self.change_channel(self.currentChannel)
        else:
            print("Телевізор вимкнений або вже на першому каналі.")