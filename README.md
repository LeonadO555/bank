## XYZ BANK test automation framework

### Installation

* install [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html);
* install dependencies:
    * Go to file build.gradle;
    * Click on the button build(elephant);
    * Go to IDE settings;
    * Search "Gradle" in search field
    * Choose Build Tool -> Gradle;
    * Choose "Build in run using", "Run test using": IntelliJ IDEA
* install [ImageMagic](https://imagemagick.org/script/download.php) version 6 is required;
    * for Mac Apple Silicon:
        * install imagemagick: `brew install imagemagick@6`
* install [AllureTestOps](https://docs.qameta.io/allure-testops/getstarted/installation/)

### Run tests

* for run all tests ./gradlew clean testName

### Report system

* Run command in terminal`allure serve`

### Install Plugins

* Gradle
* Indent Rainbows
* Brackets RainBows
