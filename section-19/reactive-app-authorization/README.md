
### Configuration
- we add a bean of type **SecurityWebFilterChain** to the spring context

### Naming Config
- Exchange was used in SecurityWebFilterChain building, due to term used in Reactive apps
- communication btw components is called exchanging data
- **httpBasic**, **formLogin()**, **csrf()**, **cors()** all works the same way
