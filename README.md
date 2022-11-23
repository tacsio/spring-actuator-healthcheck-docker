# Springboot 3 Actuator Docker Healthcheck

Integrate Actuator healthcheck with docker-compose

## Build and Run

1. Build Java project

```bash
mvn package -DskipTests
```

2. Build Docker Image

```bash
docker compose up --build
```

## Config

Running in a base JDK alpine container the healthcheck config must use wget to retrieve health status of Spring application.

```yaml
healthcheck:
  test: "wget -nv -t1 -qO- http://localhost:8080/actuator/health | grep UP || exit 1"
  interval: 10s
  timeout: 15s
  start_period: 15s
  retries: 3
```

**test params:**

-nv: no verbose

-t1: number of retries 

-q: quiet (turn off output)

-O-: output to default stream

**healthcheck params:**

interval: time between healthchecks to be performed

timeout: time to consider the check failed

retries: consecutive failure to the container be considered to have failed
