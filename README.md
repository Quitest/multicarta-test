## Краткое описание

### Требуемый результат:
1. main/payment.xsd - схема валидации входящего запроса на покупку
2. main/resources/schema.sql - схема БД



### Конечные точки для браузера:
1. /reports/sales/inLastWeeks (список покупок за последнюю неделю)
2. /reports/sales/bestseller (самый покупаемый товар за последний месяц)
3. /reports/sales/bestbuyer (имя и фамилию человека, совершившего больше всего покупок за полгода)
4. /reports/sales/byAge (Что чаще всего покупают люди в возрасте 18 лет)

### Конечные точки REST-контролеров 
1. Платежи (PaymentController):
- GET /api/payments 
- POST /api/payments - принимает запросы, удовлетворяющие XSD (payment.xsd). Пример запроса - payment.xml
2. Товары (ProductController):
- GET /api/products - список всех товаров (продуктов)
- GET /api/products/{id} - получить товар по его ID
- POST /api/products - создать новый продукт

### Пользователи
Имеется две встроенные учётные записи:  admin и user с паролями admin и user соответственно. User имеет права доступа только к Web, а admin как к web так и к REST API.

### База данных
БД используется PostgreSQL, хостящеяся на Heroku. Данные для подключения указаны в Application.properties.

