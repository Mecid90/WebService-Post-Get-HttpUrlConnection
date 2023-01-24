package Authorization;

import com.sun.jersey.core.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String HEADER_PREFIX = "Basic ";
    private static final String SECURED_URL = "index";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (containerRequestContext.getUriInfo().getPath().contains(SECURED_URL)){
            List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER);
            if (authHeader!=null && authHeader.size()>0){
                String authToken = authHeader.get(0);
                authToken = authToken.replaceFirst(HEADER_PREFIX,"");
                String decode = Base64.base64Decode(authToken);
                StringTokenizer tokenizer = new StringTokenizer(decode,":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();

                if ("testlinkusername".equals(username) && "testlinkpassword".equals(password)){
                    return;
                }
            }
            Response unAuthorizedStatus = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User can't access the resource")
                    .build();

            containerRequestContext.abortWith(unAuthorizedStatus);
        }
    }
}
