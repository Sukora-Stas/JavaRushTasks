taskKey="com.javarush.task.task33.task3309"

Комментарий внутри xml

Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова: toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second>some string</second>
<!--it's a comment-->
<second><![CDATA[need CDATA because of < and >]]></second>
<!--it's a comment-->
<second/>
</first>


Требования:
1.	Количество комментариев вставленных в xml должно быть равно количеству тегов tagName.
2.	Метод toXmlWithComment должен возвращать xml в виде строки преобразованной в соответствии с условием задачи.
3.	Метод toXmlWithComment не должен изменять входящий xml в случае, если искомый тег отсутствует в нём.
4.	Метод toXmlWithComment должен быть статическим.
5.	Метод toXmlWithComment должен быть публичным.


