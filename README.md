Для настройки TLS были выбраны версии 1.2 и 1.3. TLSv1.3 является самой новой на данный момент, но она не поддерживается всеми
устройствами. По-этому была добавлена и TLSv1.2 для совместимости.

TLS cipher suites были выбраны защищенные алгоритмы, которые используются в windows10 https://docs.microsoft.com/en-us/windows/win32/secauthn/tls-cipher-suites-in-windows-10-v1709

Сертификаты находятся в ресурсах проекта, ключи в конфигурационных файлах.