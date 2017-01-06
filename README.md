# Spring Redis Demo

A small demonstration on how to use Redis in Spring applications for caching
and repository purposes. The Redis configuration is activated in `redis` profile

    mvn clean spring-boot:run -Dspring.profiles.active=redis

It assumes that Redis is running on `localhost:6379`.

If you have a Pivotal CloudFoundry instance with Redis service running,
you can deploy this application to it

    cf push --hostname spring-redis

and PCF will auto-reconfigure it to use the cloud version of Redis.

The default profile (`memory`) doesn't use Redis at all.

    mvn clean spring-boot:run

Instead, it uses `ConcurrentHashMap` as a cache and in-memory [key-value store][1]
as a repository.

## References

- [Spring Data Redis reference][2]
- [Spring Data Key Value reference][1]
- [Spring Cache reference][5]
- [Working with Spring Data Repositories][6]
- [Spring Boot application properties][3]
- [Redis for PCF][4]

[1]: https://docs.spring.io/spring-data/keyvalue/docs/current/reference/html/
[2]: https://docs.spring.io/spring-data/redis/docs/current/reference/html/
[3]: https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
[4]: https://docs.pivotal.io/redis/1-7/index.html
[5]: https://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html
[6]: https://docs.spring.io/spring-data/data-commons/docs/1.12.6.RELEASE/reference/html/#repositories