from TelevisionWithTuner import TelevisionWithTuner

if __name__ == "__main__":
    # Створюємо телевізор з тюнером
    tv_with_tuner = TelevisionWithTuner(brand="LG", size=65, tuner_type="digital")

    # Вмикаємо телевізор
    tv_with_tuner.power()

    # Перемикаємо канали через тюнер
    tv_with_tuner.set_tuner_channel(10)
    tv_with_tuner.next_tuner_channel()
    tv_with_tuner.previous_tuner_channel()

    # Отримуємо інформацію про тюнер
    tv_with_tuner.display_tuner_info()

    # Перемикаємо канал телевізора
    tv_with_tuner.change_channel(5)

    # Змінюємо гучність звуку
    tv_with_tuner.sound.set_volume(80)

    # Вимикаємо телевізор і закриваємо лог
    tv_with_tuner.power()
    tv_with_tuner.close_log()