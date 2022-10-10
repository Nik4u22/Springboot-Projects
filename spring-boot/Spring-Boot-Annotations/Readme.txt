SpringBoot Annotations Details


1. @SpringBootApplication (Equivalent to below three annotations)
        @EnablleAutoConfiguration (+) @ComponentScan (+) @Configuration

2. @Configuration (Mark class as source of bean definitions and components)
    - Returns java beans and components

3. @Bean
    - Use inside @ Configuration to return class object

4. @Autowired
    - Automatically inject dependencies by checking object components

5. @Component
    - Annotate any class as a component so do not need to create bean for class and object will be managed by Spring
        1. @Controller (Component, MVC Controller -> Presentation Layer)
        2. @Service (Service layer)
        3. Respository (DAO Layer -> Data Access Object)


6. @ComponentScan
    - Scan the specific components from specific package
    - Use in BeanConfig Class and pass multiple packages

7. @Qualifier
    - Same class name but multiple objects

8. @Lazy
    - Create lazy object only when we are using

9. @RequestMapping
    - Use in controller to map request from url to object

10. @ResponseBody
    - Automatically convert return body into JSON

11. @RequestBody
    - Getting data as JSON from form/url

12. @RestController
    - Convert all data in JSON
    - Can be used insteat of @Controller

13. @PathVariable
     - get data from variables passed in url