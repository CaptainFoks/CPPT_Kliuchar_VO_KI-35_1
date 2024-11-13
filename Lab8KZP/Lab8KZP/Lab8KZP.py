import math
import struct

# Функція для обчислення виразу y = cos(x) / tan(2x)
def calculate_expression(x):
    """
    Обчислює значення виразу y = cos(x) / tan(2x).
    
    Аргументи:
    x -- значення змінної x.
    
    Повертає:
    Значення виразу y.
    """
    try:
        y = math.cos(x) / math.tan(2 * x)
        return y
    except ZeroDivisionError:
        print("Помилка: тангенс 2x дорівнює нулю (неможливо поділити на 0).")
        return None

# Функція для запису результатів у текстовий файл
def write_to_text_file(filename, results):
    """
    Записує результати обчислень у текстовий файл.
    
    Аргументи:
    filename -- назва текстового файлу для запису.
    results -- список кортежів (x, y), де x -- значення, y -- результат обчислень.
    """
    with open(filename, 'w') as file:
        for x, y in results:
            file.write(f"x = {x}, y = {y}\n")

# Функція для запису результатів у двійковий файл
def write_to_binary_file(filename, results):
    """
    Записує результати обчислень у двійковий файл.
    
    Аргументи:
    filename -- назва двійкового файлу для запису.
    results -- список кортежів (x, y), де x -- значення, y -- результат обчислень.
    """
    with open(filename, 'wb') as file:
        for x, y in results:
            # Структуруємо кожен кортеж у форматі "dd" (два числа з плаваючою комою)
            file.write(struct.pack('dd', x, y))

# Функція для читання результатів з текстового файлу
def read_from_text_file(filename):
    """
    Читає результати обчислень з текстового файлу і виводить їх на екран.
    
    Аргументи:
    filename -- назва текстового файлу для читання.
    """
    try:
        with open(filename, 'r') as file:
            data = file.readlines()
            print("Результати з текстового файлу:")
            for line in data:
                print(line.strip())
    except FileNotFoundError:
        print(f"Помилка: файл '{filename}' не знайдено.")

# Функція для читання результатів з двійкового файлу
def read_from_binary_file(filename):
    """
    Читає результати обчислень з двійкового файлу і виводить їх на екран.
    
    Аргументи:
    filename -- назва двійкового файлу для читання.
    """
    try:
        with open(filename, 'rb') as file:
            print("Результати з двійкового файлу:")
            while True:
                # Читаємо двійкові дані по 16 байт (2 числа з плаваючою комою)
                data = file.read(16)
                if not data:
                    break
                x, y = struct.unpack('dd', data)
                print(f"x = {x}, y = {y}")
    except FileNotFoundError:
        print(f"Помилка: файл '{filename}' не знайдено.")

# Основна функція
def main():
    """
    Основна функція, яка виконує обчислення і запис/читання результатів у файли.
    """
    # Запитуємо у користувача значення x
    try:
        x_values = [float(x) for x in input("Введіть значення x через пробіл: ").split()]
    except ValueError:
        print("Помилка: введено некоректні значення для x.")
        return
    
    # Обчислюємо результати для кожного x
    results = []
    for x in x_values:
        y = calculate_expression(x)
        if y is not None:
            results.append((x, y))

    # Записуємо результати у текстовий файл
    text_filename = "results.txt"
    write_to_text_file(text_filename, results)
    print(f"Результати записано в текстовий файл '{text_filename}'.")

    # Записуємо результати у двійковий файл
    binary_filename = "results.bin"
    write_to_binary_file(binary_filename, results)
    print(f"Результати записано в двійковий файл '{binary_filename}'.")

    # Читаємо результати з текстового файлу
    read_from_text_file(text_filename)

    # Читаємо результати з двійкового файлу
    read_from_binary_file(binary_filename)

# Запуск програми
if __name__ == "__main__":
    main()
