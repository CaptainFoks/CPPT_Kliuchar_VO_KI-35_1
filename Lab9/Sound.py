class Sound:
    """
    Клас, що представляє звукову систему телевізора.
    Містить інформацію про поточну гучність, тип звуку та спеціальну гучність.
    """

    def __init__(self, volume=50, sound_type="stereo", svolume=30):
        """
        Ініціалізує звукову систему з заданими параметрами.

        :param volume: Поточний рівень гучності (за замовчуванням 50).
        :param sound_type: Тип звуку (за замовчуванням stereo).
        :param svolume: Спеціальний рівень гучності (за замовчуванням 30).
        """
        self.__volume = volume
        self.__type = sound_type
        self.__svolume = svolume

    def get_volume(self):
        """
        Повертає поточний рівень гучності.
        """
        return self.__volume

    def set_volume(self, volume):
        """
        Встановлює новий рівень гучності.

        :param volume: Новий рівень гучності.
        """
        if 0 <= volume <= 100:
            self.__volume = volume
            print(f"Гучність встановлена на рівень {self.__volume}.")
        else:
            print("Гучність повинна бути між 0 і 100.")

    def get_type(self):
        """
        Повертає тип звукової системи.
        """
        return self.__type

    def set_type(self, sound_type):
        """
        Встановлює новий тип звуку.

        :param sound_type: Новий тип звуку (наприклад, stereo, mono, surround).
        """
        self.__type = sound_type
        print(f"Тип звуку змінено на {self.__type}.")

    def get_special_volume(self):
        """
        Повертає спеціальний рівень гучності.
        """
        return self.__svolume

    def set_special_volume(self, svolume):
        """
        Встановлює новий спеціальний рівень гучності.

        :param svolume: Новий рівень спеціальної гучності.
        """
        if 0 <= svolume <= 100:
            self.__svolume = svolume
            print(f"Спеціальна гучність встановлена на рівень {self.__svolume}.")
        else:
            print("Спеціальна гучність повинна бути між 0 і 100.")
    
    # Додаткові функції для звуку
    def mute(self):
        """
        Вимикає звук, встановлюючи гучність на 0.
        """
        self.__volume = 0
        print("Звук вимкнено (гучність на 0).")