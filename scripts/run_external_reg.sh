#!/bin/bash

echo Start mod-license in external-register mode

java -jar build/libs/mod-licenses-1.0.jar -Xmx1G --grails.server.host=10.0.2.2 --dataSource.username=folio_admin --dataSource.password=folio_admin --dataSource.url=jdbc:postgresql://localhost:5432/okapi_modules

