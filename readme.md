# JavaTest Application #

#### How to run ####

- Run build gradle 
- Add a file path as argument for application
    - If you haven't any file in hand you can try `./src/main/resources/example.csv` as example
    - Also you can try generate a base64 txt file like `base64 /dev/urandom | head -c 1000000000 > file.txt` and use some character different than a pipe to split phrases
- Run `Application` class


#### TO DO ####

- Fix log4j warning about multiple instances
- Fix spark warnings about *illegal reflective* on Java 11 or above (Java 8 runs ok)
    - It's a problem related with hadoop, this project use the last spark-core version however it's a prolem not solved yet, see further on
    https://stackoverflow.com/questions/52155078/how-to-fix-hadoop-warning-an-illegal-reflective-access-operation-has-occurred-e
- Improve unit tests coverage
- Improve parallelisation threads usage on PhraseService

