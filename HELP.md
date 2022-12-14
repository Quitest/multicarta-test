# Тестовое задание на вакансию java разработчика
Используемые технологии (строгое соблюдение):
-	Java 11
-	Spring Boot 2.1.6
- Spring Data JPA
- Spring Security
-	Maven
-	Tomcat
-	PostgresSQL 11
-	Html 5\CSS (Можно React.js, Angular.js, Vue.js и.т.д)

Дополнительно:
- Docker (можно прислать Dockerfile либо docker-compose файл для вашего приложения)

#### Входные форматы данных:
1) Покупка
- name - название покупки

Список покупок:
- Телевизор
- Смартфон
- Соковыжималка
- Наушники
- Клавиатура

2) Информация о покупке пользователя:
- name - Имя (например, Иван)
- lastname - Фамилия (Например, Иванов)
- age - Возраст (например, 10 лет)
- purchaseItem - Содержимое покупки (ссылка на Покупку)
- count - Количество товара (например, 3)
- amount - Сумма покупки (например, 147.50)
- purchaseDate - Дата покупки (например, 02.05.2019)

#### Задача
1) Описать входящий запрос xsd схемой + описать структуры базы данных в SQL

2) Сформировать веб-страницу с basic авторизацией (с использованием Spring security), которая реализует CRUD операции для работы с информацией о покупках пользователя. Работа с таблицей "покупки" не требуется, она доступна только для выбора на странице.

3) Реализовать Rest-сервис (с используемой описанной вами xsd). Сервис должен принимать информацию о покупке в формате xml, проводится его валидация по xsd при успехе запись в БД, при ошибке вывод пользователю что не так.

4) Сформировать четыре страницы с отчетами по БД:
- Вывести список покупок за последнюю неделю
- Вывести самый покупаемый товар за последний месяц
- Вывести имя и фамилию человека, совершившего больше всего покупок за полгода
- Что чаще всего покупают люди в возрасте 18 лет

5) Сформировать описание вашего сервиса в соответвии со спецификацией OpenAPI 3.0 (Swagger), указав примеры запросов, ответов и возможных ошибок.

#### Результаты

В качестве результата необходимо предоставить xsd-схему, sql-скрипт для построения структуры БД, исходный код, который решает данное тестовое задание.