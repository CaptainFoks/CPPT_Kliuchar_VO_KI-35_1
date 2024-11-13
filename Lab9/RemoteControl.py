class RemoteControl:
    """
    Клас, що представляє дистанційний пульт для керування телевізором.
    """

    def __init__(self, battery_level=100):
        """
        Ініціалізує пульт з рівнем заряду батареї.
        
        :param battery_level: Початковий рівень заряду батареї (в %).
        """
        self.__battery_level = battery_level
    
    def press_button(self, action):
        """
        Симуляція натискання кнопки на пульті.

        :param action: Дія, яку виконує кнопка (наприклад, "увімкнути", "змінити канал").
        """
        if self.__battery_level > 0:
            print(f"Натиснута кнопка для дії: {action}.")
            self.__battery_level -= 1  # Кожна дія витрачає заряд батареї
        else:
            print("Пульт розряджений.")

    def get_battery_level(self):
        """
        Повертає рівень заряду батареї пульта.
        """
        return self.__battery_level

    def replace_battery(self):
        """
        Замінює батарею пульта на нову (повний заряд).
        """
        self.__battery_level = 100
        print("Батарея пульта замінена на нову.")

    # Додаткові функції для пульта
    def check_battery(self):
        """
        Виводить інформацію про рівень заряду батареї.
        """
        print(f"Рівень заряду батареї пульта: {self.__battery_level}%.")