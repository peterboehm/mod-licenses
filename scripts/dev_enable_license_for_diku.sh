#!/bin/bash

curl -XPOST http://localhost:9130/_/proxy/tenants/diku/modules -d '{"id": "mod-license-1.0.0"}'
