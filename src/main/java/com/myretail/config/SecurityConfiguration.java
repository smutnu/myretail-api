package com.myretail.config;

//TODO have to analyze why custom security configurations are not working.

/*@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)*/
public class SecurityConfiguration {/*extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
		
       auth
          .inMemoryAuthentication()
          .withUser("user")
            .password("password")
            .roles("USER")
            .and()
          .withUser("admin")
            .password("admin")
            .roles("USER", "ADMIN");
       logger.info("initialized users with roles user and admin");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
     
         http.httpBasic().

         realmName("MY_RETAIL_REALM").

         and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).

         and().csrf().disable().

         authorizeRequests().antMatchers("/products/**").permitAll().anyRequest().authenticated();
         logger.info("configured security rules");

    }*/
    
 /*   @Bean
    public MyRetailCustomAuthEntrypoint getBasicAuthEntryPoint(){
        return new MyRetailCustomAuthEntrypoint();
    }
  */
    
   /* @Bean
    public BCryptPasswordEncoder passwordEncoder(){
    	return new BCryptPasswordEncoder();
    }*/
}
