openssl req -newkey rsa:2048 -nodes -keyout key.pem -x509 -days 365 -out certificate.pem

openssl pkcs12 -inkey key.pem -in certificate.pem -export -out certificate.p12

###################################################################################################################

keytool -genkey -alias server-alias -keyalg RSA -keypass changeit -storepass changeit -keystore keystore.jks

keytool -export -alias server-alias -storepass changeit -file server.cer -keystore keystore.jks

keytool -import -v -trustcacerts -alias server-alias -file server.cer -keystore cacerts.jks -keypass changeit -storepass changeit