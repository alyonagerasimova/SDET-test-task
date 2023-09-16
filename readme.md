# Tests

## Docker Selenium Commands
Запустить можно одной из комманд:   
`docker build -t standalone-chrome-b .`  
`docker run -d -p 4444:4444 -p 7900:7900 --shm-size="3g" --name standalone-chrome-b standalone-chrome-b`   
Или через compose    
`docker-compose up --build -d`   
Или напрямую запустить из образа (не рекомендуется - нужно примонтировать текущую папку с ресурсами)
`docker run -d -p 4444:4444 -p 7900:7900 --shm-size="3g" --name standalone-chrome -v "{absolute path}/src/test/resources:/src-res/resources:ro" selenium/standalone-chrome:4.11.0`

Посмотреть как отрабатывает браузер: http://localhost:7900/?autoconnect=1&resize=scale&password=secret    
Селениум хаб: http://localhost:4444/ui#    

## Project how to run
Приложены конфигурации запуска для IDEA


