package br.com.danilooa.ocpjadee7.webservices.ws;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebService(
//*Optional*/endpointInterface = "br.com.danilooa.ocpjadee7.webservices.ws.WsExampleEndPointInterface"
)
/*
@WebServiceProvider(serviceName = "MyWebService",
        portName = "MyWebServicePort",
        targetNamespace = "http://example.com/webservice")
*/
//The implementing class must not be declared final and must not be abstract.
//The implementing class must have a default public constructor.
//The implementing class must not define the finalize method

public class WsExample {

    @WebMethod
    /*
    The business methods of the implementing class must be public and must not be declared static or final.
    */
    /*
    Business methods that are exposed to web service clients must have
    JAXB-compatible parameters and return types. See the list of JAXB default data
    type bindings in Types Supported by JAX-WS.
     */
    public List<WsInput> methodExample(WsInput wsInput) {
        return IntStream.range(1, 11)  // Generate numbers from 1 to 10
                .mapToObj(i -> {
                    WsInput out = new WsInput();
                    out.setByte_((byte) i);
                    out.setShort_((short) i);
                    out.setInteger(i);
                    out.setBigDecimal(BigDecimal.valueOf(i));
                    out.setBigInteger(BigInteger.valueOf(i));
                    out.setString("String " + i);
                    out.setDate(new Date());
                    return out;
                })  // Create MockObject instances
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        // Initialization logic here
        System.out.println("Initializing MyService...");
        // Any setup code needed when the object is constructed
    }

    /*
    The implementing class may use the javax.annotation.PostConstruct or the
    javax.annotation.PreDestroy annotations on its methods for lifecycle event
    callbacks.
    The @PostConstruct method is called by the container before the implementing
    class begins responding to web service clients.
    The @PreDestroy method is called by the container before the endpoint is removed
    from operation.
     */
    @PreDestroy
    public void cleanUp() {
        // Cleanup logic here
        System.out.println("Cleaning up MyService...");
        // Any cleanup code needed before the object is destroyed
    }
}
