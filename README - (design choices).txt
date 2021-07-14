To implement the system I choose to use Spring Boot. I've been working with this framework over this past year using Java
and knew it would make it easy to set up a simple API.

I also choose to use Kotlin, I missed coding in Kotlin and knew it could be used in Spring. Also, Kotlin compiles to the
 JVM just like Java so performance-wise it shouldn't make a difference. In my opinion and experience, Kotlin code looks
  better and writes faster than Java code.

I choose to use a database for persistence. This wasn't a very good choice for me for the time that was allowed for
this assignment. I haven't worked with databases in Java/Kotlin yet. And not at all since over a year but I was curious
to see how it would go and what it would look like in a Spring project. The hardest part for me was learning the parts of
Java Persistence API (JPA) and Hibernate that I needed to create tables, relationships and then records.
To simplify things I used an h2 in-memory database which needs almost no setup but can be swapped out for a 'real' DB
with minimal work.

Most of the functionality of the rental process can be found in the service package and the CashMachine class in the model package.
The design should allow for unit tests for most of the methods. Unit tests where not written because of time constraints.

The way (most of) the project is organized is that Controllers receive API calls and use Services to handle
the business logic and data manipulation. Interactions with the database are delegated to Repositories.
