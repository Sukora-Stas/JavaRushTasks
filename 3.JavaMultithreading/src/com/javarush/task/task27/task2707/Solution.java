package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        //следующие 4 строки в тестах имеют другую реализацию
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;

        synchronized (firstLock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }

            synchronized (secondLock) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        if (o1.hashCode() < o2.hashCode()) {
            synchronized (o1) {
                synchronized (o2) {
                    return true;
                }
            }
        }
        if (o1.hashCode() > o2.hashCode()) {
            synchronized (o2) {
                synchronized (o1) {
                    return false;
                }
            }
        }else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o1, o2); //expected boolean b
                } catch (Exception ignored) {
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    isNormalLockOrder(solution, o2, o1); //expected boolean !b
                } catch (Exception ignored) {
                }
            }
        }.start();
    }
}

/*
		}
	} else  {
		synchronized (toAcct) {
			synchronized (fromAcct) {
				doTransfer(fromAcct, toAcct, amount)}
			}
		}
	}
 */