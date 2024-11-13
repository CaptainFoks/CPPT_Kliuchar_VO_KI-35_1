import math

def generate_lines(size, fill_char):
    """
    Функція генерує зубчастий список з ліній, заповнених символом.
    
    Аргументи:
    size -- розмір квадратної матриці.
    fill_char -- символ, який використовується для заповнення ліній.
    
    Повертає:
    lines -- список, що містить лише заштриховані області (лінії).
    """
    # Визначаємо довжину лінії (заокруглення в більшу сторону)
    line_length = math.ceil(size / 6)
    
    # Створюємо список для ліній
    lines = []
    
    # Генеруємо заштриховані області (3 лінії)
    for _ in range(line_length):
        line = [fill_char] * size  # Заштрихована лінія
        lines.append(line.copy())  # Додаємо рядок у список ліній
    
    return lines


def print_matrix_with_spaces(size, lines):
    """
    Функція для виведення матриці з пропусками між лініями.
    
    Аргументи:
    size -- розмір повної квадратної матриці.
    lines -- список, що містить заштриховані лінії.
    """
    total_lines = len(lines)  # Кількість заштрихованих рядків у кожній лінії
    section_size = size // 3  # Розмір кожної секції
    
    for i in range(3):
        # Виводимо порожні рядки перед кожною заштрихованою лінією
        for _ in range((section_size - total_lines)):
            print(" " * size)
        
        # Виводимо заштриховані рядки
        for line in lines:
            print(" ".join(line))
            


def main():
    """
    Основна функція, що виконує програму.
    """
    try:
        # Введення розміру матриці
        size = int(input("Введіть розмір квадратної матриці: "))
        
        # Введення символа-заповнювача
        fill_char = input("Введіть символ-заповнювач (1 символ): ")
        if len(fill_char) != 1:
            print("Помилка: символ-заповнювач має бути одинарним символом!")
            return

        # Генерація ліній
        lines = generate_lines(size, fill_char)
        
        # Виведення матриці з пропусками
        print("Згенерована матриця:")
        print_matrix_with_spaces(size, lines)
        
        print("")
        
        for i in range(3):
            for line in lines:
                print("".join(line))

    except ValueError:
        print("Помилка: введено некоректне значення для розміру матриці.")

# Запуск програми
if __name__ == "__main__":
    main()
