# Проект по автоматизации мобильного тестирования
<p align="center">
<a href="https://www.wikipedia.org/"><img src="images/logos/wiki.jpg"/></a>
</p>

## :card_file_box: Содержание
- [Технологии и инструменты](#bookmark-технологии-и-инструменты)
- [Запуск из терминала](#bookmark-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#bookmark--jenkins--job-)
- [Allure отчет](#bookmark--отчет-в-allure-report)
- [Уведомление в Telegram](#bookmark--уведомление-в-telegram)
- [Видео прохождения тестов](#bookmark--видео-прохождения-некоторых-тестов)
- [Allure TestOps](#bookmark--добавление-интеграции-с-allure-testops)

## :bookmark: Технологии и инструменты
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logos/IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit5"/></a>
<a href="https://gradle.org/"><img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logos/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a><img src="images/logos/Appium.svg" width="50" height="50"  alt="Appium"/></a>
<a><img src="images/logos/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
<a><img src="images/logos/Android_Studio.svg" width="50" height="50"  alt="Android_Studio"/></a>
<a><img src="images/logos/Appium_Inspector.png" width="50" height="50"  alt="Appium_Inspector"/></a>
<a><img src="images/logos/Browserstack.svg" width="50" height="50"  alt="Browserstack"/></a>
</p>

## :bookmark: Запуск тестов из терминала
Локальный запуск:
```
gradle clean appium_test/browserstack_test -DdeviceHost=appium/browserstack
```

Удаленный запуск:
```
clean browserstack_test -DdeviceHost=browserstack
```
## :bookmark: <img src="images/logos/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/pols-mobile-diploma/8/"> job </a>

## :bookmark: <img src="images/logos/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/pols-mobile-diploma/8/allure/">Allure report</a>

### Обзор сборки
<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/Allure Overview.jpg">
</p>

### Тесты
<p align="center">
<img title="Allure Suites" src="images/screens/Allure Suites.jpg">
</p>

### :bar_chart: Графики
<p align="center">
<img title="Allure Graphs" src="images/screens/Allure Graphs.jpg">
</p>

## :bookmark: <img src="images/logos/Telegram.svg" width="25" height="25"  alt="Telegram"/></a> Уведомление в Telegram
<p align="center">
<img title="" src="images/screens/Telegram.jpg">
</p>

## :bookmark: Видео прохождения тестов

### <img src="images/logos/Browserstack.svg" width="25" height="25" alt="Browserstack"/></a> Browserstack

<p align="center">
  <img title="Browserstack input search test" src="images/gif/browserstack_test.gif">
</p>

### <img src="images/logos/Android_Studio.svg" width="25" height="25" alt="Android Studio"/></a> Local

<p align="center">
  <img title="Close announcement test" src="images/gif/close_announcement.gif">
</p>

<p align="center">
  <img title="Open article test" src="images/gif/open_article.gif">
</p>

<p align="center">
  <img title="Search results size test" src="images/gif/search_results_size.gif">
</p>

## :bookmark: <img src="images/logos/Allure_TO.svg" width="25" height="25" alt="Allure TestOps"/></a> Добавление интеграции с Allure TestOps
<a target="_blank" href="https://allure.autotests.cloud/launch/21508">Job</a>

### Allure TestOps Dashboard
<p align="center">
  <img title="Allure TestOps" src="images/screens/Allure TestOps Dashboard.jpg">
</p>
