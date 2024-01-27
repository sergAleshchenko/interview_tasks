package evgeny_borisov.spring_potroshitel.part_1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Sergei Aleshchenko
 */

/*
   Для профилирования методов класса нужно будет на лету создавать
   новый класс (прокси), которым мы будет на лету заменять оригинальный
   объект. Никто не дожнен заметить этой подмены. В новом классе мы будем
   делигировать уже существующим методам оригинального класса. Есть 2 способа
   создать новый класс:
      1) Наследование от оригинального класса и переопределение его методов (cglib)
      2) Имплементировать те же самые интерфейсы (dynamic proxy)
   Первый метод считается хуже. Работает медленее и не такой гибкий. Spring AOP
   работает именно через proxy: если есть интерфейсы, он идет через proxy. Если
   интерфейсов нет, то идет через cglib
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
