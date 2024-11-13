from Television import Television

class TelevisionWithTuner(Television):
    """
    Похідний клас, що представляє телевізор з тюнером.
    """

    def __init__(self, brand, size, tuner_type="digital"):
        """
        Ініціалізує телевізор з тюнером, що підтримує цифрові або аналогові канали.

        :param brand: Бренд телевізора.
        :param size: Розмір телевізора.
        :param tuner_type: Тип тюнера ("digital" або "analog").
        """
        super().__init__(brand, size)
        self.__tuner_type = tuner_type
        self.__tuner_channel = 1  # Початковий канал тюнера

    def get_tuner_type(self):
        """
        Повертає тип тюнера ("digital" або "analog").
        """
        return self.__tuner_type

    def set_tuner_channel(self, channel):
        """
        Налаштовує тюнер на вказаний канал.

        :param channel: Канал для налаштування тюнера.
        """
        if self.isOn:
            self.__tuner_channel = channel
            print(f"Тюнер налаштовано на канал {self.__tuner_channel} ({self.__tuner_type}).")
        else:
            print("Телевізор вимкнений. Спочатку увімкніть його.")
    
    def next_tuner_channel(self):
        """
        Перемикає тюнер на наступний канал.
        """
        if self.isOn:
            self.__tuner_channel += 1
            print(f"Тюнер перемкнуто на канал {self.__tuner_channel}.")
        else:
            print("Телевізор вимкнений. Спочатку увімкніть його.")
    
    def previous_tuner_channel(self):
        """
        Перемикає тюнер на попередній канал.
        """
        if self.isOn and self.__tuner_channel > 1:
            self.__tuner_channel -= 1
            print(f"Тюнер перемкнуто на канал {self.__tuner_channel}.")
        else:
            print("Телевізор вимкнений або вже на першому каналі.")

    def display_tuner_info(self):
        """
        Виводить інформацію про поточний канал і тип тюнера.
        """
        print(f"Поточний канал тюнера: {self.__tuner_channel} ({self.__tuner_type} тюнер).")