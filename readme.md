# Практикум SDET: тестовое задание
UI-автотесты формы регистрации https://demoqa.com/automation-practice-form

## Docker Selenium Commands
Запустить через команды:   
`docker build -t standalone-chrome-b .`  
`docker run -d -p 4444:4444 -p 7900:7900 --shm-size="3g" --name standalone-chrome-b standalone-chrome-b`   
или через compose    
`docker-compose up --build -d`   .

Посмотреть как отрабатывает браузер: http://localhost:7900/?autoconnect=1&resize=scale&password=secret    
Selenium Grid: http://localhost:4444/ui#    

## Project how to run
Приложены конфигурации запуска для IDEA

## Projects screens

### Selenium Grid:
![grid.png](screenshots%2Fgrid.png)
### Test form:
![test-site.png](screenshots%2Ftest-site.png)
### Allure:
![allure1.png](screenshots%2Fallure1.png)
![allure2.png](screenshots%2Fallure2.png)