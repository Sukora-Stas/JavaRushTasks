taskKey="com.javarush.task.task26.task2612"

Весь мир играет комедию

Почитать про java.util.concurrent.locks.Lock на http://docs.oracle.com/ (там все есть в джавадоках!)
Написать реализацию метода someMethod:
1. попытаться захватить лок
1.1. если лок занят, то вызвать метод ifLockIsBusy
1.2. если лок свободен, то:
1.2.1 вызвать метод ifLockIsFree
1.2.2 отпустить лок при любых условиях, даже если ifLockIsFree будет кидать исключение


Требования:
1.	Класс Solution содержать приватное поле Lock lock.
2.	Класс Solution содержать публичный метод ifLockIsFree.
3.	Класс Solution содержать публичный метод ifLockIsBusy.
4.	Метод someMethod должен пытаться захватить лок.
5.	Метод someMethod должен вызвать метод ifLockIsBusy если лок занят.
6.	Метод someMethod должен вызвать метод ifLockIsFree если лок свободен.
7.	Метод someMethod должен отпускать лок при любых условиях, даже если ifLockIsFree будет кидать исключение.


