class Screen:
    """
    Клас, що представляє екран телевізора.
    Містить інформацію про розмір екрану та його тип.
    """

    def __init__(self, sizeX=1920, sizeY=1080, screen_type="LED"):
        """
        Ініціалізує екран з заданими параметрами.

        :param sizeX: Ширина екрану в пікселях (за замовчуванням 1920).
        :param sizeY: Висота екрану в пікселях (за замовчуванням 1080).
        :param screen_type: Тип екрану (за замовчуванням LED).
        """
        self.__sizeX = sizeX
        self.__sizeY = sizeY
        self.__type = screen_type

    def get_size(self):
        """
        Повертає розміри екрану як кортеж (sizeX, sizeY).
        """
        return self.__sizeX, self.__sizeY

    def set_size(self, sizeX, sizeY):
        """
        Встановлює нові розміри екрану.

        :param sizeX: Нова ширина екрану.
        :param sizeY: Нова висота екрану.
        """
        self.__sizeX = sizeX
        self.__sizeY = sizeY
        print(f"Розміри екрану змінено на {self.__sizeX}x{self.__sizeY} пікселів.")

    def get_type(self):
        """
        Повертає тип екрану.
        """
        return self.__type

    def set_type(self, screen_type):
        """
        Встановлює новий тип екрану.

        :param screen_type: Новий тип екрану (наприклад, LED, OLED, LCD).
        """
        self.__type = screen_type
        print(f"Тип екрану змінено на {self.__type}.")

    # Додаткові функції для екрану
    def adjust_brightness(self, level):
        """
        Регулює яскравість екрану.

        :param level: Рівень яскравості (від 0 до 100).
        """
        if 0 <= level <= 100:
            print(f"Яскравість екрану встановлена на {level}.")
        else:
            print("Рівень яскравості повинен бути від 0 до 100.")