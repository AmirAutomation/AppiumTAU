# AppiumTAU
Proyecto base para la automatizacion con Appium y lengueaje de programacion Java

Documentacion https://github.com/appium/appium/blob/master/ROADMAP.md

## **Installing and runnig Appium on Windows**

Pre-requisitos 
* NodeJS 10* AND npm
* jAVA +8
* Android SDK +16


## **Herramientas**
* Intellij IDEA
* Android Studio
* Appium Desktop
* Appium Inspector

## **Driver**
* uiautomator2

## ****Java****
* version: 8u202
Link: https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html

## ****NodeJS****
* version: 16.14.0
link: https://nodejs.org/en/

**consultar la version**
* -javac -version
* -npm -v
* -node -v

**Install Appium**
npm install -g appium

**Android Studio**
Link: https://developer.android.com/studio

**Appium doctor**
* Lo utilizamos para verificar que nuestro sistema cumple con las configuraciones minimas para ejecutar el emulador de android
npm i -g appium-doctor

**Concepts Android**
* Apk file: El Apk o Apk de Google Play
* AppActivityName: funcionalidades de la App
* AppPackage: com.google.adroid.youtube

**Concepts IOS**
* .IPA file: App 
* BundleID: Es el paquete que identifica com.google.ios.youtube
* UDID: Identificador unico de Apple
El UDID se usa cuando se van a ejecutar pruebas en aplicativo real se necesita para parar la capabilitis del dispostivo

**App**
ApuDemos-debug.apk

Capabilities: son key en formato JSON para la configuracion la conexion del servidor de appium con el emulador

* Documentacion: http://appium.io/docs/en/writing-running-appium/caps/index.html
