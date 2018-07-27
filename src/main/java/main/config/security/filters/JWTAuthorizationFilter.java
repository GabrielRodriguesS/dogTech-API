package main.config.security.filters;

import main.config.security.TokenAuthentication;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthorizationFilter extends GenericFilterBean {

    private Environment env;

    public JWTAuthorizationFilter(Environment env) {
        this.env = env;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = TokenAuthentication.getAuthentication((HttpServletRequest) servletRequest);
        if(authentication != null){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }


//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        String header = request.getHeader(this.env.getProperty("security.header_string"));
//
//        if (header == null || !header.startsWith(this.env.getProperty("security.token_prefix"))) {
//            chain.doFilter(request, response);
//            return;
//        }
//        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(request, response);
//    }
//
//    // TODO ver se pego o usuario no banco ou a lista de permissoes dele no request
//    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
//        String token = request.getHeader(this.env.getProperty("security.header_string"));
//        if (token != null) {
//            String user = Jwts.parser()
//                    .setSigningKey(this.env.getProperty("security.secret").getBytes())
//                    .parseClaimsJws(token.replace(this.env.getProperty("security.token_prefix"), ""))
//                    .getBody()
//                    .getSubject();
//
//            if (user != null) {
//                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//            }
//            return null;
//        }
//        return null;
//    }
}
