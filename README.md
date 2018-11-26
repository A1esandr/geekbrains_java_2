# geekbrains_java_2
Repository for Java course 2 level

* lesson1

Задание 1 урока

1. Разобраться с имеющимся кодом;
2. Добавить класс Team, который будет содержать: название команды, массив из 4-х участников (т.е. в конструкторе можно сразу всех участников указывать), метод для вывода информации о членах команды прошедших дистанцию, метод вывода информации обо всех членах команды.
3. Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий, метод который будет просить команду пройти всю полосу;
То есть в итоге должно быть:

public static void main(String[] args) {

Course c = new Course(...); // Создаем полосу препятствий

Team team = new Team(...); // Создаем команду

c.doIt(team); // Просим команду пройти полосу

team.showResults(); // Показываем результаты

}


* lesson2 

Задание 2 урока

1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
