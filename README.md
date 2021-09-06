# DTEK0066 project template

## Workflow

```bash
$ git clone https://gitlab.utu.fi/tech/education/ooj/ooj2021-harj1
$ cd ooj2021-harj1

< implement the exercises >

< edit AUTHORS.TXT >

$ git add -A
$ git commit -m 'Add exercises'
$ git remote add oma https://gitlab.utu.fi/USERNAME/ooj2021-harj1
$ git push oma

< in case the exercises require fixes >

$ git add -A
$ git commit -m 'Fix exercises'
$ git push oma
```

## Using Maven

```bash
$ mvn clean
$ mvn compile
$ mvn test
$ mvn exec:java
$ mvn javafx:run
$ mvn surefire-report:report
```

## Online report

See <https://gitlab.utu.fi/tech/education/ooj/ooj2021-harj1/pages>

Your version: https://USERNAME.utugit.fi/ooj2021-harj1/
