Echo off
Title Firefox Node on 4547

Echo Setting Project Location for Node
set projectLocation=%cd%
pushd %projectLocation%
Echo Setting GeckoDriver path and Creating node on 4547
java -Dwebdriver.gecko.driver=geckodriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig firefoxNodeConfig.json
pause