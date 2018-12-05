#!/bin/bash

echo Start mod-licenses in external-register mode

java -jar build/libs/mod-licenses-1.1.jar -Xmx1G --server.port=8080 --grails.server.host=10.0.2.2 --dataSource.username=folio_admin --dataSource.password=folio_admin --dataSource.url=jdbc:postgresql://localhost:54321/okapi_modules

