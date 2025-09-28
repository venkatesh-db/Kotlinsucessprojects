package com.example.kotlinurlparameters

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class KotlinurlparametersApplication

fun main(args: Array<String>) {
    runApplication<KotlinurlparametersApplication>(*args)
}


/*

Perfect 👍 — your `curl` commands show that your **UserController endpoints are working correctly**:

1. **Path variable**

```bash
curl "http://localhost:9090/api/users/101"
```

Output:

```
User with ID: 101
```

2. **Query parameters**

```bash
curl "http://localhost:9090/api/users?active=true&role=admin"
```

Output:

```
Users with active=true, role=admin
```

3. **Multiple query params**

```bash
curl "http://localhost:9090/api/users/filter?age=25&country=India"
```

Output:

```
Filter users by age=25, country=India
```

✅ Everything is working as expected on port 9090.

---

If you want, we can now **add a `/hello` endpoint** in the same `UserController` to test `@RequestParam` separately, so you have a small demo endpoint for learning parameter passing styles.

Do you want me to do that?

 */
