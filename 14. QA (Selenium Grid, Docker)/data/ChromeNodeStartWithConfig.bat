Echo off
Title ChromeDriver Node on 4546

Echo Setting Project Location for Node
set projectLocation=%cd%
pushd %projectLocation%
Echo Setting ChromeDriver path and Creating node on 4546
java -Dwebdriver.chrome.driver=chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig chromeNodeConfig.json
pause